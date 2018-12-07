package modele;

import java.awt.Point;

import vue.Morph;

public abstract class EtreVivant implements Observateur {

	protected Morph representationGraphique;
	protected Terrain terrainLie;

	public void seDeplacer() {
	}
	
	public void vivre() throws InterruptedException
	{	
		
	}
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
