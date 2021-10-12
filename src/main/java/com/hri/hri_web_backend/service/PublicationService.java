package com.hri.hri_web_backend.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hri.hri_web_backend.domain.Publication;
import com.hri.hri_web_backend.domain.PublicationType;
import com.hri.hri_web_backend.dto.PublicationDto;
import com.hri.hri_web_backend.repository.PublicationRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PublicationService {

	private final PublicationRepository pr;

	//생성
	@Transactional
	public void savePublication(@Valid PublicationDto publicationDto){
		Publication publication = Publication.builder()
			.id(publicationDto.getId())
			.link(publicationDto.getLink())
			.publication_type(publicationDto.getPublication_type())
			.topic(publicationDto.getTopic())
			.detail(publicationDto.getDetail())
			.build();
		Publication saved = pr.save(publication);
	}

	//조회
	public List<Publication> findPublicationsByType(PublicationType type){
		return pr.findByType(type);
	}

	//수정
	public void updatePublication(PublicationDto publicationDto, Long id) {
		Publication publication = Publication.builder()
			.id(publicationDto.getId())
			.link(publicationDto.getLink())
			.publication_type(publicationDto.getPublication_type())
			.topic(publicationDto.getTopic())
			.detail(publicationDto.getDetail())
			.build();
		pr.save(publication);
	}

	//삭제
	public void deletePublication(Long id){
		pr.deleteById(id); //EmptyResultDataAccessException 발생 가능
	}
}
