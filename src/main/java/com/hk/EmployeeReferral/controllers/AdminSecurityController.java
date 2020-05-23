package com.hk.EmployeeReferral.controllers;

import com.hk.EmployeeReferral.bean.UserBean;
import com.hk.EmployeeReferral.entities.Job;
import com.hk.EmployeeReferral.services.JobService;
import com.hk.EmployeeReferral.utility.EnumDepartment;
import com.hk.EmployeeReferral.utility.EnumJobStatus;
import com.hk.EmployeeReferral.utility.EnumUserType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/admin")
public class AdminSecurityController {

    @Autowired
    JobService jobService;

    @Value(value = "${jd.upload.path}")
    private String jdUploadPath;

    private List<Job> jobs;


    private RedirectStrategy redirectStrategy =new DefaultRedirectStrategy();
    private static final Logger logger = LogManager.getLogger(AdminSecurityController.class);

    @RequestMapping(value = "/afterLogin")
    public ModelAndView loginPost(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        logger.info("inside login");

        HttpSession session = request.getSession();
        UserBean authUser = (UserBean) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        session.setAttribute("userBean", authUser);

        response.setStatus(HttpServletResponse.SC_OK);

        String authority= authUser.getUserLoginBean().getUserType();
        if(authority.equals(EnumUserType.ADMIN.getName())){
            return new ModelAndView("redirect:/admin/hrJobList");
        }else if(authority.equals(EnumUserType.EMPLOYEE.getName())){
            return new ModelAndView("redirect:/emp/candidateJobList");
        }else {
            return new ModelAndView("redirect:../logout");
        }
    }
    @RequestMapping(value = "/createJob", method = RequestMethod.GET)
    public ModelAndView createJob() {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("newJob");
        return modelAndView;
    }



    @RequestMapping(value = "/hrJobList", method = RequestMethod.GET)
    public ModelAndView hrJobList(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView=new ModelAndView();
        UserBean userBean = (UserBean) request.getSession().getAttribute("userBean");
         jobs = jobService.findAllJobs();
         modelAndView.addObject("user",userBean.getUsername());
         modelAndView.addObject("jobs",jobs);
         modelAndView.setViewName("hrJobListing");
        return modelAndView;
    }

    @RequestMapping(value = "/jobForm", method = RequestMethod.POST)
    public ModelAndView createNewJob(@RequestParam("jobTitle") String jobTitle,
                               @RequestParam("department") Long department,
                               @RequestParam("experience") Long experience,
                               @RequestParam("jobDescription") String jobDescription,
                               @RequestParam("jd_upload") MultipartFile file,
                                     HttpServletRequest request, HttpServletResponse response) {
        try {
            ModelAndView modelAndView =new ModelAndView();
            UserBean userBean = (UserBean) request.getSession().getAttribute("userBean");
            Job newJob = new Job();
            newJob.setJobTitle(jobTitle);
            newJob.setDepartment(EnumDepartment.getEnumDepartmentById(department).asGetDepartment());
            newJob.setExperience(experience);
            newJob.setJobDescription(jobDescription);
            newJob.setJobStatus(EnumJobStatus.OPEN.asGetJobStatus());
            String fileNameWithPath = jdUploadPath + "/" + file.getOriginalFilename();
            File file1 = new File(fileNameWithPath);
            file1.createNewFile();
            newJob.setFileDetails(file1.getAbsolutePath());
            jobService.createNewJob(newJob);
            jobs = jobService.findAllJobs();
            modelAndView.addObject("user",userBean.getUsername());
            modelAndView.addObject("jobs",jobs);
            modelAndView.setViewName("hrJobListing");
            return   modelAndView.addObject("msg", "Job posted successfully") ;
        }catch (Exception e){
          return   new ModelAndView().addObject("msg", "Error while posting job") ;
        }


    }
}
