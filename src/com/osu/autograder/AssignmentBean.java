/**
 * 
 */
package com.osu.autograder;

import javax.ejb.EJB;

import com.osu.autograder.EJB.Entity.AssignmentEntity;
import com.osu.autograder.EJB.Service.AssignmentService;

public class AssignmentBean {

	
	@EJB
	private AssignmentService assignmentService;
	private CourseBean courseBean;
	private AssignmentEntity selectedAssignmentEntity;


	public CourseBean getcourseBean() {
		return courseBean;
	}

	public void setCourseBean(CourseBean courseBean) {
		this.courseBean = courseBean;
	}

	public boolean addAssignment(AssignmentEntity assignmentEntity) {

		return assignmentService.addAssignment(assignmentEntity);

	}

	public AssignmentEntity getSelectedAssignmentEntity() {
		return selectedAssignmentEntity;
	}

	public void setSelectedAssignmentEntity(
			AssignmentEntity selectedAssignmentEntity) {
		this.selectedAssignmentEntity = selectedAssignmentEntity;
	}


	public String onAssignmentUploadSelected(AssignmentEntity assignmentEntity) {
		setSelectedAssignmentEntity(assignmentEntity);
		return "upload";
	}

	public String onAssignmentGradesSelected(AssignmentEntity assignmentEntity) {
		setSelectedAssignmentEntity(assignmentEntity);
		return "grade";
	}

}
