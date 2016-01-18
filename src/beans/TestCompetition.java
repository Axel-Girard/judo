package beans;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCompetition {

	@Test
	public void testId1() {
		Personne p = new Personne(1, "pseudo", "mdp", "ceinture");
		assertEquals(1, p.getId());
	}

	@Test
	public void testId2() {
		Personne p = new Personne(0, "pseudo", "mdp", "ceinture");
		assertEquals(0, p.getId());
	}

	@Test
	public void testId3() {
		Personne p = new Personne(-1, "pseudo", "mdp", "ceinture");
		assertEquals(-1, p.getId());
	}

	@Test
	public void testPseudo1() {
		Personne p = new Personne(1, "pseudo", "mdp", "ceinture");
		assertEquals("pseudo", p.getPseudo());
	}

	@Test
	public void testPseudo2() {
		Personne p = new Personne(0, "", "mdp", "ceinture");
		assertEquals("", p.getPseudo());
	}

	@Test
	public void testPseudo3() {
		Personne p = new Personne(-1, null, "mdp", "ceinture");
		assertEquals(null, p.getPseudo());
	}

	@Test
	public void testMdp1() {
		Personne p = new Personne(1, "pseudo", "mdp", "ceinture");
		assertEquals("mdp", p.getMdp());
	}

	@Test
	public void testMdp2() {
		Personne p = new Personne(0, "pseudo", "", "ceinture");
		assertEquals("", p.getMdp());
	}

	@Test
	public void testMdp3() {
		Personne p = new Personne(-1, "pseudo", null, "ceinture");
		assertEquals(null, p.getMdp());
	}

	@Test
	public void testCeinture1() {
		Personne p = new Personne(1, "pseudo", "mdp", "ceinture");
		assertEquals("ceinture", p.getCeinture());
	}

	@Test
	public void testCeinture2() {
		Personne p = new Personne(0, "pseudo", "mdp", "");
		assertEquals("", p.getCeinture());
	}

	@Test
	public void testCeinture3() {
		Personne p = new Personne(-1, "pseudo", "mdp", null);
		assertEquals(null, p.getCeinture());
	}

}
