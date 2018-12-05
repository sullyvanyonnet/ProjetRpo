package modele;

import java.util.ArrayList;
import java.util.List;

import Fourmi.Fourmi;
import Piece.Decharge;
import Piece.Salle;
import Piece.Stock;
import Role.Reine;

public class Fourmiliere extends ObjetGraphique{
    List<Fourmi> listeDeFourmis;
    List<Salle> ListeSalle;
    Reine saMajeste;
    private int nombreDeFourmi;
    

    public Fourmiliere(){
        this.listeDeFourmis = new ArrayList<>();
        this.saMajeste = new Reine();
        this.coordonnees = new Coordonnees(100,100);
        this.ListeSalle = new ArrayList<>();
        this.ListeSalle.add(new Stock());
        this.ListeSalle.add(new Decharge());        
        this.nombreDeFourmi = 0;
    }

    public List<Fourmi> getFourmis(){
    	return this.listeDeFourmis;
    }
    public String resumeFourmi(){
        StringBuilder res = new StringBuilder();
        return res.toString();
    }
    
    public Fourmi ajouterFourmi(){
      Fourmi newFourmi = new Fourmi(this.nombreDeFourmi);
      newFourmi.setCoordonnees(new Coordonnees(
    		  this.coordonnees.getCoordonneeX(), this.coordonnees.getCoordonneeY()));
		
    	listeDeFourmis.add(newFourmi);
    	this.nombreDeFourmi++;
    	return newFourmi;
    }
    
    public void Nourire() {
    	int sommeANourir = 0;
    	//get somme
    	for(int i = 0; i> this.listeDeFourmis.size(); i++) {
    		sommeANourir = sommeANourir + this.listeDeFourmis.get(i).getPoids();	
    	}	   	    
    	//todo debiter
    }



	@Override
	public void updateH() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateJ() {
		// TODO Auto-generated method stub
		
	}
    
    
}
