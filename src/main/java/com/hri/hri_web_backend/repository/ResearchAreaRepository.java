package com.hri.hri_web_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hri.hri_web_backend.domain.ResearchArea;

@Repository
public interface ResearchAreaRepository extends JpaRepository<ResearchArea, Long> {

}
