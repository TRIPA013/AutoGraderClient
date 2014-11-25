/**
 * 
 */
package com.osu.autograder;

import javax.ejb.EJB;

import com.osu.autograder.EJB.Entity.UserEntity;
import com.osu.autograder.EJB.Service.LoginService;

public class LoginBean {

	@EJB
	private LoginService loginSession;
	private UserEntity userEntity;

	public UserEntity getUserEntity() {
		return this.userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public boolean login() {
		UserEntity newUserEntity = new UserEntity();
		newUserEntity = loginSession.login(userEntity);
		if (newUserEntity == null) {
			return false;
		}
		this.userEntity = newUserEntity;
		return true;
	}
}
