package com.shops.userinfo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shops.userinfo.model.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {
	//List<Contact> findByLastName(String firstname);
	/*@Query("select * from contact where firstname = ? ")
	List<Contact> findByLastName(String firstname);*/
}