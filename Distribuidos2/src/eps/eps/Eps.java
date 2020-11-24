package eps;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

public class Eps {

	private String name;
	private int miembros;
	private Map<String, Integer> vacunasXpersonas;
	
	public Eps(String name, int miembros) throws RemoteException {
		
		super();
		
		this.name = name;
		this.miembros = miembros;
		this.vacunasXpersonas = new HashMap<String, Integer>();
		
		this.vacunasXpersonas.put("vacuna1", 0);
		this.vacunasXpersonas.put("vacuna2", 0);
		this.vacunasXpersonas.put("vacuna3", 0);
		
	}

	public void setVacunasXpersonas(String nombreVacuna, int numero)  {
	
		this.vacunasXpersonas.put(nombreVacuna, numero);
	
	}

	public Map<String, Integer> getVacunasXpersonas() {
		return vacunasXpersonas;
	}

	public int getMiembros() {
		return miembros;
	}

	public String getName() {
		return name;
	} 
	
	
	
}
