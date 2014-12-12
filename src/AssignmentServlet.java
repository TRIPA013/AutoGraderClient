import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * A simple servlet taking advantage of features added in 3.0.
 * </p>
 * 
 * <p>
 * The servlet is registered and mapped to /HelloServlet using the {@linkplain WebServlet
 * @HttpServlet}. The {@link HelloService} is injected by CDI.
 * </p>
 * 
 * @author Pete Muir
 * 
 */
@SuppressWarnings("serial")
@WebServlet("/AssignmentServlet")
public class AssignmentServlet extends HttpServlet {

	private static final String UPLOADS_MAIN_FOLDER = "C:////uploads";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String courseID = req.getParameter("course_id");
		String assignmentID = req.getParameter("assignment_id");
		int uploads = findNumberOfUploads(courseID, assignmentID);
		resp.setContentType("text/xml");
		resp.setHeader("Cache-Control", "no-cache");
		PrintWriter writer = resp.getWriter();
		writer.write(uploads + "");
	}

	private int findNumberOfUploads(String courseID, String assignmentID) {
		int total = 1;
		File folder = new File(UPLOADS_MAIN_FOLDER + "\\Course" + courseID
				+ "\\Assignment" + assignmentID);
		File[] listFiles = folder.listFiles();
		if (listFiles != null) {
			for (File file : listFiles) {
				if (file.isDirectory()) {
					total++;
				}
			}
		}
		return total;
	}
}
