package com.hk.EmployeeReferral.daos;

import com.hk.EmployeeReferral.entities.Designation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesignationRepository extends JpaRepository<Designation, Long> {

}
