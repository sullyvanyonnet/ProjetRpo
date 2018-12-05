package Role;

import Etape.Adulte;
import Etape.Oeuf;
import Fourmi.Fourmi;

public class Reine extends Role {

	private Fourmi fourmi;

    public Reine(Fourmi fourmi) {
    	super(fourmi);
    }
   
    public Oeuf pondre()
    {
    	return new Oeuf(this.fourmi);
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