package Role;

import Etape.Oeuf;

public class Reine extends Role {

	//TODO trouver un moyen de modifier la duree de vie de la reine
    public Reine() {
    	super();
    }
   
    public Oeuf pondre()
    {
		return new Oeuf();
    }
    
    public double dureeVieFourmiReine()
	{
		return (1.5*(1+((1.5*Math.random())/10)))*365;
	}
}