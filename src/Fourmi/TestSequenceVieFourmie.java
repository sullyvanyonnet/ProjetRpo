package Fourmi;

import java.util.concurrent.TimeUnit;
import Etape.Adulte;
import Etape.Cadavre;


//TEST DE LA FONCTION VIVRE() 
public class TestSequenceVieFourmie {

	public static void main(String[] args) throws InterruptedException {		
		Fourmi mimi = new Fourmi(1);
		//TODO maj
		int ageMax = (3*365);
		for (int i=0; i<ageMax; i++)
		{
			switch(mimi.isPhase())
			{
				case "oeuf" :
					System.out.println("Larve ?");					
					break;
				case "larve" :
					System.out.println("Nymphe ?");
					break;
			//TODO mettre a jour		
				case "nymphe" :
					System.out.println("Adulte ?");					
					break;
				
				case "adulte" :
					System.out.println("Mourrir ?");
					//on force la mort de la fourmi 
					//en résuisant sa durée de vie d'adulte à un jour
					mimi.setDureeDeVie(1);
					break;	
				case "cadavre" :
					System.out.println("***MORT****");
					break;	
				default:
					break;			
			}
			mimi.vivre();
			TimeUnit.MILLISECONDS.sleep(1);
		}
	}
}