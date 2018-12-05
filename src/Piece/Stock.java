package Piece;

public class Stock extends Salle {
	int poidStocke = 0;
	
	void Ajouter(int unPoids){
		this.poidStocke = this.poidStocke + unPoids;
	}
	
	boolean suppr(int unPoids) {
		
		if(this.poidStocke <= unPoids) {
			this.poidStocke = this.poidStocke - unPoids;
			return true;
		}
		return false;	
	}
}
