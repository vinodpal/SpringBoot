package com.shops.userinfo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.shops.userinfo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
/*	 @Query("SELECT * FROM user t WHERE " +
	            "LOWER(t.email) LIKE LOWER(CONCAT('%',:name, '%')) AND " +
	            "LOWER(t.password) LIKE LOWER(CONCAT('%',:password, '%'))")
	    User findUser(@Param(value = "name") String name ,@Param(value = "password") String password);*/
	//@Query("select u from User u where u.emailAddress = ?1")
	/*@Query("SELECT * FROM user t WHERE " +
            "LOWER(t.email) LIKE LOWER(CONCAT('%',:name, '%')) AND " +
            "LOWER(t.password) LIKE LOWER(CONCAT('%',:password, '%'))")
	  User findByEmailAddress( String name ,String password);*/

}