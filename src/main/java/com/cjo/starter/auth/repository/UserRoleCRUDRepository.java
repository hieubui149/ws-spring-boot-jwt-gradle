package com.cjo.starter.auth.repository;

import com.cjo.starter.auth.model.UserRole;
import org.springframework.data.repository.CrudRepository;

public interface UserRoleCRUDRepository extends CrudRepository<UserRole, Integer> {

}
