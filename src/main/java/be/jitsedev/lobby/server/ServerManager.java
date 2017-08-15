package be.jitsedev.lobby.server;

import be.jitsedev.lobby.Kernel;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.entity.Player;

public class ServerManager {

    private static ServerManager instance = null;
    private boolean debug;

    public static ServerManager getInstance(){

        if(instance == null){

            instance = new ServerManager();

        }

        return instance;

    }

    public boolean isDebugMode(){

        return this.debug;

    }

    public void setDebugMode(){

        if(this.isDebugMode()){

            this.debug = false;

            return;

        }

            this.debug = true;

    }

    public void connectPlayerToServer(Player player, String servername){

        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("connect");
        out.writeUTF(servername);

    }

}
