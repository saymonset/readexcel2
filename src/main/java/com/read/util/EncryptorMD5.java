package com.read.util;
/*
 * EncryptorMD5.java
 *
 * Created on July 11, 2007, 7:17 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */



import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.StringTokenizer;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

 
 
/**
 * Created by IntelliJ IDEA.
 * User: lcisneros
 * Date: Mar 1, 2007
 * Time: 4:56:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class EncryptorMD5 {
 
	 
private static String key = "150-130-161-240-118-204-220-146";
 


/**
     *
     * Encripta un texto en formato MD5.
     *
     * @param in un String que contiene el texto a encriptar
     * @return el texto pasado como parametro, encriptado con MD5
     * @throws java.security.NoSuchAlgorithmException
     */
       public static String getMD5(String in) throws java.security.NoSuchAlgorithmException {
           
           String checksum = null;
           if (in != null) {
               java.security.MessageDigest md5 = java.security.MessageDigest.getInstance("MD5");
               checksum = toHexString(md5.digest(in.getBytes()));
           }
           return checksum;
       }

       public static String toHexString(byte[] digest) {
           char[] values={'0', '1', '2', '3', '4', '5', '6', '7', '8',
           '9', 'a', 'b', 'c', 'd', 'e', 'f'};
           StringBuffer hex=new StringBuffer();
           for(int i=0; i<digest.length; i++) {
               byte b=digest[i];
               hex.append(values[(b >> 4) & 0xf]);
               hex.append(values[b & 0x0f]);
           }
           return hex.toString();
       }


    public static void main(String[] args) throws NoSuchAlgorithmException {
         /*
        smtpHost=mail.cantv.net
        smtpPort=25
        bdpostgres=1
        server=saymon1
        serverip=127.0.0.1
        comprado=0
        public  String fechaCaduca="2008-09-10";
        public String numero_usuarios= "10";    
          
                  */
         //BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
       // System.out.print("Indique la cantidad de Licencias a Generar y pulse Enter: ");
        System.out.flush();
        try {            
            String smtpHost= "158-101-184-198-171-69-90-121-106-175-87-98-132-164-233-95";//entrada.readLine();
           //& int numero = Integer.parseInt(usuarios);
            //log.info("Licencia para = " + usuarios + " usuarios ");
           // String plaintext = usuarios;
           
                          
            String hostEncr=decrypt(key,smtpHost);     
            System.out.println("descripatada="+hostEncr);
           
            
           
        } catch (Exception ex) {
            
            System.exit(1);
        }
        /*BufferedReader in;
        in = new BufferedReader(new InputStreamReader(System.in));


        String value = "simon";
      
            //value = in.readLine();
            EncryptorMD5 encryptorMD5 = new EncryptorMD5();
           String numusuarios=EncryptorMD5.getMD5(encryptorMD5.numero_usuarios+ecological);
           String fechaCaduca2=EncryptorMD5.getMD5(encryptorMD5.fechaCaduca+ecological);
          log.info("value="+value.toString());
          String valEnc=encrypt("208-206-128-93-25-182-193-38",value.toString());
          log.info("val_enc="+valEnc.toString());
          log.info("val_enc="+valEnc.toString());
          log.info("decrypt(String keyGen,String source )="+decrypt("208-206-128-93-25-182-193-38",valEnc.toString()));
          log.info("value="+value.toString());
          //208-206-128-93-25-182-193-38
          log.info("numusuarios="+numusuarios);
          log.info("fechaCaduca2="+fechaCaduca2);
          System.out.print("genera key"+ generateKey());*/
         
          
    }

     public static String generateKey() {
        try {
            KeyGenerator keygen = KeyGenerator.getInstance("DES");
            SecretKey desKey = keygen.generateKey();
            byte[] bytes = desKey.getEncoded();
            return getString( bytes );
        } catch( Exception e ) {
            e.printStackTrace();
            return null;
        }
    }
     
      private static String getString( byte[] bytes ) {
        StringBuffer sb = new StringBuffer(20);
        for( int i=0; i < bytes.length; i++ ) {
            byte b = bytes[ i ];
            int valor = ( int )( 0x00FF & b );
            sb.append( valor );
            if( i+1 < bytes.length ) {
                sb.append( "-" );
            }
        }
        return sb.toString();
    }

       public static String encrypt(String keyGen,String source) {
        try {
            Key key = getKey(keyGen);
            Cipher desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            desCipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] cleartext = source.getBytes();
            byte[] ciphertext = desCipher.doFinal(cleartext);
            return getString( ciphertext );
        } catch( Exception e ) {
            e.printStackTrace();
        }
        return null;
    }

       public static String decrypt(String keyGen,String source ) {
        try {
            Key key = getKey(keyGen);
            Cipher desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            byte[] ciphertext = getBytes( source );
            desCipher.init(Cipher.DECRYPT_MODE, key);
            byte[] cleartext = desCipher.doFinal(ciphertext);
            return new String( cleartext );
        }  catch( Exception e ) {
            e.printStackTrace();
        }
        return null;
    }

        private static Key getKey(String key) {
        try {
            byte[] bytes = getBytes(key);
            DESKeySpec pass = new DESKeySpec( bytes );
            SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
            SecretKey s = skf.generateSecret(pass);
            return s;
        } catch( Exception e ) {
            e.printStackTrace();
        }
        return null;
    }
        
          private static byte[] getBytes( String str ) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            StringTokenizer st = new StringTokenizer( str, "-", false );
            while( st.hasMoreTokens() ) {
                int i = Integer.parseInt( st.nextToken() );
                bos.write( ( byte )i );
            }
			
		} catch (Exception e) {
			 
		}
        return bos.toByteArray();
    }


    
    public static String getKey() {
        return key;
    }

    public static void setKey(String aKey) {
        key = aKey;
    }
}
