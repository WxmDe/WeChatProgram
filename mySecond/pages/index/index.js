//index.js
//获取应用实例  必须有这个才能获取到app.js里的东西

const app = getApp()

Page({
  data: {
    imgUrls: [
      '/images/swiper01.jpg',
      '/images/swiper02.jpg',
      '/images/swiper03.jpg'
    ],
    indicatorDots: true,
    autoplay: true,
    interval: 2000,
    duration: 1000,
    proList:null,
  },
  
  onLoad: function () {
    this.getProList();
    //请求获得access_token
    wx.request({
      url: 'http://192.168.10.194:8080/getAccessToken',
      method: 'GET',
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        app.globalData.ACCESS_TOKEN = res;
      }
    })
  },
  toDetail:function(e){
    console.log(this.data)
    var index = e.currentTarget.dataset.index;
    var proList =this.data.proList;
    var title=proList[index].title;

   /* wx.setStorageSync('title', title)
    wx.navigateTo({
      url: '/pages/detail/detail',
    }) */
    //等同于上面两行
    wx.navigateTo({
      url: '/pages/detail/detail?title='+title,
    })
    

  },
  getProList:function(){
    var self=this;
    wx.request({
      //url 必须完整加上http:// 且在详情里面勾选不校验合法域名
      url:app.globalData.host, // 仅为示例，并非真实的接口地址
      method:'GET',
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        self.setData({
          proList:res.data
          })
     }
    })
  },
  copy:function(){
    if (wx.setClipboardData){
      wx.setClipboardData({
        data: '这是我要复制的内容',
      })
      console.log(wx.setClipboardData)
    }else{
      wx.showModal({
        title: '提示',
        content: '您的微信版本太低，请升级',
      })
    }
   
  },

  sendMessage:function(e){
    console.log("formId");
    console.log(e);
    let _jsonData =
    {
      "touser": wx.getStorageSync('openid'),
      "weapp_template_msg": {
        "template_id":app.globalData.template_id,
        //服务通知中进入小程序的入口
        "page": "pages/index/index",
        "form_id": e.detail.formId,
        "data": {
          "keyword1": {
            "value": "123423423429712"
          },
          "keyword2": {
            "value": "不想买了"
          },
          "keyword3": {
            "value": "2018-1-31"
          },
          "keyword4": {
            "value": "微波炉"
          }
        },
        "emphasis_keyword": "keyword1.DATA"
      }
    }
    wx.showModal({
      title: 'formdID',
      content: e.detail.formId,
    })

    
    wx.request({
      url:'http://192.168.10.194:8080/sendMsg',
      data: _jsonData,
      method: 'POST',
      header: {
        'content-type': 'application/json' // 默认值
      },
      success:function(res){
        console.log("res")
        console.log(res)
      }
    })
    console.log("faxiaox")
  }



})
