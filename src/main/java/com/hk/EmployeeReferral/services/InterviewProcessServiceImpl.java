package com.hk.EmployeeReferral.services;

import com.hk.EmployeeReferral.daos.InterviewProcessRepository;
import com.hk.EmployeeReferral.entities.CandidateApplication;
import com.hk.EmployeeReferral.entities.InterviewProcess;
import com.hk.EmployeeReferral.entities.User;
import com.hk.EmployeeReferral.utility.EnumInterviewStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class InterviewProcessServiceImpl implements InterviewProcessService {

    @Autowired
    private UserService userService;

    @Autowired
    private InterviewProcessRepository interviewProcessRepository;

    @Override
    public void insertIntoInterviewProcess(Long interviewProcessStatusId, CandidateApplication candidateApplication , User user, String comments) {
        InterviewProcess interviewProcess = new InterviewProcess();
        interviewProcess.setAssignee(userService.getUserById( user.getEmployeeId()));
        interviewProcess.setCandidateApplication(candidateApplication);
        interviewProcess.setInterviewDate(new Date());
        interviewProcess.setInterviewStatus(EnumInterviewStatus.getInterviewStatusById(interviewProcessStatusId).asInterviewStatus());
        interviewProcess.setComments(comments);
        interviewProcessRepository.save(interviewProcess);
    }

    @Override
    public List<InterviewProcess> getAllInterviewProcessByCanidateApplication(CandidateApplication candidateApplication) {
        return interviewProcessRepository.findByCandidateApplication(candidateApplication);
    }
}
