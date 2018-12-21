package com.guan.sso.server.entity;

import java.io.Serializable;

public class SessionValue implements Serializable {

    private Long appId;

    private String redirectUrl;

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

    @Override
    public String toString() {
        return "SessionValue{" +
                "appId=" + appId +
                ", redirectUrl='" + redirectUrl + '\'' +
                '}';
    }
}
