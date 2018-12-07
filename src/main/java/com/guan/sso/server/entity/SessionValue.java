package com.guan.sso.server.entity;

import java.io.Serializable;

public class SessionValue implements Serializable {

    private Long appId;

    private String redirectUrl;

    private Integer xlogin;

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public Integer getXlogin() {
        return xlogin;
    }

    public void setXlogin(Integer xlogin) {
        this.xlogin = xlogin;
    }

    @Override
    public String toString() {
        return "SessionValue{" +
                "appId=" + appId +
                ", redirectUrl='" + redirectUrl + '\'' +
                ", xlogin=" + xlogin +
                '}';
    }
}
