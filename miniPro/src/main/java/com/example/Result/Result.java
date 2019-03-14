package com.example.Result;

/**
 * @Decription TODO
 * @Author wxm
 * @Date 2019/3/1 15:12
 **/
public class Result {

    private Object data;

    private String resultCode;//0 成功，1 失败

    private String resultMsg;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }
}
