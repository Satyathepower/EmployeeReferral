package com.hk.EmployeeReferral.utility;

import com.hk.EmployeeReferral.entities.JobStatus;

public enum EnumJobStatus {
    OPEN(1L,"Open"),
    CLOSE(2L,"Close");

    public Long id;
    public String name;

    EnumJobStatus(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public JobStatus asGetJobStatus(){
        JobStatus jobStatus=new JobStatus();
        jobStatus.setId(this.id);
        jobStatus.setName(this.name);
         return jobStatus;
    }

    public static EnumJobStatus getEnumJobStatusById(Long id){
        for (EnumJobStatus status: values()){
            if(status.getId().equals(id)){
                return status;
            }
        }
        return null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
