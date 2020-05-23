package com.hk.EmployeeReferral.configuration;

import com.hk.EmployeeReferral.services.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailServiceImpl userDetailServiceImpl;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        System.out.println("Password enc bean..........");
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService( userDetailServiceImpl).passwordEncoder(passwordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/admin/**","/emp/**","/app/**").fullyAuthenticated();
        http.authorizeRequests().antMatchers("/login").anonymous();

       http.authorizeRequests().antMatchers("/static/**","/WEB-INF/jsp/**","/").permitAll();
        http.authorizeRequests().and().formLogin().loginProcessingUrl("/j_login").loginPage("/login")
                .defaultSuccessUrl("/admin/afterLogin")
                .failureUrl("/login?fail=true").usernameParameter("email").passwordParameter("password")
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/login").deleteCookies("JSESSIONID")
                .and().exceptionHandling().accessDeniedPage("/WEB-INF/views/unAutherizedUser.jsp");
    }
    
}
