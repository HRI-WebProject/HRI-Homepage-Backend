package com.hri.hri_web_backend.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hri.hri_web_backend.domain.Publication;
import com.hri.hri_web_backend.domain.PublicationType;
import com.hri.hri_web_backend.dto.PublicationDto;

@SpringBootTest
class PublicationServiceTest {
	@Autowired PublicationService ps;

	@Test
	public void 출판물_생성_및_조회() throws Exception {
	    //given
		PublicationDto publicationDto = new PublicationDto();
		publicationDto.setPublication_type(PublicationType.JOURNAL);
		publicationDto.setDetail("detail example");
		publicationDto.setLink("link/example");
		publicationDto.setTopic("topic example");
		ps.savePublication(publicationDto);
	    //when
		List<Publication> publicationsByType = ps.findPublicationsByType(PublicationType.JOURNAL);
		//then
		Assertions.assertThat(publicationsByType.get(0).getPublication_type()).isEqualTo(PublicationType.JOURNAL);
	}


}