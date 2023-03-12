package cat.prateducacio.jdbc.mvc.model.configuration;

public class DataBaseParameters {

	private String cadenaConnexio;
	private String nomDriver;
	private String nomUsuari;
	private String password;
	private String versio;

	public String getCadenaConnexio() {
		return cadenaConnexio;
	}

	public void setCadenaConnexio(String cadenaConnexio) {
		this.cadenaConnexio = cadenaConnexio;
	}

	public String getNomDriver() {
		return nomDriver;
	}

	public void setNomDriver(String nomDriver) {
		this.nomDriver = nomDriver;
	}

	public String getNomUsuari() {
		return nomUsuari;
	}

	public void setNomUsuari(String nomUsuari) {
		this.nomUsuari = nomUsuari;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVersio() {
		return versio;
	}

	public void setVersio(String versio) {
		this.versio = versio;
	}

}
