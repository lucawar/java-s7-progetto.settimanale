package lucaguerra.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lucaguerra.interfaces.Observer;

@AllArgsConstructor
@Data
public class Sonda implements Observer {

	private Long id;
	private String latitudine;
	private String longitudine;
	private int livelloFumo;
	private String temperatura;

	@Override
	public void controlloLivelloFumo() {
		if (this.livelloFumo >= 5) {
			String notificaUrl = generaUrlNotifica();
			System.out.println("ALLARME!!! La sonda n. " + id + " ha registrato un livello di fumo di " + livelloFumo
					+ "una temperatura di " + temperatura + ", latitudine: " + latitudine + " longitudine: "
					+ longitudine);

			System.out.println("URL di notifica per il personale: " + notificaUrl);
		} else {
			System.out.println();
			System.out.println("La sonda n. " + id + " non ha registrato problemi di livello di fumo.");
			System.out.println();
		}

	}

	public String generaUrlNotifica() {
		return "http://host/alarm?idsonda=" + id + "&lat=" + latitudine + "&lon=" + longitudine + "&smokelevel="
				+ livelloFumo + "&temp=" + temperatura;
	}

}
