package edu.uoengland.contact.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="contactdetailsmessages")
public class ContactDetailsMessages {

	@Id
	@GeneratedValue(strategy=GenerationType.UUID)
	@Column(name="contactDetailsMessageId")
	private UUID contactDetailsMessageId;
	
	@Column(name="message_content")
	private String messageContent;

	@ManyToOne
    @JoinColumn(name = "id") // foreign key
    private ContactDetails contactDetails;
	
	public ContactDetailsMessages() {
		super();
	}

	public ContactDetailsMessages(UUID contactDetailsMessageId, String messageContent, ContactDetails contactDetails) {
		super();
		this.contactDetailsMessageId = contactDetailsMessageId;
		this.messageContent = messageContent;
		this.contactDetails = contactDetails;
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

	public ContactDetails getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(ContactDetails contactDetails) {
		this.contactDetails = contactDetails;
	}
	
}

