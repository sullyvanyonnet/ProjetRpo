package modele;

import java.util.ArrayList;
import java.util.List;

import Fourmi.Fourmi;
import Role.Reine;

public class Fourmiliere extends ObjetGraphique{
    List<Fourmi> listeDeFourmis;
    Reine saMajeste;
    

    public Fourmiliere(){
        this.listeDeFourmis = new ArrayList<>();
        this.saMajeste = new Reine();
    }

    public String resumeFourmi(){
        StringBuilder res = new StringBuilder();
        return res.toString();
    }
    
    public void ajouterFourmi(){
    	listeDeFourmis.add(new Fourmi());
    }
    
    
}
