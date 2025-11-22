package edu.uoengland.contact.dto;

import java.util.UUID;

import edu.uoengland.contact.entity.ContactDetails;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class ContactDetailsMessagesDTO {

	private UUID contactDetailsMessageId;
	
	private String messageContent;

	public ContactDetailsMessagesDTO() {
		super();
	}

	public ContactDetailsMessagesDTO(UUID contactDetailsMessageId, String messageContent) {
		super();
		this.contactDetailsMessageId = contactDetailsMessageId;
		this.messageContent = messageContent;
	}

	public UUID getContactDetailsMessageId() {
		return contactDetailsMessageId;
	}

	public void setContactDetailsMessageId(UUID contactDetailsMessageId) {
		this.contactDetailsMessageId = contactDetailsMessageId;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	
}
