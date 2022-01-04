package com.hri.hri_web_backend.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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

	private final PublicationRepository publicationRepository;

	//생성
	@Transactional
	public void savePublication(@Valid PublicationDto publicationDto){
		Publication publication = Publication.builder()
			.link(publicationDto.getLink())
			.publicationType(publicationDto.getPublication_type())
			.topic(publicationDto.getTopic())
			.detail(publicationDto.getDetail())
			.fillingNo(publicationDto.getFillingNo())
			.fillingDate(publicationDto.getFillingDate())
			.grantedNo(publicationDto.getGrantedNo())
			.grantedDate(publicationDto.getGrantedDate())
			.inventor(publicationDto.getInventor())
			.progress(publicationDto.getProgress())
			.build();
		Publication saved = publicationRepository.save(publication);
	}

	//조회
	public List<Publication> findPublicationsByType(PublicationType type){
		return publicationRepository.findByPublicationTypeOrderByFillingDateDesc(type);
	}

	//수정
	@Transactional
	public void updatePublication(PublicationDto publicationDto, Long id) {
		Optional<Publication> publication = publicationRepository.findById(id);
		if(publication.isEmpty()) {
			throw new NullPointerException();
		}
		Publication publication1 = publication.get();
		publication1.setPublicationType(publicationDto.getPublication_type());
		publication1.setDetail(publicationDto.getDetail());
		publication1.setLink(publicationDto.getLink());
		publication1.setTopic(publicationDto.getTopic());
		publication1.setFillingNo(publicationDto.getFillingNo());
		publication1.setFillingDate(publicationDto.getFillingDate());
		publication1.setGrantedNo(publicationDto.getGrantedNo());
		publication1.setGrantedDate(publicationDto.getGrantedDate());
		publication1.setInventor(publicationDto.getInventor());
		publication1.setProgress(publicationDto.getProgress());

	}

	//삭제
	@Transactional
	public void deletePublication(Long id){
		publicationRepository.deleteById(id); //EmptyResultDataAccessException 발생 가능
	}
}
