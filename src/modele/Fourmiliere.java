package modele;

import java.util.ArrayList;
import java.util.List;

import Fourmi.Fourmi;
import Role.Reine;

public class Fourmiliere extends ObjetGraphique{
    List<Fourmi> listeDeFourmis;
    Reine saMajeste;
    private int nombreDeFourmi;
    

    public Fourmiliere(){
        this.listeDeFourmis = new ArrayList<>();
        this.saMajeste = new Reine();
        this.coordonnees = new Coordonnees(100,100);
        this.nombreDeFourmi = 0;
    }

    public String resumeFourmi(){
        StringBuilder res = new StringBuilder();
        return res.toString();
    }
    
    public Fourmi ajouterFourmi(){
      Fourmi newFourmi = new Fourmi(this.nombreDeFourmi);
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
    	
    	//
    	
    }

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
    
    
}
