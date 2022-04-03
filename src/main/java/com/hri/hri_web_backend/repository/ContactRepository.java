package com.hri.hri_web_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hri.hri_web_backend.domain.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
