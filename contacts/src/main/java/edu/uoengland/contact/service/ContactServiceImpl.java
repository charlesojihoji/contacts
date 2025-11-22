package edu.uoengland.contact.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uoengland.contact.dto.ContactDetailsDTO;
import edu.uoengland.contact.dto.ContactDetailsMessagesDTO;
import edu.uoengland.contact.entity.ContactDetails;
import edu.uoengland.contact.entity.ContactDetailsMessages;
import edu.uoengland.contact.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;

	@Override
	public String saveAContact(ContactDetailsDTO contactDetailsDTO) {
		
		ContactDetails cntDtls = new ContactDetails();
		
		cntDtls.setContactName(contactDetailsDTO.getContactName());
		cntDtls.setPhoneNumber(contactDetailsDTO.getPhoneNumber());
		cntDtls.setAddress(contactDetailsDTO.getAddress());
		cntDtls.setEmailAddress(contactDetailsDTO.getEmailAddress());
		
		List<ContactDetailsMessages> listOfCntDtlsMsgs = new ArrayList<>();
		
		if( (contactDetailsDTO != null) && (!contactDetailsDTO.getContactDetailsMessagesDTOList().isEmpty()) ) {
			
			for(ContactDetailsMessagesDTO cntDtlsMsgsDTO: contactDetailsDTO.getContactDetailsMessagesDTOList()) {
								
				ContactDetailsMessages cntDtlsMsgs = new ContactDetailsMessages();
				
				cntDtlsMsgs.setMessageContent(cntDtlsMsgsDTO.getMessageContent());
				
				cntDtlsMsgs.setContactDetails(cntDtls);
				
				listOfCntDtlsMsgs.add(cntDtlsMsgs);
			}			
		}
		
		cntDtls.setContactDetailsMessages(listOfCntDtlsMsgs);

		contactRepository.save(cntDtls);

		return "The message has successfully been saved in the database.";
	}

	@Override
	public List<ContactDetailsDTO> getAllContacts() {

		List<ContactDetails> theList = contactRepository.findAll();

		List<ContactDetailsDTO> theDTOList = new ArrayList<>();

		for (ContactDetails ctdetails : theList) {

			List<ContactDetailsMessages> listOfCntDtlsMsgs = ctdetails.getContactDetailsMessages();

			List<ContactDetailsMessagesDTO> listOfCntDtlasMsgsDTO = new ArrayList<>();

			for (ContactDetailsMessages cntDtlsMsgs : listOfCntDtlsMsgs) {

				ContactDetailsMessagesDTO cntDtlsMsgsDTO = new ContactDetailsMessagesDTO(
						cntDtlsMsgs.getContactDetailsMessageId(), cntDtlsMsgs.getMessageContent());

				listOfCntDtlasMsgsDTO.add(cntDtlsMsgsDTO);
			}

			ContactDetailsDTO cntDetailsDTO = new ContactDetailsDTO(ctdetails.getContactId(),
					ctdetails.getContactName(), ctdetails.getPhoneNumber(), ctdetails.getAddress(),
					ctdetails.getEmailAddress(), listOfCntDtlasMsgsDTO);

			theDTOList.add(cntDetailsDTO);
		}

		return theDTOList;
	}

	@Override
	public ContactDetailsDTO getAContact(UUID contactId) {

		Optional<ContactDetails> contactDetails = contactRepository.findById(contactId);

		List<ContactDetailsMessages> listOfCntDtlsMgs = contactDetails.get().getContactDetailsMessages();

		List<ContactDetailsMessagesDTO> listOfCntDtlsMgsDTO = new ArrayList<>();

		for (ContactDetailsMessages cntctDtlsMgs : listOfCntDtlsMgs) {

			ContactDetailsMessagesDTO cntDtlsMgsDTO = new ContactDetailsMessagesDTO(
					cntctDtlsMgs.getContactDetailsMessageId(), cntctDtlsMgs.getMessageContent());

			listOfCntDtlsMgsDTO.add(cntDtlsMgsDTO);
		}

		ContactDetailsDTO cntDetailsDTO = new ContactDetailsDTO(contactDetails.get().getContactId(),
				contactDetails.get().getContactName(), contactDetails.get().getPhoneNumber(),
				contactDetails.get().getAddress(), contactDetails.get().getEmailAddress(), listOfCntDtlsMgsDTO);

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
		
		List<ContactDetailsMessages> listOfCntDtlsMsgs = contactDetailsUpdated.getContactDetailsMessages();
		
		for(ContactDetailsMessagesDTO cntDtlsMsgsDTO: contactDetailsDTO.getContactDetailsMessagesDTOList()) {
			
			ContactDetailsMessages cntDtlsMsgs = new ContactDetailsMessages(null, cntDtlsMsgsDTO.getMessageContent(), contactDetailsUpdated);
			
			listOfCntDtlsMsgs.add(cntDtlsMsgs);
		}
		
		contactDetailsUpdated.setContactDetailsMessages(listOfCntDtlsMsgs);

		contactRepository.save(contactDetailsUpdated);

		return "The contact has successfully been updated.";
	}

}
