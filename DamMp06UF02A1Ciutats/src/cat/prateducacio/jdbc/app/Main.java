package cat.prateducacio.jdbc.app;

import cat.prateducacio.jdbc.mvc.controller.CiutatController;

public class Main {

	public static void main(String[] args) {
		
		CiutatController.getInstance().addCiutat();
		CiutatController.getInstance().updateCiutat();
		CiutatController.getInstance().deleteCiutat();
		CiutatController.getInstance().getOneCiutat();
		CiutatController.getInstance().getTotesLesCiutats();
	

	}

}
