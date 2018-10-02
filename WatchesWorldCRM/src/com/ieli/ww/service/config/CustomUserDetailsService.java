package com.ieli.ww.service.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ieli.ww.model.security.Permission;
import com.ieli.ww.model.security.Role;
import com.ieli.ww.model.user.User;
import com.ieli.ww.repository.user.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = null;
		try {
			user = userRepository.findByUsername(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}

		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), true,
				true, true, true, getAuthorities(user));

	}

	private List<GrantedAuthority> getAuthorities(User user) {
		List<Role> userRoles = user.getRoles();
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (Role userRole : userRoles) {
			authorities.add(new SimpleGrantedAuthority(userRole.getRole()));
			for (Permission permission : userRole.getPermissions()) {
				authorities.add(new SimpleGrantedAuthority(permission.getPermission()));
			}
		}

		return authorities;
	}

}
