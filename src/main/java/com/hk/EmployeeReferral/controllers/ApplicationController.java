package com.hk.EmployeeReferral.controllers;

import com.hk.EmployeeReferral.bean.UserBean;
import com.hk.EmployeeReferral.daos.InterviewProcessRepository;
import com.hk.EmployeeReferral.entities.CandidateApplication;
import com.hk.EmployeeReferral.entities.InterviewProcess;
import com.hk.EmployeeReferral.entities.User;
import com.hk.EmployeeReferral.services.ApplicationService;
import com.hk.EmployeeReferral.services.InterviewProcessService;
import com.hk.EmployeeReferral.services.UserService;
import com.hk.EmployeeReferral.utility.EnumInterviewStatus;
import com.hk.EmployeeReferral.utility.EnumUserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.QueryParam;
import java.util.List;

@RestController
@RequestMapping(value = {"/app", "/emp", "/admin"})
public class ApplicationController {

    @Autowired
    ApplicationService applicationService;

    @Autowired
    UserService userService;

    @Autowired
    InterviewProcessService interviewProcessService;

    @Autowired
    InterviewProcessRepository interviewProcessRepository;

    @RequestMapping(value = "/viewAllApplications", method = RequestMethod.GET)
    public ModelAndView viewAllApplications(@QueryParam("jobId") Long jobId) {

        List<CandidateApplication> candidateApplicationList = applicationService.getApplicationsForJobId(jobId);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("applicationList");
        modelAndView.addObject("candidateApplicationList",candidateApplicationList);
        return modelAndView;
    }

    @RequestMapping(value = "/viewAssignedToUserInProcessInterviews", method = RequestMethod.GET)
    public ModelAndView viewAssignedToUserInProcessInterviews(HttpServletRequest request, HttpServletResponse response) {
        UserBean userBean= (UserBean) request.getSession().getAttribute("userBean");
        User user= userService.getUserByEmail(userBean.getUsername());
        List<CandidateApplication> candidateApplicationList = applicationService.getApplicationsForUserId(user.getId());
        ModelAndView modelAndView=new ModelAndView();
        if(user.getUserType().equals(EnumUserType.EMPLOYEE.getId())) {
            modelAndView.setViewName("empInterviewList");
        }else {
            modelAndView.setViewName("interviewList");
        }
        modelAndView.addObject("candidateApplicationList",candidateApplicationList);
        return modelAndView;
    }

    @RequestMapping(value = "/accepted", method = RequestMethod.POST)
    public ModelAndView applicationAccepted(HttpServletRequest request, HttpServletResponse response,
                                            @QueryParam("applicationId") Long applicationId) {
        UserBean userBean = (UserBean) request.getSession().getAttribute("userBean");
        CandidateApplication candidateApplication = applicationService.getCandidateApplicationById(applicationId);
        applicationService.saveCandidateApplicationByCandidateApplication(candidateApplication,userBean, EnumInterviewStatus.ACCEPT.getName());
        List<CandidateApplication> candidateApplicationList = applicationService.getApplicationsForJobId(candidateApplication.getJob().getId());
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("applicationList");
        modelAndView.addObject("candidateApplicationList",candidateApplicationList);
        return modelAndView;
    }

    @RequestMapping(value = "/rejected", method = RequestMethod.POST)
    public ModelAndView applicationRejected(HttpServletRequest request, HttpServletResponse response,
                                            @QueryParam("applicationId") Long applicationId) {
        UserBean userBean = (UserBean) request.getSession().getAttribute("userBean");
        CandidateApplication candidateApplication = applicationService.getCandidateApplicationById(applicationId);
        applicationService.saveCandidateApplicationByCandidateApplication(candidateApplication,  userBean, EnumInterviewStatus.REJECTED.getName());
        List<CandidateApplication> candidateApplicationList = applicationService.getApplicationsForJobId(candidateApplication.getJob().getId());
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("applicationList");
        modelAndView.addObject("candidateApplicationList",candidateApplicationList);
        return modelAndView;
    }

    @RequestMapping(value = "/feedbackForm", method = RequestMethod.GET)
    public ModelAndView viewAllApplications(HttpServletRequest request, HttpServletResponse response, @QueryParam("applicationId") Long applicationId) {
        UserBean userBean= (UserBean) request.getSession().getAttribute("userBean");

        CandidateApplication candidateApplication = applicationService.getCandidateApplicationById(applicationId);
        ModelAndView modelAndView=new ModelAndView();
        if(userBean.getUserLoginBean().getUserType().equals(EnumUserType.EMPLOYEE.getName())){
            modelAndView.setViewName("empInterviewProcess");
        }else {
            modelAndView.setViewName("interviewProcess");
        }
        List<User>  userList= userService.getAllUser();

        modelAndView.addObject("userList",userList);
        modelAndView.addObject("candidateName",candidateApplication.getCandidate().getName());
        modelAndView.addObject("experience",candidateApplication.getCandidate().getExperienceYears());
        modelAndView.addObject("jobDesc",candidateApplication.getJob().getJobDescription());
        modelAndView.addObject("applicationId",applicationId);

        return modelAndView;
    }

    @RequestMapping(value = "/feedbackApplication", method = RequestMethod.POST)
    public ModelAndView feedbackApplication(HttpServletRequest request, HttpServletResponse response,
                                            @RequestParam("applicationId") Long applicationId,
                                            @RequestParam("assigneeTo") Long userId,
                                            @RequestParam("status") Long status,
                                            @RequestParam("comments") String comments){
     try {
         CandidateApplication candidateApplication = applicationService.getCandidateApplicationById(applicationId);
         User user = userService.getUserById(userId);
         candidateApplication.setUser(user);
         candidateApplication.setApplicationStatus(EnumInterviewStatus.getInterviewStatusById(status).asInterviewStatus().getName());
         interviewProcessService.insertIntoInterviewProcess(status, candidateApplication, user, comments);

         return new ModelAndView("redirect:/app/viewAssignedToUserInProcessInterviews");
     }catch (Exception e){
         return new ModelAndView("redirect:../logout");
     }
    }


    @RequestMapping(value = "/interviewDetail", method = RequestMethod.GET)
    public ModelAndView  getInterviewDetail(@QueryParam("applicationId") Long applicationId ){
        ModelAndView modelAndView =new ModelAndView();
        CandidateApplication candidateApplication = applicationService.getCandidateApplicationById(applicationId);
        List<InterviewProcess> listOfInterviewProcess= interviewProcessService.getAllInterviewProcessByCanidateApplication(candidateApplication);
            if(listOfInterviewProcess !=null){
                       modelAndView.addObject("interviewsList",listOfInterviewProcess);
                       modelAndView.setViewName("interviewHistory");
            }else {
                return new ModelAndView("redirect:/app/viewAssignedToUserInProcessInterviews");
            }
           return modelAndView;
    }


}
