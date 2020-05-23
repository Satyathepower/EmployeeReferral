package com.hk.EmployeeReferral.daos;

import com.hk.EmployeeReferral.entities.Candidate;
import com.hk.EmployeeReferral.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
