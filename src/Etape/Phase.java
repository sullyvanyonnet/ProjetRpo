package Etape;

import Fourmi.Fourmi;
import modele.EtreVivant;
import modele.Observateur;

public abstract class Phase implements Observateur {
	
	//attribut Fourmi 
	Fourmi fourmi;
	
	public Phase(Fourmi fourmi)
	{	
		this.fourmi = fourmi;
	}

	public String jeSuis()
	{
		return null;
	}



	@Override
	public void updateH() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateJ() {
		// TODO Auto-generated method stub
		
	}

	public boolean devenirReine() {
		return false;	
	}
	
	public boolean devenirOuvrier() {
		return false;		
	}

	public boolean devenirSoldat() {
		return false;	
	}
	
	public boolean devenirReproducteur() {
		return false;		
	}
	
	public Phase phaseSuivante() {
		return null;
	}
}