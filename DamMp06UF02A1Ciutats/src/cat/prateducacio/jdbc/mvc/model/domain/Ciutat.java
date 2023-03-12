package cat.prateducacio.jdbc.mvc.model.domain;

public class Ciutat {

	private int IdCiutat;
	private String nomCiutat;

	public int getIdCiutat() {
		return IdCiutat;
	}

	public void setIdCiutat(int idCiutat) {
		IdCiutat = idCiutat;
	}

	public String getNomCiutat() {
		return nomCiutat;
	}

	public void setNomCiutat(String nomCiutat) {
		this.nomCiutat = nomCiutat;
	}

	@Override
	public String toString() {
		return "PAÍS: [ID_ciutat=" + IdCiutat + ", NOM_Ciutat=" + nomCiutat + "]";
	}

}
