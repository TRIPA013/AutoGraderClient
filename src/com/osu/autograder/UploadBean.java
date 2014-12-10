package com.osu.autograder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.myfaces.custom.fileupload.UploadedFile;

import com.osu.autograder.EJB.Entity.AssignmentFileEntity;
import com.osu.autograder.EJB.Service.AssignmentFileSession;

public class UploadBean {

	// Init
	// ---------------------------------------------------------------------------------------

	private static final String UPLOADS_MAIN_FOLDER = "C:////uploads";
	private UploadedFile uploadedFile;
	private String fileName;
	private AssignmentBean assignmentBean;

	// Actions
	// ------------------------------------------------------------------------------------

	public void submit() {

		// Just to demonstrate what information you can get from the uploaded
		// file.
		System.out.println("File type: " + uploadedFile.getContentType());
		System.out.println("File name: " + uploadedFile.getName());
		System.out.println("File size: " + uploadedFile.getSize() + " bytes");

		// Prepare filename prefix and suffix for an unique filename in upload
		// folder.
		String suffix = FilenameUtils.getExtension(uploadedFile.getName());

		// Prepare file and outputstream.
		File file = null;
		OutputStream output = null;

		try {

			String assignmentID = assignmentBean.getSelectedAssignmentEntity()
					.getAssignmentID() +"";
			String courseID = assignmentBean.getcourseBean()
					.getSelectedCourse().getCourseID();
			String userID = assignmentBean.getcourseBean().getLogBean()
					.getUserEntity().getUserID();
			String fileName;

			AssignmentFileEntity assignmentFile = new AssignmentFileEntity();

			File fileDir = null;
			if (assignmentBean.getcourseBean().getLogBean().getUserEntity()
					.getRole() == 'I') {
				assignmentFile.setIsSolution("True");
				fileName = "Solution";

				fileDir = new File(UPLOADS_MAIN_FOLDER + "\\Course" + courseID
						+ "\\Assignment" + assignmentID);
			} else {
				fileDir = new File(UPLOADS_MAIN_FOLDER + "\\Course" + courseID
						+ "\\Assignment" + assignmentID);
				fileName = "Assignment_" + userID;
				assignmentFile.setIsSolution("False");
			}

			assignmentFile.setScore("0");
			assignmentFile.setAssignmentFileName(fileName);
			assignmentFile.setAssignmentID(assignmentID);
			assignmentFile.setUserID(userID);
			if (!fileDir.exists()) {
				fileDir.mkdirs();
			}
			// Create file with unique name in upload folder and write to it.
			file = new File(fileDir, fileName + "." + suffix);
			output = new FileOutputStream(file);
			IOUtils.copy(uploadedFile.getInputStream(), output);
			fileName = file.getName();

			// Show succes message.
			FacesContext.getCurrentInstance().addMessage(
					"uploadForm",
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"File upload succeed!", null));
			
			AssignmentFileSession assignmentFileService = new AssignmentFileSession();
			boolean result = assignmentFileService
					.addAssignment(assignmentFile);
			System.out.println(result);
			
		} catch (IOException e) {
			// Cleanup.
			if (file != null)
				file.delete();

			// Show error message.
			FacesContext.getCurrentInstance().addMessage(
					"uploadForm",
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"File upload failed with I/O error.", null));

			// Always log stacktraces (with a real logger).
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(output);
		}
	}

	// Getters
	// ------------------------------------------------------------------------------------

	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}

	public String getFileName() {
		return fileName;
	}

	// Setters
	// ------------------------------------------------------------------------------------

	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

	public AssignmentBean getAssignmentBean() {
		return assignmentBean;
	}

	public void setAssignmentBean(AssignmentBean assignmentBean) {
		this.assignmentBean = assignmentBean;
	}
}