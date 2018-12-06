package Piece;

import java.util.ArrayList;

import Etape.Cadavre;
import Fourmi.Fourmi;

public class Decharge extends Salle {

	int poidsTotal;	
	//TODO observable pour surveiller que le nb de fourmi *0.3 > totalCadavre) 
	int size;	
	ArrayList<Cadavre> listeCadavre;
		
	public Decharge() {
		super();
		this.poidsTotal = 0;
		this.size = 0;
		this.listeCadavre = new ArrayList<Cadavre>();
	}

	public int getPoidsTotal() {
		return poidsTotal;
	}

	public void setPoidsTotal(int poidsTotal) {
		this.poidsTotal = poidsTotal;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public ArrayList<Cadavre> getListeCadavre() {
		return listeCadavre;
	}

	public void setListeCadavre(ArrayList<Cadavre> listeCadavre) {
		this.listeCadavre = listeCadavre;
	}

	public void ajouter(int unPoids){
		this.poidsTotal = this.poidsTotal + unPoids;
	}
	
	public void ajouterFourmi(Cadavre mimi){
		this.listeCadavre.add(mimi);
		this.poidsTotal +=mimi.getFourmi().getPoids();
		size++;
	}
	
	public void suppr(Cadavre uneFourmiMorte){
		this.listeCadavre.remove(uneFourmiMorte);
		this.poidsTotal -=uneFourmiMorte.getFourmi().getPoids();
		size--;
	}
}
