package modele;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Parametrage implements Runnable {
	int Tick; //temps avant action en ms
	
	//todo observable 
	ArrayList<Observateur> lesObserveur = new ArrayList<Observateur>();
	
	public Parametrage(int tickInitial) {
		this.Tick = tickInitial;
	}
	
	public int getTick() {
		return this.Tick;
	}
	
	public void setTick(int nouveauTick) {
		this.Tick = nouveauTick;
	}
	
	public void register(Observateur o) {
		this.lesObserveur.add(o);
	}

	public void notifyObservers() {
		for (int i=0;i<this.lesObserveur.size();i++) {
			this.lesObserveur.get(i).update();
		}
	}
	
	@Override
	public void run() {
		Terrain monTerrain = new Terrain();
		
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
