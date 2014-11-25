/**
 * 
 */
package com.osu.autograder;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import com.osu.autograder.EJB.Entity.UserEntity;
import com.osu.autograder.EJB.Service.LoginSession;

public class CourseBean {

	@EJB
	private CourseBean CourseBean;
	@EJB
	private LoginBean logBean;

	private String user;

	private List<List<String>> courseList = new ArrayList<List<String>>();

	public LoginBean getLogBean() {
		return logBean;
	}

	public void setLogBean(LoginBean logBean) {
		this.logBean = logBean;
	}

	public List<List<String>> getCourses() {
		return courseList;
	}

	public void setCourses(List<List<String>> courseList) {
		this.courseList = courseList;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String courseAdd() {

		user = logBean.getName();
		jobs = jobsAdded.jobsAdded(user);

		if (jobs.isEmpty())
			return "false";

		else {
			return "true";
		}

	}

}
