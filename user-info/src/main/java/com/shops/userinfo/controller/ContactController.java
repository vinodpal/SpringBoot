package com.shops.userinfo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shops.userinfo.model.Contact;
import com.shops.userinfo.model.User;
import com.shops.userinfo.repository.ContactRepository;
import com.shops.userinfo.service.ContactService;

@RestController
@RequestMapping("/contactapi")
public class ContactController {
	@Autowired
	ContactRepository contactRepository;

	// Get All Contacts
	@GetMapping("/contacts")
	public ResponseEntity<Iterable<Contact>> getAllContacts() {
		System.out.println("GetMethod");
		//return null;
		return ResponseEntity.ok(contactRepository.findAll());
	}
	// Get All Contacts
		/*@GetMapping("/contacts/{firstName}/{lastName}")
		public ResponseEntity<List<Contact>> getContactFisrtNameAndLastName(@PathVariable(value="firstName")String firstName,@PathVariable(value="lastName")
		String lastName) {
			System.out.println("GetMethod");
			//return null;
			return ResponseEntity.ok(contactRepository.findByLastName(firstName));
		}*/
		
		// Get Single Contact
		@GetMapping("/contacts/{email}")
		public ResponseEntity<Contact> updateUser(@PathVariable(value = "email") Long email) {
			Contact contact = contactRepository.findOne(email);
			if (contact == null) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(contact);
		}

	// Update a User
		@PutMapping("/contact/{id}")
		public ResponseEntity<List<Contact>> updateUser(@PathVariable(value = "id") String userid
				/*@RequestParam("extraField") String extraField*/) {
			System.out.println("File uploading ... ");
			String extraField = "/home/nanobi/bank.csv";
			List<Contact> listContact = ContactService.readCsvFile(extraField,userid);
			List<Contact> contacts = new ArrayList<>();
			if(listContact!=null) {
				for(int i=0;i<listContact.size();++i)
				contactRepository.save(listContact.get(i));
			}
			
			if (contacts.isEmpty()) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(contacts);
		}


}
