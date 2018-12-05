package Etape;

import Fourmi.Fourmi;
import modele.ObjetGraphique;

public class Phase extends ObjetGraphique {
	
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
		// TODO Auto-generated method stub
		
	}

	public Phase phaseSuivante() {
		// TODO Auto-generated method stub
		return null;
	}
}