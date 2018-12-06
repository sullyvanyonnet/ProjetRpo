package proie;

import java.awt.Point;

import Etape.Adulte;
import modele.Coordonnees;
import modele.EtreVivant;

public class Proie extends EtreVivant {
	
	private static int PoidsEnMilligrammeParDefaut = 15;
	
	private int identifiant;
	private int poids;

	public Proie(int identifiant, int poids) {
		super();
		this.identifiant = identifiant;
		this.poids = poids;
	}
	
	public Proie(int identifiant) {
		super();
		this.identifiant = identifiant;
		this.poids = PoidsEnMilligrammeParDefaut;
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

	@Override
	public void updateH() {
		this.seDeplacer();
		
	}

	@Override
	public void updateJ() {
		// TODO Auto-generated method stub
		
	}

}
