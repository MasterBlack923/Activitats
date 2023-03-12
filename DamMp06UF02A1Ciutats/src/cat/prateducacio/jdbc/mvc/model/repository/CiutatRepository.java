package cat.prateducacio.jdbc.mvc.model.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cat.prateducacio.jdbc.mvc.model.configuration.DataBaseConfiguration;
import cat.prateducacio.jdbc.mvc.model.configuration.DataBaseParameters;
import cat.prateducacio.jdbc.mvc.model.domain.Ciutat;

public class CiutatRepository {

	private CiutatRepository() {

	}

	private static CiutatRepository instance;

	public static CiutatRepository getInstance() {
		if (instance == null) {
			instance = new CiutatRepository();
		}
		return instance;
	}

	private Connection getConnection() {

		DataBaseConfiguration dataBaseConfiguration = DataBaseConfiguration.getInstance();
		DataBaseParameters dataBaseParameters = dataBaseConfiguration.getDataBaseParameters();

		Connection connection = null;

		try {
			Class.forName(dataBaseParameters.getNomDriver());
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage());
		}

		try {
			connection = DriverManager.getConnection(dataBaseParameters.getCadenaConnexio(),
					dataBaseParameters.getNomUsuari(), dataBaseParameters.getPassword());

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}

		return connection;

	}

	public Ciutat getUnaCiutat(int idCiutat) {
		Ciutat resultat = null;
		String sql = "SELECT * FROM CIUTATS WHERE PK_Ciutat_Id = " + idCiutat + " ;";

		Statement statement;
		ResultSet resultSet;
		try {
			Connection connection = this.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String nom = resultSet.getString(2);
				resultat = new Ciutat();
				resultat.setIdCiutat(id);
				resultat.setNomCiutat(nom);
				break;
			}
			if (connection != null) {
				connection.close();
			}

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}

		return resultat;
	}

	public List<Ciutat> getAllCiutats() {

		List<Ciutat> resultat = new ArrayList<Ciutat>();

		String sql = "SELECT * FROM CIUTATS;";

		Statement statement;
		ResultSet resultSet;
		try {
			Connection connection = this.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String nom = resultSet.getString(2);
				Ciutat ciutat = new Ciutat();
				ciutat.setIdCiutat(id);
				ciutat.setNomCiutat(nom);
				resultat.add(ciutat);
			}
			if (connection != null) {
				connection.close();
			}

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}

		return resultat;
	}

	public int insert(Ciutat ciutat) {
		String sql = "INSERT INTO CIUTATS (NomCiutat) VALUES('" + ciutat.getNomCiutat() + "');";
		return this.actualitzaTaula(sql);

	}

	public int update(Ciutat ciutat) {

		String sql = "UPDATE CIUTATS SET NomCiutat = '" + ciutat.getNomCiutat() + "' WHERE pk_Ciutat_Id=" + ciutat.getIdCiutat()
				+ ";";
		return this.actualitzaTaula(sql);
	}

	public int delete(int id) {

		String sql = "DELETE FROM CIUTATS WHERE pk_Ciutat_Id=" + id + ";";
		return this.actualitzaTaula(sql);
	}

	private int actualitzaTaula(String sql) {
		int filesAfectades = 0;

		Statement statement;

		try {
			Connection connection = this.getConnection();
			statement = connection.createStatement();
			filesAfectades = statement.executeUpdate(sql);

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());

		}

		return filesAfectades;
	}

}
