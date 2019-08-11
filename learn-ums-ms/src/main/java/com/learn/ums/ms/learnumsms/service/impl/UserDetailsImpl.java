package com.learn.ums.ms.learnumsms.service.impl;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.learn.ums.ms.learnumsms.constants.UserRoles;
import com.learn.ums.ms.learnumsms.entity.UserEO;

public class UserDetailsImpl implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UserEO user;
	
	public UserDetailsImpl(UserEO user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authority =  new HashSet<>();
		for(UserRoles role : user.getRoles()) {
			authority.add(new SimpleGrantedAuthority(role.getRole()));
		}
		return authority;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return !user.isExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		return !user.isLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return !user.isExpired();
	}

	@Override
	public boolean isEnabled() {
		return !user.isDisabled();
	}
	
	public String getMob() {
		
		return user.getMob();
	}

}
