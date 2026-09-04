package com.applyflow.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.applyflow.entity.JobApplication;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
List<JobApplication> findByStatus(String status);
}