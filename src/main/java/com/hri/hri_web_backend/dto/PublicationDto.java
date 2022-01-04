package com.hri.hri_web_backend.dto;

import java.time.LocalDate;

import com.hri.hri_web_backend.domain.PublicationType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PublicationDto {
    Long id;
	String topic;
	String link;
	String Detail;
    PublicationType publication_type;

	String inventor;
	String fillingNo;
	LocalDate fillingDate;
	String grantedNo;
	LocalDate grantedDate;
	String progress;

}
