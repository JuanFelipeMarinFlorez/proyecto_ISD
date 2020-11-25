package eps;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

import ips.Ips;
import ips.IpsInterface;

public class MainEps {

	public static void main(String[] args) {
		//saluCop Salud total seguro social
		//Coomeva prepagada
		
		int puerto = 1099;
		int vacunasDisponible = 0;
		String nombre = null;
		String ipv4 = null;
		
		try {
			boolean eof = false;
			int i = 0;
			
			Scanner sc = new Scanner(new File("eps.txt"));
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
		         else if(i == 3) {
		        	 ipv4 = new String(st.nextToken());
		        	 i++;
		         }
		         
		     }
			
		    Eps salud = new Eps(nombre,vacunasDisponible);
		    
			sc.close();
			
			//HILO que se conecta a rmi y realiza la (por ahora funciones sencillas transaccion)
			//practicamente es un hilo que esta dentro de un for que posibilita enciar un paciente a la vez
			
			//Eps salud = new Eps("Sanitas", 20);
			//---------------------------------------------------------------
			
			//Lo importante de RMI
			
			Registry miRegistro = LocateRegistry.getRegistry(ipv4, puerto);
			IpsInterface misuma = (IpsInterface)Naming.lookup("//"+ipv4+":"+puerto+"/suma");
			
			
			
			//System.setProperty("java.rmi.server.hostname","192.168.1.10");
			//IpsInt nIps = (IpsInt) Naming.lookup("//localhost/IpsInt"); 
			//obj = (Hello)Naming.lookup("//127.0.0.1:1500/HelloServer"); 
			
			//Suma suma = (Suma) Naming.lookup("//"+ MainServer.IP_SERVER+":"+MainServer.PORT+"/suma");
			
			while(true) {
				
				String menu =  JOptionPane.showInputDialog(""
						+ "Suma de dos numeros...........(1)\n"
						+ "Mostrar vacunas disponibles...(2)\n"
						+ "Crear transacci�n.............(3)\n"
						+ "Salir.........................(4)\n");
				
				switch(menu) {
				
				case "1":{
					int x = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el primer numero"));
					int y = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el segundo numero"));
					
					JOptionPane.showMessageDialog(null, "La suma es : " + misuma.suma(x, y));	
					
					break;}
						
				case "2":{
					JOptionPane.showMessageDialog(null, "Las vacunas disponibles : " + misuma.getVacunasDisponibles());
					
					break;}
					
				case "3":{
					int tam = 0;
					
					int numero = new Integer(JOptionPane.showInputDialog("vacuna1"));
					salud.setVacunasXpersonas("vacuna1",new Integer((int) numero));
					tam = tam + numero;
					
					numero = new Integer(JOptionPane.showInputDialog("vacuna2"));
					salud.setVacunasXpersonas("vacuna2",numero);
					tam = tam + numero;
					
					numero = new Integer(JOptionPane.showInputDialog("vacuna3"));
					salud.setVacunasXpersonas("vacuna3",numero);
					tam = tam + numero;
					
					if(tam < salud.getMiembros()+1) {
						
						for (Entry<String, Integer> pair : salud.getVacunasXpersonas().entrySet()) {
							
							JOptionPane.showMessageDialog(null, "Las vacunas disponibles de "+ pair.getKey() + " es: " + misuma.pedirVacunas(pair.getKey(), pair.getValue()));
						    //pair.getKey(); 
							//pair.getValue();
						}
						
					}
					
					else {
						
						JOptionPane.showMessageDialog(null,"El numero de vacunas pedidas no concuerda con el numero de miembros de la eps");
						
					}
					
					break;}
					
				case "4":{
					
					return ;}
				}
				
				
				
				
			}
			
		} catch (RemoteException | MalformedURLException | NotBoundException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
