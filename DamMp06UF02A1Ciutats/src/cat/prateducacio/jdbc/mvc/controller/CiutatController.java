package cat.prateducacio.jdbc.mvc.controller;

import java.util.List;

import cat.prateducacio.jdbc.mvc.model.domain.Ciutat;
import cat.prateducacio.jdbc.mvc.model.service.CiutatService;
import cat.prateducacio.jdbc.mvc.view.console.CiutatView;

public class CiutatController {

	private CiutatController() {

	}

	private static CiutatController instance;

	public static CiutatController getInstance() {
		if (instance == null) {
			instance = new CiutatController();
		}
		return instance;
	}

	public void addCiutat() {
		try {
			Ciutat ciutat = CiutatView.getInstance().getCiutatAdd();
			int filesAfectades = CiutatService.getInstance().insert(ciutat);
			CiutatView.getInstance().mostrar("Les files afectades són: " + filesAfectades, false);
		} catch (Exception e) {
			CiutatView.getInstance().mostrar(e.getMessage(), true);
		}
	}

	public void updateCiutat() {
		try {
			Ciutat ciutat = CiutatView.getInstance().getCiutatUpdate();
			int filesAfectades = CiutatService.getInstance().update(ciutat);
			CiutatView.getInstance().mostrar("Les files afectades són: " + filesAfectades, false);
		} catch (Exception e) {
			CiutatView.getInstance().mostrar(e.getMessage(), true);
		}
	}

	public void deleteCiutat() {
		try {
			int id = CiutatView.getInstance().getIdCiutatEliminar();
			int filesAfectades = CiutatService.getInstance().delete(id);
			CiutatView.getInstance().mostrar("Les files afectades són: " + filesAfectades, false);
		} catch (Exception e) {
			CiutatView.getInstance().mostrar(e.getMessage(), true);
		}
	}

	public void getOneCiutat() {
		try {
			int id = CiutatView.getInstance().getIdCiutatSeleccionar();
			Ciutat ciutat = CiutatService.getInstance().getUnaCiutat(id);
			if (ciutat != null) {
				CiutatView.getInstance().mostrar(ciutat.toString(), false);
			} else {
				CiutatView.getInstance().mostrar("El pais que has sol·licitat, NO existeix" , false);
			}
		} catch (Exception e) {
			CiutatView.getInstance().mostrar(e.getMessage(), true);
		}
	}

	public void getTotesLesCiutats() {

		try {
			List<Ciutat> ciutats = CiutatService.getInstance().getAllCiutats();
			if (ciutats != null) {
				CiutatView.getInstance().mostrar(ciutats.toString(), false);
			}
			else {
				CiutatView.getInstance().mostrar("NO existeix cap ciutat actualment a la base de dades!!", false);
			}
		}
		catch (Exception e) {
			CiutatView.getInstance().mostrar(e.getMessage(), true);
		}
	}
}
