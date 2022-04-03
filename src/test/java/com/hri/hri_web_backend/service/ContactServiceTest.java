package com.hri.hri_web_backend.service;

import static org.mockito.BDDMockito.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hri.hri_web_backend.domain.Contact;
import com.hri.hri_web_backend.dto.ContactDto;
import com.hri.hri_web_backend.repository.ContactRepository;

@ExtendWith(MockitoExtension.class)
class ContactServiceTest {

	@InjectMocks
	ContactService contactService;

	@Mock
	ContactRepository contactRepository;

	@DisplayName("Contact 가져오기")
	@Test
	public void getContact() throws Exception {
		//when
		List<Contact> contact = contactService.getContact();
		//then
		then(contactRepository).should(times(1)).findAll();
	}

	@DisplayName("Contact를 등록한다")
	@Test
	public void registerContact() throws Exception {
		//given
		final ContactDto contactDto = ContactDto.builder()
			.professorName("prof name")
			.professorEmail("ex@ex.com")
			.professorPhone("010-0000-0000")
			.labManagerName("lm name")
			.labManagerEmail("ex2@ex2.com")
			.labManagerPhone("010-000-000")
			.officeLocation("loc info")
			.officePhone("02-000-0000")
			.build();
		//when
		contactService.registerContact(contactDto);
		//then
		then(contactRepository).should(times(1)).save(any());
	}

	@DisplayName("Contact를 삭제한다")
	@Test
	public void deleteContact() throws Exception {
		//when
		contactService.deleteContact(0L);
		//then
		then(contactRepository).should(times(1)).deleteById(any());
	}
}