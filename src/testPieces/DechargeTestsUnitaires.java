package testPieces;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Fourmi.Fourmi;
import Etape.Cadavre;
import Piece.Decharge;

class DechargeTestsUnitaires {
	
	//TODO mettre a jour
	//code rendu obsolete lors de l'implémentation des vues
	
	Decharge dechargeVide;
	Decharge decharge2cadavres;
	Fourmi mimi;
	Fourmi mi;

	@BeforeEach
	void setUp() throws Exception {
		dechargeVide = new Decharge();
		decharge2cadavres = new Decharge();
		//ajouts de 2 cadavres à la decharge
		mimi = new Fourmi(1);
		int ageMax = 40;
		while(!("cadavre".equals(mimi.isPhase())))
		{
			if("adulte".equals(mimi.isPhase()))
			{
				//on force la mort 
				//en mettant la duree de vie d'une fourmi adulte
				//à 1 jour
				mimi.setDureeDeVie(1);
			}
			mimi.vivre();
			TimeUnit.MILLISECONDS.sleep(1);
		}
		decharge2cadavres.ajouterCadavre(mimi);
		mi = new Fourmi(1);
		while(!("cadavre".equals(mi.isPhase())))
		{
			if("adulte".equals(mi.isPhase()))
			{
				//on force la mort 
				//en mettant la duree de vie d'une fourmi adulte
				//à 1 jour
				mi.setDureeDeVie(1);
			}
			mi.vivre();
			TimeUnit.MILLISECONDS.sleep(1);
		}
		boolean b = decharge2cadavres.ajouterCadavre(mi);
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testGetPoidsTotal() {
								
		int poidsTotalAttendu = mimi.getPoids()+ mi.getPoids();
		assert(poidsTotalAttendu == decharge2cadavres.getPoidsTotal());
	}

	@Test
	void testGetSize() {
		assert(dechargeVide.getSize() == 0);
		System.out.println(decharge2cadavres.getSize());
		assert(decharge2cadavres.getSize() == 2);
	}

	@Test
	void testAjouterPoids() {
		dechargeVide.ajouterPoids(45);
		assert(dechargeVide.getPoidsTotal() == 45);
	}

	@Test
	void testAjouterCadavreFaux() {
		Fourmi mimi = new Fourmi(1);	
		assertFalse(dechargeVide.ajouterCadavre(mimi));		
	}
 
	@Test
	void testAjouterCadavreVrai() throws InterruptedException {
		Fourmi mimi = new Fourmi(1);
		//simuler la vie de la fourmi jusqu'à sa mort
		Fourmi mimi2 = new Fourmi(1);
		while(!("cadavre".equals(mimi2.isPhase())))
		{
			if("adulte".equals(mimi2.isPhase()))
			{
				//on force la mort 
				//en mettant la duree de vie d'une fourmi adulte
				//à 1 jour
				mimi2.setDureeDeVie(1);
			}
			mimi2.vivre();
			TimeUnit.MILLISECONDS.sleep(1);
		}
		assertTrue(dechargeVide.ajouterCadavre(mimi2));		
		assertTrue(dechargeVide.getSize() == 1);
	}

	@Test
	void testSupprimerCadavre() {
		int sizeCadavresAvantSuppression = decharge2cadavres.getSize();
		decharge2cadavres.supprimerCadavre(mimi);
		assertTrue(decharge2cadavres.getSize() == (sizeCadavresAvantSuppression - 1));
	}

}
