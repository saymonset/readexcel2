package com.bcv.procura.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
	private static ReadProperties instance = null;
	private static String smtp;
	private static String asunto;
	private static String from;
	private static String puerto;
	private static String usuario;
	private static String passwd;

	private static String usuarioalfresco;
	private static String passwdalfresco;
	private static String urlalfresco;
	private static String homeusuarioalfresco;
	private static String mensajesversiondoc;

	private static String usuariocreadomailpordefecto;
	private static String usuariocreadocontrasenapordefecto;
	private static String usuariocreadomensajepordefecto;
	private static String usuariocreadorifpordefecto;
	private static String jndiName;
	
	private static String serverbdmaximo;
	private static String puertobdmaximo;

	private static String jdbcuser;
	private static String jdbcpassword;
	private static String jdbcurl;
	private static String jdbcdriver;

	private static final String SMTP = "SMTP";
	private static final String ASUNTO = "ASUNTO";
	private static final String FROM = "FROM";
	private static final String SERVERBDMAXIMO = "SERVERBDMAXIMO";
	private static final String PUERTOBDMAXIMO = "PUERTOBDMAXIMO";
	private static String urlserviciosjson;
	private static final String URLSERVICIOSJSON = "URLSERVICIOSJSON";
	
	private static String urlserviciosjsonAdmin;
	private static final String URLSERVICIOSJSONADMIN = "URLSERVICIOSJSONADMIN";
	
	private static String urlservicioswscxf;
	private static final String URLSERVICIOSWSCXF = "URLSERVICIOSWSCXF";
	
	

	private static final String PUERTO = "PUERTO";
	private static final String USUARIO = "USUARIO";
	private static final String PASSWD = "PASSWD";

	private static final String USUARIOALFRESCO = "USUARIOALFRESCO";
	private static final String PASSWDALFRESCO = "PASSWDALFRESCO";
	private static final String URLALFRESCO = "URLALFRESCO";
	private static final String HOMEUSUARIOALFRESCO = "HOMEUSUARIOALFRESCO";
	private static final String MENSAJESVERSIONDOC = "MENSAJESVERSIONDOC";

	private static final String USUARIOCREADOMAILPORDEFECTO = "USUARIOCREADOMAILPORDEFECTO";
	private static final String USUARIOCREADOCONTRASENAPORDEFECTO = "USUARIOCREADOCONTRASENAPORDEFECTO";
	private static final String USUARIOCREADOMENSAJEPORDEFECTO = "USUARIOCREADOMENSAJEPORDEFECTO";
	private static final String USUARIOCREADORIFPORDEFECTO = "USUARIOCREADORIFPORDEFECTO";

	private static final String JNDI_NAME = "JNDINAME";

	private ReadProperties() {
		// Exists only to defeat instantiation.
	}

	public static ReadProperties getInstance() {
		if (instance == null) {
			instance = new ReadProperties();
			Properties p = new Properties();
			InputStream is =ReadProperties.class
					.getResourceAsStream("configuration.properties");
			try {
				p.load(is);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			urlserviciosjson = p.getProperty(URLSERVICIOSJSON);
			urlserviciosjsonAdmin = p.getProperty(URLSERVICIOSJSONADMIN);

			smtp = p.getProperty(SMTP);
			asunto = p.getProperty(ASUNTO);
			from = p.getProperty(FROM);
			puerto = p.getProperty(PUERTO);
			usuario = p.getProperty(USUARIO);
			passwd = p.getProperty(PASSWD);
			usuarioalfresco = p.getProperty(USUARIOALFRESCO);
			passwdalfresco = p.getProperty(PASSWDALFRESCO);
			urlalfresco = p.getProperty(URLALFRESCO);
			homeusuarioalfresco = p.getProperty(HOMEUSUARIOALFRESCO);
			mensajesversiondoc = p.getProperty(MENSAJESVERSIONDOC);
			usuariocreadomailpordefecto = p
					.getProperty(USUARIOCREADOMAILPORDEFECTO);
			usuariocreadocontrasenapordefecto = p
					.getProperty(USUARIOCREADOCONTRASENAPORDEFECTO);
			usuariocreadomensajepordefecto = p
					.getProperty(USUARIOCREADOMENSAJEPORDEFECTO);
			usuariocreadorifpordefecto = p
					.getProperty(USUARIOCREADORIFPORDEFECTO);
			jndiName = p.getProperty(JNDI_NAME);

			jdbcuser = p.getProperty("JDBCUSER");
			jdbcpassword = p.getProperty("JDBCPASSWORD");
			jdbcurl = p.getProperty("JDBCURL");
			jdbcdriver = p.getProperty("JDBCDRIVER");
			serverbdmaximo = p.getProperty("SERVERBDMAXIMO");
			puertobdmaximo = p.getProperty("PUERTOBDMAXIMO");
			urlservicioswscxf=p.getProperty(URLSERVICIOSWSCXF);
			

		}
		return instance;
	}

	public void testProperties() throws Exception {
		Properties p = new Properties();
		InputStream is = ReadProperties.class
				.getResourceAsStream("/configuration.properties");
		p.load(is);
		is.close();
		String userName = p.getProperty(USUARIOALFRESCO);

	}

	public static String getSmtp() {
		return smtp;
	}

	public static void setSmtp(String smtp) {
		ReadProperties.smtp = smtp;
	}

	public static String getAsunto() {
		return asunto;
	}

	public static void setAsunto(String asunto) {
		ReadProperties.asunto = asunto;
	}

	public static String getFrom() {
		return from;
	}

	public static void setFrom(String from) {
		ReadProperties.from = from;
	}

	public static String getPuerto() {
		return puerto;
	}

	public static void setPuerto(String puerto) {
		ReadProperties.puerto = puerto;
	}

	public static String getUsuario() {
		return usuario;
	}

	public static void setUsuario(String usuario) {
		ReadProperties.usuario = usuario;
	}

	public static String getPasswd() {
		return passwd;
	}

	public static void setPasswd(String passwd) {
		ReadProperties.passwd = passwd;
	}

	public static String getUsuarioalfresco() {
		return usuarioalfresco;
	}

	public static void setUsuarioalfresco(String usuarioalfresco) {
		ReadProperties.usuarioalfresco = usuarioalfresco;
	}

	public static String getPasswdalfresco() {
		return passwdalfresco;
	}

	public static void setPasswdalfresco(String passwdalfresco) {
		ReadProperties.passwdalfresco = passwdalfresco;
	}

	public static String getUrlalfresco() {
		return urlalfresco;
	}

	public static void setUrlalfresco(String urlalfresco) {
		ReadProperties.urlalfresco = urlalfresco;
	}

	public static String getHomeusuarioalfresco() {
		return homeusuarioalfresco;
	}

	public static void setHomeusuarioalfresco(String homeusuarioalfresco) {
		ReadProperties.homeusuarioalfresco = homeusuarioalfresco;
	}

	public static String getMensajesversiondoc() {
		return mensajesversiondoc;
	}

	public static void setMensajesversiondoc(String mensajesversiondoc) {
		ReadProperties.mensajesversiondoc = mensajesversiondoc;
	}

	public static String getUsuariocreadomailpordefecto() {
		return usuariocreadomailpordefecto;
	}

	public static void setUsuariocreadomailpordefecto(
			String usuariocreadomailpordefecto) {
		ReadProperties.usuariocreadomailpordefecto = usuariocreadomailpordefecto;
	}

	public static String getUsuariocreadocontrasenapordefecto() {
		return usuariocreadocontrasenapordefecto;
	}

	public static void setUsuariocreadocontrasenapordefecto(
			String usuariocreadocontrasenapordefecto) {
		ReadProperties.usuariocreadocontrasenapordefecto = usuariocreadocontrasenapordefecto;
	}

	public static String getUsuariocreadomensajepordefecto() {
		return usuariocreadomensajepordefecto;
	}

	public static void setUsuariocreadomensajepordefecto(
			String usuariocreadomensajepordefecto) {
		ReadProperties.usuariocreadomensajepordefecto = usuariocreadomensajepordefecto;
	}

	public static String getUsuariocreadorifpordefecto() {
		return usuariocreadorifpordefecto;
	}

	public static void setUsuariocreadorifpordefecto(
			String usuariocreadorifpordefecto) {
		ReadProperties.usuariocreadorifpordefecto = usuariocreadorifpordefecto;
	}

	public static String getJndiName() {
		return jndiName;
	}

	public static void setJndiName(String jndiName) {
		ReadProperties.jndiName = jndiName;
	}

	public static String getJdbcuser() {
		return jdbcuser;
	}

	public static void setJdbcuser(String jdbcuser) {
		ReadProperties.jdbcuser = jdbcuser;
	}

	public static String getJdbcpassword() {
		return jdbcpassword;
	}

	public static void setJdbcpassword(String jdbcpassword) {
		ReadProperties.jdbcpassword = jdbcpassword;
	}

	public static String getJdbcurl() {
		return jdbcurl;
	}

	public static void setJdbcurl(String jdbcurl) {
		ReadProperties.jdbcurl = jdbcurl;
	}

	public static String getJdbcdriver() {
		return jdbcdriver;
	}

	public static void setJdbcdriver(String jdbcdriver) {
		ReadProperties.jdbcdriver = jdbcdriver;
	}

	public static void setInstance(ReadProperties instance) {
		ReadProperties.instance = instance;
	}

	public static String getServerbdmaximo() {
		return serverbdmaximo;
	}

	public static void setServerbdmaximo(String serverbdmaximo) {
		ReadProperties.serverbdmaximo = serverbdmaximo;
	}

	public static String getPuertobdmaximo() {
		return puertobdmaximo;
	}

	public static void setPuertobdmaximo(String puertobdmaximo) {
		ReadProperties.puertobdmaximo = puertobdmaximo;
	}

	public static String getUrlserviciosjson() {
		return urlserviciosjson;
	}

	public static void setUrlserviciosjson(String urlserviciosjson) {
		ReadProperties.urlserviciosjson = urlserviciosjson;
	}

	public static String getUrlserviciosjsonAdmin() {
		return urlserviciosjsonAdmin;
	}

	public static void setUrlserviciosjsonAdmin(String urlserviciosjsonAdmin) {
		ReadProperties.urlserviciosjsonAdmin = urlserviciosjsonAdmin;
	}

	public static String getUrlservicioswscxf() {
		return urlservicioswscxf;
	}

	public static void setUrlservicioswscxf(String urlservicioswscxf) {
		ReadProperties.urlservicioswscxf = urlservicioswscxf;
	}

 

 

	 
}
