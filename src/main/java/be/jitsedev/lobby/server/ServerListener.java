package be.jitsedev.lobby.server;

import be.jitsedev.lobby.mysql.MySQL;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;

public class ServerListener implements Listener{

    @EventHandler
    public void onLogin(PlayerLoginEvent e){

        Player p = e.getPlayer();

        if(!MySQL.getInstance().isConnected()){

            p.kickPlayer(ChatColor.RED + "Whoops, something went wrong with de database!");

        }

        if(p.getName().contains("&")){

            p.kickPlayer("Whoops, Your username is invalid!");

        }

    }

}
