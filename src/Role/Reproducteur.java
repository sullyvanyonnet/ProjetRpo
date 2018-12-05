package Role;

import Fourmi.Fourmi;

public class Reproducteur extends Role{
	public Reproducteur(Fourmi fourmi) {
    	super(fourmi);
    }
	
	@Override		
	public String monRole()
	{
		return "reproducteur";
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