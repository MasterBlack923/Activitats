package cat.prateducacio.dam.mp09.uf01.c11.p01.view.console;

import java.time.LocalDate;
import java.util.Scanner;

import cat.prateducacio.dam.mp09.uf01.c11.p01.model.domain.VisitaMedica;

public class VisitaMedicaView {

	private VisitaMedicaView() {

	}

	private static VisitaMedicaView instance;

	public static VisitaMedicaView getInstance() {
		if (instance == null) {
			instance = new VisitaMedicaView();
		}

		return instance;

	}
	
	public int inici() {
		int i = 0;
		
		System.out.println("Opcions: Vols afegir o modificar una visita mèdica?");
		System.out.println(" 1 - Sí \n 2 - No ");
		Scanner s = new Scanner (System.in);
		i = s.nextInt();
		
		return i;
	}
	
	public VisitaMedica demanaVisitaMedica()
	{
		int IdVisita = demanaIdVisita();
		String nomPacient = this.getDadaString("Nom pacient:");
		String nomMetge = this.getDadaString("Nom metge:");
		String diagnostic = this.getDadaString("Patologia o diagnòstic:");
		int dia = this.getDadaInt("Dia de la consulta:");
		int mes = this.getDadaInt("Mes de la consulta:");
		int any = this.getDadaInt("Any de la consulta:");
			
		LocalDate ld = LocalDate.of(dia, mes, any);
		
		VisitaMedica result = new VisitaMedica(IdVisita, nomPacient, nomMetge, ld, diagnostic);
		return result;
	}
	
	public int demanaIdVisita()
	{
		int ID_Visita = this.getDadaInt("ID de la visita que vol sol·licitar:");
		return ID_Visita;
	}

	private String getDadaString(String instruccions) {
		String dada = null;
		System.out.println(instruccions);

		Scanner scanner = new Scanner(System.in);
		dada = scanner.nextLine();
		return dada;

	}
	
	private int getDadaInt(String instruccions) {
		int dada = 0;
		System.out.println(instruccions);

		Scanner scanner = new Scanner(System.in);
		dada = scanner.nextInt();
		return dada;

	}

	public void mostrarDada(String dada, boolean esError) {
		if (esError) {
			System.err.println(dada);
		} else {
			System.out.println(dada);

		}
	}
	

}
