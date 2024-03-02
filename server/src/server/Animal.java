package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import common.Espece;
import common.IAnimal;


public class Animal extends UnicastRemoteObject implements IAnimal{
	
	
	//attributs
	private String nom;
	private String nomMaitre;
	private String race;
	private DossierSuivi dossierSuivi;
	private Espece esp;
	
	
	//constructeurs
	
	public Animal(String nom, String nomMaitre, String race,
			String ds, Espece esp) throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		this.dossierSuivi = new DossierSuivi();
		this.setNom(nom);
		this.setNomMaitre(nomMaitre);
		this.setRace(race);
		this.setDossierSuivi(ds);
		this.esp= new Espece(esp.getNomEspece(),esp.getDureeVieMoy());
	}
	
	public Animal(String nom, String nomMaitre, String race, String ds, 
			String nomEspece, int dureeVieMoy) throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		this.dossierSuivi = new DossierSuivi();
		this.setNom(nom);
		this.setNomMaitre(nomMaitre);
		this.setRace(race);
		this.setDossierSuivi(ds);
		this.esp= new Espece(nomEspece,dureeVieMoy);
	}

	
	//Methodes
	public String helloAnimal() throws RemoteException {
		return "hello animal!";
	}
	
	
	public String getNom() throws RemoteException {
		return this.nom;
	}

	public void setNom(String nom) throws RemoteException {
		this.nom = nom;
	}
	
	
	public String getNomMaitre() throws RemoteException {
		return this.nomMaitre;
	}
	
	public void setNomMaitre(String nomMaitre) throws RemoteException {
		this.nomMaitre = nomMaitre;
	}
	
	
	public String getRace() throws RemoteException{
		return this.race;
	}
	
	public void setRace(String race) throws RemoteException {
		this.race = race;
	}
	
	
	public Espece getEspece() {
		return this.esp;
	}
	
	public void setEspece(Espece espece) {
		this.esp = esp;
	}
	
	public String getDossierSuivi() throws RemoteException {
		return this.dossierSuivi.getDS();
	}
	
	public void setDossierSuivi(String ds) throws RemoteException {
		this.dossierSuivi.setDS(ds);
	}

}
