package edu.uoengland.contact.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uoengland.contact.dto.ContactDetailsDTO;
import edu.uoengland.contact.entity.ContactDetails;
import edu.uoengland.contact.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService{

	@Autowired
	private ContactRepository contactRepository;
	
	@Override
	public String saveAMessage(ContactDetailsDTO contactDetailsDTO) {

		ContactDetails theContactDetails = new ContactDetails(contactDetailsDTO.getContactId(), contactDetailsDTO.getContactName(), contactDetailsDTO.getPhoneNumber(),
				contactDetailsDTO.getAddress(), contactDetailsDTO.getEmailAddress(), contactDetailsDTO.getMessageContent());
		
		contactRepository.save(theContactDetails);
		
		return "The message has successfully been saved in the database.";
	}

}
