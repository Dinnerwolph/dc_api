package fr.definity.api.database.tables;

import fr.definity.api.database.ConnectionDriver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServersInfo {

    private static Connection connection = ConnectionDriver.getConnection();

    public static Integer getCount(String serverName) {
        int count = 0;
        try {
            ConnectionDriver.reconnect();
            connection = ConnectionDriver.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) FROM `users` WHERE `SERVER` LIKE ?");
            statement.setString(1, "%" + serverName + "%");
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            count = resultSet.getInt("COUNT(*)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
