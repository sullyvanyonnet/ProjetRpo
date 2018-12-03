package Etape;

import modele.ObjetGraphique;

public class Phase extends ObjetGraphique {
	Etape etape;

	public Etape getEtape() {
		return etape;
	}

	public void setEtape(Etape etape) {
		this.etape = etape;
	}

	public Phase(Etape etape) {
		this.etape = etape;
	}
}
