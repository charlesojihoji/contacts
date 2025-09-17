package edu.uoengland.contact.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.uoengland.contact.dto.ContactDetailsDTO;
import edu.uoengland.contact.repository.ContactRepository;
import edu.uoengland.contact.service.ContactService;

@RestController
@RequestMapping("/contact")
@CrossOrigin("*")
public class ContactControllers {

	@Autowired
	private ContactService contactService;
	
	@PostMapping
	public String saveAMessage(@RequestBody ContactDetailsDTO contactDetailsDTO) {
		
		contactService.saveAMessage(contactDetailsDTO);
		
		return "The message has been successfully saved.";
	}
	
}
