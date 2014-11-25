/**
 * 
 */
package com.osu.autograder;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import com.osu.autograder.EJB.Entity.AssignmentEntity;
import com.osu.autograder.EJB.Entity.CourseEntity;
import com.osu.autograder.EJB.Service.AssignmentService;

public class AssignmentBean {

	@EJB
	private AssignmentService assignmentService;
	private CourseBean courseBean;
	private AssignmentEntity selectedAssignmentEntity;

	private List<AssignmentEntity> assignmentList;

	public CourseBean getcourseBean() {
		return courseBean;
	}

	public void setCourseBean(CourseBean courseBean) {
		this.courseBean = courseBean;
	}

	public void findAssignments(CourseEntity courseEntity) {

		this.setAssignmentList(assignmentService.findAssignments(courseEntity));
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

	public String onAssignmentUploadSelected(AssignmentEntity assignmentEntity) {
		setSelectedAssignmentEntity(assignmentEntity);
		return "upload";
	}

	public String onAssignmentGradesSelected(AssignmentEntity assignmentEntity) {
		setSelectedAssignmentEntity(assignmentEntity);
		return "grade";
	}

	@PostConstruct
	public void load() {
		findAssignments();
	}

	private void findAssignments() {
		assignmentList = assignmentService.findAssignments(courseBean
				.getSelectedCourse());
	}

}
