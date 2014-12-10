/**
 * 
 */
package com.osu.autograder;

import java.util.List;

import javax.ejb.EJB;

import com.osu.autograder.EJB.Entity.AssignmentEntity;
import com.osu.autograder.EJB.Entity.CourseEntity;
import com.osu.autograder.EJB.Service.AssignmentSession;
import com.osu.autograder.EJB.Service.CourseSession;

public class CourseBean {

	@EJB
	private AssignmentSession assignmentService;

	@EJB
	private CourseSession courseService;

	private LoginBean logBean;

	public LoginBean getLogBean() {
		return logBean;
	}

	public void setLogBean(LoginBean logBean) {
		this.logBean = logBean;
	}

	private CourseEntity selectedCourse;

	public boolean addCourse(CourseEntity courseEntity) {
		return false;

	}

	public CourseEntity getSelectedCourse() {
		return selectedCourse;
	}

	public void setSelectedCourse(CourseEntity selectedCourse) {
		this.selectedCourse = selectedCourse;
	}

	public String onCourseSelected(CourseEntity seleCourseEntity) {
		setSelectedCourse(seleCourseEntity);
		findAssignments();
		return logBean.getSelection();
	}

	private void findAssignments() {
		setAssignmentList(assignmentService.findAssignments(selectedCourse));
	}

	/**
	 * @return the assignmentList
	 */
	public List<AssignmentEntity> getAssignmentList() {
		return assignmentList;
	}

	/**
	 * @param assignmentList
	 *            the assignmentList to set
	 */
	public void setAssignmentList(List<AssignmentEntity> assignmentList) {
		this.assignmentList = assignmentList;
	}

	private List<AssignmentEntity> assignmentList;

	
}
