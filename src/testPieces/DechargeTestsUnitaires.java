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
		for (int i=0; i<ageMax; i++)
		{
			if("adulte".equals(mimi.isPhase()))
			{
				//on force la mort 
				//en mettant la duree de vie d'une fourmi adulte
				//à 1 jour
				mimi.setDureeDeVie(1);
				break;
			}
			mimi.vivre();
			TimeUnit.MILLISECONDS.sleep(1);
		}
		decharge2cadavres.ajouterCadavre(mimi);
		mi = new Fourmi(1);
		for (int i=0; i<ageMax; i++)
		{
			if("adulte".equals(mi.isPhase()))
			{
				//on force la mort 
				//en mettant la duree de vie d'une fourmi adulte
				//à 1 jour
				mimi.setDureeDeVie(1);
				break;
			}
			mi.vivre();
			TimeUnit.MILLISECONDS.sleep(1);
		}
		decharge2cadavres.ajouterCadavre(mi);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetPoidsTotal() {
								
		int poidsTotalAttendu = mimi.getPoids()+ mi.getPoids();
		System.out.println(decharge2cadavres.getPoidsTotal());
		assert(poidsTotalAttendu == decharge2cadavres.getPoidsTotal());
	}

	@Test
	void testGetSize() {
		assert(dechargeVide.getSize() == 0);
		assert(decharge2cadavres.getSize() == 3);
	}

	@Test
	void testGetListeCadavre() {
		fail("Not yet implemented");
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
	
	//TODO 
	@Test
	void testAjouterCadavreVrai() throws InterruptedException {
		Fourmi mimi = new Fourmi(1);
		//simuler la vie de la fourmi jusqu'à sa mort
		Fourmi mimi2 = new Fourmi(1);
		while(true)
		{
			if("adulte".equals(mimi2.isPhase()))
			{
				//on force la mort 
				//en mettant la duree de vie d'une fourmi adulte
				//à 1 jour
				mimi.setDureeDeVie(1);
				break;
			}
			mimi2.vivre();
			TimeUnit.MILLISECONDS.sleep(1);
		}
		System.out.println(mimi2.isPhase());
		assertTrue(dechargeVide.ajouterCadavre(mimi2));		
	}

	@Test
	void testSupprimerCadavre() {
		fail("Not yet implemented");
	}

}
