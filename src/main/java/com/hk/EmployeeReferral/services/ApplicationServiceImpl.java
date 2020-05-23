package com.hk.EmployeeReferral.services;

import com.hk.EmployeeReferral.bean.UserBean;
import com.hk.EmployeeReferral.daos.CandidateApplicationRepository;
import com.hk.EmployeeReferral.daos.JobRepository;
import com.hk.EmployeeReferral.entities.CandidateApplication;
import com.hk.EmployeeReferral.entities.InterviewProcess;
import com.hk.EmployeeReferral.entities.Job;
import com.hk.EmployeeReferral.utility.EnumInterviewStatus;
import com.hk.EmployeeReferral.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicationServiceImpl implements ApplicationService{

    @Autowired
    JobService jobService;

    @Autowired
    UserService userService;

    @Autowired
    InterviewProcessService interviewProcessService;

    @Autowired
    CandidateApplicationRepository candidateApplicationRepository;

    public List<CandidateApplication> getApplicationsForJobId(Long jobId){
         Job job=jobService.getJobById(jobId);
         List<CandidateApplication> candidateApplicationList=candidateApplicationRepository.findByJob(job);
         return candidateApplicationList;
    }

    public List<CandidateApplication> getApplicationsForUserId(Long userId){
        User user=userService.getUserById(userId);
        List<CandidateApplication> candidateApplicationList=candidateApplicationRepository.findByUser(user);
        return candidateApplicationList;
    }

    @Override
    public CandidateApplication getCandidateApplicationById(Long applicationId) {
        Optional<CandidateApplication> oCandidateApplication = candidateApplicationRepository.findById(applicationId);
        return oCandidateApplication.isPresent() ? oCandidateApplication.get() : null;
    }

    @Override
    public void saveCandidateApplicationByCandidateApplication(CandidateApplication candidateApplication, UserBean  userBean, String status) {
        candidateApplication.setApplicationStatus(status);
        candidateApplicationRepository.save(candidateApplication);
        User user=  userService.getUserByEmail(userBean.getUserLoginBean().getLoginId());
        interviewProcessService.insertIntoInterviewProcess(EnumInterviewStatus.ACCEPT.getId(),candidateApplication ,user ,"");
    }
}
