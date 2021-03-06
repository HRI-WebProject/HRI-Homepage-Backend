package com.hri.hri_web_backend.service;

import com.hri.hri_web_backend.domain.Administrator;
import com.hri.hri_web_backend.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;

    @Transactional
    public Long join(Administrator administrator){
        adminRepository.save(administrator);
        return administrator.getId();
    }

    public Administrator findAdminByUsernameAndPassword(Administrator administrator){
        Optional<Administrator> admin = adminRepository.findByUsernameAndPassword(administrator.getUsername(), administrator.getPassword());
        if(admin.isEmpty()){
            throw new NullPointerException();
        }else{
            return admin.get();
        }
    }

    public Administrator findAdminById(Long id){
        Optional<Administrator> admin = adminRepository.findById(id);
        if(admin.isEmpty()){
            throw new NullPointerException();
        }else{
            return admin.get();
        }
    }
}
