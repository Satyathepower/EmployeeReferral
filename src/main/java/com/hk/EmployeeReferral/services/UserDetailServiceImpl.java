package com.hk.EmployeeReferral.services;

import com.hk.EmployeeReferral.bean.UserBean;
import com.hk.EmployeeReferral.bean.UserLoginBean;
import com.hk.EmployeeReferral.daos.UserRepository;
import com.hk.EmployeeReferral.entities.User;
import com.hk.EmployeeReferral.utility.EnumUserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {

//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
//
//        String username= request.getParameter("username");
//
         UserBean userBean=new UserBean();
        UserLoginBean userLoginBean = new UserLoginBean();

        if(true){

       User user= userRepository.findByEmail(loginId);
       System.out.println(user.getEmail());
        if(user !=null) {

            userLoginBean.setActive(user.isActive());
            userLoginBean.setLoginId(user.getEmail());
            if(user.getUserType().equals(EnumUserType.EMPLOYEE.getId())) {
                userLoginBean.setUserType(EnumUserType.EMPLOYEE.getName());
            }else {
                userLoginBean.setUserType(EnumUserType.ADMIN.getName());
            }
            userLoginBean.setUserPass(user.getPassword());
            userLoginBean.setUserId(user.getId());
            userBean.setUserLoginBean(userLoginBean);

        }else {
            throw new AuthenticationCredentialsNotFoundException("Bad Credential");
        }

        }else {
            throw  new BadCredentialsException("Please enter the details");

        }
        return userBean;
    }
}
