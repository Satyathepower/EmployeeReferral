package com.hk.EmployeeReferral.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "candidate")
public class Candidate implements Serializable {

    private static final long serialVersionUID = 0x62A6DA99AABDA8A8L;


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "contact_no")
    private String contactNumber;

    @Column(name = "mail_id")
    private String email;

    @Column(name = "experience_years")
    private Long experienceYears;

    @Column(name = "experience_months")
    private Long experienceMonths;

    @Column(name = "current_designation")
    private String currentDesignation;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate=new Date();


    @Column(name = "cv_file_id")
    private String cvFileDetails;

    public String getCvFileDetails() {
        return cvFileDetails;
    }

    public void setCvFileDetails(String cvFileDetails) {
        this.cvFileDetails = cvFileDetails;
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

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(Long experienceYears) {
        this.experienceYears = experienceYears;
    }

    public Long getExperienceMonths() {
        return experienceMonths;
    }

    public void setExperienceMonths(Long experienceMonths) {
        this.experienceMonths = experienceMonths;
    }

    public String getCurrentDesignation() {
        return currentDesignation;
    }

    public void setCurrentDesignation(String currentDesignation) {
        this.currentDesignation = currentDesignation;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }


}
