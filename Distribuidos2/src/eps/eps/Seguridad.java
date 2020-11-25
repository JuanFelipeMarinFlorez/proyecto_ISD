package eps;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Seguridad {

    public static SecureRandom sr = new SecureRandom();

    public static String encriptar(String clave, byte[] iv, String value) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            SecretKeySpec sks = new SecretKeySpec(clave.getBytes("UTF-8"), "AES");
            cipher.init(Cipher.ENCRYPT_MODE, sks, new IvParameterSpec(iv));

            byte[] encriptado = cipher.doFinal(value.getBytes());
            File archivo = new File("Seguridad.txt");
            FileWriter escribir = new FileWriter(archivo, true);
            escribir.write(clave+"  "+Base64.getEncoder().encodeToString(encriptado)+'\n');
            escribir.close();
            return Base64.getEncoder().encodeToString(encriptado);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static boolean buscarUsuario(String clave, byte [] iv, String password ) {
    	File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
           // Apertura del fichero y creacion de BufferedReader para poder
           // hacer una lectura comoda (disponer del metodo readLine()).
           archivo = new File ("Seguridad.txt");
           fr = new FileReader (archivo);
           br = new BufferedReader(fr);

           // Lectura del fichero
           String linea;
           while((linea=br.readLine())!=null){
        	   
        	   String [] line = linea.split("  ");
        	   if(line.length ==2) {
        		   if(line[0].equals(clave)) {
        			   String contrasena= decriptar(clave,iv, line[1]);
                	 
                	   if (contrasena.equals(password)) {
                		   
                		   return true;
                	   }
        			   
        		   }
        	   }
        	   
        	   
           }
           return false;
        } 
        catch(Exception e){
           e.printStackTrace();
          return false;
        }finally{
           // En el finally cerramos el fichero, para asegurarnos
           // que se cierra tanto si todo va bien como si salta 
           // una excepcion.
           try{                    
              if( null != fr ){   
                 fr.close();     
              
              }                  
           }catch (Exception e2){ 
              e2.printStackTrace();
              
           }
        }
    	
    }
    
    public static boolean buscarUsuario(String username) {
    	File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
    	 try {
             // Apertura del fichero y creacion de BufferedReader para poder
             // hacer una lectura comoda (disponer del metodo readLine()).
             archivo = new File ("Seguridad.txt");
             fr = new FileReader (archivo);
             br = new BufferedReader(fr);

             // Lectura del fichero
             String linea;
             while((linea=br.readLine())!=null){
          	   
          	   String [] line = linea.split("  ");
          	   if(line.length ==2) {
          		   if(line[0].equals(username)) {
          			   return true;
          		   }
          	   }
          	   
          	   
             }
             return false;
          } 
          catch(Exception e){
             e.printStackTrace();
            return false;
          }finally{
             // En el finally cerramos el fichero, para asegurarnos
             // que se cierra tanto si todo va bien como si salta 
             // una excepcion.
             try{                    
                if( null != fr ){   
                   fr.close();     
                
                }                  
             }catch (Exception e2){ 
                e2.printStackTrace();
                
             }
          }
    }

    public static String decriptar(String clave, byte[] iv, String encriptado) {
    	String contra="";
        try {
        	
        	
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            SecretKeySpec sks = new SecretKeySpec(clave.getBytes("UTF-8"), "AES");
            cipher.init(Cipher.DECRYPT_MODE, sks, new IvParameterSpec(iv));

            byte[] dec = cipher.doFinal(Base64.getDecoder().decode(encriptado));
            return new String(dec);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return contra;
    }

    public static void main(String[] args) {
        String clave = "juancho996499061"; // 128 bit
        byte[] iv = new byte[16];
        sr.nextBytes(iv);
        String encriptado = encriptar(clave, iv, "Demasiados Secretos!");
        System.out.println(String.format("encriptado: %s", encriptado));
        System.out.println(decriptar(clave, iv,encriptado)); 
        if(buscarUsuario(clave,iv,"Demasiados Secretos!")==true) {
        	System.out.println("holangas"); 
        }
        else {
        	System.out.println("holangas noooo "); 
        }
    }
}