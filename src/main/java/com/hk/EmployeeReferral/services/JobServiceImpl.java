package com.hk.EmployeeReferral.services;

import com.hk.EmployeeReferral.daos.JobRepository;
import com.hk.EmployeeReferral.daos.JobStatusRepository;
import com.hk.EmployeeReferral.entities.Job;
import com.hk.EmployeeReferral.entities.JobStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService{

    @Autowired
    JobRepository jobRepository;

    @Autowired
    JobStatusRepository jobStatusRepository;

    public List<Job> findAllJobs(){
         return jobRepository.findAll();
    }

    public JobStatus getJobStatusById(Long id){
        return jobStatusRepository.getOne(id);
    }

    public void createNewJob(Job newJob){
        jobRepository.save(newJob);
    }

    public Job getJobById(Long jobid){
        return  jobRepository.getOne(jobid);
    }

}
