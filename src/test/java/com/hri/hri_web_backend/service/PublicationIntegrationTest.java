package com.hri.hri_web_backend.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.hri.hri_web_backend.domain.Publication;
import com.hri.hri_web_backend.domain.PublicationType;
import com.hri.hri_web_backend.dto.PublicationDto;

@SpringBootTest
@Transactional
class PublicationIntegrationTest {
	@Autowired PublicationService ps;

	@PostConstruct
	public void saveOne(){
		//given
		PublicationDto publicationDto = new PublicationDto();
		publicationDto.setId(1L);
		publicationDto.setPublication_type(PublicationType.JOURNAL);
		publicationDto.setDetail("detail example");
		publicationDto.setLink("link/example");
		publicationDto.setTopic("topic example");
		ps.savePublication(publicationDto);
	}

	@Test
	public void 출판물_생성_및_조회() throws Exception {
	    //when
		List<Publication> publicationsByType = ps.findPublicationsByType(PublicationType.JOURNAL);

		//then
		Assertions.assertThat(publicationsByType.get(0).getPublicationType()).isEqualTo(PublicationType.JOURNAL);
	}

	@Test
	public void 출판물_업데이트() throws Exception {
	    //given
			//to change
		PublicationDto publicationDto2 = new PublicationDto();
		publicationDto2.setPublication_type(PublicationType.BOOK);
		publicationDto2.setDetail("detail example2");
		publicationDto2.setLink("link/example2");
		publicationDto2.setTopic("topic example2");

		//when
		ps.updatePublication(publicationDto2,1L);

		List<Publication> publicationsByType = ps.findPublicationsByType(PublicationType.BOOK);

		//then
		Assertions.assertThat(publicationsByType.get(0).getTopic()).isEqualTo("topic example2");
	}

	@Test
	public void 출판물_삭제() throws Exception {
	    //given
	    //when
	    ps.deletePublication(1L);
	    //then
	    Assertions.assertThat(ps.findPublicationsByType(PublicationType.JOURNAL).isEmpty()).isTrue();
	}



}