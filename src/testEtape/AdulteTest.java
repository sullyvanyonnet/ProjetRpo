package testEtape;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Etape.Adulte;
import Fourmi.Fourmi;
import Role.Ouvrier;
import Role.Reine;
import Role.Reproducteur;
import Role.Role;
import Role.Soldat;

class AdulteTest {
	
	//TODO mettre a jour
	//code rendu obsolete lors de l'implémentation des vues

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testDevenirReine() throws InterruptedException {
		Fourmi mimi = new Fourmi(1);
		int ageMax = 40;
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
		assertTrue(b);
		Role role =((Adulte) mimi.getPhase()).getRole();
		assertTrue(role instanceof Reine);
	}
	
	@Test
	void testDevenirOuvrier() throws InterruptedException {
		Fourmi mimi = new Fourmi(1);
		int ageMax = 40;
		boolean b = false;
		for (int i=0; i<ageMax; i++)
		{
			if("adulte".equals(mimi.isPhase()))
			{
				b = mimi.devenirOuvrier();
				break;
			}
			mimi.vivre();
			TimeUnit.MILLISECONDS.sleep(1);
		}		
		assertTrue(b);
		Role role =((Adulte) mimi.getPhase()).getRole();
		assertTrue(role instanceof Ouvrier);
	}
	
	@Test
	void testDevenirSoldat() throws InterruptedException {
		Fourmi mimi = new Fourmi(1);
		int ageMax = 40;
		boolean b = false;
		for (int i=0; i<ageMax; i++)
		{
			if("adulte".equals(mimi.isPhase()))
			{
				b = mimi.devenirSoldat();
				break;
			}
			mimi.vivre();
			TimeUnit.MILLISECONDS.sleep(1);
		}		
		assertTrue(b);
		Role role =((Adulte) mimi.getPhase()).getRole();
		assertTrue(role instanceof Soldat);
	}
	
	@Test
	void testDevenirReproducteur() throws InterruptedException {
		Fourmi mimi = new Fourmi(1);
		int ageMax = 40;
		boolean b = false;
		for (int i=0; i<ageMax; i++)
		{
			if("adulte".equals(mimi.isPhase()))
			{
				b = mimi.devenirReproducteur();
				break;
			}
			mimi.vivre();
			TimeUnit.MILLISECONDS.sleep(1);
		}		
		assertTrue(b);
		Role role =((Adulte) mimi.getPhase()).getRole();
		assertTrue(role instanceof Reproducteur);
	}

}
