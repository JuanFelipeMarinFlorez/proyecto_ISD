package eps;

import java.io.File;
import java.io.FileWriter;
import  java.util.Random; 

public class GeneradorSolicitudes extends Thread{

    public GeneradorSolicitudes(){

    }

    public void run(){
        try{
            while(true){
                try {
                    File archivo = new File("solicitudes.txt");
                    FileWriter escribir = new FileWriter(archivo, true);
                    int valorEntero = (int)Math.floor(Math.random()*(10-1+1)+1);
                    for (int i = 0; i <  valorEntero; i++) {
                        escribir.write("Vacuna1");
                        escribir.write("\r\n"); 
                    }
                    valorEntero = (int)Math.floor(Math.random()*(10-1+1)+1);
                    for (int i = 0; i <  valorEntero; i++) {
                        escribir.write("Vacuna2");
                        escribir.write("\r\n"); 
                    }
                    valorEntero = (int)Math.floor(Math.random()*(10-1+1)+1);
                    for (int i = 0; i <  valorEntero; i++) {
                        escribir.write("Vacuna3");
                        escribir.write("\r\n"); 
                    }
                    escribir.close();
                } 
                catch (Exception e) {
                    System.out.println("Error al generar solicitudes de vacunas");
                }
            Thread.sleep(10000);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}