package lucaguerra;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lucaguerra.entities.Sonda;

public class SondaTest {

	private Sonda sonda;

	@BeforeEach
	public void setUp() {
		sonda = new Sonda(1L, "-27289", "27283", 0, "30C°");
	}

	@Test
	public void testControlloLivelloFumoAllarme() {
		sonda.setLivelloFumo(6);
		sonda.controlloLivelloFumo();
		assertTrue(sonda.getLivelloFumo() >= 5);
	}

	@Test
	public void testControlloLivelloFumoNeiLimiti() {
		sonda.setLivelloFumo(3);
		sonda.controlloLivelloFumo();
		assertFalse(sonda.getLivelloFumo() >= 5);
	}

	@Test
	public void testGeneraUrlNotifica() {
		sonda.setLivelloFumo(3);
		String url = "http://host/alarm?idsonda=1&lat=-27289&lon=27283&smokelevel=3&temp=30C°";
		String generaUrl = sonda.generaUrlNotifica();
		assertEquals(url, generaUrl);
	}

}
