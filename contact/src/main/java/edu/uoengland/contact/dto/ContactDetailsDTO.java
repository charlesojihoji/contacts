package edu.uoengland.contact.dto;

import java.util.UUID;

public class ContactDetailsDTO {

	private UUID contactId;

	private String contactName;

	private String phoneNumber;

	private String address;

	private String emailAddress;

	private String messageContent;

	public ContactDetailsDTO() {
			super();
		}

	public ContactDetailsDTO(UUID contactId, String contactName, String phoneNumber, String address, String emailAddress,
				String messageContent) {
			super();
			this.contactId = contactId;
			this.contactName = contactName;
			this.phoneNumber = phoneNumber;
			this.address = address;
			this.emailAddress = emailAddress;
			this.messageContent = messageContent;
		}

	public UUID getContactId() {
		return contactId;
	}

	public void setContactId(UUID contactId) {
		this.contactId = contactId;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
}