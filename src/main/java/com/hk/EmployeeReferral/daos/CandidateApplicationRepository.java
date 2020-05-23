package com.hk.EmployeeReferral.daos;

import com.hk.EmployeeReferral.entities.Candidate;
import com.hk.EmployeeReferral.entities.CandidateApplication;
import com.hk.EmployeeReferral.entities.Job;
import com.hk.EmployeeReferral.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateApplicationRepository extends JpaRepository<CandidateApplication, Long>, JpaSpecificationExecutor<CandidateApplication> {

    public List<CandidateApplication>  findByJob(Job job);
    public CandidateApplication findByCandidate(Candidate candidate);
    List<CandidateApplication>  findByUser(User user);
}
