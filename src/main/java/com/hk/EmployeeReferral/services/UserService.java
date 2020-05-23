package com.hk.EmployeeReferral.services;

import com.hk.EmployeeReferral.entities.Candidate;
import com.hk.EmployeeReferral.entities.CandidateApplication;
import com.hk.EmployeeReferral.entities.User;

import java.util.List;

public interface UserService {

    User getUserById(String empId);
    CandidateApplication saveCandidateApplication(CandidateApplication candidateApplication);
    User getUserById(Long userId);
    User getUserByEmail(String email);
    List<User> getAllUser();
    User saveEmployee(User user);


}
