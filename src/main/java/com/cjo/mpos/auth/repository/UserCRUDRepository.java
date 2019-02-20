package com.cjo.mpos.auth.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cjo.mpos.auth.model.User;

public interface UserCRUDRepository extends CrudRepository<User, Integer> {

	List<User> findByEmail(String email);
	
}
