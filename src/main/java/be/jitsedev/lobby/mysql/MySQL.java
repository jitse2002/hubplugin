package be.jitsedev.lobby.mysql;

import org.bukkit.Bukkit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQL {

    private static MySQL instance = null;
    private String host = "localhost";
    private String username = "root";
    private String password = "";
    private String database = "minegamen_server";
    private int port = 3306;
    private Connection conn;

    public static MySQL getInstance(){

        if(instance == null){

            instance = new MySQL();

        }

        return instance;

    }

    public void MainDBConnect(){

        if(!isConnected()){

            try {
                conn = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database,username,password);
                Bukkit.getServer().getConsoleSender().sendMessage("Mysql connected!");

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }

    public void MainDBDisconnect(){

        if(isConnected()){

            try {
                conn.close();

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }

    public Boolean isConnected(){

        return conn != null;

    }

    public static void createTable(){}

    public void update(String qry){

        try {
            conn.createStatement().executeUpdate(qry);
            Bukkit.getServer().getConsoleSender().sendMessage("MySQL: " + qry);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public ResultSet getResult(String qry){

        if(isConnected()){

            try {
                return conn.createStatement().executeQuery(qry);

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


        }

        return null;

    }

}
