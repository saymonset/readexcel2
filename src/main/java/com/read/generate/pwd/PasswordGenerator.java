package com.read.generate.pwd;

import java.io.Serializable;
import java.util.Random;

/**
 * 
 * Clase que genera password aleatorio
 * 
 * @author Ing Simon Alberto Rodriguez Pacheco 18/11/2013 07:24:24
 */
public class PasswordGenerator implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String NUMEROS = "0123456789";

	private static String MAYUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	private static String MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";

	private static String ESPECIALES = "ñÑ";

	private static int tamanoPassword;

	/**
	 * 
	 * El tamaño del password, debe ser mayor  a dos
	 * @param tamanoPassword
	 */
	public PasswordGenerator(int tamanoPassword) {
		super();
		this.tamanoPassword = tamanoPassword;
	}

	//
	public static String getPinNumber() throws Exception {
		if (tamanoPassword<=2){
			throw new Exception("Tamaño del passsword debe ser mayor a dos caracteres");
		}
		return getPassword(NUMEROS, tamanoPassword);
	}

	public static String getPassword() {
		return getPassword(8);
	}

	public static String getPassword(int length) {
		return getPassword(MAYUSCULAS + MINUSCULAS + NUMEROS, length);
	}

	public static String getPassword(String key, int length) {
		String pswd = "";

		char[] text = new char[2];
		Random rng = new Random();
		String dosCaracteres = "";
		for (int i = 0; i < 2; i++) {
			if (i == 0) {
				text[i] = MAYUSCULAS.charAt(rng.nextInt(MAYUSCULAS.length()));
			} else {
				text[i] = MINUSCULAS.charAt(rng.nextInt(MINUSCULAS.length()));
			}

		}
		dosCaracteres = new String(text);

		for (int i = 0; i < tamanoPassword - 2; i++) {
			pswd += (key.charAt((int) (Math.random() * key.length())));
		}
		pswd = dosCaracteres + pswd;
		return pswd;
	}

}