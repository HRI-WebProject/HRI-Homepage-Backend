package com.hri.hri_web_backend.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hri.hri_web_backend.domain.ResearchEquipment;
import com.hri.hri_web_backend.repository.ResearchEquipmentRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ResearchEquipmentService {
	private final ResearchEquipmentRepository researchEquipmentRepository;

	public void saveResearchEquipment(@Valid ResearchEquipment researchEquipment){
		researchEquipmentRepository.save(researchEquipment);
	}

	public List<ResearchEquipment> getResearchEquipments() {
		return researchEquipmentRepository.findAll();
	}

	public void updateResearchEquipment(ResearchEquipment researchEquipment, Long id){
		Optional<ResearchEquipment> updateEquipment = researchEquipmentRepository.findById(id);
		if(updateEquipment.isEmpty())
			throw new NullPointerException();

		updateEquipment.ifPresent(equipment->{
			equipment.setName(researchEquipment.getName());
			equipment.setEngName(researchEquipment.getEngName());
			equipment.setPhoto(researchEquipment.getPhoto());
		});
	}

	public void deleteResearchEquipment(Long id){
		researchEquipmentRepository.deleteById(id);
	}
}
