package com.hk.EmployeeReferral.daos;

import com.hk.EmployeeReferral.entities.Department;
import com.hk.EmployeeReferral.entities.JobStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobStatusRepository extends JpaRepository<JobStatus, Long> {
}
