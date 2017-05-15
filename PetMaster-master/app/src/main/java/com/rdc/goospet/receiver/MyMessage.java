package com.rdc.goospet.receiver;

/**
 * Created by Shower on 2017/5/14.
 */

public interface MyMessage {
    /**
     * 电话来了
     */
    public void comePhone();

    /**
     * 短信来了
     */
    void  comeShortMessage();

    /**
     * 微信消息
     */
    void  comeWxMessage();

    /**
     * qq消息
     */
    void comeQQmessage();
}
