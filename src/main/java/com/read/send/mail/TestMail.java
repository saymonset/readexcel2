package com.read.send.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

public class TestMail {
	private static final Logger log = Logger
			.getLogger(TestMail.class);
	public static void main(String[] args) {
		try {
			// Propiedades de la conexiÃ³n
			Properties props = new Properties();
	 
//			props.setProperty("mail.smtp.host", "mail.bcv.org.ve");
//			props.setProperty("mail.smtp.port", "25");
//			props.setProperty("mail.smtp.user", "ProveedoresGSI");
//			props.setProperty("mail.smtp.auth", "true");

			props.setProperty("mail.smtp.host", "smtp.mail.yahoo.com");
			props.setProperty("mail.smtp.port", "465");
			props.setProperty("mail.smtp.user", "oracle_fedora@yahoo.com");
			props.setProperty("mail.smtp.auth", "true");

			//
			// Here are the settings:
			// POP server: pop.gmail.com, Port: 995 (SSL)
			// SMTP: smtp.gmail.com, Port: 465 (SSL)
			// User name: your Gmail email address.

			// Preparamos la sesion
			Session session = Session.getDefaultInstance(props, null);

			// Construimos el mensaje
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("yo@yo.com"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					"davinio@yahoo.com"));
			message.setSubject("Hola");
			message.setText("Mensajito con Java Mail" + "de los buenos."
					+ "poque si");

			// Lo enviamos.
			Transport t = session.getTransport("smtp");
			// t.connect("ecolo4", "Oirad111");
			t.connect("oracle_fedora@yahoo.com", "12760187");
			t.sendMessage(message, message.getAllRecipients());

			// Cierre.
			t.close();
		} catch (Exception e) {
			log.error(e.toString());
		}
	}
}
