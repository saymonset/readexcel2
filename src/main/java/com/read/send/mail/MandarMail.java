package com.read.send.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

import com.bcv.procura.util.ReadProperties;
import com.read.util.Tools;
 
public class MandarMail {
	private ReadProperties readProperties=ReadProperties.getInstance();
 
	private static final Logger log = Logger
			.getLogger(MandarMail.class);
	public MandarMail() {

	}

//	public static void main(String[] args) {
//		MandarMail m = new MandarMail();
//		StringBuilder messageBody = new StringBuilder();
//		messageBody.append("Su registro fue creado con exito.");
//		messageBody.append("\n pulse este link para completar los datos. \n\n");
//
//		try {
//			m.send(  "oraclefedora@gmail.com",messageBody.toString(),"j298346370","http://localhost:8080/proveedores-web/", false);
//		} catch (ExceptionSendMail e) {
//			log.error(e.toString());
//		}
//	}
	  
	public void send ( 
			String to,  String messageBody,String rif,String url,boolean swActivar) throws ExceptionSendMail{
		try {
		 
			readProperties=ReadProperties.getInstance();
 
			Properties props = new Properties();
			log.debug("-----------------------1--------------------------------------");
			log.info(readProperties.getSmtp().trim()+"=readProperties.getSmtp().trim()");
			log.debug("readProperties.getSmtp().trim()="+readProperties.getSmtp().trim());
			props.setProperty("mail.smtp.host",readProperties.getSmtp().trim()); 
			props.setProperty("mail.smtp.port",readProperties.getPuerto().trim());
			props.setProperty("mail.smtp.user",readProperties.getUsuario().trim());
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
			message.setFrom(new InternetAddress(readProperties.getFrom()));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					to));
			message.setSubject(readProperties.getAsunto());
			StringBuilder messageBodyWithUrl = new StringBuilder(messageBody.toString()); 
			messageBodyWithUrl.append("\n\n"+url+"/index.jsf?nuRif=").append(rif);
			messageBodyWithUrl.append("&swActivar=").append(swActivar);				
			message.setText(messageBodyWithUrl.toString());
			// Lo enviamos.
			Transport t = session.getTransport("smtp");
		
			 
			t.connect(readProperties.getUsuario().trim(), readProperties.getPasswd().trim());
			t.sendMessage(message, message.getAllRecipients());
		 
			t.close();
			 
		} catch (Exception e) {
			log.error(e.toString());
			throw new ExceptionSendMail("mailSendError");
		}
	}

	
	
}
