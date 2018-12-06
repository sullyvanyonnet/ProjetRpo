package Piece;

import java.util.ArrayList;

import Etape.Cadavre;
import Fourmi.Fourmi;

public class Decharge extends Salle {

	int poidsTotal;	
	//TODO observable pour surveiller que le nb de fourmi *0.3 > totalCadavre) 
	int size;	
	ArrayList<Fourmi> listeCadavre;
		
	public Decharge() {
		super();
		this.poidsTotal = 0;
		this.size = 0;
		this.listeCadavre = new ArrayList<Fourmi>();
	}

	public int getPoidsTotal() {
		return poidsTotal;
	}

	public int getSize() {
		return size;
	}

	public ArrayList<Fourmi> getListeCadavre() {
		return listeCadavre;
	}

	public void ajouterPoids(int unPoids){
		this.poidsTotal = this.poidsTotal + unPoids;
	}
	
	public boolean ajouterCadavre(Fourmi mimi){
		boolean res = false;
		if("cadavre".equals(mimi.isPhase()))
		{
			this.listeCadavre.add(mimi);
			ajouterPoids(mimi.getPoids());
			size++;
			res = true;
		}			
		return res;
	}
	
	public void supprimerCadavre(Fourmi uneFourmiMorte){
		this.listeCadavre.remove(uneFourmiMorte);
		this.poidsTotal -= uneFourmiMorte.getPoids();
		size--;
	}
}
