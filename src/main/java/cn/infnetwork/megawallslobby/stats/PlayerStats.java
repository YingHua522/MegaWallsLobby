package cn.infnetwork.megawallslobby.stats;

import cn.infnetwork.megawallslobby.MegaWallsLobby;
import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.ClassesManager;
import cn.infnetwork.megawallslobby.classes.ClassesSkin;
import cn.infnetwork.megawallslobby.classes.ClassesType;
import cn.infnetwork.megawallslobby.database.DataBase;
import cn.infnetwork.megawallslobby.database.KeyValue;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.reward.RewardManager;
import cn.infnetwork.megawallslobby.reward.Task;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.bukkit.Bukkit;

import java.util.*;
import java.util.Map.Entry;

public class PlayerStats {
    private static Map<GamePlayer, PlayerStats> statsMap = new HashMap();
    private static DataBase database = MegaWallsLobby.getInstance().getDataBase();
    private static Gson gson = new Gson();
    private GamePlayer gamePlayer;
    private int kills;
    private int finalKills;
    private int wins;
    private int mvp;
    private int games;
    private ClassesSkin selectedSkin;
    private String selectedSkinName;
    private int coins;
    private int mythicDust;
    private String selected;
    private EffectStatsContainer effectStats;
    private JsonObject challenges;
    private boolean autoAccept;
    private Map<Task, TaskStatsContainer> taskMap = new HashMap();
    private Map<Classes, KitStatsContainer> kitStatsMap = new HashMap();

    public PlayerStats(GamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
        if (!database.isValueExists("megawalls_stats", SQLSettings.KV_STATS, new KeyValue("uuid", gamePlayer.getUuid().toString()))) {
            database.dbInsert("megawalls_stats", new KeyValue("uuid", gamePlayer.getUuid().toString()).add("realname", gamePlayer.getName()).add("kills", 0).add("finalKills", 0).add("wins", 0).add("mvps",0).add("games", 0).add("coins", 5000).add("mythicDust", 0).add("selected", "HIM").add("Skin", "Steve"));
            database.dbInsert("megawalls_effects", (new KeyValue("uuid", gamePlayer.getUuid().toString())).add("realname", gamePlayer.getName()).add("hologramEffect", "Default").add("killMessage", "Default").add("redColor", "RED").add("greenColor", "GREEN").add("blueColor", "BLUE").add("yellowColor", "YELLOW").add("enablePrefix", "true").add("enableItalic", "false").add("enableBold", "false").add("surface", "false"));
            database.dbInsert("megawalls_challenges", (new KeyValue("uuid", gamePlayer.getUuid().toString())).add("realname", gamePlayer.getName()).add("challenges", RewardManager.defaultChallenge.toString()).add("autoAccept", "false"));
            Iterator var2 = RewardManager.getTasks().iterator();

            while (var2.hasNext()) {
                Task task = (Task) var2.next();
                database.dbInsert("megawalls_reward_" + task.getId(), (new KeyValue("uuid", gamePlayer.getUuid().toString())).add("realname", gamePlayer.getName()).add("progress", task.defaultData().toString()).add("lastFinished", "2019-01-01"));
            }

            var2 = ClassesManager.getClasses().iterator();

            while (var2.hasNext()) {
                Classes classes = (Classes) var2.next();
                database.dbInsert("classes_" + classes.getName(), (new KeyValue("uuid", gamePlayer.getUuid().toString())).add("realname", gamePlayer.getName()).add("level", classes.getClassesType() == ClassesType.NOVICE ? 1 : 0).add("equipLevel", classes.getClassesType() == ClassesType.NOVICE ? 5 : 1).add("skillLevel", classes.getClassesType() == ClassesType.NOVICE ? 5 : 1).add("skill2Level", 1).add("skill3Level", 1).add("skill4Level", 1).add("wins", 0).add("mvps",0).add("games", 0).add("finalKills", 0).add("finalAssists", 0).add("enderChest", 3).add("masterPoints", 0).add("enableGoldTag", "false").add("playTime", 0).add("inventory", "null"));
            }
        }

    }

    public static PlayerStats get(GamePlayer gamePlayer) {
        if (statsMap.containsKey(gamePlayer)) {
            return (PlayerStats) statsMap.get(gamePlayer);
        } else {
            PlayerStats ps = new PlayerStats(gamePlayer);
            statsMap.put(gamePlayer, ps);
            return (PlayerStats) statsMap.get(gamePlayer);
        }
    }

    public static void remove(GamePlayer gamePlayer) {
        if (statsMap.containsKey(gamePlayer)) {
            statsMap.remove(gamePlayer);
        }
    }

    public void update() {
        Iterator var1;
        KeyValue kv;
        for (var1 = database.dbSelect("megawalls_stats", SQLSettings.KV_STATS, new KeyValue("uuid", this.gamePlayer.getUuid().toString())).iterator(); var1.hasNext(); this.selectedSkinName = kv.getString("Skin"),this.selected = kv.getString("selected")) {
            kv = (KeyValue) var1.next();
            this.kills = Integer.parseInt(kv.getString("kills"));
            this.finalKills = Integer.parseInt(kv.getString("finalKills"));
            this.wins = Integer.parseInt(kv.getString("wins"));
            this.mvp = Integer.parseInt(kv.getString("mvps"));
            this.games = Integer.parseInt(kv.getString("games"));
            this.coins = Integer.parseInt(kv.getString("coins"));
            this.mythicDust = Integer.parseInt(kv.getString("mythicDust"));
        }

        var1 = database.dbSelect("megawalls_effects", SQLSettings.KV_EFFECTS, new KeyValue("uuid", this.gamePlayer.getUuid().toString())).iterator();

        while (var1.hasNext()) {
            kv = (KeyValue) var1.next();
            this.effectStats = new EffectStatsContainer(this.gamePlayer);
            this.effectStats.setHologramEffect(kv.getString("hologramEffect"));
            this.effectStats.setKillMessage(kv.getString("killMessage"));
            this.effectStats.setRedColor(kv.getString("redColor"));
            this.effectStats.setGreenColor(kv.getString("greenColor"));
            this.effectStats.setBlueColor(kv.getString("blueColor"));
            this.effectStats.setYellowColor(kv.getString("yellowColor"));
            this.effectStats.setEnablePrefix(Boolean.parseBoolean(kv.getString("enablePrefix")));
            this.effectStats.setEnableItalic(Boolean.parseBoolean(kv.getString("enableItalic")));
            this.effectStats.setEnableBold(Boolean.parseBoolean(kv.getString("enableBold")));
            this.effectStats.setSurface(Boolean.parseBoolean(kv.getString("surface")));
        }

        for (var1 = database.dbSelect("megawalls_challenges", SQLSettings.KV_CHALLENGES, new KeyValue("uuid", this.gamePlayer.getUuid().toString())).iterator(); var1.hasNext(); this.autoAccept = Boolean.valueOf(kv.getString("autoAccept"))) {
            kv = (KeyValue) var1.next();
            this.challenges = (JsonObject) gson.fromJson(kv.getString("challenges"), JsonObject.class);
        }

        var1 = RewardManager.getTasks().iterator();

        Iterator var3;
        while (var1.hasNext()) {
            Task task = (Task) var1.next();
            var3 = database.dbSelect("megawalls_reward_" + task.getId(), SQLSettings.KV_REWARD, new KeyValue("uuid", this.gamePlayer.getUuid().toString())).iterator();

            while (var3.hasNext()) {
                kv = (KeyValue) var3.next();
                boolean accept = Boolean.valueOf(kv.getString("accept"));
                JsonObject jsonObject = (JsonObject) gson.fromJson(kv.getString("progress"), JsonObject.class);
                String lastFinished = kv.getString("lastFinished");
                this.taskMap.put(task, new TaskStatsContainer(this.gamePlayer, task, accept, jsonObject, lastFinished));
            }
        }

        var1 = ClassesManager.getClasses().iterator();

        Classes classes;
        KitStatsContainer kitStats;
        String inventory;
        while (var1.hasNext()) {
            classes = (Classes) var1.next();

            for (var3 = database.dbSelect("classes_" + classes.getName(), SQLSettings.KV_CLASSES, new KeyValue("uuid", this.gamePlayer.getUuid().toString())).iterator(); var3.hasNext(); this.kitStatsMap.put(classes, kitStats)) {
                kv = (KeyValue) var3.next();
                kitStats = new KitStatsContainer(this.gamePlayer, classes);
                kitStats.setLevel(Integer.parseInt(kv.getString("level")));
                kitStats.setEquipLevel(Integer.parseInt(kv.getString("equipLevel")));
                kitStats.setSkillLevel(Integer.parseInt(kv.getString("skillLevel")));
                kitStats.setSkill2Level(Integer.parseInt(kv.getString("skill2Level")));
                kitStats.setSkill3Level(Integer.parseInt(kv.getString("skill3Level")));
                kitStats.setSkill4Level(Integer.parseInt(kv.getString("skill4Level")));
                kitStats.setWins(Integer.parseInt(kv.getString("wins")));
                kitStats.setMvps(Integer.parseInt(kv.getString("mvps")));
                kitStats.setGames(Integer.parseInt(kv.getString("games")));
                kitStats.setFinalKills(Integer.parseInt(kv.getString("finalKills")));
                kitStats.setFinalAssists(Integer.parseInt(kv.getString("finalAssists")));
                kitStats.setEnderChest(Integer.parseInt(kv.getString("enderChest")));
                kitStats.setMasterPoints(Integer.parseInt(kv.getString("masterPoints")));
                kitStats.setEnableGoldTag(Boolean.parseBoolean(kv.getString("enableGoldTag")));
                kitStats.setPlayTime(Long.parseLong(kv.getString("playTime")));
                inventory = kv.getString("inventory");
                if (!inventory.equalsIgnoreCase("null") && !inventory.equalsIgnoreCase("")) {
                    kitStats.setInventory((JsonObject) gson.fromJson(inventory, JsonObject.class));
                }
            }
        }

        var1 = ClassesManager.getClasses().iterator();

        while (var1.hasNext()) {
            classes = (Classes) var1.next();
            if (!this.kitStatsMap.containsKey(classes)) {
                database.dbInsert("classes_" + classes.getName(), (new KeyValue("uuid", this.gamePlayer.getUuid().toString())).add("realname", this.gamePlayer.getName()).add("level", classes.getClassesType() == ClassesType.NOVICE ? 1 : 0).add("equipLevel", classes.getClassesType() == ClassesType.NOVICE ? 5 : 1).add("skillLevel", classes.getClassesType() == ClassesType.NOVICE ? 5 : 1).add("skill2Level", 1).add("skill3Level", 1).add("skill4Level", 1).add("wins", 0).add("mvps",0).add("games", 0).add("finalKills", 0).add("finalAssists", 0).add("enderChest", 3).add("masterPoints", 0).add("enableGoldTag", "false").add("playTime", 0).add("inventory", "null"));
            }

            for (var3 = database.dbSelect("classes_" + classes.getName(), SQLSettings.KV_CLASSES, new KeyValue("uuid", this.gamePlayer.getUuid().toString())).iterator(); var3.hasNext(); this.kitStatsMap.put(classes, kitStats)) {
                kv = (KeyValue) var3.next();
                kitStats = new KitStatsContainer(this.gamePlayer, classes);
                kitStats.setLevel(Integer.parseInt(kv.getString("level")));
                kitStats.setEquipLevel(Integer.parseInt(kv.getString("equipLevel")));
                kitStats.setSkillLevel(Integer.parseInt(kv.getString("skillLevel")));
                kitStats.setSkill2Level(Integer.parseInt(kv.getString("skill2Level")));
                kitStats.setSkill3Level(Integer.parseInt(kv.getString("skill3Level")));
                kitStats.setSkill4Level(Integer.parseInt(kv.getString("skill4Level")));
                kitStats.setWins(Integer.parseInt(kv.getString("wins")));
                kitStats.setMvps(Integer.parseInt(kv.getString("mvps")));
                kitStats.setGames(Integer.parseInt(kv.getString("games")));
                kitStats.setFinalKills(Integer.parseInt(kv.getString("finalKills")));
                kitStats.setFinalAssists(Integer.parseInt(kv.getString("finalAssists")));
                kitStats.setEnderChest(Integer.parseInt(kv.getString("enderChest")));
                kitStats.setMasterPoints(Integer.parseInt(kv.getString("masterPoints")));
                kitStats.setEnableGoldTag(Boolean.parseBoolean(kv.getString("enableGoldTag")));
                kitStats.setPlayTime(Long.parseLong(kv.getString("playTime")));
                inventory = kv.getString("inventory");
                if (!inventory.equalsIgnoreCase("null") && !inventory.equalsIgnoreCase("")) {
                    kitStats.setInventory((JsonObject) gson.fromJson(inventory, JsonObject.class));
                }
            }
        }

        if (this.autoAccept) {
            Bukkit.getScheduler().runTaskLater(MegaWallsLobby.getInstance(), new Runnable() {
                public void run() {

                    for (Task task : RewardManager.getTasks()) {
                        TaskStatsContainer container = (TaskStatsContainer) PlayerStats.this.taskMap.get(task);
                        if (!container.isAccept() && Task.isLater(Task.current(), container.getLastFinished(), task.getType())) {
                            container.accept();
                            PlayerStats.this.gamePlayer.sendMessage("§a你开始了 §6" + task.getType().getName() + "任务: " + task.getName() + " §a任务！");
                        }
                    }

                }
            }, 40L);
        }

    }

    public Classes getSelected() {
        return ClassesManager.getClassesByName(this.selected);
    }

    public void setSelected(String classesName) {
        if (ClassesManager.getClassesByName(classesName) != null) {
            database.dbUpdate("megawalls_stats", new KeyValue("Selected", classesName), new KeyValue("uuid", this.gamePlayer.getUuid().toString()));
            this.selected = classesName;
        }
    }

    public void giveCoins(int amount) {
        this.coins += amount;
        database.dbUpdate("megawalls_stats", new KeyValue("coins", this.coins), new KeyValue("uuid", this.gamePlayer.getUuid().toString()));
    }

    public void takeCoins(int amount) {
        if (this.coins - amount >= 0) {
            this.coins -= amount;
            database.dbUpdate("megawalls_stats", new KeyValue("coins", this.coins), new KeyValue("uuid", this.gamePlayer.getUuid().toString()));
        }
    }

    public void giveMythicDust(int amount) {
        this.mythicDust += amount;
        database.dbUpdate("megawalls_stats", new KeyValue("mythicDust", this.mythicDust), new KeyValue("uuid", this.gamePlayer.getUuid().toString()));
    }

    public void takeMythicDust(int amount) {
        if (this.mythicDust - amount >= 0) {
            this.mythicDust -= amount;
            database.dbUpdate("megawalls_stats", new KeyValue("mythicDust", this.mythicDust), new KeyValue("uuid", this.gamePlayer.getUuid().toString()));
        }
    }

    public ClassesSkin getSelectedSkin() {
        return this.selectedSkin;
    }

    public void setSelectedSkin(ClassesSkin selectedSkin) {
        database.dbUpdate("megawalls_stats", new KeyValue("Skin", selectedSkinName), new KeyValue("uuid", this.gamePlayer.getUuid().toString()));
        this.selectedSkin = selectedSkin;
        this.selectedSkinName = selectedSkin.getName();
    }

    public TaskStatsContainer getTaskStats(Task task) {
        return this.taskMap.getOrDefault(task, null);
    }

    public KitStatsContainer getKitStats(Classes classes) {
        return this.kitStatsMap.getOrDefault(classes, null);
    }

    public List<Classes> unlockedClasses() {
        List<Classes> list = new ArrayList();
        Iterator var2 = this.kitStatsMap.entrySet().iterator();

        while (var2.hasNext()) {
            Entry<Classes, KitStatsContainer> entry = (Entry) var2.next();
            if (this.isUnlocked((Classes) entry.getKey())) {
                list.add(entry.getKey());
            }
        }

        return list;
    }

    public List<Classes> unlockedNormalClasses() {
        List<Classes> list = new ArrayList();
        Iterator var2 = ClassesManager.getNormalClasses().iterator();

        while (var2.hasNext()) {
            Classes classes = (Classes) var2.next();
            if (this.isUnlocked(classes)) {
                list.add(classes);
            }
        }

        return list;
    }

    public List<Classes> unlockedMythicClasses() {
        List<Classes> list = new ArrayList();
        Iterator var2 = ClassesManager.getMythicClasses().iterator();

        while (var2.hasNext()) {
            Classes classes = (Classes) var2.next();
            if (this.isUnlocked(classes)) {
                list.add(classes);
            }
        }

        return list;
    }

    public boolean isUnlocked(Classes classes) {
        return ((KitStatsContainer) this.kitStatsMap.get(classes)).getLevel() >= 1;
    }

    public KitStatsContainer usuallyUsedClasses() {
        KitStatsContainer kitStats = null;
        Iterator var2 = this.kitStatsMap.entrySet().iterator();

        while (var2.hasNext()) {
            Entry<Classes, KitStatsContainer> entry = (Entry) var2.next();
            if (kitStats == null) {
                kitStats = (KitStatsContainer) entry.getValue();
            } else if (((KitStatsContainer) entry.getValue()).getPlayTime() > kitStats.getPlayTime()) {
                kitStats = (KitStatsContainer) entry.getValue();
            }
        }

        return kitStats;
    }

    public List<Classes> maxedClasses() {
        List<Classes> list = new ArrayList();
        Iterator var2 = this.unlockedClasses().iterator();

        while (var2.hasNext()) {
            Classes classes = (Classes) var2.next();
            if (((KitStatsContainer) this.kitStatsMap.get(classes)).isMaxed()) {
                list.add(classes);
            }
        }

        return list;
    }

    public int masterClasses() {
        int i = 0;
        List<Classes> unlocked = this.unlockedClasses();

        Classes classes;
        for (Iterator var3 = unlocked.iterator(); var3.hasNext(); i += ((KitStatsContainer) this.kitStatsMap.get(classes)).getLevel()) {
            classes = (Classes) var3.next();
        }

        return i - unlocked.size();
    }

    public int getChallenge(int challengeId) {
        return this.challenges.get(String.valueOf(challengeId)).getAsInt();
    }

    public String getChallengeLastFinished(int challengeId) {
        return this.challenges.get(challengeId + "_lastFinished").getAsString();
    }

    public void addChallenge(int challengeId, int amount) {
        JsonObject newJson = new JsonObject();
        Iterator var4 = this.challenges.entrySet().iterator();

        while (var4.hasNext()) {
            Entry<String, JsonElement> entry = (Entry) var4.next();
            if (((String) entry.getKey()).equals(String.valueOf(challengeId))) {
                newJson.addProperty(String.valueOf(challengeId), this.challenges.get(String.valueOf(challengeId)).getAsInt() + amount);
            } else {
                newJson.add((String) entry.getKey(), (JsonElement) entry.getValue());
            }
        }

        this.challenges = newJson;
        database.dbUpdate("megawalls_challenges", new KeyValue("challenges", this.challenges.toString()), new KeyValue("uuid", this.gamePlayer.getUuid().toString()));
    }

    public void setChallengeFinished(int challengeId) {
        String current = Task.current();
        JsonObject newJson = new JsonObject();
        Iterator var4 = this.challenges.entrySet().iterator();

        while (var4.hasNext()) {
            Entry<String, JsonElement> entry = (Entry) var4.next();
            if (((String) entry.getKey()).equals(challengeId + "_lastFinished")) {
                newJson.addProperty(challengeId + "_lastFinished", current);
            } else {
                newJson.add((String) entry.getKey(), (JsonElement) entry.getValue());
            }
        }

        this.challenges = newJson;
        database.dbUpdate("megawalls_challenges", new KeyValue("challenges", this.challenges.toString()), new KeyValue("uuid", this.gamePlayer.getUuid().toString()));
    }

    public GamePlayer getGamePlayer() {
        return this.gamePlayer;
    }

    public int getKills() {
        return this.kills;
    }

    public int getFinalKills() {
        return this.finalKills;
    }

    public int getWins() {
        return this.wins;
    }

    public int getMvp() {
        return mvp;
    }

    public int getGames() {
        return this.games;
    }

    public int getCoins() {
        return this.coins;
    }

    public int getMythicDust() {
        return this.mythicDust;
    }

    public EffectStatsContainer getEffectStats() {
        return this.effectStats;
    }

    public JsonObject getChallenges() {
        return this.challenges;
    }

    public boolean isAutoAccept() {
        return this.autoAccept;
    }

    public void setAutoAccept(boolean autoAccept) {
        this.autoAccept = autoAccept;
        database.dbUpdate("megawalls_challenges", new KeyValue("autoAccept", autoAccept), new KeyValue("uuid", this.gamePlayer.getUuid().toString()));
    }

    public Map<Task, TaskStatsContainer> getTaskMap() {
        return this.taskMap;
    }

    public Map<Classes, KitStatsContainer> getKitStatsMap() {
        return this.kitStatsMap;
    }
}
