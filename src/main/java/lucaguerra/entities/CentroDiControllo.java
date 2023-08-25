package lucaguerra.entities;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lucaguerra.interfaces.Observer;
import lucaguerra.interfaces.Subject;

@Data
public class CentroDiControllo implements Subject {

	private Long id;

	private List<Sonda> listaSonde = new ArrayList<>();

	public CentroDiControllo(Long id) {
		this.id = id;
	}

	@Override
	public void registra(Observer o) {
		listaSonde.add((Sonda) o);

	}

	@Override
	public void osservaNotifiche() {
		System.out.println();
		System.out.println("OSSERVAZIONE NOTIFICHE DEL CENTRO DI CONTROLLO N°:" + id);
		System.out.println();
		for (Sonda s : listaSonde) {
			s.controlloLivelloFumo();
		}
	}

}
