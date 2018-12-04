package Fourmi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Etape.Adulte;
import Etape.Cadavre;
import Etape.Larve;
import Etape.Nymphe;

class TestsUnitairesFourmi {
	
	Fourmi mimi ;

	@BeforeEach
	void setUp() throws Exception {
		mimi = new Fourmi(1);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	//DO evolutionLarve
	@Test
	void testEvolutionLarve() {
		mimi.evolutionLarve();
		assert(mimi.getPhase() instanceof Larve);
	}
	//DO evolutionNymphe
	@Test
	void testEvolutionNymphe() {
		mimi.evolutionNymphe();
		assert(mimi.getPhase() instanceof Nymphe);
	}
	//DO evolutionAdulte
	@Test
	void testEvolutionAdulte() {
		mimi.evolutionAdulte();
		assert(mimi.getPhase() instanceof Adulte);
	}
	//DO mourrir
	@Test
	void testMourrir() {
		mimi.mourrir();
		assert(mimi.getPhase() instanceof Cadavre);
	}
	
	//DO mourrir
		@Test
		void testMourrir2() throws InterruptedException {
			int age = 15;
			mimi.evolutionAdulte();
			mimi.setDureeDeVie(age);
			for (int i=0; i<age+1; i++)
			{
				mimi.vivre();
				if(mimi.isPhase().equals("cadavre"))
				{
					System.out.println("***MORT****");	
					break;
				}
				else
				{
					System.out.print("vi");
				}
				TimeUnit.MILLISECONDS.sleep(1);
			}
		}
	
	//DO evolution
	@Test
	void testEvolution()
	{
		Fourmi mimo = new Fourmi(2);
		mimo.evolution();
		assert(mimo.getPhase() instanceof Larve);
		mimo.evolution();
		assert(mimo.getPhase() instanceof Nymphe);
		mimo.evolution();
		assert(mimo.getPhase() instanceof Adulte);
	}
	
	@Test
	void testDureeVieFourmiAdulte()
	{		
		Double vie = mimi.dureeVieFourmiAdulte();
		assert(vie>(1.5*365) && vie<(2.6*365));
	}
}
