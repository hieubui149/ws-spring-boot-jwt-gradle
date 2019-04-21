package com.cjo.starter.auth.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cjo.starter.auth.model.Authority;

/**
 * @author Tomas
 * @date Apr 20, 2019
 *
 */
public interface AuthorityCRUDRepository extends CrudRepository<Authority, Integer> {

	@Query("SELECT au FROM Authority au WHERE au.id IN :authorityIds")
	Set<Authority> findByIdIn(@Param("authorityIds") List<Integer> authorityIds);
	
}
