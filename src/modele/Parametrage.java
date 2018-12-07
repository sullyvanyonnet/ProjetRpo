package modele;

import java.util.concurrent.TimeUnit;

/**
 * Classe principale de l'application, gere le lancement de la fenetre, le
 * passage du temps fait se déplacer les ObjetsGraphiques.
 */
public class Parametrage implements Runnable {
	private int Tick; // Temps avant action en ms.
	private int nbHeure; // Nombre d'heures écoulée depuis la derniere mise à jour journalière.

	Terrain unTerrain; // La fenetre de l'application.

	public Parametrage(int tickInitial) {
		this.Tick = tickInitial;
		this.unTerrain = new Terrain(this);
		this.nbHeure = 0;
	}

	public int getTick() {
		return this.Tick;
	}

	public void setTick(int nouveauTick) {
		this.Tick = nouveauTick;
	}

	public void notifyH() {
		this.unTerrain.updateH();
	}

	public void notifyJ() {
		this.unTerrain.updateJ();
	}

	/**
	 * Methode lancant le passage du temps, qui peut etre accéléré, 
	 * ralentit et pausé depuis la fenetre.
	 */
	@Override
	public void run() {
		while (true) {
			try {
				TimeUnit.MILLISECONDS.sleep(1);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (this.getTick() > 0) {
				try {
					TimeUnit.MILLISECONDS.sleep(this.Tick);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (this.nbHeure == 24) {
					notifyJ();
					this.nbHeure = 0;
				}
				notifyH();
				this.nbHeure++;
			}
		}
	}
}
