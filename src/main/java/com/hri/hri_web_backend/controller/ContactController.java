package com.hri.hri_web_backend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hri.hri_web_backend.domain.Contact;
import com.hri.hri_web_backend.dto.ContactDto;
import com.hri.hri_web_backend.global.StatusEnum;
import com.hri.hri_web_backend.global.SuccessResponse;
import com.hri.hri_web_backend.service.ContactService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ContactController {

	private final ContactService contactService;

	@ResponseBody
	@GetMapping("/api/contact")
	public SuccessResponse getContact(){
		List<Contact> contact = contactService.getContact();
		return SuccessResponse.builder()
			.status(StatusEnum.OK)
			.message("Contact 조회 성공")
			.data(contact)
			.build();
	}

	@ResponseBody
	@PostMapping("/api/admin/contact")
	public SuccessResponse registerContact(@Valid @RequestBody ContactDto contactDto){
		contactService.registerContact(contactDto);
		return SuccessResponse.builder()
			.status(StatusEnum.OK)
			.message("Contact 등록 성공")
			.build();
	}

	@ResponseBody
	@PutMapping("/api/admin/contact/{id}")
	public SuccessResponse updateContact(@Valid @RequestBody ContactDto contactDto, @PathVariable Long id){
		contactService.changeContactInfo(contactDto, id);
		return SuccessResponse.builder()
			.status(StatusEnum.OK)
			.message("Contact 수정 성공")
			.build();
	}

	@ResponseBody
	@DeleteMapping("/api/admin/contact/{id}")
	public SuccessResponse deleteContact(@PathVariable Long id){
		contactService.deleteContact(id);
		return SuccessResponse.builder()
			.status(StatusEnum.OK)
			.message("Contact 삭제 성공")
			.build();
	}
}
