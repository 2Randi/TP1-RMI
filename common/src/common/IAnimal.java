package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAnimal extends Remote {
	
	String helloAnimal() throws RemoteException;
	String getNom() throws RemoteException;
	void setNom(String next) throws RemoteException;
	String getNomMaitre() throws RemoteException;
	void setNomMaitre(String next) throws RemoteException;
	String getRace() throws RemoteException;
	void setRace(String next) throws RemoteException;
	Espece getEspece() throws RemoteException;
	void setEspece(Espece esp) throws RemoteException;
	String getDossierSuivi() throws RemoteException;
	void setDossierSuivi(String ds) throws RemoteException;
	
	
}
