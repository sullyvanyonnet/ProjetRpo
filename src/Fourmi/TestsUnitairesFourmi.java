package Fourmi;

import static org.junit.jupiter.api.Assertions.*;

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

	//TODO evolutionLarve
	@Test
	void testEvolutionLarve() {
		mimi.evolutionLarve();
		assert(mimi.getPhase() instanceof Larve);
	}
	//TODO evolutionNymphe
	@Test
	void testEvolutionNymphe() {
		mimi.evolutionNymphe();
		assert(mimi.getPhase() instanceof Nymphe);
	}
	//TODO evolutionAdulte
	@Test
	void testEvolutionAdulte() {
		mimi.evolutionAdulte();
		assert(mimi.getPhase() instanceof Adulte);
	}
	//TODO mourrir
	@Test
	void testMourrir() {
		mimi.mourrir();
		assert(mimi.getPhase() instanceof Cadavre);
	}
	
	//TODO evolution
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
	
	//TODO vivre
	

}
