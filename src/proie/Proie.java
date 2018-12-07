package proie;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import Etape.Adulte;
import modele.Coordonnees;
import modele.EtreVivant;
import modele.Terrain;
import vue.Morph;
import vue.Oval;
import vue.RectangleDrawable;

public abstract class Proie extends EtreVivant {
	
	private static int PoidsEnMilligrammeParDefaut = 15;
	private int DureeDeVie;
	private int identifiant;
	private int poids;
	
	//TODO ajouter parametres en rapport avec la chasse
	//nbDeFourmiAttaquantes
	//nbDeFourmiAttaquantesMax
	//boolean mort

	public Proie(int identifiant, int poids, Terrain leTerrain) {
		super();
		this.identifiant = identifiant;
		this.poids = poids;
		this.terrainLie = leTerrain;
		this.representationGraphique = this.RepCreeFourmi();
		this.DureeDeVie = 3;
	}
	
	public Proie(int identifiant) {
		super();
		this.identifiant = identifiant;
		this.poids = PoidsEnMilligrammeParDefaut;
		this.DureeDeVie = 3;
	}
	
	public void seDeplacer() {				
		double direction = Math.random();
		Point pos = new Point();
	    if(direction < 0.25) {
	    	pos.setLocation(this.representationGraphique.getPosition().getX() - 1, 
	    			this.representationGraphique.getPosition().getY());
	    } else if (direction < 0.50) {
	    	pos.setLocation(this.representationGraphique.getPosition().getX() +1, 
	    			this.representationGraphique.getPosition().getY());
	    } else if (direction < 0.75) {
	    	pos.setLocation(this.representationGraphique.getPosition().getX(), 
	    			this.representationGraphique.getPosition().getY()+1);
	    } else if (direction < 1.00) {
	    	pos.setLocation(this.representationGraphique.getPosition().getX(), 
	    			this.representationGraphique.getPosition().getY()-1);
	    }  	
	}

	public Morph RepCreeFourmi() {
		double tailleProiX = Math.random() * Math.min(this.terrainLie.getWord().getSize().getWidth(), this.terrainLie.getWord().getSize().getHeight()) - 50 ;
		double tailleProiY = Math.random() * Math.min(this.terrainLie.getWord().getSize().getWidth(), this.terrainLie.getWord().getSize().getHeight()) - 50 ;
		Point pos = new Point ((int)tailleProiX,(int)tailleProiY);
		double DimDefaut = 5;
		double moyenDim = DimDefaut*this.poids/15;
		Dimension dim = new Dimension((int)moyenDim,(int)moyenDim);
		return new RectangleDrawable(Color.GRAY, pos, dim);
	}
	
	public void vivre() throws InterruptedException
	{
		
		this.DureeDeVie = this.DureeDeVie - 1	;
		if(DureeDeVie == 0) {
			int indexSupr = this.terrainLie.getWord().contents().indexOf(this.representationGraphique);
			this.terrainLie.getWord().contents().remove(indexSupr);
			this.terrainLie = null;
		}
	}
	
	@Override
	public void updateH() {
		this.seDeplacer();
		
	}

	@Override
	public void updateJ() {
		// TODO Auto-generated method stub
		try {
			this.vivre();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
