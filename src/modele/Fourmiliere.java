package modele;

import java.util.ArrayList;
import java.util.List;

import Etape.Adulte;
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
    
    
}
