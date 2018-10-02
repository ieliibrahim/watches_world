package com.ieli.ww.repository.user;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ieli.ww.model.user.UserRole;


@Repository("userRoleRepository")
@Transactional
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

	UserRole findByUserId(Integer userId);

	void deleteByUserId(Integer userId);
}
