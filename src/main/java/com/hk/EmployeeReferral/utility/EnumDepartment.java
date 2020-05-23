package com.hk.EmployeeReferral.utility;

import com.hk.EmployeeReferral.entities.Department;

import java.util.Arrays;
import java.util.List;

public enum EnumDepartment {

    TECH(1L,"TECH"),
    HR(2L, "HR"),
    IT(3L,"IT"),
    ANALYTICS(4L, "Analytics"),
    ADMIN(5L,"Admin"),
    FINANCE(6L,"Finance");

    EnumDepartment(Long id, String name){
        this.id=id;
        this.name=name;
    }

    public Department asGetDepartment(){
        Department department=new Department();
        department.setId(this.id);
        department.setName(this.name);
        return department;
    }

    public static EnumDepartment getEnumDepartmentById(Long id){
        for(EnumDepartment status: values()){
            if(status.getId().equals(id)){
                return status;
            }
        }
        return null;
    }


    public static List<Department> getArrayListOfDepartment(){
      return   Arrays.asList(TECH.asGetDepartment(),HR.asGetDepartment(),IT.asGetDepartment(),ANALYTICS.asGetDepartment(),ADMIN.asGetDepartment(),FINANCE.asGetDepartment());
    }

    private Long id;

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

    private String name;

}
