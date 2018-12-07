package Role;
import Fourmi.Fourmi;
import vue.Morph;
import vue.Oval;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Stack;

public class Ouvrier extends Role{
	//varaible pour dir a l'ouvrier d'explorer ou de rentrer à la ruche 
	Boolean rentreer = false;
	
	//stoque les poits parcourus 
	Stack<Point> PilePoint = new Stack<Point>(); 
	
	//contructeur du role ouvrier prenant en parametre la fourmi associé
	public Ouvrier(Fourmi fourmi) {
	   	super(fourmi);
	   	//modifie la representation graphique de la fourmi
	   	this.fourmi.setRepresentationGraphique(this.RepCreeFourmi());
	}
	
	//change l'etat du booléen
	public void inverseBool() {
		this.rentreer = !this.rentreer;
	}
	
	//permet le deplacement de l'ouvrier. Prend en parametre le poind courant
	@Override 
	public Point sedeplacer(Point unPoint){
		//recupaire le parametre
	    Point retourCoordonnees = unPoint;
	    //si il doit explorer
		if(!rentreer) {	
			//recupaire un nombre aleatoir entre 0 et 1
		    double direction = Math.random();
		    //si le nombre et compris entre 0 et 0.25
		    if(direction < 0.25) {
		    	//deplace la fourmit de 2 pixel vers la gauche
		    	retourCoordonnees.setLocation(unPoint.getX() - 2, unPoint.getY());
		    } else if (direction < 0.50) {
		    	//deplace la fourmit de 2 pixel vers la droit
		    	retourCoordonnees.setLocation(unPoint.getX() + 2, unPoint.getY());
		    } else if (direction < 0.75) {
		    	//deplace la fourmit de 2 pixel vers la haut

		    	retourCoordonnees.setLocation(unPoint.getX() ,unPoint.getY() + 2);
		    } else if (direction < 1.00) {
		    	//deplace la fourmit de 2 pixel vers la bas
		    	retourCoordonnees.setLocation(unPoint.getX() ,unPoint.getY() - 2);
		    }
		    //ajoute le point dans la pile
		    this.PilePoint.add(retourCoordonnees);	    
		}else {
			//si la fourmi doit rentrer a la fourmiliere
			if(! this.PilePoint.empty()) {
				//depile la pile pour recuperer le chemin
				retourCoordonnees =  this.PilePoint.pop();
			}
		}
		//retourne le resulta
		return retourCoordonnees;
	}
	
	//Creer la representation graphique d'un ouvrier
	public Morph RepCreeFourmi() {
		Point pos = this.fourmi.getrepresentationGraphique().getPosition();
		Dimension dim = new Dimension(5, 5);
		return new Oval(Color.ORANGE, pos, dim);
	}

	@Override
    public String monRole()
	{
		return "ouvrier";
	}
	@Override
	public void updateH() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateJ() {
		this.inverseBool();		
	}
}
