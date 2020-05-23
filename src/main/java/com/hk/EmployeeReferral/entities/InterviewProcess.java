package com.hk.EmployeeReferral.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "interview_process")
public class InterviewProcess implements Serializable{

    private static final long serialVersionUID = 0x62A6DA99AABDA8A8L;


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_application_id")
    private CandidateApplication candidateApplication;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignee_id")
    private User assignee;

    @Column(name = "comments")
    private String comments;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "interview_date")
    private Date interviewDate=new Date();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "interview_status_id")
    private InterviewStatus interviewStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CandidateApplication getCandidateApplication() {
        return candidateApplication;
    }

    public void setCandidateApplication(CandidateApplication candidateApplication) {
        this.candidateApplication = candidateApplication;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(Date interviewDate) {
        this.interviewDate = interviewDate;
    }

    public InterviewStatus getInterviewStatus() {
        return interviewStatus;
    }

    public void setInterviewStatus(InterviewStatus interviewStatus) {
        this.interviewStatus = interviewStatus;
    }
}
