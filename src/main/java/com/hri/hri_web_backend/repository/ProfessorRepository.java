package com.hri.hri_web_backend.repository;

import com.hri.hri_web_backend.domain.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository  extends JpaRepository<Professor, Long> {
}
