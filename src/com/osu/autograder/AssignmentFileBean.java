/**
 * 
 */
package com.osu.autograder;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import com.osu.autograder.EJB.Entity.AssignmentEntity;
import com.osu.autograder.EJB.Entity.AssignmentFileEntity;
import com.osu.autograder.EJB.Entity.CourseEntity;
import com.osu.autograder.EJB.Service.AssignmentFileService;
import com.osu.autograder.EJB.Service.AssignmentService;

public class AssignmentFileBean {

	@EJB
	private AssignmentFileService assignmentFileService;
	private AssignmentBean assignmentBean;
	private CourseBean courseBean;
	private LoginBean logBean;

	private List<AssignmentFileEntity> assignmentFileList = new ArrayList<AssignmentFileEntity>();

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

	public AssignmentBean getAssignmentBean() {
		return assignmentBean;
	}

	public void setAssignmentBean(AssignmentBean assignmentBean) {
		this.assignmentBean = assignmentBean;
	}

	public boolean updateAssignmentFile(AssignmentFileEntity assignmentFileEntity) {

		return assignmentFileService.updateAssignmentFile(assignmentFileEntity);
	}

	public boolean addAssignmentFile(AssignmentFileEntity assignmentFileEntity) {

		return assignmentFileService.updateAssignmentFile(assignmentFileEntity);

	}
}
