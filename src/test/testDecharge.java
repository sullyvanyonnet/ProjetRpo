package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Fourmi.Fourmi;
import Etape.Cadavre;
import Piece.Decharge;

class testDecharge {
	
	Decharge decharge;

	@BeforeEach
	void setUp() throws Exception {
		decharge = new Decharge();
	}
	

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAjouterFourmi() throws InterruptedException {
		Fourmi mimi = new Fourmi(1);
		int ageMax = 10000;
		boolean b = false;
		for (int i=0; i<ageMax; i++)
		{
			if("adulte".equals(mimi.isPhase()))
			{
				b = mimi.devenirReine();
				break;
			}
			mimi.vivre();
			TimeUnit.MILLISECONDS.sleep(1);
		}		
		Cadavre mimiMorte = new Cadavre(mimi);
		decharge.ajouterFourmi(mimiMorte);
		assert(decharge.getSize() == 1);
	}
	
	@Test
	void testSupprimerFourmi() throws InterruptedException {
		Fourmi mimi = new Fourmi(1);
		int ageMax = 10000;
		boolean b = false;
		for (int i=0; i<ageMax; i++)
		{
			if("adulte".equals(mimi.isPhase()))
			{
				b = mimi.devenirReine();
				break;
			}
			mimi.vivre();
			TimeUnit.MILLISECONDS.sleep(1);
		}		
		Cadavre mimiMorte = new Cadavre(mimi);
		decharge.ajouterFourmi(mimiMorte);
		decharge.suppr(mimiMorte);
		assert(decharge.getSize() == 0);
	}
	
	@Test 
	void testAjouterPoids()
	{
		decharge.ajouter(15);
		assert(decharge.getPoidsTotal() == 15);
	}

}
