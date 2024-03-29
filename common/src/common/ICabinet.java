package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICabinet extends Remote {

	String helloCabinet() throws RemoteException;
	IAnimal rechercheAnimal(String rechercheNom) throws RemoteException;
	String consulterNoms() throws RemoteException;
	int cabinetSize() throws RemoteException;

	void createAnimal(String nom, String nomMaitre, String race, String ds, 
			String nomEspece, int dureeVieMoy) throws RemoteException;
	
	void createAnimalE(String nom, String nomMaitre, String race, 
			String ds, Espece esp) throws RemoteException; 
	
	void removeAll() throws RemoteException;
	void removeAnimal(String nom) throws RemoteException;
	String infoAnimal(IAnimal animal) throws RemoteException;
	String consulterTous() throws RemoteException;

}
