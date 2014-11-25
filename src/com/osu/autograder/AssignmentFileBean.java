/**
 * 
 */
package com.osu.autograder;

import javax.ejb.EJB;

import com.osu.autograder.EJB.Entity.AssignmentFileEntity;
import com.osu.autograder.EJB.Service.AssignmentFileService;

public class AssignmentFileBean {

	@EJB
	private AssignmentFileService assignmentFileService;
	private AssignmentBean assignmentBean;

	private AssignmentFileEntity assignmentFileEntity;

	public AssignmentBean getAssignmentBean() {
		return assignmentBean;
	}

	public void setAssignmentBean(AssignmentBean assignmentBean) {
		this.assignmentBean = assignmentBean;
	}

	public boolean updateAssignmentFile(
			AssignmentFileEntity assignmentFileEntity) {

		return assignmentFileService.updateAssignmentFile(assignmentFileEntity);
	}

	public boolean addAssignmentFile(AssignmentFileEntity assignmentFileEntity) {

		return assignmentFileService.updateAssignmentFile(assignmentFileEntity);

	}

	/**
	 * @return the assignmentFileEntity
	 */
	public AssignmentFileEntity getAssignmentFileEntity() {
		return assignmentFileEntity;
	}

	/**
	 * @param assignmentFileEntity
	 *            the assignmentFileEntity to set
	 */
	public void setAssignmentFileEntity(
			AssignmentFileEntity assignmentFileEntity) {
		this.assignmentFileEntity = assignmentFileEntity;
	}

	public String uploadFile() {
		
		return null;

	}
}
