package com.read.send.mail;

/**
 * @author Ing Simón Alberto Rodriguez Pacheco Desarrollador Senior Java
 *         simon.rodriguez@enquistech.com oraclefedora@gmail.com 17/05/2013 10:10:31
 *
 */
public class ExceptionSendMail  extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ExceptionSendMail(){
		super();
	}
	public ExceptionSendMail(String msg){
		super(msg);
	}
	 
	public ExceptionSendMail(String msg,Exception e){
		super(msg,e);
	}
}
