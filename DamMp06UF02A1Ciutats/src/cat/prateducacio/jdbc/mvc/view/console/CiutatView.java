package cat.prateducacio.jdbc.mvc.view.console;

import java.util.Scanner;

import cat.prateducacio.jdbc.mvc.model.domain.Ciutat;

public class CiutatView {

	private CiutatView() {

	}

	private static CiutatView instance;

	public static CiutatView getInstance() {
		if (instance == null) {
			instance = new CiutatView();
		}
		return instance;
	}

	public Ciutat getCiutatAdd() {
		Ciutat ciutat = null;

		Scanner scanner = new Scanner(System.in);

		System.out.println("Introdueix el nom de la ciutat: ");
		String nom = scanner.next();

		scanner.close();

		ciutat = new Ciutat();
		ciutat.setIdCiutat(0);
		ciutat.setNomCiutat(nom);

		return ciutat;

	}

	public Ciutat getCiutatUpdate() {
		Ciutat ciutat = null;

		Scanner scanner = new Scanner(System.in);

		System.out.println("Introdueix l'ID de la ciutat que vols modificar: ");
		int id = scanner.nextInt();

		System.out.println("Introdueix el nou nom de la ciutat: ");
		String nom = scanner.next();

		scanner.close();

		ciutat = new Ciutat();
		ciutat.setIdCiutat(id);
		ciutat.setNomCiutat(nom);

		return ciutat;

	}

	public int getIdCiutatEliminar() {

		return this.getIdCiutat("Introdueix el nom de la ciutat que vols eliminar: ");

	}

	public int getIdCiutatSeleccionar() {

		return this.getIdCiutat("Introdueix el nom de la ciutat que vols seleccionar: ");

	}

	private int getIdCiutat(String missatge) {
		Scanner scanner = new Scanner(System.in);

		System.out.println(missatge);
		int id = scanner.nextInt();
		scanner.close();

		return id;
	}

	public void mostrar(String missatge, boolean error) {
		if (error) {
			System.err.println(missatge);
		} else {
			System.out.println(missatge);
		}
	}

}
