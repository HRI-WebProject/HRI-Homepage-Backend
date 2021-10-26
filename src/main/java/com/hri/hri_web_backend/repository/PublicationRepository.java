package com.hri.hri_web_backend.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hri.hri_web_backend.domain.Publication;
import com.hri.hri_web_backend.domain.PublicationType;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long> {
	List<Publication> findByPublicationType(Enum<PublicationType> type);
}
