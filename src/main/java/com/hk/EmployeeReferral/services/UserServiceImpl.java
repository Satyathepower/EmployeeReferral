package com.hk.EmployeeReferral.services;

import com.hk.EmployeeReferral.daos.CandidateApplicationRepository;
import com.hk.EmployeeReferral.daos.UserRepository;
import com.hk.EmployeeReferral.entities.CandidateApplication;
import com.hk.EmployeeReferral.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CandidateApplicationRepository candidateApplicationRepository;

    @Override
    public User getUserById(String empId){
        return  userRepository.findByEmployeeId(empId);
    }

    @Override
    public User getUserByEmail(String email){
        return  userRepository.findByEmail(email);
    }

    @Override
    public CandidateApplication saveCandidateApplication(CandidateApplication candidateApplication){
        return candidateApplicationRepository.save(candidateApplication);
    }

    public User getUserById(Long userId){
        return  userRepository.getOne(userId);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User saveEmployee(User user) {
        return userRepository.save(user);
    }
}
