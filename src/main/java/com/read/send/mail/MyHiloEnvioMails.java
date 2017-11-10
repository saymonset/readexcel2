package com.read.send.mail;

import org.apache.log4j.Logger;

import com.read.util.Tools;

public class MyHiloEnvioMails implements Runnable {
	private String to;
	private String messageBody;
	private String rif;
	private String url;
	private boolean swActivar;
	private String errorMail;
	private static final Logger log = Logger
			.getLogger(MyHiloEnvioMails.class);
	public MyHiloEnvioMails() {

	}

	public MyHiloEnvioMails(String to, String messageBody, String rif,
			String url,boolean swActivar) {
		this.to = to;
		this.messageBody = messageBody;
		this.rif = rif;
		this.url = url;
		this.swActivar = swActivar;
		

	}
	public void run(){
		try {
			runSinHilo();
		} catch (ExceptionSendMail e) {
		log.error(e.toString());
		}
		
	}
	public void runSinHilo()throws ExceptionSendMail{
		MandarMail m = new MandarMail();
		errorMail="";
 
		if (!Tools.isEmptyOrNull(rif) && !Tools.isEmptyOrNull(url)) {
			 
				try {
				    log.debug("pasando---------------url.trim()="+url.trim());
					m.send(to, messageBody.toString(), rif.trim(), url.trim(),swActivar);
					 
				} catch (ExceptionSendMail e) {
					log.error(e.toString());

				 
					errorMail=e.getMessage();
					throw new ExceptionSendMail (e.getMessage());
				}
			 
		}

	}

	public String getErrorMail() {
		return errorMail;
	}

	public void setErrorMail(String errorMail) {
		this.errorMail = errorMail;
	}

}
