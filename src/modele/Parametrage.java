package modele;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Parametrage implements Runnable {
	int Tick = 1000; //temps avant action en ms
	
	//todo observable 
	ArrayList<Observateur> lesObserveur = new ArrayList<Observateur>();

	public void register(Observateur o) {
		this.lesObserveur.add(o);
	}

	public void notifyObservers() {
		// TODO Auto-generated method stub
		for (int i=0;i<this.lesObserveur.size();i++) {
			this.lesObserveur.get(i).update();
		}
	}
	
	@Override
	public void run() {
		Fourmiliere uneFourmiliere = new Fourmiliere();
		uneFourmiliere.ajouterFourmi();
		
		while(true) {
			
			try {
				TimeUnit.MILLISECONDS.sleep(this.Tick);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			this.notifyObservers();
		}		
	}

	
}
