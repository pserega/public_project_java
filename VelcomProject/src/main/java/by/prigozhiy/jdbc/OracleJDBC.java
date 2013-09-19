package by.prigozhiy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleJDBC {

	public static void main(String[] argv) {

		System.out.println("-------- H2 Connection Testing ------");

		try {

			Class.forName("org.h2.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your H2 Driver?");
			e.printStackTrace();
			return;

		}

		System.out.println("H2 Driver Registered!");

		Connection connection = null;

		try {

			connection = DriverManager.getConnection(
					"jdbc:h2:tcp://localhost/~/test", "sa", "sa");

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;

		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
	}

}
