package lucaguerra.entities;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CentroDiControllo {

	private Long id;

	private List<Sonda> listaSonde = new ArrayList<>();

	public CentroDiControllo(Long id) {
		this.id = id;
	}
}
