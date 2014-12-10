package Email;

import javax.mail.*;
import javax.mail.internet.*;

import java.util.*;

public class Email {
	public final static String SYSEMAILADD = "test.autograder@gmail.com";
	public final static String SENDEREMAILID = "test.autograder@gmail.com";
	public final static String SENDERPASSWORD = "zzat1234";
	public final static String EMAILSMTPSERVER = "smtp.gmail.com";
	public final static String EMAILSERVERPORT = "465";

	private String[] ReceiverEmailIDs;
	private String EmailSubject;
	private String EmailBody;

	public void setReceiverEmailID(String[] ReceiverEmailIDs) {
		this.ReceiverEmailIDs = ReceiverEmailIDs;
	}

	public String[] getReceiverEmailID() {
		return this.ReceiverEmailIDs;
	}

	public void setEmailSubject(String EmailSubject) {
		this.EmailSubject = EmailSubject;
	}

	public String getEmailSubject() {
		return this.EmailSubject;
	}

	public void setEmailBody(String EmailBody) {
		this.EmailBody = EmailBody;
	}

	public String getEmailBody() {
		return this.EmailBody;
	}

	public Email(String[] receiverEmailIDs, String emailSubject,
			String emailBody) {
		this.ReceiverEmailIDs = receiverEmailIDs;
		this.EmailSubject = emailSubject;
		this.EmailBody = emailBody;
	}

	public boolean SendEmail() {
		boolean isEmailSent = false;
		if (ReceiverEmailIDs.length > 0) {

			Properties props = new Properties();
			props.put("mail.smtp.user", SENDEREMAILID);
			props.put("mail.smtp.host", EMAILSMTPSERVER);
			props.put("mail.smtp.port", EMAILSERVERPORT);
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.auth", "true");
			// props.put("mail.smtp.debug", "true");
			props.put("mail.smtp.socketFactory.port", EMAILSERVERPORT);
			props.put("mail.smtp.socketFactory.class",
					"javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.socketFactory.fallback", "false");

			// SecurityManager security = System.getSecurityManager();

			try {
				Authenticator auth = new SMTPAuthenticator();
				Session session = Session.getInstance(props, auth);
				// session.setDebug(true);

				MimeMessage msg = new MimeMessage(session);
				msg.setText(EmailBody);
				msg.setSubject(EmailSubject);
				msg.setFrom(new InternetAddress(SENDEREMAILID));

				Address[] tos = null;

				tos = new InternetAddress[this.ReceiverEmailIDs.length];
				for (int i = 0; i < this.ReceiverEmailIDs.length; i++) {
					tos[i] = new InternetAddress(this.ReceiverEmailIDs[i]);
				}

				msg.addRecipients(Message.RecipientType.TO, tos);
				msg.setSentDate(new Date());
				Transport.send(msg);
				isEmailSent = true;
			} catch (Exception mex) {
				mex.printStackTrace();

			}
		}
		return isEmailSent;
	}

	public class SMTPAuthenticator extends javax.mail.Authenticator {
		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(SENDEREMAILID, SENDERPASSWORD);
		}
	}

}
