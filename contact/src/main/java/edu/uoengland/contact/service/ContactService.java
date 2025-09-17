package edu.uoengland.contact.service;

import edu.uoengland.contact.dto.ContactDetailsDTO;

public interface ContactService {

	public String saveAMessage(ContactDetailsDTO contactDetailsDTO);
}
