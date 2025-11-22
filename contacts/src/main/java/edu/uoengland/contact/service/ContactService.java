package edu.uoengland.contact.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import edu.uoengland.contact.dto.ContactDetailsDTO;

public interface ContactService {

	public String saveAContact(ContactDetailsDTO contactDetailsDTO);

	public List<ContactDetailsDTO> getAllContacts();

	public String deleteAContact(UUID contactId);

	public ContactDetailsDTO getAContact(UUID contactId);

	public String updateAContact(ContactDetailsDTO contactDetailsDTO);
}
