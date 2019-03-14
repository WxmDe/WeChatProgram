package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.Result.Result;
import com.example.utils.WeChatUtil;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.example.utils.Params.OPENID;
import static com.example.utils.Params.TEMPLATE_ID;

/**
 * @Decription 具体操作
 * @Author wxm
 * @Date 2019/3/4 11:18
 **/
@Controller
@EnableScheduling
public class OperationController {

       /**
     * 第一步：获取AccessToken;
     * @return
     */
    @RequestMapping("/getAccessToken")
    @ResponseBody
    public  String  getAccessToken(){

        // 微信小程序ID
        String appid = "wxf087609e0fb66298";
        // 微信小程序秘钥
        String secret = "9d230ef9975532e7192e5993100ee7e9";

        String url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+secret;
        // 发送请求，返回Json字符串
        String str = WeChatUtil.httpRequest(url, "GET", null);
        // 转成Json对象 获取openid
        JSONObject jsonObject = JSONObject.parseObject(str);
        System.out.println("access_token---"+jsonObject.toJSONString());
        // 我们需要的openid，在一个小程序中，openid是唯一的
        String access_token = jsonObject.get("access_token").toString();
        return access_token;
        }

    @RequestMapping("/sendMsg")
    @ResponseBody
      public void sendMessage(@RequestBody String _jsonData){
        System.out.println("sendMesg传入参数"+_jsonData);
        // 微信小程序ID
        String appid = "wxf087609e0fb66298";
        // 微信小程序秘钥
        String secret = "9d230ef9975532e7192e5993100ee7e9";

        String ACCESS_TOKEN=getAccessToken();
        // 根据小程序穿过来的code想这个url发送请求
        String url = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/uniform_send?access_token="+ACCESS_TOKEN;
        // 发送请求，返回Json字符串
        String str = WeChatUtil.httpRequest(url, "POST", _jsonData);
        // 转成Json对象 获取openid
        JSONObject jsonObject = JSONObject.parseObject(str);
        System.out.println("jsonObject____"+jsonObject.toJSONString());
        // 我们需要的openid，在一个小程序中，openid是唯一的
    }

    @Scheduled(cron="0 0/1 * * * * ")//代表每一分钟执行一次   必须在类上加上@EnableScheduling 否则不会定时执行
    public  void start() {
        System.out.println(new Date());
    }

}
