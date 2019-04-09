package com.cjo.starter.auth.repository;

import org.springframework.data.repository.CrudRepository;

import com.cjo.starter.auth.model.UserRole;

public interface UserRoleCRUDRepository extends CrudRepository<UserRole, Integer> {

}
