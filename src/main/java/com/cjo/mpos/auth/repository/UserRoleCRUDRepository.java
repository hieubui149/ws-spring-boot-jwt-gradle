package com.cjo.mpos.auth.repository;

import org.springframework.data.repository.CrudRepository;

import com.cjo.mpos.auth.model.UserRole;

public interface UserRoleCRUDRepository extends CrudRepository<UserRole, Integer> {

}
