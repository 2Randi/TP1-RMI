package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import common.Chat;
import common.Chien;
import common.Espece;
import common.IAnimal;
import common.ICabinet;
import common.IObservable;

public class Client {
	
	public static void main(String[] args){
		
		// TODO Auto-generated method stub
		String host = (args.length < 1) ? null : args[0];
		try {
			Registry registry = LocateRegistry.getRegistry(host);

			ICabinet stubICabinet = (ICabinet) registry.lookup("cabinet");
			String responseCA = stubICabinet.helloCabinet();
			System.err.println("Client ready ... " + responseCA);
			
			IObservable stubIObservable = (IObservable) registry.lookup("observable");
			stubIObservable.addObserver(new Observer());
			
			Espece chat = new Chat();
			Espece chien = new Chien();
			
			
			Scanner sc = new Scanner(System.in);
			int input = 0;
			do {
				System.out.println(
						"\n1 Afficher tous les noms d'animaux.\n"+
						"2 Afficher les informations de tous les animaux.\n"+
						"3 Ajouter un nouveau animal.\n"+
						"4 Recherche animal par nom - modification dossier suivi - suppression animal.\n"+
						"5 Simuler l'augmentation de nombre de patients jusqu'à 100.\n"+
						"6 Simuler l'augmentation de nombre de patients jusqu'à 500.\n"+
						"7 Simuler l'augmentation de nombre de patients jusqu'à 1000.\n"+
						"8 Supprimer tous les animaux.\n"+
						"9 Nombre total d'animaux dans le cabinet.\n"+
						"0 Quitter."
				);
				
				try {
					input = sc.nextInt();
				} catch (Exception e) {
					System.out.println("Erreur!!! Saisie non valide. Relancer le programme pour recommencer.");
					e.printStackTrace();
					break;
				}
				
				// 1 Affichagpar nom tous les animaux.
				if (input == 1) {
					System.out.println("Nom de tous les animaux : \n" + stubICabinet.consulterNoms());
				}
				
				// 2 Affichage des informations de tous les animaux.
				if (input == 2) {
					System.out.println("Info sur tous les patients : \n" + stubICabinet.consulterTous());
				}
				
				// 3 Créer un nouveau animal.
				if (input == 3) {
					
					System.out.println("Nom de l'animal : ");
					String nom = sc.next();
					if (stubICabinet.rechercheAnimal(nom) == null) {
						System.out.println("Nom  du Maître : ");
						String nomMaitre = sc.next();
						System.out.println("Race : ");
						String race = sc.next();
						System.out.println("Dossier suivi (état) : ");
						String ds = sc.next();
						
						System.out.println(
								"Espèce ('chat' ou 'chien' ou 'autre') : \n" +
								"Si 'autre', veuillez entrer 'nom d'espèce' et 'durée de vie moyenne' de l'animal.");
	
						String inputEspece = sc.next();
						try {
							if (inputEspece.equals("chat")) {
							stubICabinet.createAnimalE(nom, nomMaitre, race, ds, chat);
							System.out.println("Animal (chat) crée. \n");
							
							}else if (inputEspece.equals("chien")) {
							stubICabinet.createAnimalE(nom, nomMaitre, race, ds, chien);
							System.out.println("Animal (chien) crée. \n");
			
							}else if (inputEspece.equals("autre")) {
							System.out.println("Espèce : ");
							String nomEspece = sc.next();
							System.out.println("Durée moyenne de cette espèce : ");
							int dureeVieMoy = sc.nextInt();
							stubICabinet.createAnimal(nom, nomMaitre, race, ds, nomEspece, dureeVieMoy);
							System.out.println("Animal crée avec succès  \n");
							} else {
							System.out.println("Erreur lors de saisie d'info! Animal non crée. \n");
							}
							}catch (Exception e) {
							e.printStackTrace();
						}
					} else 
						System.out.println("Nom d'animal déjà existe, ne peut pas être crée.\n");
					
				}

				// 4 Rechercher d'animal par nom.
				if (input == 4) {
					System.out.println("Entrer le nom d'animal pour la recherche : ");
					String nom = sc.next();
					IAnimal rechercheAnim = stubICabinet.rechercheAnimal(nom);
					if (rechercheAnim == null) {
						System.out.println("Impossible de le trouver. L'animal n'existe pas! \n");
					} else {
						System.out.println(stubICabinet.infoAnimal(rechercheAnim));
						
						// modifier son dossier suivi
						System.out.println("Modifier le dossier suivi de cet animal ? (y/n)");
						if (sc.next().charAt(0) == 'y') {
							System.out.println("Entrer le nouveau dossier de suivi : ");
							String ds = sc.next();
							rechercheAnim.setDossierSuivi(ds);
						}
						//Suppression animal
						System.out.println("Supprimer cet animal ? (y/n)");
						if (sc.next().charAt(0) == 'y') {
							stubICabinet.removeAnimal(nom);
							System.out.println("Animal supprimé.\n");
						}
					}
				}
				
				// 5 Simuler l'augmentation de nombre de patients jusqu'à 100.
				if (input == 5) {
					try {
					stubICabinet.removeAll();
					System.out.println("Clear cabinet.");
					for (int i=1; i<=100; i++) {
						System.out.println(i+" patient(s) ajouté.\n");
						stubICabinet.createAnimal(""+i, "nomMaitre", "race", "ds", "dinausore", 1000);
					}
					}catch (Exception e) {
						e.printStackTrace();
				}
				}
				
				// 6 Simuler l'augmentation de nombre de patients jusqu'à 500.
				if (input == 6) {
					try {
						stubICabinet.removeAll();
						System.out.println("Clear cabinet.");
						for (int i=1; i<=500; i++) {
							System.out.println(i+" patient(s) ajouté.");
							stubICabinet.createAnimal(""+i, "nomMaitre", "race", "ds", "dinausore", 1000);
						}
						}catch (Exception e) {
							e.printStackTrace();
					}
				}
				
				// 7 Simuler l'augmentation de nombre de patients jusqu'à 1000.
				if (input == 7) {
					try {
						stubICabinet.removeAll();
						System.out.println("Clear cabinet.");
						for (int i=1; i<=1000; i++) {
							System.out.println( i+" patient(s) ajouté.");
							stubICabinet.createAnimal(""+i, "nomMaitre", "race", "ds", "dinausore", 1000);
						}
						}catch (Exception e) {
							e.printStackTrace();
					}
				}
				
				// 8 Supprimer tous les animaux.
				if (input == 8) {
					stubICabinet.removeAll();
					System.out.println("Suppression de tous les animaux!\n");
				}
				
				// 9 Nobmre total d'animaux dans le cabinet.
				if (input == 9) {
					System.out.println("Il y a "+stubICabinet.cabinetSize()+" patients dans le cabinet.\n");
				}
			
				// 0 Quitter le programme
				if (input == 0) {
					System.out.println("Exit...\nRelancer le programme pour recommencer.");
					sc.close();
				}
			} while (input != 0);
		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();
		}
	}
}



