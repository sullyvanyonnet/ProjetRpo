package testEtape;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Fourmi.Fourmi;

class LarveTest {
	
	//TODO mettre a jour
	//code rendu obsolete lors de l'implémentation des vues
	
	Fourmi mimi;

	@BeforeEach
	void setUp() throws Exception {
		mimi = new Fourmi(1);
		for(int i=0; i<4 ;i++)
		{
			mimi.vivre();
			TimeUnit.MILLISECONDS.sleep(1);
		}
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testCalculPoids()
	{
		double poidsAttenduMin = 15*3;
		double poidsAttenduMax = 15*4 + (15*(1/3))*4;
		double poidsResultat = mimi.calculPoids();
		assertTrue(poidsResultat<=poidsAttenduMax); 
		assertTrue(poidsResultat>=poidsAttenduMin);		
	}
	

}
