package com.hk.EmployeeReferral.utility;

import com.hk.EmployeeReferral.entities.Designation;

public enum EnumDesignation {

    SOFTWARE_ENGINEER(1L,"Software Engineer"),
    SENIOR_SOFTWARE_ENGINEER(2L,"S.Software Engineer"),
    TEAM_LEAD(3L, "Team Lead"),
    MANAGER(4L, "Manager"),
    GENERAL_MANAGER(5L, "General Manager");


    private Long id;
    private String name;

    EnumDesignation(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Designation asGetDesignation(){
        Designation designation=new Designation();
        designation.setId(this.id);
        designation.setName(this.name);
        return designation;
    }

    public static EnumDesignation getEnumDesignationById(Long id){

        for (EnumDesignation status: values()){
            if(status.getId().equals(id)){
                return status;
            }
        }

        return  null;
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
