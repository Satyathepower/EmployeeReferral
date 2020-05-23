package com.hk.EmployeeReferral.services;

import com.hk.EmployeeReferral.entities.CandidateApplication;
import com.hk.EmployeeReferral.entities.InterviewProcess;
import com.hk.EmployeeReferral.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InterviewProcessService {

    void insertIntoInterviewProcess(Long interviewProcessStatusId, CandidateApplication candidateApplication, User user , String comments);

     List<InterviewProcess> getAllInterviewProcessByCanidateApplication(CandidateApplication candidateApplication);
}
