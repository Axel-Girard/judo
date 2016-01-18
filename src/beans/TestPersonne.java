package beans;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPersonne {

	@Test
	public void testDate1() {
		Competition p = new Competition("date", "adresse");
		assertEquals("date", p.getDate());
	}

	@Test
	public void testDate2() {
		Competition p = new Competition("", "adresse");
		assertEquals("", p.getDate());
	}

	@Test
	public void testDate3() {
		Competition p = new Competition(null, "adresse");
		assertEquals(null, p.getDate());
	}

	@Test
	public void testAdresse1() {
		Competition p = new Competition("date", "adresse");
		assertEquals("adresse", p.getAdresse());
	}

	@Test
	public void testAdresse2() {
		Competition p = new Competition("date", "");
		assertEquals("", p.getAdresse());
	}

	@Test
	public void testAdresse3() {
		Competition p = new Competition("date", null);
		assertEquals(null, p.getAdresse());
	}

}
