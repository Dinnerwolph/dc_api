package fr.definity.api.database.tables;

import fr.definity.api.API;
import fr.definity.api.database.ConnectionDriver;
import fr.definity.api.groups.Groups;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Dinnerwolph
 */
public class Group {

    private Connection connection = ConnectionDriver.getConnection();

    public void getAllGroups() {
        ConnectionDriver.reconnect();
        connection = ConnectionDriver.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM `Group` WHERE 1");
            ResultSet resultSet = statement.executeQuery();
            int i = 999;
            while (resultSet.next()) {
                Groups groups = new Groups(resultSet.getInt("GroupId"), resultSet.getString("Prefix"), resultSet.getString("Suffix"), i--);
                API.getInstance().addGroups(groups);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
