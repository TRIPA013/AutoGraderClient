/**
 * 
 */
package com.osu.autograder;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import com.osu.autograder.EJB.Entity.CourseEntity;
import com.osu.autograder.EJB.Entity.UserEntity;
import com.osu.autograder.EJB.Service.CourseService;
import com.osu.autograder.EJB.Service.LoginService;

public class CourseBean {

	@EJB
	private CourseService courseService;
	private LoginBean logBean;

	private List<CourseEntity> courseList = new ArrayList<CourseEntity>();

	public LoginBean getLogBean() {
		return logBean;
	}

	public void setLogBean(LoginBean logBean) {
		this.logBean = logBean;
	}

	public List<CourseEntity> getCourses() {
		return courseList;
	}

	public void setCourses(List<CourseEntity> courseList) {
		this.courseList = courseList;
	}

	public void findCourses() {
		UserEntity userEntity = logBean.getUserEntity();
		this.courseList = courseService.findCourses(userEntity);
	}

	public boolean addCourse(CourseEntity courseEntity) {
		
		UserEntity userEntity = logBean.getUserEntity();
		return courseService.addCourse(courseEntity);

	}

}
