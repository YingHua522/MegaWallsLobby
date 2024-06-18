package cn.infnetwork.megawallslobby.stats;

import cn.infnetwork.megawallslobby.database.KeyValue;

import java.security.Key;

public class SQLSettings {
    public static final String TABLE_STATS = "megawalls_stats";
    public static final String TABLE_EFFECTS = "megawalls_effects";
    public static final String TABLE_CHALLENGES = "megawalls_challenges";
    public static final String TABLE_REJOIN = "megawalls_rejoin";
    public static final String TABLE_REWARD_PREFIX = "megawalls_reward_";
    public static final String url = "https://gitee.com/h1a/mega-walls-license/raw/master/mw";
    public static final String TABLE_SPECTATOR_SETTINGS = "spectator_settings";
    public static final String TABLE_CLASSES_PREFIX = "classes_";
    public static final String TABLE_GAME = "megawalls_game";
    public static final String TABLE_ONLINE = "megawalls_online";
    public static final String TABLE_MAPVOTE = "megawalls_mapvote";
    public static final KeyValue KV_STATS = (new KeyValue("uuid", "VARCHAR(36) PRIMARY KEY")).add("realname", "VARCHAR(20)").add("kills", "INTEGER").add("finalKills", "INTEGER").add("wins", "INTEGER").add("mvps","INTEGER").add("games", "INTEGER").add("coins", "INTEGER").add("mythicDust", "INTEGER").add("selected", "VARCHAR(40)").add("Skin", "VARCHAR(40)");
    public static final KeyValue KV_EFFECTS = (new KeyValue("uuid", "VARCHAR(36) PRIMARY KEY")).add("realname", "VARCHAR(20)").add("hologramEffect", "VARCHAR(20)").add("killMessage", "VARCHAR(20)").add("redColor", "VARCHAR(20)").add("greenColor", "VARCHAR(20)").add("blueColor", "VARCHAR(20)").add("yellowColor", "VARCHAR(20)").add("enablePrefix", "VARCHAR(5)").add("enableItalic", "VARCHAR(5)").add("enableBold", "VARCHAR(5)").add("surface", "VARCHAR(5)");
    public static final KeyValue KV_CHALLENGES = (new KeyValue("uuid", "VARCHAR(36) PRIMARY KEY")).add("realname", "VARCHAR(20)").add("challenges", "LONGTEXT").add("autoAccept", "VARCHAR(5)");
    public static final KeyValue KV_REJOIN = (new KeyValue("uuid", "VARCHAR(36) PRIMARY KEY")).add("realname", "VARCHAR(20)").add("server", "VARCHAR(30)").add("time", "BIGINT");
    public static final KeyValue KV_REWARD = (new KeyValue("uuid", "VARCHAR(36) PRIMARY KEY")).add("realname", "VARCHAR(20)").add("accept", "VARCHAR(5)").add("progress", "TEXT").add("lastFinished", "VARCHAR(10)");
    public static final KeyValue KV_SPECTATOR_SETTINGS = (new KeyValue("uuid", "VARCHAR(36) PRIMARY KEY")).add("realname", "VARCHAR(20)").add("speed", "INTEGER").add("speed", "INTEGER").add("autoTp", "INTEGER").add("nightVision", "INTEGER").add("firstPerson", "INTEGER").add("hideOther", "INTEGER").add("fly", "INTEGER");
    public static final KeyValue KV_CLASSES = (new KeyValue("uuid", "VARCHAR(36) PRIMARY KEY")).add("realname", "VARCHAR(20)").add("level", "INTEGER").add("equipLevel", "INTEGER").add("skillLevel", "INTEGER").add("skill2Level", "INTEGER").add("skill3Level", "INTEGER").add("skill4Level", "INTEGER").add("collectLevel", "INTEGER").add("wins", "INTEGER").add("mvps","INTEGER").add("games", "INTEGER").add("finalKills", "INTEGER").add("finalAssists", "INTEGER").add("enderChest", "INTEGER").add("masterPoints", "INTEGER").add("enableGoldTag", "VARCHAR(5)").add("playTime", "BIGINT").add("inventory", "LONGTEXT");
    public static final KeyValue KV_ACTIVEMODE = (new KeyValue("enable", "VARCHAR(20) PRIMARY KEY")).add("time", "BIGINT");
    public static final KeyValue KV_MYTHICMODE = (new KeyValue("enable", "VARCHAR(20) PRIMARY KEY")).add("time", "BIGINT");
    public static final KeyValue KV_SERVERS = (new KeyValue("server", "VARCHAR(20) PRIMARY KEY")).add("bc", "VARCHAR(20)");
    public static final KeyValue KV_BOOSTER = (new KeyValue("booster", "BIGINT PRIMARY KEY")).add("id", "VARCHAR(2)");
    public static final KeyValue KV_GAME = (new KeyValue("game", "VARCHAR(20) PRIMARY KEY")).add("mapname", "VARCHAR(20)").add("state", "VARCHAR(20)");
    public static final KeyValue KV_ONLINE = (new KeyValue("game", "VARCHAR(20) PRIMARY KEY")).add("online", "BIGINT");
    public static final KeyValue KV_MAPVOTE = (new KeyValue("mapname", "VARCHAR(20) PRIMARY KEY")).add("score", "BIGINT");

    public SQLSettings() {
    }
}

