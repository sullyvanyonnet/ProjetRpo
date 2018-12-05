package Role;

import modele.Observateur;
import Etape.Oeuf;
import Fourmi.Fourmi;

public abstract class Role implements Observateur{	
	
	private Fourmi fourmi;
	
	public Role(Fourmi fourmi)
	{
		this.fourmi = fourmi ;
	}

	public String monRole() {
		return null;
	}

	public Oeuf pondre() {		
		return null;
	}

	public double dureeVieFourmiReine() {		
		return (Double) null;
	}
}