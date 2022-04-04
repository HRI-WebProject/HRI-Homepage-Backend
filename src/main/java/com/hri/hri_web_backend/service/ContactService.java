package com.hri.hri_web_backend.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.hri.hri_web_backend.domain.Contact;
import com.hri.hri_web_backend.dto.ContactDto;
import com.hri.hri_web_backend.repository.ContactRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ContactService {

	private final ContactRepository contactRepository;

	public List<Contact> getContact(){
		return contactRepository.findAll();
	}

	public void registerContact(ContactDto contactDto){
		Contact contact = Contact.builder()
			.professorName(contactDto.getProfessorName())
			.professorEmail(contactDto.getProfessorEmail())
			.professorPhone(contactDto.getOfficePhone())
			.labManagerName(contactDto.getLabManagerName())
			.labManagerEmail(contactDto.getLabManagerEmail())
			.labManagerPhone(contactDto.getLabManagerPhone())
			.officeLocation(contactDto.getOfficeLocation())
			.officePhone(contactDto.getOfficePhone())
			.build();
		contactRepository.save(contact);
	}

	public void changeContactInfo(ContactDto contactDto, Long id){
		Optional<Contact> updateContact = contactRepository.findById(id);
		if(updateContact.isEmpty())
			throw new NullPointerException();

		updateContact.ifPresent(selectContact->{
			selectContact.setProfessorName(contactDto.getProfessorName());
			selectContact.setProfessorEmail(contactDto.getProfessorEmail());
			selectContact.setProfessorPhone(contactDto.getProfessorPhone());
			selectContact.setLabManagerName(contactDto.getLabManagerName());
			selectContact.setLabManagerEmail(contactDto.getLabManagerEmail());
			selectContact.setLabManagerPhone(contactDto.getLabManagerPhone());
			selectContact.setOfficeLocation(contactDto.getOfficeLocation());
			selectContact.setOfficePhone(contactDto.getOfficePhone());
		});
	}

	public void deleteContact(Long id){
		contactRepository.deleteById(id);
	}
}