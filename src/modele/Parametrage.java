package modele;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Parametrage implements Runnable {
	int Tick; //temps avant action en ms
	int nbHeure;
	
	Terrain unTerrain ;
	
	public Parametrage(int tickInitial) {
		this.Tick = tickInitial;
		this.unTerrain = new Terrain();
		this.nbHeure = 0;
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
		while(true) {
			
			try {
				TimeUnit.MILLISECONDS.sleep(this.Tick);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			if(this.nbHeure == 24) {
				notifyObserversJ();
				this.nbHeure = 0;
			}
			notifyObserversH();
			this.nbHeure++;
		}		
	}

	
	public void starte() {
		while(true) {
			try {
				TimeUnit.MILLISECONDS.sleep(this.Tick);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			if(this.nbHeure == 24) {
				notifyObserversJ();
				this.nbHeure = 0;
			}
			notifyObserversH();
			this.nbHeure++;
		}		
	}
	
}
