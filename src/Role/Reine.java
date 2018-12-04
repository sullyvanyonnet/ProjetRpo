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

    @Override
	public String monRole() {
		return "reine";
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