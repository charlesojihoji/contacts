package edu.uoengland.contact.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uoengland.contact.dto.ContactDetailsDTO;
import edu.uoengland.contact.entity.ContactDetails;
import edu.uoengland.contact.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;

	@Override
	public String saveAContact(ContactDetailsDTO contactDetailsDTO) {

		ContactDetails theContactDetails = new ContactDetails(contactDetailsDTO.getContactId(),
				contactDetailsDTO.getContactName(), contactDetailsDTO.getPhoneNumber(), contactDetailsDTO.getAddress(),
				contactDetailsDTO.getEmailAddress(), contactDetailsDTO.getMessageContent());

		contactRepository.save(theContactDetails);

		return "The message has successfully been saved in the database.";
	}

	@Override
	public List<ContactDetailsDTO> getAllContacts() {

		List<ContactDetails> theList = contactRepository.findAll();

		List<ContactDetailsDTO> theDTOList = new ArrayList<>();

		for (ContactDetails ctdetails : theList) {

			ContactDetailsDTO cntDetailsDTO = new ContactDetailsDTO(ctdetails.getContactId(),
					ctdetails.getContactName(), ctdetails.getPhoneNumber(), ctdetails.getAddress(),
					ctdetails.getEmailAddress(), ctdetails.getMessageContent());

			theDTOList.add(cntDetailsDTO);
		}

		return theDTOList;
	}


	@Override
	public ContactDetailsDTO getAContact(UUID contactId) {

		Optional<ContactDetails> contactDetails = contactRepository.findById(contactId);
		
		ContactDetailsDTO cntDetailsDTO = new ContactDetailsDTO(contactDetails.get().getContactId(), contactDetails.get().getContactName(),
				contactDetails.get().getPhoneNumber(), contactDetails.get().getAddress(), contactDetails.get().getEmailAddress(),
				contactDetails.get().getMessageContent());

		return cntDetailsDTO;
	}

	@Override
	public String deleteAContact(UUID contactId) {

		contactRepository.deleteById(contactId);

		return "That contact has been deleted.";
	}

	@Override
	public String updateAContact(ContactDetailsDTO contactDetailsDTO) {

		Optional<ContactDetails> contactDetails = contactRepository.findById(contactDetailsDTO.getContactId());
		
		ContactDetails contactDetailsUpdated = contactDetails.get();
		
		contactDetailsUpdated.setContactId(contactDetailsDTO.getContactId());
		contactDetailsUpdated.setContactName(contactDetailsDTO.getContactName());
		contactDetailsUpdated.setPhoneNumber(contactDetailsDTO.getPhoneNumber());
		contactDetailsUpdated.setAddress(contactDetailsDTO.getAddress());
		contactDetailsUpdated.setEmailAddress(contactDetailsDTO.getEmailAddress());
		contactDetailsUpdated.setMessageContent(contactDetailsDTO.getMessageContent());
		
		contactRepository.save(contactDetailsUpdated);
		
		return "The contact has successfully been updated.";
	}

}
