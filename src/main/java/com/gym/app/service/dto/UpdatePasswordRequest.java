package com.gym.app.service.dto;

import java.io.Serializable;

public class UpdatePasswordRequest implements Serializable {
    private String loginId;
    private String password;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UpdatePasswordRequest{" +
                "loginId='" + loginId + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}