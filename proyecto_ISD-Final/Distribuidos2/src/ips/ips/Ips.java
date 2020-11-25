package ips;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class Ips extends UnicastRemoteObject implements IpsInterface {

	private String name;
	private int vacunasDisponibles;
	private Map<String, Integer> vacunasXpersonas;
	
	public Ips(String name) throws RemoteException {
		super();
		
		this.name = name;
		this.vacunasDisponibles = 0;
		this.vacunasXpersonas = new HashMap<String, Integer>();
		
		this.vacunasXpersonas.put("vacuna1", 0);
		this.vacunasXpersonas.put("vacuna2", 0);
		this.vacunasXpersonas.put("vacuna3", 0);
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
		this.vacunasXpersonas.put(nombreVacuna, (this.vacunasXpersonas.get(nombreVacuna)-vacunasGastadas));
		
		return this.vacunasDisponibles;
		
	}
	//cuarta funcion del interfaz
	public String getName() {
		return name;
	}
	//tercera funcion del interfaz
	public int getVacunasDisponibles() {
		return vacunasDisponibles;
	}
	public void setVacunasDisponibles(int vacunasDisponibles) {
		this.vacunasDisponibles = this.vacunasDisponibles+vacunasDisponibles;
	}
	public void setVacunasXpersonas(String key,int vacunas) {
		this.vacunasXpersonas.put(key, (this.vacunasXpersonas.get(key)+vacunas));
		setVacunasDisponibles(vacunas);
	}

	
	
}
