package cn.infnetwork.megawallslobby.stats;

import cn.infnetwork.megawallslobby.MegaWallsLobby;
import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.database.DataBase;
import cn.infnetwork.megawallslobby.database.KeyValue;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.util.StringUtils;
import com.google.gson.JsonObject;

public class KitStatsContainer {
    private static final DataBase database = MegaWallsLobby.getInstance().getDataBase();
    private final GamePlayer gamePlayer;
    private final Classes classes;
    private int level;
    private int equipLevel;
    private int skillLevel;
    private int skill2Level;
    private int skill3Level;
    private int skill4Level;
    private int wins;
    private int mvps;
    private int games;
    private int finalKills;
    private int finalAssists;
    private int enderChest;
    private int masterPoints;
    private boolean enableGoldTag;
    private boolean PrestigeSkin;
    private long playTime;
    private JsonObject inventory;

    public KitStatsContainer(GamePlayer gamePlayer, Classes classes) {
        this.gamePlayer = gamePlayer;
        this.classes = classes;
    }

    public void addLevel() {
        ++this.level;
        database.dbUpdate("classes_" + this.classes.getName(), new KeyValue("level", this.level), new KeyValue("uuid", this.gamePlayer.getUuid().toString()));
    }

    public void addEquipLevel() {
        ++this.equipLevel;
        database.dbUpdate("classes_" + this.classes.getName(), new KeyValue("equipLevel", this.equipLevel), new KeyValue("uuid", this.gamePlayer.getUuid().toString()));
    }

    public void addSkillLevel() {
        ++this.skillLevel;
        database.dbUpdate("classes_" + this.classes.getName(), new KeyValue("skillLevel", this.skillLevel), new KeyValue("uuid", this.gamePlayer.getUuid().toString()));
    }

    public void addSkill2Level() {
        ++this.skill2Level;
        database.dbUpdate("classes_" + this.classes.getName(), new KeyValue("skill2Level", this.skill2Level), new KeyValue("uuid", this.gamePlayer.getUuid().toString()));
    }

    public void addSkill3Level() {
        ++this.skill3Level;
        database.dbUpdate("classes_" + this.classes.getName(), new KeyValue("skill3Level", this.skill3Level), new KeyValue("uuid", this.gamePlayer.getUuid().toString()));
    }

    public void addSkill4Level() {
        ++this.skill4Level;
        database.dbUpdate("classes_" + this.classes.getName(), new KeyValue("skill4Level", this.skill4Level), new KeyValue("uuid", this.gamePlayer.getUuid().toString()));
    }

    public void addWins() {
        ++this.wins;
        database.dbUpdate("classes_" + this.classes.getName(), new KeyValue("wins", this.wins), new KeyValue("uuid", this.gamePlayer.getUuid().toString()));
    }

    public void addMvp() {
        ++this.mvps;
        database.dbUpdate("classes_" + this.classes.getName(), new KeyValue("mvps", this.mvps), new KeyValue("uuid", this.gamePlayer.getUuid().toString()));
    }

    public void addGames() {
        ++this.games;
        database.dbUpdate("classes_" + this.classes.getName(), new KeyValue("games", this.games), new KeyValue("uuid", this.gamePlayer.getUuid().toString()));
    }

    public void addFinalKills(int amount) {
        this.finalKills += amount;
        database.dbUpdate("classes_" + this.classes.getName(), new KeyValue("finalKills", this.finalKills), new KeyValue("uuid", this.gamePlayer.getUuid().toString()));
    }

    public void addFinalAssists(int amount) {
        this.finalAssists += amount;
        database.dbUpdate("classes_" + this.classes.getName(), new KeyValue("finalAssists", this.finalAssists), new KeyValue("uuid", this.gamePlayer.getUuid().toString()));
    }

    public void addEnderChest() {
        ++this.enderChest;
        database.dbUpdate("classes_" + this.classes.getName(), new KeyValue("enderChest", this.enderChest), new KeyValue("uuid", this.gamePlayer.getUuid().toString()));
    }

    public void setPrestigeSkin(boolean PrestigeSkin) {
        this.PrestigeSkin = PrestigeSkin;
        database.dbUpdate("classes_" + this.classes.getName(), new KeyValue("PrestigeSkin", String.valueOf(PrestigeSkin)), new KeyValue("uuid", this.gamePlayer.getUuid().toString()));
    }

    public void giveMasterPoints(int amount) {
        this.masterPoints += amount;
        database.dbUpdate("classes_" + this.classes.getName(), new KeyValue("masterPoints", this.masterPoints), new KeyValue("uuid", this.gamePlayer.getUuid().toString()));
    }

    public void takeMasterPoints(int amount) {
        if (this.masterPoints - amount >= 0) {
            this.masterPoints -= amount;
            database.dbUpdate("classes_" + this.classes.getName(), new KeyValue("masterPoints", this.masterPoints), new KeyValue("uuid", this.gamePlayer.getUuid().toString()));
        }
    }

    public void addPlayTime(long time) {
        this.playTime += time;
        database.dbUpdate("classes_" + this.classes.getName(), new KeyValue("playTime", this.playTime), new KeyValue("uuid", this.gamePlayer.getUuid().toString()));
    }

    public void updateEnableGoldTag(boolean enableGoldTag) {
        this.enableGoldTag = enableGoldTag;
        database.dbUpdate("classes_" + this.classes.getName(), new KeyValue("enableGoldTag", String.valueOf(enableGoldTag)), new KeyValue("uuid", this.gamePlayer.getUuid().toString()));
    }

    public void updateInventory(JsonObject inventory) {
        this.inventory = inventory;
        database.dbUpdate("classes_" + this.classes.getName(), new KeyValue("inventory", inventory == null ? "null" : inventory.toString()), new KeyValue("uuid", this.gamePlayer.getUuid().toString()));
    }

    public String upgradePercent() {
        double percent = (double) (this.equipLevel + this.skillLevel + this.skill2Level + this.skill3Level + this.skill4Level - 8) / 16.0;
        return (percent >= 1.0 ? "§a§l" : "§e") + StringUtils.percent(percent);
    }

    public boolean isMaxed() {
        return this.equipLevel + this.skillLevel + this.skill2Level + this.skill3Level + this.skill4Level + this.enderChest - 8 == 16;
    }

    public GamePlayer getGamePlayer() {
        return this.gamePlayer;
    }

    public Classes getClasses() {
        return this.classes;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getEquipLevel() {
        return this.equipLevel;
    }

    public void setEquipLevel(int equipLevel) {
        this.equipLevel = equipLevel;
    }

    public int getSkillLevel() {
        return this.skillLevel;
    }

    public void setSkillLevel(int skillLevel) {
        this.skillLevel = skillLevel;
    }

    public int getSkill2Level() {
        return this.skill2Level;
    }

    public void setSkill2Level(int skill2Level) {
        this.skill2Level = skill2Level;
    }

    public int getSkill3Level() {
        return this.skill3Level;
    }

    public void setSkill3Level(int skill3Level) {
        this.skill3Level = skill3Level;
    }

    public int getSkill4Level() {
        return this.skill4Level;
    }

    public void setSkill4Level(int skill4Level) {
        this.skill4Level = skill4Level;
    }

    public int getWins() {
        return this.wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getMvps() {
        return mvps;
    }

    public void setMvps(int mvps) {
        this.mvps = mvps;
    }

    public int getGames() {
        return this.games;
    }

    public void setGames(int games) {
        this.games = games;
    }

    public int getFinalKills() {
        return this.finalKills;
    }

    public void setFinalKills(int finalKills) {
        this.finalKills = finalKills;
    }

    public int getFinalAssists() {
        return this.finalAssists;
    }

    public void setFinalAssists(int finalAssists) {
        this.finalAssists = finalAssists;
    }

    public int getEnderChest() {
        return this.enderChest;
    }

    public void setEnderChest(int enderChest) {
        this.enderChest = enderChest;
    }

    public int getMasterPoints() {
        return this.masterPoints;
    }

    public void setMasterPoints(int masterPoints) {
        this.masterPoints = masterPoints;
    }

    public boolean isEnableGoldTag() {
        return this.enableGoldTag;
    }

    public boolean isPrestigeSkin() {
        return PrestigeSkin;
    }

    public void setEnableGoldTag(boolean enableGoldTag) {
        this.enableGoldTag = enableGoldTag;
    }

    public long getPlayTime() {
        return this.playTime;
    }

    public void setPlayTime(long playTime) {
        this.playTime = playTime;
    }

    public JsonObject getInventory() {
        return this.inventory;
    }

    public void setInventory(JsonObject inventory) {
        this.inventory = inventory;
    }
}
