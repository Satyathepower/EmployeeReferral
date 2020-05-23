package com.hk.EmployeeReferral.bean;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserBean implements UserDetails {


    UserLoginBean userLoginBean;
    List<GrantedAuthority> grantedAuthority;

    public UserLoginBean getUserLoginBean() {
        return userLoginBean;
    }

    public void setUserLoginBean(UserLoginBean userLoginBean) {
        this.userLoginBean = userLoginBean;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthority;
    }

    @Override
    public String getPassword() {
        return userLoginBean.getUserPass();
    }

    @Override
    public String getUsername() {
        return userLoginBean.getLoginId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

/*
    public void setUserAuthorities(List<String> roles)
    {
        List<GrantedAuthority> listOfAuthorities = new ArrayList<GrantedAuthority>();
        for (String role : roles)
        {
            listOfAuthorities.add(new GrantedAuthorityImpl(role));
        }
        this.grantedAuthority = listOfAuthorities;
    }*/

}
