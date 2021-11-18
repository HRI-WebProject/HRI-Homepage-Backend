package com.hri.hri_web_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hri.hri_web_backend.domain.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
