package com.applyflow.service;
import java.util.List;
import com.applyflow.entity.ApplicationStatus;
import org.springframework.stereotype.Service;

import com.applyflow.entity.JobApplication;
import com.applyflow.repository.JobApplicationRepository;
import com.applyflow.exception.ResourceNotFoundException;
import java.util.HashMap;
import java.util.Map;
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
    public Map<String, Long> getApplicationStatistics() {

    Map<String, Long> statistics = new HashMap<>();

    statistics.put("applied", jobApplicationRepository.countByStatus(ApplicationStatus.APPLIED));
statistics.put("interview", jobApplicationRepository.countByStatus(ApplicationStatus.INTERVIEW));
statistics.put("rejected", jobApplicationRepository.countByStatus(ApplicationStatus.REJECTED));
statistics.put("offer", jobApplicationRepository.countByStatus(ApplicationStatus.OFFER));
    return statistics;
}
public List<JobApplication> getApplicationsSortedByDate() {
    return jobApplicationRepository.findAllByOrderByApplicationDateDesc();
}
    public JobApplication getJobApplicationById(Long id) {
    return jobApplicationRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(
                    "Job application not found with id: " + id));
}
public void deleteJobApplication(Long id) {
    jobApplicationRepository.deleteById(id);
}
public List<JobApplication> getJobApplicationsByStatus(ApplicationStatus status) {
    return jobApplicationRepository.findByStatus(status);
}
public List<JobApplication> getJobApplicationsByCompany(String companyName) {
    return jobApplicationRepository.findByCompanyName(companyName);
}
public List<JobApplication> searchJobApplicationsByCompany(String companyName) {
    return jobApplicationRepository.findByCompanyNameContainingIgnoreCase(companyName);
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