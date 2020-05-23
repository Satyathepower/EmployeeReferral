package com.hk.EmployeeReferral.daos;

import com.hk.EmployeeReferral.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> , JpaSpecificationExecutor<User> {

    User findByEmailAndPassword(String email, String password);
    User findByEmployeeId(String empId);
    User findByEmail(String email);
    List<User> findAll();
}
