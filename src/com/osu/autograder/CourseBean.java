/**
 * 
 */
package com.osu.autograder;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import com.osu.autograder.EJB.Entity.CourseEntity;
import com.osu.autograder.EJB.Entity.UserEntity;
import com.osu.autograder.EJB.Service.CourseService;

public class CourseBean {

	@EJB
	private CourseService courseService;

	private LoginBean logBean;

	private CourseEntity selectedCourse;

	private List<CourseEntity> courses = new ArrayList<CourseEntity>();

	public LoginBean getLogBean() {
		return logBean;
	}

	public void setLogBean(LoginBean logBean) {
		this.logBean = logBean;
	}

	public List<CourseEntity> getCourses() {
		return courses;
	}

	public void setCourses(List<CourseEntity> courseList) {
		this.courses = courseList;
	}

	public void findCourses() {
		UserEntity userEntity = logBean.getUserEntity();
		this.courses = courseService.findCourses(userEntity);
	}

	public boolean addCourse(CourseEntity courseEntity) {
		UserEntity userEntity = logBean.getUserEntity();
		return courseService.addCourse(courseEntity);

	}

	@PostConstruct
	public void load() {
		findCourses();
	}
	

	public CourseEntity getSelectedCourse() {
		return selectedCourse;
	}

	public void setSelectedCourse(CourseEntity selectedCourse) {
		this.selectedCourse = selectedCourse;
	}
	
	
	public String onCourseSelected(CourseEntity seleCourseEntity){
		setSelectedCourse(seleCourseEntity);
		return logBean.getSelection();
	}
}
