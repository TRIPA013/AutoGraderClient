/**
 * 
 */
package com.osu.autograder;

import javax.ejb.EJB;

import com.osu.autograder.EJB.Entity.AssignmentEntity;
import com.osu.autograder.EJB.Service.AssignmentSession;

public class AssignmentBean {

	@EJB
	private AssignmentSession assignmentService;
	private CourseBean courseBean;
	private AssignmentEntity selectedAssignmentEntity;

	private String assignmentType;

	public String getAssignmentType() {
		return assignmentType;
	}

	public void setAssignmentType(String assignmentType) {
		this.assignmentType = assignmentType;
	}

	public String getAssignmentName() {
		return assignmentName;
	}

	public void setAssignmentName(String assignmentName) {
		this.assignmentName = assignmentName;
	}

	public String getConfigurationFile() {
		return configurationFile;
	}

	public void setConfigurationFile(String configurationFile) {
		this.configurationFile = configurationFile;
	}

	public String getMaxPoints() {
		return MaxPoints;
	}

	public void setMaxPoints(String maxPoints) {
		MaxPoints = maxPoints;
	}

	public String getDirectory() {
		return Directory;
	}

	public void setDirectory(String directory) {
		Directory = directory;
	}

	private String assignmentName;
	private String configurationFile;
	private String MaxPoints;
	private String Directory;

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

	public boolean add() {

		boolean result = assignmentService.addAssignment(this.assignmentName,
				this.assignmentType, this.configurationFile, this.MaxPoints,
				this.Directory, this.courseBean.getSelectedCourse()
						.getCourseID());
		return result;
	}
}
