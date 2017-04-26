package fr.definity.api.database.tables;

import fr.definity.api.database.ConnectionDriver;
import fr.definity.api.database.ServerTypes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Dinnerwolph
 */

public class PlayerStats {

    private Connection connection = ConnectionDriver.getConnection();
    private String sql = "SELECT * FROM `%table%` WHERE DefinityId=?";
    private String setsql = "UPDATE `%table%` SET `%colonne%`=? WHERE `DefinityId`=?";

    public Integer getStatsWins(int definityID, ServerTypes serverTypes) {
        ConnectionDriver.reconnect();
        connection = ConnectionDriver.getConnection();
        int i = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(sql.replace("%table%", serverTypes.getName()));
            statement.setInt(1, definityID);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            i = resultSet.getInt("Wins");
            statement.close();
            resultSet.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return i;
    }

    public void setStatsWins(int definityID, ServerTypes serverTypes, int values) {
        ConnectionDriver.reconnect();
        connection = ConnectionDriver.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(setsql.replace("%table%", serverTypes.getName()).replace("%colonne%", "Wins"));
            statement.setInt(1, values);
            statement.setInt(2, definityID);
            statement.executeUpdate();
            statement.close();
        }catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public Integer getStatsDeaths(int definityID, ServerTypes serverTypes) {
        ConnectionDriver.reconnect();
        connection = ConnectionDriver.getConnection();
        int i = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(sql.replace("%table%", serverTypes.getName()));
            statement.setInt(1, definityID);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            i = resultSet.getInt("Deaths");
            statement.close();
            resultSet.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return i;
    }

    public void setStatsDeaths(int definityID, ServerTypes serverTypes, int values) {
        ConnectionDriver.reconnect();
        connection = ConnectionDriver.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(setsql.replace("%table%", serverTypes.getName()).replace("%colonne%", "Deaths"));
            statement.setInt(1, values);
            statement.setInt(2, definityID);
            statement.executeUpdate();
            statement.close();
        }catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public Integer getStatsLoses(int definityID, ServerTypes serverTypes) {
        ConnectionDriver.reconnect();
        connection = ConnectionDriver.getConnection();
        int i = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(sql.replace("%table%", serverTypes.getName()));
            statement.setInt(1, definityID);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            i = resultSet.getInt("Loses");
            statement.close();
            resultSet.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return i;
    }

    public void setStatsLoses(int definityID, ServerTypes serverTypes, int values) {
        ConnectionDriver.reconnect();
        connection = ConnectionDriver.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(setsql.replace("%table%", serverTypes.getName()).replace("%colonne%", "Loses"));
            statement.setInt(1, values);
            statement.setInt(2, definityID);
            statement.executeUpdate();
            statement.close();
        }catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public Integer getStatsKill(int definityID, ServerTypes serverTypes) {
        ConnectionDriver.reconnect();
        connection = ConnectionDriver.getConnection();
        int i = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(sql.replace("%table%", serverTypes.getName()));
            statement.setInt(1, definityID);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            i = resultSet.getInt("Kills");
            statement.close();
            resultSet.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return i;
    }

    public void setStatsKill(int definityID, ServerTypes serverTypes, int values) {
        ConnectionDriver.reconnect();
        connection = ConnectionDriver.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(setsql.replace("%table%", serverTypes.getName()).replace("%colonne%", "Kills"));
            statement.setInt(1, values);
            statement.setInt(2, definityID);
            statement.executeUpdate();
            statement.close();
        }catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public Integer getStatsGames(int definityID, ServerTypes serverTypes) {
        ConnectionDriver.reconnect();
        connection = ConnectionDriver.getConnection();
        int i = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(sql.replace("%table%", serverTypes.getName()));
            statement.setInt(1, definityID);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            i = resultSet.getInt("Games");
            statement.close();
            resultSet.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return i;
    }

    public void setStatsGames(int definityID, ServerTypes serverTypes, int values) {
        ConnectionDriver.reconnect();
        connection = ConnectionDriver.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(setsql.replace("%table%", serverTypes.getName()).replace("%colonne%", "Games"));
            statement.setInt(1, values);
            statement.setInt(2, definityID);
            statement.executeUpdate();
            statement.close();
        }catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * special states
     */

    // The Blocks
    public Integer getTheBlockBlocks(int definityID) {
        ConnectionDriver.reconnect();
        connection = ConnectionDriver.getConnection();
        int i = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(sql.replace("%table%", "TheBlock"));
            statement.setInt(1, definityID);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            i = resultSet.getInt("Blocks");
            statement.close();
            resultSet.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return i;
    }

    public void setTheBlockBlocks(int definityID, int values) {
        ConnectionDriver.reconnect();
        connection = ConnectionDriver.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(setsql.replace("%table%", "TheBlock").replace("%colonne%", "Blocks"));
            statement.setInt(1, values);
            statement.setInt(2, definityID);
            statement.executeUpdate();
            statement.close();
        }catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public Integer getTheBlockFinalsKills(int definityID) {
        ConnectionDriver.reconnect();
        connection = ConnectionDriver.getConnection();
        int i = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(sql.replace("%table%", "TheBlock"));
            statement.setInt(1, definityID);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            i = resultSet.getInt("FinalsKills");
            statement.close();
            resultSet.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return i;
    }

    public void setTheBlockFinalsKills(int definityID, int values) {
        ConnectionDriver.reconnect();
        connection = ConnectionDriver.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(setsql.replace("%table%", "TheBlock").replace("%colonne%", "FinalsKills"));
            statement.setInt(1, values);
            statement.setInt(2, definityID);
            statement.executeUpdate();
            statement.close();
        }catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    //Fishing wars
    public Integer getFishingWarsBigFish(int definityID) {
        ConnectionDriver.reconnect();
        connection = ConnectionDriver.getConnection();
        int i = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(sql.replace("%table%", "FishingWars"));
            statement.setInt(1, definityID);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            i = resultSet.getInt("BigFish");
            statement.close();
            resultSet.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return i;
    }

    public void setFishingWarsBigFish(int definityID, int values) {
        ConnectionDriver.reconnect();
        connection = ConnectionDriver.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(setsql.replace("%table%", "FishingWars").replace("%colonne%", "BigFish"));
            statement.setInt(1, values);
            statement.setInt(2, definityID);
            statement.executeUpdate();
            statement.close();
        }catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public Integer getFishingWarsSmallFish(int definityID) {
        ConnectionDriver.reconnect();
        connection = ConnectionDriver.getConnection();
        int i = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(sql.replace("%table%", "FishingWars"));
            statement.setInt(1, definityID);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            i = resultSet.getInt("SmallFish");
            statement.close();
            resultSet.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return i;
    }

    public void setFishingWarsSmallFish(int definityID, int values) {
        ConnectionDriver.reconnect();
        connection = ConnectionDriver.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(setsql.replace("%table%", "FishingWars").replace("%colonne%", "SmallFish"));
            statement.setInt(1, values);
            statement.setInt(2, definityID);
            statement.executeUpdate();
            statement.close();
        }catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    // Bombe Arming
    public Integer getBombeArmingBombArmed(int definityID) {
        ConnectionDriver.reconnect();
        connection = ConnectionDriver.getConnection();
        int i = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(sql.replace("%table%", "BombArming"));
            statement.setInt(1, definityID);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            i = resultSet.getInt("BombArmed");
            statement.close();
            resultSet.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return i;
    }

    public void setBombArmingBombArmed(int definityID, int values) {
        ConnectionDriver.reconnect();
        connection = ConnectionDriver.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(setsql.replace("%table%", "BombArming").replace("%colonne%", "BombArmed"));
            statement.setInt(1, values);
            statement.setInt(2, definityID);
            statement.executeUpdate();
            statement.close();
        }catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public Integer getBombeArmingBombDefused(int definityID) {
        ConnectionDriver.reconnect();
        connection = ConnectionDriver.getConnection();
        int i = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(sql.replace("%table%", "BombArming"));
            statement.setInt(1, definityID);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            i = resultSet.getInt("BombDefused");
            statement.close();
            resultSet.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return i;
    }

    public void setBombArmingBombDefused(int definityID, int values) {
        ConnectionDriver.reconnect();
        connection = ConnectionDriver.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(setsql.replace("%table%", "BombArming").replace("%colonne%", "BombDefused"));
            statement.setInt(1, values);
            statement.setInt(2, definityID);
            statement.executeUpdate();
            statement.close();
        }catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public Integer getBombeArmingBombEquipeElimine(int definityID) {
        ConnectionDriver.reconnect();
        connection = ConnectionDriver.getConnection();
        int i = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(sql.replace("%table%", "BombArming"));
            statement.setInt(1, definityID);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            i = resultSet.getInt("EquipeElimine");
            statement.close();
            resultSet.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return i;
    }

    public void setBombArmingEquipeElimine(int definityID, int values) {
        ConnectionDriver.reconnect();
        connection = ConnectionDriver.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(setsql.replace("%table%", "BombArming").replace("%colonne%", "EquipeElimine"));
            statement.setInt(1, values);
            statement.setInt(2, definityID);
            statement.executeUpdate();
            statement.close();
        }catch (SQLException exception) {
            exception.printStackTrace();
        }
    }


}
