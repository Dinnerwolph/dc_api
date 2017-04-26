package fr.definity.api.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Dinnerwolph
 */

public class ConnectionDriver {
    private static Connection connection;

    public static Connection getConnection() {
        return connection;
    }

    public static void openConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://dev.liittlecookie.fr:3306/wlszgo_serveur", "wlszgo_serveur", "ngdojfdbosdbfomvimildfbvrtimsgbmilrtdhfg");
            //connection = DriverManager.getConnection("jdbc:mysql://dinnerwolph.ddns.net:3306/DefinityCraft", "root", "kokopops");
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public static boolean isConnected() {
        try {
            if ((connection == null) || (connection.isClosed())) {
                return false;
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void reconnect() {
        if(!isConnected()) {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://dev.liittlecookie.fr:3306/wlszgo_serveur", "wlszgo_serveur", "ngdojfdbosdbfomvimildfbvrtimsgbmilrtdhfg");
                //connection = DriverManager.getConnection("jdbc:mysql://dinnerwolph.ddns.net:3306/DefinityCraft", "root", "kokopops");
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
    }
}
