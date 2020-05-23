package com.hk.EmployeeReferral.utility;

import com.hk.EmployeeReferral.entities.UserType;

public enum EnumUserType {
    EMPLOYEE(1L, "Employee"),
    ADMIN(2L,"Admin");

    private String name;
    private Long id;

    EnumUserType(Long id, String name) {
        this.name = name;
        this.id = id;
    }

    public UserType asGetUserType(){
        UserType userType=new UserType();
        userType.setId(this.id);
        userType.setName(this.name);
        return userType;
    }

    public static EnumUserType getEnumUserTypeById(Long id){
        for (EnumUserType status: values()){
            if(status.getId().equals(id)){
                return status;
            }
        }

        return null;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

}
