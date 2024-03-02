package server;

public class DossierSuivi {
	
	//Atribut
	private String ds;
	
	//Constructeur
	public DossierSuivi() {
		this.ds = "dossier suivi...";
	}
	
	//Methodes
	public String getDS() {
		return this.ds;
	}
	
	public void setDS(String ds) {
		this.ds = ds;
	}
	
	public String toString() {
		return this.ds;
	}
}
