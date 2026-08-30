package com.applyflow.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.applyflow.entity.JobApplication;
import com.applyflow.service.JobApplicationService;

@RestController
public class JobApplicationController {
    
    @GetMapping("/applications")
public List<JobApplication> getAllJobApplications() {
    return jobApplicationService.getAllJobApplications();
}

    private final JobApplicationService jobApplicationService;

    public JobApplicationController(JobApplicationService jobApplicationService) {
        this.jobApplicationService = jobApplicationService;
    }
    

    @PostMapping("/applications")
    public JobApplication createJobApplication(@RequestBody JobApplication jobApplication) {
        return jobApplicationService.saveJobApplication(jobApplication);
    }
}