package com.controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.internet.*;
import javax.mail.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.MailService;

@WebServlet("/mail")
public class MainServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String to = request.getParameter("to");
//        String subject = request.getParameter("subject");
//        String body = request.getParameter("body");

		String content = " <style>\r\n"
				+ "        body {\r\n"
				+ "            font-family: Arial, sans-serif;\r\n"
				+ "            display: flex;\r\n"
				+ "            justify-content: center;\r\n"
				+ "            align-items: center;\r\n"
				+ "            height: 100vh;\r\n"
				+ "            margin: 0;\r\n"
				+ "            background-color: #f8f9fa;\r\n"
				+ "        }\r\n"
				+ "        .banner {\r\n"
				+ "            background-color: #4CAF50; /* Green background */\r\n"
				+ "            color: white; /* White text */\r\n"
				+ "            padding: 20px 40px;\r\n"
				+ "            border-radius: 10px;\r\n"
				+ "            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);\r\n"
				+ "            text-align: center;\r\n"
				+ "            font-size: 24px;\r\n"
				+ "        }\r\n"
				+ "        .banner h1 {\r\n"
				+ "            margin: 0;\r\n"
				+ "            font-size: 2.5em;\r\n"
				+ "        }\r\n"
				+ "        .banner p {\r\n"
				+ "            margin: 10px 0 0;\r\n"
				+ "            font-size: 1.2em;\r\n"
				+ "        }\r\n"
				+ "    </style>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "\r\n"
				+ "    <div class=\"banner\">\r\n"
				+ "        <h1>Congratulations!</h1>\r\n"
				+ "        <p>Your order has been placed successfully.</p>\r\n"
				+ "    </div>\r\n"
				+ "\r\n"
				+ "</body>";

		String name = "SHUBHAM";
		long mob = 987654320l;
		String from = "imshubu1809@gmail.com"; // Replace with your email
		String password = "nllmpcmerxdknwqw"; // Replace with your email password

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});

		//
		MailService service = new MailService();
		int pass = service.getOtp();
		String username = service.getUsername(name, mob);
        //
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("shubhamkrsam1809@gmail.com"));
			message.setSubject("Congratulations");
			message.setContent(content+"<h1>Your Branch Created Successfully <br>Your creanditials username: </h1> \n\nusername"
					+ username + "" + "\npassword:" + pass + "", "text/html");
//			message.setText("Your Branch Created Successfully\n\nYour creanditials\n\n username: " + username
//					+ "\npassword:" + pass + "");
			Transport.send(message);

			response.getWriter().print("<h1>Signup Successfull</h1>");
			request.getRequestDispatcher("login.jsp").include(request, response);

		} catch (MessagingException e) {
			e.printStackTrace();
			response.getWriter().write("Failed to send email: " + e.getMessage());
		}
	}
}
