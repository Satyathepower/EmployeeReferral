package com.hk.EmployeeReferral.services;

import com.hk.EmployeeReferral.daos.CandidateApplicationRepository;
import com.hk.EmployeeReferral.daos.CandidateRepository;
import com.hk.EmployeeReferral.daos.JobRepository;
import com.hk.EmployeeReferral.daos.UserRepository;
import com.hk.EmployeeReferral.entities.Candidate;
import com.hk.EmployeeReferral.entities.CandidateApplication;
import com.hk.EmployeeReferral.entities.Job;
import com.hk.EmployeeReferral.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CandidateServiceImpl implements CandidateService{

    @Autowired
    CandidateRepository candidateRepository;
    @Autowired
    JobRepository jobRepository;
    @Autowired
    CandidateApplicationRepository candidateApplicationRepository;

    @Override
    public Candidate saveCandidate(Candidate candidate){
        return candidateRepository.save(candidate);
    }

    @Override
   public Candidate getByEmail(String email){
        return candidateRepository.findByEmail(email);
    }

    @Override
    public CandidateApplication getByCandidate(Candidate candidate){
        return candidateApplicationRepository.findByCandidate(candidate);
    }

    @Override
    public List<CandidateApplication> getReferCandidateByApplication(User user) {
        return candidateApplicationRepository.findByUser(user);
    }
}
