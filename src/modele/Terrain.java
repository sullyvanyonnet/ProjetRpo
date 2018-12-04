package modele;

import java.util.ArrayList;

public class Terrain implements Observateur{

	ArrayList<ObjetGraphique> lesObjetGraphiques = new ArrayList<ObjetGraphique>();

	Terrain(){
		Fourmiliere uneFourmiliere = new Fourmiliere();
		this.lesObjetGraphiques.add(uneFourmiliere);
		
		for (int i = 0; i < 100 ; i++ ) {
			
			uneFourmiliere.ajouterFourmi();
		}
		
		
	}

	public void notifyObservers() {
		// TODO Auto-generated method stub
		for (int i=0;i<this.lesObjetGraphiques.size();i++) {
			this.lesObjetGraphiques.get(i).update();
		}
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
