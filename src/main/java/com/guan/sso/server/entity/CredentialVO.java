package com.guan.sso.server.entity;

import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotBlank;

public class CredentialVO {

    @NotBlank(message = "username is empty")
    private String username;

    @NotBlank(message = "password is empty")
    private String password;

    @NotBlank(message = "redirect url is empty")
    private String redirectUrl;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    @Override
    public String toString() {
        return "CredentialVO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", redirectUrl='" + redirectUrl + '\'' +
                '}';
    }
}
