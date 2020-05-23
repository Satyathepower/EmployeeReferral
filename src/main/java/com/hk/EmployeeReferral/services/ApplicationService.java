package com.hk.EmployeeReferral.services;

import com.hk.EmployeeReferral.bean.UserBean;
import com.hk.EmployeeReferral.entities.CandidateApplication;

import java.util.List;

public interface ApplicationService {

    List<CandidateApplication> getApplicationsForJobId(Long jobId);

    List<CandidateApplication> getApplicationsForUserId(Long userId);

    CandidateApplication getCandidateApplicationById(Long applicationId);

    void saveCandidateApplicationByCandidateApplication(CandidateApplication candidateApplication, UserBean userBean, String status);
}
