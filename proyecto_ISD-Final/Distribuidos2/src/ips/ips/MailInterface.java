package ips;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MailInterface extends Remote{
	
	public IpsInterface ipsInterface()throws RemoteException;
	
	public void setIps(IpsInterface ips)throws RemoteException;

}
