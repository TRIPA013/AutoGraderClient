/**
 * 
 */
package com.osu.autograder;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import com.osu.autograder.EJB.Entity.AssignmentEntity;
import com.osu.autograder.EJB.Entity.CourseEntity;
import com.osu.autograder.EJB.Service.AssignmentService;

public class AssignmentBean {

	@EJB
	private AssignmentService assignmentService;
	private CourseBean courseBean;
	private LoginBean logBean;

	private List<AssignmentEntity> assignmentList = new ArrayList<AssignmentEntity>();

	public LoginBean getLogBean() {
		return logBean;
	}

	public void setLogBean(LoginBean logBean) {
		this.logBean = logBean;
	}

	public CourseBean getcourseBean() {
		return courseBean;
	}

	public void setCourseBean(CourseBean courseBean) {
		this.courseBean = courseBean;
	}

	public void findAssignments(CourseEntity courseEntity) {

		this.assignmentList = assignmentService.findAssignments(courseEntity);
	}

	public boolean addAssignment(AssignmentEntity assignmentEntity) {

	
		return assignmentService.addAssignment(assignmentEntity);

	}
}
