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
	
	@Test
	void testEvolution()
	{
		Fourmi mimo = new Fourmi(2);
		mimo.evolution();
	//TODO mettre a jour
	/*	assert(mimo.getPhase() instanceof Larve);
		mimo.evolution();
		assert(mimo.getPhase() instanceof Nymphe);
		mimo.evolution();
		assert(mimo.getPhase() instanceof Adulte);*/
	}
	
	@Test
	void testDureeVieFourmiAdulte()
	{		
		Double vie = mimi.dureeVieFourmiAdulte();
		System.out.println("duree de vie d'une fourmi adulte : " + vie);
		Double vie2 = mimi.dureeVieFourmiAdulte();
		System.out.println("duree de vie d'une fourmi adulte : " + vie2);
		assert(vie>(1.5*365) && vie<(2.6*365));
	}
}
