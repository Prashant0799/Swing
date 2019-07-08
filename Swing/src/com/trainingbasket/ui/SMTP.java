package com.trainingbasket.ui;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SMTP {

	public static void sendMail(String studentEmail, int studentId, String stream) {
		// Properties class to note some properties
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		Authenticator authenticator = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("loggerdemon@gmail.com", "students@1989");
			}
		};
		Session session = Session.getDefaultInstance(props, authenticator);
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("loggerdemon@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(studentEmail));
			message.setSubject("Testing Subject for weekend batch" );
			String ssss = new String("Welcome to XYZ University Your Student Id is "+studentId +"Stram is "+stream );
			message.setText("Boss Thi is for Weekend Batch" + ssss);
			Transport.send(message);
			System.out.println("Done for Java Weekend Batch");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}
}