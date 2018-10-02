package com.ieli.ww.repository.user;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ieli.ww.model.user.User;

@Repository("userRepository")
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

}
