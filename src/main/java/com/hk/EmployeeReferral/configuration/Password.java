package com.hk.EmployeeReferral.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Password {

    public static String encryptPassword(String pw){
        BCryptPasswordEncoder enP=new BCryptPasswordEncoder();
        return enP.encode(pw);
    }


    public static void main(String []args){

         System.out.println(new BCryptPasswordEncoder().encode("abcd"));
    }

}
