package Piece;

import java.util.ArrayList;

import Fourmi.Fourmi;
import proie.Proie;

public class Stock extends Salle {
	int poidsTotal;	
	int size;	
	ArrayList<Proie> listeProies;
	
	public int getPoidsTotal() {
		return poidsTotal;
	}

	public int getSize() {
		return size;
	}

	public ArrayList<Proie> getListeProies() {
		return listeProies;
	}

	void ajouterStock(int unPoids){
		this.poidsTotal = this.poidsTotal + unPoids;
	}
	
	void ajouterStock(Proie uneProie){
		this.listeProies.add(uneProie);
		this.size = this.getSize() + 1;
	}
	
	boolean supprimerStock(int unPoids) {
		
		if(this.poidsTotal <= unPoids) {
			this.poidsTotal = this.poidsTotal - unPoids;
			return true;
		}
		return false;	
	}
	
	//TODO
	/*boolean supprimerStock(Proie uneProie) {
		
		//regler proie
		
		//regler poids
		if(this.poidsTotal <= uneProie.get) {
			this.poidsTotal = this.poidsTotal - unPoids;
			return true;
		}
		return false;	
	}*/
}
