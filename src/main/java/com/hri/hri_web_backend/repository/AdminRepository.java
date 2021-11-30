package com.hri.hri_web_backend.repository;

import com.hri.hri_web_backend.domain.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdminRepository extends JpaRepository<Administrator, Long> {

    Optional<Administrator> findByUsernameAndPassword(String username, String password);
    Administrator findByUsername(String username);
}
