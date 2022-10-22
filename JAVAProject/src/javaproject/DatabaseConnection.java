/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class DatabaseConnection {

	private static final String dburl = "jdbc:postgresql://localhost:5432/javaprojects?user=postgres&password=8950";

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			try (Connection conn = DriverManager.getConnection(dburl)) {
				System.out.println("Success");
				conn.close();
			}
		} catch (SQLException ex) {
			Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
