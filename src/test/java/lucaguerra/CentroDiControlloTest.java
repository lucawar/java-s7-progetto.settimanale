package lucaguerra;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lucaguerra.entities.CentroDiControllo;
import lucaguerra.entities.Sonda;

@SpringBootTest
public class CentroDiControlloTest {

	private CentroDiControllo centroDiControllo;

	@BeforeEach
	public void setUp() {
		centroDiControllo = new CentroDiControllo(1L);
	}

	@Test
	public void testRegistraSonda1() {
		Sonda sonda = new Sonda(1L, "-27289", "27283", 0, "30C°");
		centroDiControllo.registra(sonda);
		assertEquals(1, centroDiControllo.getListaSonde().size());
	}

	@Test
	public void testOsservaNotificheSonda1() {
		Sonda sonda = new Sonda(1L, "-27289", "27283", 0, "30C°");
		centroDiControllo.registra(sonda);

		centroDiControllo.osservaNotifiche();

		for (Sonda s : centroDiControllo.getListaSonde()) {
			assertEquals(0, s.getLivelloFumo());
		}
	}

	@Test
	public void testOsservaNotificheSonda2() {
		Sonda sonda = new Sonda(2L, "23445", "-66290", 9, "500C°");
		centroDiControllo.registra(sonda);

		centroDiControllo.osservaNotifiche();

		for (Sonda s : centroDiControllo.getListaSonde()) {
			assertEquals(9, s.getLivelloFumo());
		}
	}
}
