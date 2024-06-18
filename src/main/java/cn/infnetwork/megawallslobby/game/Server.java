package cn.infnetwork.megawallslobby.game;
/*
 * @Author huanmeng_qwq
 * @Date 2020/8/22 20:08
 * MegaWallsLobby
 */

public class Server {
    String name;
    String mapName;
    int online;

    public Server() {
    }

    public String getName() {
        return name;
    }

    public Server setName(String name) {
        this.name = name;
        return this;
    }

    public String getMapName() {
        return mapName;
    }

    public Server setMapName(String mapName) {
        this.mapName = mapName;
        return this;
    }

    public int getOnline() {
        return online;
    }

    public Server setOnline(int online) {
        this.online = online;
        return this;
    }
}
