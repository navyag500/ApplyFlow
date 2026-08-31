package com.applyflow.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.applyflow.entity.JobApplication;
import com.applyflow.repository.JobApplicationRepository;

@Service
public class JobApplicationService {
    public List<JobApplication> getAllJobApplications() {
    return jobApplicationRepository.findAll();
}

    private final JobApplicationRepository jobApplicationRepository;

    public JobApplicationService(JobApplicationRepository jobApplicationRepository) {
        this.jobApplicationRepository = jobApplicationRepository;
    }

    public JobApplication saveJobApplication(JobApplication jobApplication) {
        return jobApplicationRepository.save(jobApplication);
    }
    public JobApplication getJobApplicationById(Long id) {
    return jobApplicationRepository.findById(id).orElse(null);
}
}