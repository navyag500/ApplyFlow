package com.applyflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.applyflow.entity.JobApplication;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {

}