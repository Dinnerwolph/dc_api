package fr.definity.api.database.tables;

import fr.definity.api.database.ConnectionDriver;
import org.bukkit.entity.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Dinnerwolph
 */

public class PlayerInfo {

    private Connection connection = ConnectionDriver.getConnection();

    public boolean contains(UUID uuid) {
        ConnectionDriver.reconnect();
        connection = ConnectionDriver.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM `Players` WHERE UUID=?;");
            statement.setString(1, uuid.toString());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                statement.close();
                resultSet.close();
                return true;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    public void create(Player player) {
        ConnectionDriver.reconnect();
        connection = ConnectionDriver.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO `Players`(`UUID`, `PlayerName`, `Group`) VALUES (?,?,?)");
            statement.setString(1, player.getUniqueId().toString());
            statement.setString(2, player.getName());
            statement.setString(3, "0");
            statement.executeUpdate();
            statement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    //NOUVELLE BDD D'UN GENIE

    public Integer getDefinityId(UUID uuid) {
        int i = 0;
        ConnectionDriver.reconnect();
        connection = ConnectionDriver.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT `DefinityId` FROM `Players` WHERE `UUID`=?");
            statement.setString(1, uuid.toString());
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            i = resultSet.getInt("DefinityId");
            resultSet.close();
            statement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return i;
    }

    public Integer getGroupId(int definityId) {
        int i = 0;
        ConnectionDriver.reconnect();
        connection = ConnectionDriver.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT `Group` FROM `Players` WHERE `DefinityId`=?");
            statement.setInt(1, definityId);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            i = resultSet.getInt("Group");
            resultSet.close();
            statement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return i;
    }

    public void setGroupId(int definityId, int groupId) {
        ConnectionDriver.reconnect();
        connection = ConnectionDriver.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE `Players` SET `Group`=? WHERE `DefinityId`=?");
            statement.setInt(1, groupId);
            statement.setInt(2, definityId);
            statement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public String getNickName(int definityId) {
        String string = null;
        ConnectionDriver.reconnect();
        connection = ConnectionDriver.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT `NickName` FROM `Players` WHERE `DefinityId`=?");
            statement.setInt(1, definityId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                string = resultSet.getString("NickName");
                System.out.println(string);
            }
            resultSet.close();
            statement.close();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        System.err.println(string);
        return string;
    }

    public void setNickName(int definityId, String nickName) {
        ConnectionDriver.reconnect();
        connection = ConnectionDriver.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE `Players` SET `NickName`=? WHERE `DefinityId`=?");
            statement.setString(1, nickName);
            statement.setInt(2, definityId);
            statement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public Integer getXp(int definityId) {
        ConnectionDriver.reconnect();
        connection = ConnectionDriver.getConnection();
        int i = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM `Shop` WHERE `DefinityId`=?");
            statement.setInt(1, definityId);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            i = resultSet.getInt("Xp");
            statement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return i;
    }

    public Integer getOrs(int definityId) {
        ConnectionDriver.reconnect();
        connection = ConnectionDriver.getConnection();
        int i = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM `Shop` WHERE `DefinityId`=?");
            statement.setInt(1, definityId);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            i = resultSet.getInt("Or");
            statement.close();
            resultSet.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return i;
    }

    public Integer getCoins(int definityId) {
        ConnectionDriver.reconnect();
        connection = ConnectionDriver.getConnection();
        int i = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM `Shop` WHERE `DefinityId`=?");
            statement.setInt(1, definityId);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            i = resultSet.getInt("Coins");
            statement.close();
            resultSet.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return i;
    }

    //ANCIENNE BDD DE MERDE

    public void setCoins(int definityId, int amount) {
        ConnectionDriver.reconnect();
        connection = ConnectionDriver.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE `Shop` SET `Coins`=? WHERE `DefinityId`= ?");
            statement.setInt(1, amount);
            statement.setInt(2, definityId);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }


    public void setOrs(int definityId, int amount) {
        ConnectionDriver.reconnect();
        connection = ConnectionDriver.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE `Shop` SET `Or`=? WHERE `DefinityId`= ?");
            statement.setInt(1, amount);
            statement.setInt(2, definityId);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }


    public void setXp(int definityId, int amount) {
        ConnectionDriver.reconnect();
        connection = ConnectionDriver.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE `Shop` SET `Xp`=? WHERE `DefinityId`= ?");
            statement.setInt(1, amount);
            statement.setInt(2, definityId);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void setPseudo(int definityId, String pseudo) {
        ConnectionDriver.reconnect();
        connection = ConnectionDriver.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE `Players` SET ``PlayerName`=? WHERE `DefinityId`=?");
            statement.setString(1, pseudo);
            statement.setInt(2, definityId);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public String getPseudo(UUID uuid) {
        String string = "";
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM `Players` WHERE UUID=?;");
            statement.setString(1, uuid.toString());
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            string = resultSet.getString("Pseudo");
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return string;
    }

    public void setAcces(UUID uuid, int amount) {
        ConnectionDriver.reconnect();
        connection = ConnectionDriver.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE `Players` SET `Acces`= ? WHERE UUID=?;");
            statement.setInt(1, amount);
            statement.setString(2, uuid.toString());
            statement.execute();
            statement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }

    public Integer getAcces(UUID uuid) {
        ConnectionDriver.reconnect();
        connection = ConnectionDriver.getConnection();
        int i = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM `Players` WHERE UUID=?;");
            statement.setString(1, uuid.toString());
            ResultSet result = statement.executeQuery();
            result.next();
            i = result.getInt("Acces");
            statement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return i;
    }

    public void setFriends(UUID uuid, String friends) {
        ConnectionDriver.reconnect();
        connection = ConnectionDriver.getConnection();
        try {
            PreparedStatement statement = ConnectionDriver.getConnection().prepareStatement("UPDATE `Players` SET `Friends`= ? WHERE UUID=?;");
            statement.setString(1, friends);
            statement.setString(2, uuid.toString());
            statement.execute();
            statement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }

    public String getFriendsString(UUID uuid) {
        ConnectionDriver.reconnect();
        connection = ConnectionDriver.getConnection();
        String friend = "";
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM `Players` WHERE UUID=?;");
            statement.setString(1, uuid.toString());
            ResultSet result = statement.executeQuery();
            result.next();
            friend = result.getString("Friends");
            statement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return friend;
    }

    public ArrayList<String> getFriends(UUID uuid) {
        ConnectionDriver.reconnect();
        connection = ConnectionDriver.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM `Players` WHERE UUID=?;");
            statement.setString(1, uuid.toString());
            ArrayList friends = new ArrayList();
            ResultSet result = statement.executeQuery();
            result.next();
            String toreturn = result.getString("Friends");
            String[] var8;
            int var7 = (var8 = toreturn.split(", ")).length;

            for (int var6 = 0; var6 < var7; ++var6) {
                String s = var8[var6];
                if (s != null) {
                    friends.add(s);
                }
            }

            statement.close();
            return friends;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public void removeFriends(UUID uuid, String friendtoremove) {
        ConnectionDriver.reconnect();
        connection = ConnectionDriver.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE `Players` SET `Friends`= ? WHERE UUID=?;");
            statement.setString(1, getFriendsString(uuid).replace(friendtoremove + ", ", ""));
            statement.setString(2, uuid.toString());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

    }

    public String getUUID(String playerName) {
        ConnectionDriver.reconnect();
        connection = ConnectionDriver.getConnection();
        String string = "";
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM `Players` WHERE Pseudo=?;");
            statement.setString(1, playerName);
            ResultSet result = statement.executeQuery();
            result.next();
            string = result.getString("UUID");
            statement.close();
        } catch (SQLException var4) {
            var4.printStackTrace();
        }
        return string;
    }
}
