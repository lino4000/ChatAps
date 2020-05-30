package com.lino4000.ChatAps.repository;


import org.springframework.data.repository.CrudRepository;

import com.lino4000.ChatAps.model.Role;

public interface RoleRepository extends CrudRepository<Role, Long>{

	Role findByTitle(String title);
}