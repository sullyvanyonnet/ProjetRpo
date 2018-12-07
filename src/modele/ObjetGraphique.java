package modele;

import java.awt.Point;

import vue.Morph;

/**
 * Classe abstraite représentant un Objet destiné à être représenté sur le Terrain principal
 */
public abstract class ObjetGraphique implements Observateur {

	protected Morph representationGraphique; //Morph représentant l'objet sur le World.
	protected Terrain terrainLie; //Terrain sur lequel est représenté l'objet.

	public void seDeplacer() {}
	
	public void vivre() throws InterruptedException{}
	public Morph getrepresentationGraphique() {
		return this.representationGraphique;
	}
	
	public void setRepresentationGraphique(Morph uneRepresentationGraphique) {
		this.representationGraphique = uneRepresentationGraphique; 
	};

	public Point getCoordonnees() {
		return this.representationGraphique.getPosition();
	}

	public void setCoordonnees(Point coord) {
		this.representationGraphique.setPosition(coord);
	}
	
	public Terrain getTerrainLie() {
		return this.terrainLie;
	}

}
