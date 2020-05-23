package com.hk.EmployeeReferral.bean;

import java.io.Serializable;

public class UserLoginBean implements Serializable {

    private String loginId;
    private boolean active;
    private String userType;
    private String userPass;
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLoginId() {
        return loginId;
    }
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }
    public String getUserType() {
        return userType;
    }
    public void setUserType(String userType) {
        this.userType = userType;
    }
    public String getUserPass() {
        return userPass;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }
}
