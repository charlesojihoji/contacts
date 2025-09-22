package edu.uoengland.contact.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public String saveAContact(@RequestBody ContactDetailsDTO contactDetailsDTO) {
		
		contactService.saveAContact(contactDetailsDTO);
		
		return "The message has been successfully saved.";
	}
	
	@GetMapping
	public List<ContactDetailsDTO> getAllContacts() {
		
		return contactService.getAllContacts();
	}
	
	@GetMapping("/{contactId}")
	public ContactDetailsDTO getAContact(@PathVariable UUID contactId) {
		
		return contactService.getAContact(contactId);
	}
	
	@PutMapping("/updateAContact")
	public String updateAContact(@RequestBody ContactDetailsDTO contactDetailsDTO) {
		
		contactService.updateAContact(contactDetailsDTO);
		
		return "The contact has been successfully updated.";
	}
	
	@DeleteMapping("/{contactId}")
	public String deleteAContact(@PathVariable UUID contactId) {
		
		return contactService.deleteAContact(contactId);
	}
}
