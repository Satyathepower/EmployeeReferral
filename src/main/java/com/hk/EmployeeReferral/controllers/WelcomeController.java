package com.hk.EmployeeReferral.controllers;

import com.hk.EmployeeReferral.configuration.Password;
import com.hk.EmployeeReferral.entities.User;
import com.hk.EmployeeReferral.services.UserService;
import com.hk.EmployeeReferral.utility.EnumDepartment;
import com.hk.EmployeeReferral.utility.EnumDesignation;
import com.hk.EmployeeReferral.utility.EnumUserType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class WelcomeController {

    @Autowired
    UserService userService;


    private static final Logger logger = LogManager.getLogger(WelcomeController.class);
    @RequestMapping(value ={"/" ,"/login"}, method = RequestMethod.GET)
    public ModelAndView home() {
        logger.info("In home");
        ModelAndView model = new ModelAndView();
        model.setViewName("login");
        return model;
    }

    @RequestMapping(value = "/empRegForm", method = RequestMethod.GET)
    public ModelAndView empRegForm(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("departmentList",EnumDepartment.getArrayListOfDepartment());
        modelAndView.setViewName("employeeReg");
        return modelAndView;
    }

    @RequestMapping(value = "/empRegFormSubmit",method = RequestMethod.POST)
    public ModelAndView empRegFormSubmit(@RequestParam("empId")  String empId,
                                         @RequestParam("empName") String empName,
                                         @RequestParam("email") String email,
                                         @RequestParam("password") String password,
                                         @RequestParam("contact") String contact,
                                         @RequestParam("currentDes") Long currentDes ,
                                         @RequestParam("department") Long department ,
                                         @RequestParam("empType") Long userType){
        ModelAndView modelAndView=new ModelAndView();
       User checkOldUser= userService.getUserByEmail(email);
       if(checkOldUser!=null) {
           User user = new User();
           user.setEmployeeId(empId);
           user.setName(empName);
           user.setEmail(email);
           user.setPassword(Password.encryptPassword(password));
           user.setContactNumber(contact);
           user.setDepartment(EnumDepartment.getEnumDepartmentById(department).asGetDepartment());
           user.setDesignation(EnumDesignation.getEnumDesignationById(currentDes).asGetDesignation());
           user.setUserType(EnumUserType.getEnumUserTypeById(userType).asGetUserType());
           userService.saveEmployee(user);
           modelAndView.setViewName("login");
       }else {
           modelAndView.setViewName("forgetPassword");
           modelAndView.addObject("msg","You have already registered");
           modelAndView.addObject("email",checkOldUser.getEmail());
       }
       return  modelAndView;
    }

    @RequestMapping(value = "/forgetPassword", method = RequestMethod.GET)
    public ModelAndView forgetPassword(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("forgetPassword");
        return modelAndView;
    }

    @RequestMapping(value = "/forgetPasswordSubmit", method = RequestMethod.GET)
    public ModelAndView forgetPasswordSubmit(@RequestParam("email") String email,
                                       @RequestParam("password") String password){
        ModelAndView modelAndView=new ModelAndView();

        User user= userService.getUserByEmail(email);
        if(user!=null) {
            user.setPassword(Password.encryptPassword(password));
            userService.saveEmployee(user);
            modelAndView.addObject("msg", "Password Update SuccessFully !");
            modelAndView.setViewName("login");

        }else {
            modelAndView.addObject("msg", " User Not Exists !");
            modelAndView.setViewName("forgetPassword");
        }
        return modelAndView;
    }

}
