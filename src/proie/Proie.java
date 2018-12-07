package proie;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import modele.ObjetGraphique;
import modele.Terrain;
import vue.Morph;
import vue.RectangleDrawable;

public abstract class Proie extends ObjetGraphique {

	private static int PoidsEnMilligrammeParDefaut = 15;
	private int DureeDeVie;
	private int identifiant;
	private int poids;

	// TODO ajouter parametres en rapport avec la chasse
	// nbDeFourmiAttaquantes
	// nbDeFourmiAttaquantesMax
	// boolean mort
	
	//constructeur insecte avec 3 parametre 
	public Proie(int identifiant, int poids, Terrain leTerrain) {
		super();
		this.identifiant = identifiant;
		this.poids = poids;
		this.terrainLie = leTerrain;
		this.representationGraphique = this.RepCreeFourmi();
		this.DureeDeVie = 3;
	}
	//constructeur insecte avec 2 parametre et un poid par defaud 
	public Proie(int identifiant, Terrain leTerrain) {
		super();
		this.identifiant = identifiant;
		this.poids = PoidsEnMilligrammeParDefaut;
		this.DureeDeVie = 3;
	}

	//permet le deplacement de la Proie
	public void seDeplacer() {
		//genere un nombre aleatoir entre 0 et 1
		double direction = Math.random();
		//cree un point vide
		Point pos = new Point();
		//si le nombre aleatoir et compris entre 0 et 0.25
		if (direction < 0.25) {
			//la proie se deplace vers la gauche de un pixel
			pos.setLocation(this.representationGraphique.getPosition().getX() - 1,
					this.representationGraphique.getPosition().getY());
			
		//si le nombre aleatoir et compris entre 0.25 et 0.50
		} else if (direction < 0.50) {
			//la proie se deplace vers la droite de un pixel
			pos.setLocation(this.representationGraphique.getPosition().getX() + 1,
					this.representationGraphique.getPosition().getY());
			
			//si le nombre aleatoir et compris entre 0.50 et 0.75
		} else if (direction < 0.75) {
			//la proie se deplace vers la haut de un pixel
			pos.setLocation(this.representationGraphique.getPosition().getX(),
					this.representationGraphique.getPosition().getY() + 1);
			//si le nombre aleatoir et compris entre 0.75 et 1.00
		} else if (direction < 1.00) {
			//la proie se deplace vers la bas de un pixel
			pos.setLocation(this.representationGraphique.getPosition().getX(),
					this.representationGraphique.getPosition().getY() - 1);
		}
	}

	//cree la representation graphique d'un proie
	public Morph RepCreeFourmi() {
		//recupaire Poind random dans sur le terain en X
		double tailleProiX = Math.random() * Math.min(this.terrainLie.getWorld().getSize().getWidth(),
				this.terrainLie.getWorld().getSize().getHeight());
		
		//recupaire Poind random dans sur le terain en Y
		double tailleProiY = Math.random() * Math.min(this.terrainLie.getWorld().getSize().getWidth(),
				this.terrainLie.getWorld().getSize().getHeight());
		//cree le poind avec ces nouvelles coordonnées
		Point pos = new Point((int) tailleProiX, (int) tailleProiY);
		
		double DimDefaut = 5;
		//calcul une dimention proportionnelle en fonction de son poid
		double moyenDim = DimDefaut * this.poids / 15;
		//cree la dimention
		Dimension dim = new Dimension((int) moyenDim, (int) moyenDim);
		//cree le morph avec toutes les parametre
		return new RectangleDrawable(Color.GRAY, pos, dim);
	}

	public void vivre() throws InterruptedException {
		//fais baisser la vie de la proie de 1
		this.DureeDeVie = this.DureeDeVie - 1;
		//si la vie est a 0
		if (DureeDeVie == 0) {
			//stoque ca forme precedante
			Morph old = this.representationGraphique;
			//modifi les dimentions pour le faire disparetre
			this.representationGraphique = new RectangleDrawable(Color.WHITE, new Point(0, 0), new Dimension(0, 0));
			//met a jours l'IHM 
			this.getTerrainLie().updateEtreVivant(old, this.representationGraphique);
		}
	}
	//action a realiser toutes les heurs
	@Override
	public void updateH() {
		this.seDeplacer();

	}
	//action a realiser toutes jours
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
