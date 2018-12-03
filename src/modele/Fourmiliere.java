package modele;

import java.util.ArrayList;
import java.util.List;

import Etape.Adulte;
import Fourmi.Fourmi;
import Role.Reine;

public class Fourmiliere extends ObjetGraphique{
    List<Adulte> listeDeFourmis;
    Reine saMajeste;
    

    public Fourmiliere(){
        this.listeDeFourmis = new ArrayList<>();
        this.saMajeste = new Reine();
        this.coordonnees = new Coordonnees(100,100);
    }

    public String resumeFourmi(){
        StringBuilder res = new StringBuilder();
        return res.toString();
    }
    
    public Adulte ajouterFourmi(){
      Adulte newFourmi = new Adulte();
      newFourmi.setCoordonnees(this.coordonnees);
    	listeDeFourmis.add(new Adulte());
    	return newFourmi;
    }
    
    
}
