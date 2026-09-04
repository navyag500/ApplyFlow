package com.applyflow.service;
import java.util.List;
import org.springframework.stereotype.Service;
import java.util.List;
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
public void deleteJobApplication(Long id) {
    jobApplicationRepository.deleteById(id);
}
public List<JobApplication> getJobApplicationsByStatus(String status) {
    return jobApplicationRepository.findByStatus(status);
}
public List<JobApplication> getJobApplicationsByCompany(String companyName) {
    return jobApplicationRepository.findByCompanyName(companyName);
}
public JobApplication updateJobApplication(Long id, JobApplication updatedApplication) {
    JobApplication existingApplication = jobApplicationRepository.findById(id).orElse(null);

    if (existingApplication == null) {
        return null;
    }

    existingApplication.setCompanyName(updatedApplication.getCompanyName());
    existingApplication.setJobRole(updatedApplication.getJobRole());
    existingApplication.setStatus(updatedApplication.getStatus());
    existingApplication.setApplicationDate(updatedApplication.getApplicationDate());

    return jobApplicationRepository.save(existingApplication);
}
}