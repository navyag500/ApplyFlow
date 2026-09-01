package com.applyflow.controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.applyflow.entity.JobApplication;
import com.applyflow.service.JobApplicationService;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    @GetMapping("/applications/{id}")
public JobApplication getJobApplicationById(@PathVariable Long id) {
    return jobApplicationService.getJobApplicationById(id);
}
@DeleteMapping("/applications/{id}")
public void deleteJobApplication(@PathVariable Long id) {
    jobApplicationService.deleteJobApplication(id);
}
@PutMapping("/applications/{id}")
public JobApplication updateJobApplication(
        @PathVariable Long id,
        @RequestBody JobApplication updatedApplication) {

    return jobApplicationService.updateJobApplication(id, updatedApplication);
}
}