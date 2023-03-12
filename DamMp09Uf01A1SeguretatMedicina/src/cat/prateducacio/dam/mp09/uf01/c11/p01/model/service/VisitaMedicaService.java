package cat.prateducacio.dam.mp09.uf01.c11.p01.model.service;

import java.util.List;

import cat.prateducacio.dam.mp09.uf01.c11.p01.model.config.DataConfiguration;
import cat.prateducacio.dam.mp09.uf01.c11.p01.model.domain.VisitaMedica;
import cat.prateducacio.dam.mp09.uf01.c11.p01.model.repository.VisitaMedicaRepository;
import cat.prateducacio.dam.mp09.uf01.c11.p01.model.security.EncriptacioFactory;
import cat.prateducacio.dam.mp09.uf01.c11.p01.model.security.EnumAlgoritmeEncriptacio;
import cat.prateducacio.dam.mp09.uf01.c11.p01.model.security.IEncriptacio;

public class VisitaMedicaService {

	private VisitaMedicaService() throws Exception {

		VisitaMedicaRepository = VisitaMedicaRepository.getInstance();
		dataConfiguration = DataConfiguration.getInstance();
	}

	private static VisitaMedicaService instance;

	public static VisitaMedicaService getInstance() throws Exception {
		if (instance == null) {
			instance = new VisitaMedicaService();
		}

		return instance;

	}

	private VisitaMedicaRepository VisitaMedicaRepository;
	private DataConfiguration dataConfiguration;

	public VisitaMedica add(VisitaMedica medicina) {

		VisitaMedica VisitaMedicaRetornat = VisitaMedicaRepository.getOne(medicina.getIdVisita());

		if (VisitaMedicaRetornat != null) {
			throw new RuntimeException("La visita que està intentant afegir JA EXISTEIX. Provi amb un altre visita.");
		}

		String nou_nom = this.encriptar(medicina.getNomPacient());
		String nou_desencriptat = this.encriptar(medicina.getDiagnostic());
		medicina.setNomPacient(nou_nom);
		medicina.setDiagnostic(nou_desencriptat);

		VisitaMedicaRepository.add(medicina);
		return medicina;
	}

	public List<VisitaMedica> getAll() {

		List<VisitaMedica> VisitaMedicaList = VisitaMedicaRepository.getAll();

		for (VisitaMedica v : VisitaMedicaList) {
			String nou_nom = this.desencriptar(v.getNomPacient());
			String nou_desencriptat = this.desencriptar(v.getDiagnostic());
			v.setNomPacient(nou_nom);
			v.setDiagnostic(nou_desencriptat);
		}

		return VisitaMedicaList;
	}

	public VisitaMedica getOne(int IdVisita) {
		VisitaMedica visitaMedica = VisitaMedicaRepository.getOne(IdVisita);
		String nou_nom = this.desencriptar(visitaMedica.getNomPacient());
		String nou_desencriptat = this.desencriptar(visitaMedica.getDiagnostic());
		visitaMedica.setNomPacient(nou_nom);
		visitaMedica.setDiagnostic(nou_desencriptat);
		
		return visitaMedica;
	}

	private String encriptar(String valor) {
		String resultat = valor;

		EnumAlgoritmeEncriptacio algoritme = dataConfiguration.getAlgoritmeSeguretat();
		EncriptacioFactory encriptacioFactory = EncriptacioFactory.getInstance();

		IEncriptacio iencriptacio = encriptacioFactory.getAlgoritme(algoritme);

		if (iencriptacio != null) {
			resultat = iencriptacio.encripta(valor);
		}

		return resultat;
	}

	private String desencriptar(String valor) {
		String resultat = valor;

		EnumAlgoritmeEncriptacio algoritme = dataConfiguration.getAlgoritmeSeguretat();
		EncriptacioFactory encriptacioFactory = EncriptacioFactory.getInstance();

		IEncriptacio iencriptacio = encriptacioFactory.getAlgoritme(algoritme);

		if (iencriptacio != null) {
			resultat = iencriptacio.desencripta(valor);
		}

		return resultat;
	}

}
