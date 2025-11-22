package edu.uoengland.contact.entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="contactdetails")
public class ContactDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.UUID)
	@Column(name="id")
	private UUID contactId;
	
	@Column(name="full_Name", nullable=false)
	private String contactName;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="address")
	private String address;
	
	@Column(name="email_address", unique=true)
	private String emailAddress;
	
	@OneToMany(mappedBy = "contactDetails", cascade = CascadeType.ALL)
    private List<ContactDetailsMessages> contactDetailsMessages;

	public ContactDetails() {
		super();
	}

	public ContactDetails(UUID contactId, String contactName, String phoneNumber, String address, String emailAddress) {
		super();
		this.contactId = contactId;
		this.contactName = contactName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.emailAddress = emailAddress;
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

	public List<ContactDetailsMessages> getContactDetailsMessages() {
		return contactDetailsMessages;
	}

	public void setContactDetailsMessages(List<ContactDetailsMessages> contactDetailsMessages) {
		this.contactDetailsMessages = contactDetailsMessages;
	}
	
}
