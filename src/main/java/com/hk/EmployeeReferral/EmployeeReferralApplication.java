package com.hk.EmployeeReferral;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
/*@ComponentScan("com.hk.EmployeeReferral")*/
/*@ComponentScan(basePackageClasses = WelcomeController.class)*/
@ComponentScan(basePackages={"com"})
public class EmployeeReferralApplication {

	public static void main(String[] args) {

		SpringApplication.run(EmployeeReferralApplication.class, args);
	}

}
