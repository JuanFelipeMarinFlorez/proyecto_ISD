package ips;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;

import javax.swing.JOptionPane;

import eps.Eps;

public class MainMail {
	
	public static void main(String[] args) {
		//int puerto = 1099;
		int puerto = 1500;
		String ipv4 = "127.0.0.1";//debe ser la ip del computador que corrio a los servers de Ips
		
		try {
			
			//Ips salu = new Ips("tutaima", 30);
			//Ips salu3 = new Ips("salud total", 30);
			//Eps salu2 = new Eps("valledupar", 20);
			Mail mail = new Mail();
				
			//Registry r = java.rmi.registry.LocateRegistry.createRegistry(puerto);
			//Registry r = java.rmi.registry.LocateRegistry.getRegistry(puerto);
			
			//r.bind("suma",(Remote)salu);
			
			Registry r = java.rmi.registry.LocateRegistry.getRegistry(puerto);
			
			//Ips suma = (Ips)UnicastRemoteObject.exportObject(new Ips(), 1500);
			r.rebind("suma", (Remote) mail);
			//JOptionPane.showMessageDialog(null, "servidor conectado");
			//r.bind("salud", (Remote)salu);
			//r.bind("salud", (Remote)salu2);
			
			mail.setIps((IpsInterface)Naming.lookup("//"+ipv4+":"+puerto+"/ips"));
			mail.setIps((IpsInterface)Naming.lookup("//"+ipv4+":"+puerto+"/ips2"));
			
			//mail.setIps((IpsInterface)Naming.lookup("//"+ipv4+":"+puerto+"/suma"));
			
			JOptionPane.showMessageDialog(null, "servidor REDI 1500");
			
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
