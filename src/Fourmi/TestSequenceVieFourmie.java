package Fourmi;

import java.util.concurrent.TimeUnit;
import Etape.Adulte;
import Etape.Cadavre;


//TEST DE LA FONCTION VIVRE() 
public class TestSequenceVieFourmie {

	public static void main(String[] args) throws InterruptedException {		
		Fourmi mimi = new Fourmi(1);
		while (!(mimi.getPhase() instanceof Cadavre))
		{
			switch(mimi.getPhase().getEtape())
			{
				case oeuf :
					System.out.println("Larve ?");					
					break;
				case larve :
					System.out.println("Nymphe ?");
					break;
				case nymphe :
					System.out.println("Adulte ?");
					break;
				case adulte :
					System.out.println("Mourrir ?");
					break;
				default:
					break;			
			}
			mimi.vivre();
			TimeUnit.MILLISECONDS.sleep(100);
		}
	}
}
