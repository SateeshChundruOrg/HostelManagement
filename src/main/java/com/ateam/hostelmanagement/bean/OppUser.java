package com.ateam.hostelmanagement.bean;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class OppUser {
	private String oppUserName;
	private Long oppId;
	private String name;
	private boolean enabled;
	
	private Collection<GrantedAuthority> authorities;
	
	public String getOppUserName() {
		return oppUserName;
	}
	public void setOppUserName(String oppUserName) {
		this.oppUserName = oppUserName;
	}
	public Long getOppId() {
		return oppId;
	}
	public void setOppId(Long oppId) {
		this.oppId = oppId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public Collection<GrantedAuthority> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(Collection<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	public boolean hasRole(String role) {
        for (GrantedAuthority auth : authorities) {
            if (role.equals(auth.getAuthority())){
                return true;
            }
        }

        return false;
	}
}
