package com.hk.EmployeeReferral.services;

import com.hk.EmployeeReferral.entities.Job;
import com.hk.EmployeeReferral.entities.JobStatus;

import java.util.List;

public interface JobService {

    List<Job> findAllJobs();

    JobStatus getJobStatusById(Long id);

    void createNewJob(Job newJob);

    Job getJobById(Long jobid);
}
