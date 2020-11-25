package ips;

import java.rmi.Remote;
import java.rmi.RemoteException;

//public class Ips extends UnicastRemoteObject implements IpsInterface
public interface IpsInterface extends Remote {

	public int suma(int a, int b) throws RemoteException;
	
	public int pedirVacunas(String nombreVacuna, int vacunasGastadas) throws RemoteException;
	
	public int getVacunasDisponibles()throws RemoteException;
	
	public String getName()	throws RemoteException;
	// public void register (Eps eps) throws RemoteException;
	// public void broadcastMessage (String Message) throws RemoteException;

}
