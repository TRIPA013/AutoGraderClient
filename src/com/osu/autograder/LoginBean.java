/**
 * 
 */
package com.osu.autograder;

import javax.ejb.EJB;

import com.osu.autograder.EJB.Entity.UserEntity;
import com.osu.autograder.EJB.Service.LoginSession;

public class LoginBean {

	// private static final Logger log =
	// LoggerFactory.getLogger(LoginBean.class);
	// Logger logger = LoggerFactory.getLogger(LoginBean.class);
	@EJB
	private LoginSession helloService;
	private String name;
	private String password;
	private String selection;

	public String getSelection() {
		return selection;
	}

	public void setSelection(String selection) {
		this.selection = selection;
	}

	@EJB
	private LoginSession loginSession;

	public String userName() {

		String[] params = new String[3];
		params[0] = name;
		params[1] = password;
		params[2] = selection;

		UserEntity userEntity = new UserEntity();
		userEntity.setName(name);
		userEntity.setPassword(password);
		userEntity = loginSession.login(userEntity);
		if (userEntity == null) {
			return "false";
		}
		return selection;
	}

	public String getMessage() {
		return "lol";
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

}
