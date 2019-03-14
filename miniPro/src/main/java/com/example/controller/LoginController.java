package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.Result.Result;
import com.example.utils.Params;
import com.example.utils.WeChatUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Decription TODO
 * @Author wxm
 * @Date 2019/3/1 14:39
 **/
@Controller
public class LoginController {
    /**
     * 第二步：code获取openid
     * @param code
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public Result  login(String code){
        // 微信小程序ID
        String appid = "wxf087609e0fb66298";
        // 微信小程序秘钥
        String secret = "9d230ef9975532e7192e5993100ee7e9";

        // 根据小程序穿过来的code想这个url发送请求
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret=" + secret + "&js_code=" + code + "&grant_type=authorization_code";
        // 发送请求，返回Json字符串
        String str = WeChatUtil.httpRequest(url, "GET", null);
        // 转成Json对象 获取openid
        JSONObject jsonObject = JSONObject.parseObject(str);

        // 我们需要的openid，在一个小程序中，openid是唯一的
        String openid = jsonObject.get("openid").toString();
        Map<String,String> map=new HashMap<String,String>();
        map.put("openid",openid);
        Result result=new Result();
        result.setData(map);
        result.setResultMsg("openid");
        result.setResultCode("0");
        Params.OPENID=openid;
        return result;
    }

    @Scheduled(cron="0 0/2 * * * * ")//代表每一分钟执行一次   必须在类上加上@EnableScheduling 否则不会定时执行
    public  void start() {
        System.out.println("每隔两分钟");
    }
}
