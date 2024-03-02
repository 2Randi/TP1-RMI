package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import common.Espece;
import common.IAnimal;
import common.ICabinet;

public class Cabinet extends UnicastRemoteObject implements ICabinet{
	
	//Attributs
	private ArrayList<IAnimal> cabinet = new ArrayList<>();

	//Constructeurs
	protected Cabinet() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		IAnimal monAnimal = new Animal("Belou", "Tsiory", "chartreux", "en_observation", 
			"chat", 20);
		this.cabinet.add(monAnimal);
	}
	
	//Méthodes
	public String helloCabinet() throws RemoteException {
		return "\nWelcome Cabinet Vétérinaire";
	}
	
	//Nombre total d'animaux
	public int cabinetSize() throws RemoteException {
		return this.cabinet.size();
	}
	
	//Creation animal dont l'espece est different de chat et chien
	public void createAnimal(String nom, String nomMaitre, String race, String ds, 
			String nomEspece, int dureeVieMoy) throws RemoteException {
		IAnimal animal = new Animal(nom, nomMaitre, race, ds, nomEspece, dureeVieMoy);
		this.cabinet.add(animal);
		if (this.cabinetSize() == 100 || this.cabinetSize() == 500 || this.cabinetSize() == 1000) {
	        ObserverUpdater.numberChanged(this.cabinetSize());
		}
	}
	
	//Creation animal dont l'espece est chat ou chien
	public void createAnimalE(String nom, String nomMaitre, String race, 
			String ds, Espece esp) throws RemoteException {
		IAnimal animal = new Animal(nom, nomMaitre, race, ds, esp);
		this.cabinet.add(animal);
		if (this.cabinetSize() == 100 || this.cabinetSize() == 500 || this.cabinetSize() == 1000) {
	        ObserverUpdater.numberChanged(this.cabinetSize());
		}
	}
	
	//Suppression animal
	public void removeAnimal(String nom) throws RemoteException {
		for (int i=0; i<this.cabinetSize(); i++) {
			if (this.cabinet.get(i).getNom().equals(nom)) {
				this.cabinet.remove(i);
			}
		}
		if (this.cabinetSize() == 100 || this.cabinetSize() == 500 || this.cabinetSize() == 1000) {
	        ObserverUpdater.numberChanged(this.cabinetSize());
		}
	}
	
	//Supprimer tous les animaux
	public void removeAll() throws RemoteException {
		this.cabinet.removeAll(this.cabinet);
	}

	//recherche animal par nom
	public IAnimal rechercheAnimal(String rechercheNom) throws RemoteException {
		IAnimal rechercheAnim = null;
		for (IAnimal animal : this.cabinet) {
			if (animal.getNom().equals(rechercheNom)) {
				rechercheAnim = animal;
			}
		}
		return rechercheAnim;
	}
	
	//Afficher tous les infos : nom, nomMaitre, race, dossiersuivi, espece
	public String infoAnimal(IAnimal animal) throws RemoteException {
		return "Nom animal: " + animal.getNom() + 
				", Nom du maître: " + animal.getNomMaitre() +
				", Race: " + animal.getRace() +
				", Dossier de suivi: " + animal.getDossierSuivi()
				+ animal.getEspece();
	}
	
	public String consulterTous() throws RemoteException {
		String tousInfo = "";
		for (IAnimal animal : this.cabinet) {
			tousInfo += this.infoAnimal(animal) + "\n";
		}
		return tousInfo;
	}
	
	public String consulterNoms() throws RemoteException {
		String nomCabinet = "";
		for (IAnimal animal : this.cabinet) {
			nomCabinet += animal.getNom() + "\n";
		}
		return nomCabinet;
	}

}
