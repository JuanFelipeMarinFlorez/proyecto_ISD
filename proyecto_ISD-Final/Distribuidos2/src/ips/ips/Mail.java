package ips;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Mail extends UnicastRemoteObject implements MailInterface {

	//public IpsInterface ips;
	public ArrayList<IpsInterface> ips;
	public int index;
	
	public Mail() throws RemoteException {
		super();
		this.ips = new ArrayList<IpsInterface>();
		this.index = 0;
	}



	@Override
	public IpsInterface ipsInterface() throws RemoteException {
		// TODO Auto-generated method stub
		int i = this.index;
		this.index = (this.index + 1) % (this.ips.size());
		return this.ips.get(i);
	}


	@Override
	public void setIps(IpsInterface ips)throws RemoteException {
		this.ips.add(ips);
	}

	
	
}
