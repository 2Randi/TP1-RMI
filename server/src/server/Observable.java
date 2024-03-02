package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import common.IObservable;

import common.IObserver;

public class Observable extends UnicastRemoteObject implements IObservable {
	
    //Constructeur
	protected Observable() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	//Methode
	public void addObserver(IObserver o) throws RemoteException {
		ObserverUpdater.addIObserver(o);
	}

}
