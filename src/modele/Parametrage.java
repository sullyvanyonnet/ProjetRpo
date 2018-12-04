package modele;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Parametrage {
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
	
	public void main(String[] args) throws InterruptedException {
		
		while(true) {
			TimeUnit.MILLISECONDS.sleep(this.Tick);	
			
		}
		
		
	}

	
}
