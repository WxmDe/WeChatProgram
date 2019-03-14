//app.js
App({


  //全局变量
  globalData: {
    userInfo: null,
    host: 'http://192.168.10.194:8080/data.json',
    appID:'wxf087609e0fb66298',
    appSecret:'9d230ef9975532e7192e5993100ee7e9',
    template_id:"lmHGtqYb3IRj9IeAsrKb7OuZdyyhcTqS3ONVLLkA_jQ",
    openid:null,
    ACCESS_TOKEN:null,
  },

  onShow: function () {
    console.log('App Show')
  },
  onHide: function () {
    console.log('App Hide')
  },
  onLaunch: function () {
    // 展示本地存储能力
    var logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs)

    // 登录
    wx.login({
       success: function (res) {
        if (res.code) {
          console.log("res.code=" + res.code)
          // 发起网络请求
          wx.request({
            // 这里是接口地址,建议部署配置域名为https，否则可能会出问题，nginx加密证书配置见文章尾
            url: 'http://192.168.10.194:8080/login',
            data: {
              code: res.code
            },
            success:function(result){
              //app.globalData.openid=result.data.openid;
              wx.setStorageSync('openid', result.data.data.openid);
                          }
          })
        } else {
          console.log('登录失败！' + res.errMsg)
        }
      }
    })
    // 获取用户信息
    wx.getSetting({
      success: res => {
        if (res.authSetting['scope.userInfo']) {
          // 已经授权，可以直接调用 getUserInfo 获取头像昵称，不会弹框
          wx.getUserInfo({
            success: res => {
              // 可以将 res 发送给后台解码出 unionId
              this.globalData.userInfo = res.userInfo

              // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
              // 所以此处加入 callback 以防止这种情况
              if (this.userInfoReadyCallback) {
                this.userInfoReadyCallback(res)
              }
            }
          })
        }
      }
    })
  }
})