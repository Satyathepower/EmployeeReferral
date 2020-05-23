package com.hk.EmployeeReferral.utility;

import com.hk.EmployeeReferral.entities.InterviewProcess;
import com.hk.EmployeeReferral.entities.InterviewStatus;

public enum EnumInterviewStatus {


    ON_HOLD(1L,"On Hold"),
    IN_PROCESS(2L,"In Process"),
    REJECTED(3L,"Rejected"),
    SELECT(4L,"Selected"),
    CONFIRM(5L,"Confirmed"),
    ACCEPT(6L,"Accepted");

    private java.lang.String name;

    private java.lang.Long id;

    EnumInterviewStatus(Long id, java.lang.String name) {
        this.name = name;
        this.id = id;
    }

    public java.lang.String getName() {
        return name;
    }

    public java.lang.Long getId() {
        return id;
    }

    public InterviewStatus asInterviewStatus() {
        InterviewStatus interviewStatus = new InterviewStatus();
        interviewStatus.setId(this.getId());
        interviewStatus.setName(this.getName());
        return interviewStatus;
    }

    public static EnumInterviewStatus getInterviewStatusById(Long id) {
        for (EnumInterviewStatus status : values()) {
            if (status.getId().equals(id)) {
                return status;
            }
        }
        return null;
    }

}
