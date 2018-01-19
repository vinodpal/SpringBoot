package com.shops.userinfo.controller;

import com.shops.userinfo.model.Contact;
import com.shops.userinfo.model.User;
import com.shops.userinfo.repository.ContactRepository;
import com.shops.userinfo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.TypedQuery;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/userapi")
public class UserController {

	@Autowired
	UserRepository userRepository;
	

	
	// Create a new User
	@PostMapping("/user")
	public User createUser(@Valid @RequestBody User user) {
		System.out.println("User Create Start");
		return userRepository.save(user);
	}

	/*// Get a Single User
	@GetMapping("/user/{name}/{password}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "name") String name ,@PathVariable(value = "password") String password) {
		//User user = userRepository.findUser(name, password);
		String queryStr = "SELECT NEW com.admin.entity.DealInfo(deal.url, deal.url, deal.url, deal.url, deal.price, deal.value) " + "FROM Deal AS deal where deal.id in :inclList";
        TypedQuery<User> query = em.createQuery(queryStr, User.class);
        query.setParameter("name", name);
        query.setParameter("password", password);
        User user = (User) query.getResultList();
        userRepository.
		if (user == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(user);
	}*/

	// Update a User
	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userid,
			@Valid @RequestBody User userDetails) {
		User note = userRepository.findOne(userid);
		if (note == null) {
			return ResponseEntity.notFound().build();
		}
		note.setPassword(userDetails.getPassword());

		User updatedNote = userRepository.save(note);
		return ResponseEntity.ok(updatedNote);
	}

	// Delete a User
	@DeleteMapping("/user/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable(value = "id") Long noteId) {
		User note = userRepository.findOne(noteId);
		if (note == null) {
			return ResponseEntity.notFound().build();
		}

		userRepository.delete(note);
		return ResponseEntity.ok().body(note);
	}
}