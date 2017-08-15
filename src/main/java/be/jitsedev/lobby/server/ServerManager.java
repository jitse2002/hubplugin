package be.jitsedev.lobby.server;

import be.jitsedev.lobby.Kernel;

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

}
