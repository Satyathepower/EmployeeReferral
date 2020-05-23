package com.hk.EmployeeReferral.controllers;

import com.hk.EmployeeReferral.bean.UserBean;
import com.hk.EmployeeReferral.entities.Candidate;
import com.hk.EmployeeReferral.entities.CandidateApplication;
import com.hk.EmployeeReferral.entities.Job;
import com.hk.EmployeeReferral.entities.User;
import com.hk.EmployeeReferral.services.CandidateService;
import com.hk.EmployeeReferral.services.JobService;
import com.hk.EmployeeReferral.services.UserService;
import com.hk.EmployeeReferral.utility.ApplicationStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping(value = "/emp")
public class EmployeeSecurityController {

    private static final Logger logger = LogManager.getLogger(EmployeeSecurityController.class);
    @Autowired
    CandidateService candidateService;

    @Autowired
    JobService jobService;

    @Autowired
    UserService userService;

    @Value(value = "${file.upload.path}")
    private String fileUploadPath;

    private List<Job> jobs = new ArrayList<Job>();

    @RequestMapping(value = "/candRegistation", method = RequestMethod.GET)
    public ModelAndView candRegistation(HttpServletRequest request, HttpServletResponse response,
                                        @RequestParam("jobId") Long refJobId) {
        UserBean userBean=(UserBean) request.getSession().getAttribute("userBean");
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("refJobId", refJobId);
       User user= userService.getUserByEmail(userBean.getUsername());
        modelAndView.addObject("empId",user.getEmployeeId());
        modelAndView.setViewName("candidateReg");
        return modelAndView;
    }

    @RequestMapping(value = "/candidateJobList", method = RequestMethod.GET)
    public ModelAndView candidateJobList(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView=new ModelAndView();
        UserBean userBean = (UserBean) request.getSession().getAttribute("userBean");
        jobs = jobService.findAllJobs();
        modelAndView.addObject("user",userBean.getUsername());
        modelAndView.addObject("jobs",jobs);
        modelAndView.setViewName("jobListing");
        return modelAndView;
    }

    @RequestMapping(value = "/candidateReferDetails", method = RequestMethod.GET)
    public ModelAndView candidateReferDetails(HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelAndView=new ModelAndView();
        UserBean userBean = (UserBean) request.getSession().getAttribute("userBean");
        User user= userService.getUserById(userBean.getUserLoginBean().getUserId());
        if(user !=null){
           List<CandidateApplication> listOfCandidateApplication= candidateService.getReferCandidateByApplication(user);
           if(listOfCandidateApplication!=null){
                 modelAndView.addObject("listOfCandidateApplication",listOfCandidateApplication);
                 modelAndView.setViewName("candidateReferDetails");
           }
        }
        return  modelAndView;
    }



    @RequestMapping(value = "/candRegistationForm", method = RequestMethod.POST)
    public ModelAndView candRegistationForm( @RequestParam("name") String name,
                                       @RequestParam("email") String email,
                                       @RequestParam("currentDes") String currentDes,
                                       @RequestParam("contact") String contact,
                                       @RequestParam("totalExpYr") Long totalExpYr,
                                       @RequestParam("totalExpMont") Long totalExpMont,
                                       @RequestParam("jobid") Long jobid,
                                       @RequestParam("cv_upload") MultipartFile file,
                                       @RequestParam("empId") String empId)  {
        ModelAndView modelAndView=new ModelAndView();
        try {
            Date referenceDate = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(referenceDate);
            c.add(Calendar.MONTH, -3);
            Date result = c.getTime();

            Candidate checkoldCand = candidateService.getByEmail(email);
            if (checkoldCand != null) {
                CandidateApplication checkcandAplication = candidateService.getByCandidate(checkoldCand);
                if (checkcandAplication != null && result.after(checkcandAplication.getCreateDate())) {
                    return   modelAndView.addObject("msg","allready applied with in 3 momnths.");

                } else {

                    Candidate candidateBean = new Candidate();
                    CandidateApplication candidateApplication = new CandidateApplication();
                    candidateBean.setName(name);
                    candidateBean.setEmail(email);
                    candidateBean.setCurrentDesignation(currentDes);
                    candidateBean.setContactNumber(contact);
                    candidateBean.setExperienceYears(totalExpYr);
                    candidateBean.setExperienceMonths(totalExpMont);

                    String fileNameWithPath = fileUploadPath + "/" + file.getOriginalFilename();
                    File file1 = new File(fileNameWithPath);
                    file1.createNewFile();
                    candidateBean.setCvFileDetails(file1.getAbsolutePath());

                    Candidate candidate = (Candidate) candidateService.saveCandidate(candidateBean);

                    Job job = jobService.getJobById(jobid);
                    candidateApplication.setJob(job);
                    candidateApplication.setCandidate(candidate);
                    candidateApplication.setApplicationStatus(ApplicationStatus.APPLIED.getName());
                    User user = userService.getUserById(empId);
                    candidateApplication.setUser(user);
                    userService.saveCandidateApplication(candidateApplication);
                    modelAndView.setViewName("candidateReg");
                }

            } else {

                Candidate candidateBean = new Candidate();
                CandidateApplication candidateApplication = new CandidateApplication();
                candidateBean.setName(name);
                candidateBean.setEmail(email);
                candidateBean.setCurrentDesignation(currentDes);
                candidateBean.setContactNumber(contact);
                candidateBean.setExperienceYears(totalExpYr);
                candidateBean.setExperienceMonths(totalExpMont);

                String fileNameWithPath = fileUploadPath + "/" + file.getOriginalFilename();
                File file1 = new File(fileNameWithPath);
                file1.createNewFile();
                candidateBean.setCvFileDetails(file1.getAbsolutePath());

                Candidate candidate = (Candidate) candidateService.saveCandidate(candidateBean);

                Job job = jobService.getJobById(jobid);
                candidateApplication.setJob(job);
                candidateApplication.setCandidate(candidate);
                candidateApplication.setApplicationStatus(ApplicationStatus.APPLIED.getName());
                User user = userService.getUserById(empId);
                candidateApplication.setUser(user);
                userService.saveCandidateApplication(candidateApplication);
                modelAndView.setViewName("candidateReg");
            }

        }catch (Exception e){
            return  new ModelAndView().addObject("msg","Error while Candidate Referred.");
        }
        return   modelAndView.addObject("msg","Job reffered successfully.");
    }
}
