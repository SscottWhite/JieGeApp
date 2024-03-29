package com.ncstudy.pojo.alipay;

import lombok.Data;

@Data
public class Participant {
    /**
     * 参与方的唯一标识
     */
    private String identity;

    /**
     * 参与方的标识类型，目前支持如下类型：
     * 1、ALIPAY_USER_ID 支付宝的会员ID
     * 2、ALIPAY_LOGON_ID：支付宝登录号，支持邮箱和手机号格式
     */
    private String identity_type;

    /**
     * 参与方真实姓名，如果非空，将校验收款支付宝账号姓名一致性。
     * 当identity_type=ALIPAY_LOGON_ID时，本字段必填。
     */
    private String name;
}