package com.hk.EmployeeReferral.utility;

public enum  ApplicationStatus {
    APPLIED(1L, "Applied"),
    REJECT (2L, "Reject");



    private String name;
    private Long id;

    ApplicationStatus(Long id, String name) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }
}
