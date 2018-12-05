package Piece;

import java.util.ArrayList;

import Etape.Cadavre;
import Fourmi.Fourmi;

public class Decharge extends Salle{

	int poidsTotal = 0 ;
	
	ArrayList<Cadavre> listeCadavre = new ArrayList<Cadavre>();
	
	void Ajouter(int unPoids){
		this.poidsTotal = this.poidsTotal + unPoids;
	}
	
	void AjouterFourmi(Cadavre uneFourmiMorte){
		this.listeCadavre.add(uneFourmiMorte);
	}
	
	
	void Suppr(Fourmi uneFourmiMorte){
		this.listeCadavre.remove(uneFourmiMorte);
	}
}
