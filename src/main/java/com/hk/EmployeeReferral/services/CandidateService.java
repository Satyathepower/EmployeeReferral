package com.hk.EmployeeReferral.services;

import com.hk.EmployeeReferral.entities.Candidate;
import com.hk.EmployeeReferral.entities.CandidateApplication;
import com.hk.EmployeeReferral.entities.Job;
import com.hk.EmployeeReferral.entities.User;

import java.util.Date;
import java.util.List;

public interface CandidateService {

    Candidate saveCandidate(Candidate candidate);
    Candidate getByEmail(String email);
    CandidateApplication getByCandidate(Candidate candidate);
    List<CandidateApplication> getReferCandidateByApplication(User user);


}
