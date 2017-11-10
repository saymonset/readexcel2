package com.read.send.mail;

import com.read.util.Tools;
 
public class Mail {

	
	public void send(String to, String messageBody, String rif, String url,
			boolean swActivar) throws ExceptionSendMail {

		if (!Tools.isEmptyOrNull(url)) {
			// mandamos el mail a traves de un hilo
			MyHiloEnvioMails myHiloEnvioMails = new MyHiloEnvioMails(to,
					messageBody, rif, url, swActivar);
			try {
				// myHiloEnvioMails.runSinHilo();

				myHiloEnvioMails.run();
			} catch (Exception e) {
				 
				throw new ExceptionSendMail(e.getMessage());
			}
			if (!Tools.isEmptyOrNull(myHiloEnvioMails.getErrorMail())) {
				throw new ExceptionSendMail(myHiloEnvioMails.getErrorMail());
			}

		}
	}
}
