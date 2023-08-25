package lucaguerra.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Sonda {

	private Long id;
	private String latitudine;
	private String longitudine;
	private Integer livelloFumo;
	private CentroDiControllo centroControllo;

	public Sonda(Long id, String latitudine, String longitudine, Integer livelloFumo) {

		this.id = id;
		this.latitudine = latitudine;
		this.longitudine = longitudine;
		this.livelloFumo = livelloFumo;
	}
}
