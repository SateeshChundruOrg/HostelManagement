package com.ateam.hostelmanagement.bean;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;



@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionData  implements Serializable{
	private static final long serialVersionUID = 1L;
	
//	@Autowired
//	private AdminDao adminDao;

	
	private OppUser oppUser;
	
	public OppUser getOppUser() {
		if(oppUser != null){
			String userName = SecurityContextHolder.getContext().getAuthentication().getName();
			if(!oppUser.getOppUserName().equals(userName)){
				clean();
			}
		}
		
		if(oppUser == null){
			try {
				String userName = SecurityContextHolder.getContext().getAuthentication().getName();
				@SuppressWarnings("unchecked")
				Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
				//oppUser = adminDao.getOppUserByUsername(userName);
				//oppUser.setAuthorities(authorities);
			} catch (Exception e) {
				//Log.info(this.getClass(), e.toString(), e);
			}
		} 
		
		return oppUser;
	}

	public void clean() {
		oppUser = null;
	}
	
}
