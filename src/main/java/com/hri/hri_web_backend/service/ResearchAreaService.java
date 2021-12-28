package com.hri.hri_web_backend.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hri.hri_web_backend.domain.ResearchArea;
import com.hri.hri_web_backend.repository.ResearchAreaRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ResearchAreaService {
	private final ResearchAreaRepository researchAreaRepository;

	public void saveResearchArea(@Valid ResearchArea researchArea){
		researchAreaRepository.save(researchArea);
	}

	public List<ResearchArea> getResearchAreas() {
		return researchAreaRepository.findAll();
	}

	public void updateResearchArea(ResearchArea researchArea, Long id){
		Optional<ResearchArea> updateArea = researchAreaRepository.findById(id);
		if(updateArea.isEmpty())
			throw new NullPointerException();

		updateArea.ifPresent(area->{
			area.setName(researchArea.getName());
			area.setEngName(researchArea.getEngName());
			area.setPhoto(researchArea.getPhoto());
			area.setDetail(researchArea.getDetail());
			area.setEngDetail(researchArea.getEngDetail());
		});
	}

	public void deleteResearchArea(Long id){
		researchAreaRepository.deleteById(id);
	}

}
