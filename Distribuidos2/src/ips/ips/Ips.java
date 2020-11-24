package ips;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Ips extends UnicastRemoteObject implements IpsInterface {

	private String name;
	private int vacunasDisponibles;
	
	protected Ips(String name, int vacunasDisponibles) throws RemoteException {
		super();
		
		this.name = name;
		this.vacunasDisponibles = vacunasDisponibles;
	}
	//primera funcion del interfaz
	@Override
	public int suma(int a, int b) {
		// TODO Auto-generated method stub
		System.out.println("cliente");
		return a+b;
	}
	//segunda funcion del interfaz
	public int pedirVacunas(String nombreVacuna, int vacunasGastadas) {
		// TODO Auto-generated method stub
		
		this.vacunasDisponibles = this.vacunasDisponibles - vacunasGastadas;
		
		return this.vacunasDisponibles;
		
	}

	public String getName() {
		return name;
	}
	//tercera funcion del interfaz
	public int getVacunasDisponibles() {
		return vacunasDisponibles;
	}

}
