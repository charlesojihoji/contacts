package edu.uoengland.contact.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.uoengland.contact.entity.ContactDetails;

@Repository
public interface ContactRepository extends JpaRepository<ContactDetails, UUID>{

}
