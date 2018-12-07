package Role;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import Etape.Oeuf;
import Fourmi.Fourmi;
import vue.Morph;
import vue.Oval;

public class Reine extends Role {

	private Fourmi fourmi; // La fourmi correspondant a ce role.

	public Reine(Fourmi fourmi) {
		super(fourmi);
		this.fourmi.setRepresentationGraphique(this.RepCreeFourmi());
	}

	//creation unitaire d'un nouvel oeuf
	public Oeuf pondre() {
		return new Oeuf(this.fourmi);
	}

	//remplace instanceof
	@Override
	public String monRole() {
		return "reine";
	}

	//representation graphique de la reine
	public Morph RepCreeFourmi() {
		Point pos = this.fourmi.getrepresentationGraphique().getPosition();
		Dimension dim = new Dimension(8, 8);
		return new Oval(Color.BLUE, pos, dim);
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