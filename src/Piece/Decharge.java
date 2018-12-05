package Piece;

import java.util.ArrayList;

import Fourmi.Fourmi;

public class Decharge extends Salle{

	int decharge = 0 ;
	
	ArrayList<Fourmi> listeFourmi = new ArrayList<Fourmi>();
	
	void Ajouter(int unPoids){
		this.decharge = this.decharge + unPoids;
	}
	
	void AjouterFourmi(Fourmi uneFourmi){
		this.listeFourmi.add(uneFourmi);
	}
	
	
	void Suppr(Fourmi uneFourmi){
		this.listeFourmi.remove(uneFourmi);
	}
}
