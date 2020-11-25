package ips;

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class MainIps {

	public static void main(String[] args) throws IOException, NumberFormatException, HeadlessException, NotBoundException {
		
		int puerto = 1099;
		int vacunasDisponible = 0;
		String nombre = null;
		
		try {
			boolean eof = false;
			int i = 0;
			
			Scanner sc = new Scanner(new File("ips.txt"));
			//File ips = new File("ips.txt");
			System.out.println("Creando ips");
			
			StringTokenizer st = new StringTokenizer(sc.nextLine(),"|");  
		    while (st.hasMoreTokens()) {  
		         //System.out.println(st.nextToken());
		         if(i == 0) {
		        	 nombre = new String(st.nextToken());
		        	 i++;
		         }
		         else if(i == 1) {
		        	 vacunasDisponible = new Integer(st.nextToken());
		        	 i++;
		         }
		         else if(i == 2) {
		        	 puerto = new Integer(st.nextToken());
		        	 i++;
		         }
		     }
			
		    Ips ips = new Ips(nombre);
		    
			sc.close();
			/*
			 
			*/
			/*
			FileInputStream file = new FileInputStream(ips);
			
			while(!eof) {
				if(file.read() == -1) {
					
					eof = true;
					
				}
				else {
				
					String s = new String();
					//s.contentEquals(file.toString());
					JOptionPane.showMessageDialog(null,file.toString());
					
				}
				
				
				
			}*/
			
			//---------------------------------
			Ips salu = new Ips("tutaima");
			Registry r = java.rmi.registry.LocateRegistry.createRegistry(puerto);
			//Registry r = java.rmi.registry.LocateRegistry.createRegistry(puerto);
			//Ips suma = (Ips)UnicastRemoteObject.exportObject(new Ips(), 1500);
			r.rebind("ips", (Remote) salu);
			r.rebind("ips2", (Remote) ips);
			
			GeneradorVacunas vacunitas= new  GeneradorVacunas(salu);
			GeneradorVacunas vacunitas2= new  GeneradorVacunas(ips);
			
			vacunitas.start();
			vacunitas2.start();
			
			//MailInterface mali = (MailInterface)Naming.lookup("//"+"127.0.0.1"+":"+puerto+"/suma");
			
			//mali.setIps(salu);
			
			JOptionPane.showMessageDialog(null, "servidor conectado");
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "servidor no conectado" + e);	
		}
	}
	
}
