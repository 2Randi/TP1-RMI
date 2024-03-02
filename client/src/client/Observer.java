package client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import common.IObserver;

public class Observer extends UnicastRemoteObject implements IObserver {

	protected Observer() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void update(Object o) throws RemoteException {
		// TODO Auto-generated method stub
      System.out.println("\nFranchir le seuil de " + o + " patients!\n");
	}

}
