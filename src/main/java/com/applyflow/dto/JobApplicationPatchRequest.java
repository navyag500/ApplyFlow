package com.applyflow.dto;

import java.time.LocalDate;

import com.applyflow.entity.ApplicationStatus;

import jakarta.validation.constraints.Size;

public class JobApplicationPatchRequest {

    @Size(min = 1, message = "Company name cannot be empty")
    private String companyName;

    @Size(min = 1, message = "Job role cannot be empty")
    private String jobRole;

    private ApplicationStatus status;

    private LocalDate applicationDate;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }
}