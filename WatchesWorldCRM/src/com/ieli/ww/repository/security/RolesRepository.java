package com.ieli.ww.repository.security;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ieli.ww.model.security.Role;

@Repository("rolesRepository")
@Transactional
public interface RolesRepository extends JpaRepository<Role, Long> {

	List<Role> findByRoleId(Integer roleId);

}
