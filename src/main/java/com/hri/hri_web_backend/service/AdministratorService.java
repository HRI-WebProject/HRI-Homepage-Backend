package com.hri.hri_web_backend.service;

import com.hri.hri_web_backend.domain.Administrator;
import com.hri.hri_web_backend.repository.AdministratorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AdministratorService {

    private final AdministratorRepository administratorRepository;

    @Transactional
    public Long join(Administrator administrator){
        administratorRepository.save(administrator);
        return administrator.getId();
    }

    public Administrator findAdminByUsernameAndPassword(String username, String password){
        Optional<Administrator> admin = administratorRepository.findByUsernameAndPassword(username, password);
        return admin.orElse(null);
    }

    public Administrator findAdminById(Long id){
        Optional<Administrator> admin = administratorRepository.findById(id);
        return admin.orElse(null);
    }
}
