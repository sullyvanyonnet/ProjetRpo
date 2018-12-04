package modele;

import java.util.ArrayList;

public class Parametrage {
	int Tick; //temps avant action en ms
	
	//todo observable 
	ArrayList<Observateur> lesObserveur = new ArrayList<Observateur>();

	public void register(Observateur o) {
		this.lesObserveur.add(o);
	}

	public void notifyObservers() {
		// TODO Auto-generated method stub
		for (int i=0;i<this.lesObserveur.size();i++) {
			this.lesObserveur.get(i).updateFrom();
		}
	}
	
	
}
