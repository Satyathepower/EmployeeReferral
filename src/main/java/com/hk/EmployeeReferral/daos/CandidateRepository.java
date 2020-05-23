package com.hk.EmployeeReferral.daos;

import com.hk.EmployeeReferral.entities.Candidate;
import com.hk.EmployeeReferral.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer> , JpaSpecificationExecutor<Candidate> {
   Candidate findByEmail(String email );
}
