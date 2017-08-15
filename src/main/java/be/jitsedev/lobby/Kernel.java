package be.jitsedev.lobby;

import be.jitsedev.lobby.mysql.MySQL;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Kernel extends JavaPlugin {

    private static Kernel instance;

    public void onEnabel(){

        instance = this;

        Bukkit.getPluginManager().registerEvents(new be.jitsedev.lobby.server.ServerListener(),this);

        if(!MySQL.getInstance().isConnected()){

            MySQL.getInstance().MainDBConnect();

        }

    }

    public void registerListener(Listener l){

        Bukkit.getPluginManager().registerEvents(l,this);

    }

    public static Kernel getInstance(){

        return instance;

    }

    public void onDisable(){

        MySQL.getInstance().MainDBDisconnect();

    }

}
