package lucaguerra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lucaguerra.entities.CentroDiControllo;
import lucaguerra.entities.Sonda;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		Sonda s1 = new Sonda(1L, "-27289", "27283", 0, "30C°");
		Sonda s2 = new Sonda(2L, "23445", "-66290", 9, "500C°");
		Sonda s3 = new Sonda(3L, "-99989", "00789", 6, "300C°");
		Sonda s4 = new Sonda(4L, "98743", "-23458", 3, "150C°");

		CentroDiControllo cc1 = new CentroDiControllo(334543L);
		cc1.registra(s1);
		cc1.registra(s2);

		CentroDiControllo cc2 = new CentroDiControllo(229383L);
		cc2.registra(s3);
		cc2.registra(s4);

		cc1.osservaNotifiche();
		cc2.osservaNotifiche();
	}
}
