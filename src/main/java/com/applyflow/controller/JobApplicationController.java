package com.applyflow.controller;
import com.applyflow.entity.ApplicationStatus;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.applyflow.entity.JobApplication;
import com.applyflow.service.JobApplicationService;

import jakarta.validation.Valid;

@RestController
public class JobApplicationController {

    private final JobApplicationService jobApplicationService;

    public JobApplicationController(JobApplicationService jobApplicationService) {
        this.jobApplicationService = jobApplicationService;
    }

    @PostMapping("/applications")
    public JobApplication createJobApplication(
            @Valid @RequestBody JobApplication jobApplication) {

        return jobApplicationService.saveJobApplication(jobApplication);
    }

    @GetMapping("/applications")
    public List<JobApplication> getAllJobApplications() {
        return jobApplicationService.getAllJobApplications();
    }

    @GetMapping("/applications/{id}")
    public JobApplication getJobApplicationById(@PathVariable Long id) {
        return jobApplicationService.getJobApplicationById(id);
    }

    @PutMapping("/applications/{id}")
    public JobApplication updateJobApplication(
            @PathVariable Long id,
            @Valid @RequestBody JobApplication updatedApplication) {

        return jobApplicationService.updateJobApplication(id, updatedApplication);
    }

    @DeleteMapping("/applications/{id}")
    public void deleteJobApplication(@PathVariable Long id) {
        jobApplicationService.deleteJobApplication(id);
    }

    @GetMapping("/applications/status/{status}")
public List<JobApplication> getJobApplicationsByStatus(
        @PathVariable ApplicationStatus status) {
    return jobApplicationService.getJobApplicationsByStatus(status);
}

    @GetMapping("/applications/company/{companyName}")
    public List<JobApplication> getJobApplicationsByCompany(
            @PathVariable String companyName) {

        return jobApplicationService.getJobApplicationsByCompany(companyName);
    }
    @GetMapping("/applications/stats")
public Map<String, Long> getApplicationStatistics() {
    return jobApplicationService.getApplicationStatistics();
}

    @GetMapping("/applications/search")
    public List<JobApplication> searchJobApplications(
            @RequestParam String company) {

        return jobApplicationService.searchJobApplicationsByCompany(company);
    }
}