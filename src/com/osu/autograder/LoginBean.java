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

	private UserEntity userEntity = new UserEntity();

	private String selection;

	public String login() {
		userEntity.setTechnology(selection.charAt(0));
		UserEntity newUserEntity = loginSession.login(userEntity);
		if (newUserEntity == null) {
			return "false";
		}
		userEntity = newUserEntity;
		return selection;
	}

	public String getSelection() {
		return selection;
	}

	public void setSelection(String selection) {
		this.selection = selection;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}
}
