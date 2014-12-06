/**
 * 
 */
package com.osu.autograder;

import java.util.List;

import javax.ejb.EJB;

import com.osu.autograder.EJB.Entity.CourseEntity;
import com.osu.autograder.EJB.Entity.UserEntity;
import com.osu.autograder.EJB.Service.CourseService;
import com.osu.autograder.EJB.Service.LoginService;

public class LoginBean {

	@EJB
	private LoginService loginSession;

	@EJB
	private CourseService courseService;

	private UserEntity userEntity = new UserEntity();

	private String selection;

	private List<CourseEntity> courses;

	public List<CourseEntity> getCourses() {
		return courses;
	}

	public void setCourses(List<CourseEntity> courseList) {
		this.courses = courseList;
	}

	public void findCourses() {
		this.courses = courseService.findCourses(userEntity);
	}

	public String login() {
		userEntity.setTechnology(selection.charAt(0));
		UserEntity newUserEntity = loginSession.login(userEntity);
		if (newUserEntity == null) {
			return "false";
		}
		userEntity = newUserEntity;
		findCourses();
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
