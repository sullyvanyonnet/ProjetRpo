package modele;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Parametrage implements Runnable {
	int Tick; //temps avant action en ms
	int nbHeur;
	
	Terrain unTerrain ;
	
	public Parametrage(int tickInitial) {
		this.Tick = tickInitial;
		this.unTerrain = new Terrain();
		this.nbHeur = 0;
	}
	
	public int getTick() {
		return this.Tick;
	}
	
	public void setTick(int nouveauTick) {
		this.Tick = nouveauTick;
	}
	
	public void notifyObserversH() {
		this.unTerrain.updateH();
	}
	
	public void notifyObserversJ() {	
		this.unTerrain.updateJ();
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
			if(this.nbHeur == 24) {
				notifyObserversJ();
				this.nbHeur = 0;
			}
			this.nbHeur++;
		}		
	}

	
}
