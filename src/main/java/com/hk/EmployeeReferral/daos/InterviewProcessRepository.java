package com.hk.EmployeeReferral.daos;

import com.hk.EmployeeReferral.entities.CandidateApplication;
import com.hk.EmployeeReferral.entities.InterviewProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterviewProcessRepository extends JpaRepository<InterviewProcess, Long> {

   // InterviewProcess findByCandidateApplication(CandidateApplication candidateApplication);

    List<InterviewProcess> findByCandidateApplication(CandidateApplication candidateApplication);

}
