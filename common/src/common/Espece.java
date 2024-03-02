package common;

import java.io.Serializable;

public class Espece implements Serializable {
	
	//Attributs
	protected String nomEspece;
	protected int dureeVieMoy;
	
	//Constructeur
	public Espece(String nomEspece, int dureeVieMoy) {
		super();
		this.nomEspece = nomEspece;
		this.dureeVieMoy = dureeVieMoy;
	}
	
	//Methodes
	public String getNomEspece() {
		return this.nomEspece;
	}
	
	public void setNomEspece(String nomEspece) {
		this.nomEspece = nomEspece;
	}
	
	public int getDureeVieMoy() {
		return this.dureeVieMoy;
	}
	
	public void setDureeVieMoy(int dureeVieMoy) {
		this.dureeVieMoy = dureeVieMoy;
	}
	
	public String toString() {
		return " , Espèce: " + this.nomEspece + " , Espérance de vie: " + this.dureeVieMoy;
	}
}
