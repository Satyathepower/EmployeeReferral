package com.hk.EmployeeReferral.daos;

import com.hk.EmployeeReferral.entities.Candidate;
import com.hk.EmployeeReferral.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {


}
