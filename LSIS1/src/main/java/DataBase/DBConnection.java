/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author joaoferreira
 */
public class DBConnection {

//    static final String URL = "jdbc:mysql://localhost:3306/2022sinf1_003";
    static final String URL ="jdbc:mysql://ctesp.dei.isep.ipp.pt:3306/2022sinf1_003";

    static final String USER = "2022sinf1_003";
    static final String PASS = "Fw46266oGF.";

    public static Connection getConnection() {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Connection to " + conn.getCatalog() + " succeded!");
            return conn;
        } catch (SQLException exc) {
            throw new RuntimeException("Error connecting!", exc);
        }
    }

}
