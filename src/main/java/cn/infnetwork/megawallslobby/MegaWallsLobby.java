package cn.infnetwork.megawallslobby;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.ClassesManager;
import cn.infnetwork.megawallslobby.command.CommandHandler;
import cn.infnetwork.megawallslobby.config.FileConfig;
import cn.infnetwork.megawallslobby.database.DataBase;
import cn.infnetwork.megawallslobby.database.KeyValue;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.game.Server;
import cn.infnetwork.megawallslobby.hologram.HologramManager;
import cn.infnetwork.megawallslobby.inventory.PlayerPack;
import cn.infnetwork.megawallslobby.listener.PlayerListener;
import cn.infnetwork.megawallslobby.reward.RewardManager;
import cn.infnetwork.megawallslobby.reward.Task;
import cn.infnetwork.megawallslobby.stats.SQLSettings;
import cn.infnetwork.megawallslobby.task.ScoreBoardTimer;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import fr.minuskube.inv.InventoryManager;
import fr.minuskube.inv.opener.PluginUpdate;
import fr.minuskube.inv.opener.SQL;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MegaWallsLobby extends JavaPlugin {
    public static int booster = 0;
    private static MegaWallsLobby instance;
    private static long activeMode = System.currentTimeMillis();
    private static long mythicMode = System.currentTimeMillis();
    private FileConfig config;
    private CommandHandler commandHandler;
    private InventoryManager inventoryManager;
    private HologramManager hologramManager;
    private DataBase database;

    public MegaWallsLobby() {
    }



    public static MegaWallsLobby getInstance() {
        return instance;
    }

    public static void tpServer(Player player, String srv) {
        String server = srv;
        try {
            ByteArrayDataOutput buf = ByteStreams.newDataOutput();
            buf.writeUTF("Connect");
            buf.writeUTF(server);
            player.sendPluginMessage(getInstance(), "BungeeCord", buf.toByteArray());
        } catch (Exception var3) {
        }
    }

    public static boolean isActiveMode() {
        return System.currentTimeMillis() < activeMode;
    }

    public static boolean isMythicMode() {
        return System.currentTimeMillis() < mythicMode;
    }



    public static KeyValue getRejoin(GamePlayer gamePlayer) {
        DataBase database = getInstance().getDataBase();
        if (!database.isValueExists("megawalls_rejoin", SQLSettings.KV_REJOIN, new KeyValue("uuid", gamePlayer.getUuid().toString()))) {
            return null;
        } else {
            String server = "";
            String time = "0";

            KeyValue kv;
            for (Iterator var4 = database.dbSelect("megawalls_rejoin", SQLSettings.KV_REJOIN, new KeyValue("uuid", gamePlayer.getUuid().toString())).iterator(); var4.hasNext(); time = kv.getString("time")) {
                kv = (KeyValue) var4.next();
                server = kv.getString("server");
            }
            return (new KeyValue("server", server)).add("time", time);
        }
    }

    public static String translateServerByGame(Server server) {
        return MegaWallsLobby.getInstance().getDataBase().dbSelectFirst("megawalls_servers", "bc", new KeyValue("server", server.getName()));
    }

    public static int getOnlinePlayer(Server server) {
        String s = MegaWallsLobby.getInstance().getDataBase().dbSelectFirst(SQLSettings.TABLE_ONLINE, "online", new KeyValue("game", server.getName()));
        if (s == null) {
            return 0;
        }
        return Integer.parseInt(s);
    }

    public static long getActiveMode() {
        return activeMode;
    }

    public static long getMythicMode() {
        return mythicMode;
    }

    public static void setActiveMode(long activeMode) {
        MegaWallsLobby.getInstance().getDataBase().dbDelete("megawalls_activemode", new KeyValue("enable", "true"));
        MegaWallsLobby.getInstance().getDataBase().dbDelete("megawalls_activemode", new KeyValue("enable", "false"));
        MegaWallsLobby.getInstance().getDataBase().dbInsert("megawalls_activemode", new KeyValue("time", activeMode).add("enable", "true"));
        MegaWallsLobby.activeMode = activeMode;
        getBooster();
    }

    public static void setMythicMode(long mythicMode) {
        MegaWallsLobby.getInstance().getDataBase().dbDelete("megawalls_mythicmode", new KeyValue("enable", "true"));
        MegaWallsLobby.getInstance().getDataBase().dbDelete("megawalls_mythicmode", new KeyValue("enable", "false"));
        MegaWallsLobby.getInstance().getDataBase().dbInsert("megawalls_mythicmode", new KeyValue("time", mythicMode).add("enable", "true"));
        MegaWallsLobby.mythicMode = mythicMode;
        getBooster();
    }

    public static double getBooster() {
        String s = MegaWallsLobby.getInstance().getDataBase().dbSelectFirst("megawalls_booster", "booster", new KeyValue("id", "37"));
        if (s == null) {
            booster = 0;
            return 0;
        }
        booster = (int) Double.parseDouble(s);
        return Double.parseDouble(s);
    }

    public static void setBooster(double booster) {
        MegaWallsLobby.getInstance().getDataBase().dbDelete("megawalls_booster", new KeyValue("id", "37"));
        MegaWallsLobby.getInstance().getDataBase().dbDelete("megawalls_booster", new KeyValue("id", "37"));
        MegaWallsLobby.getInstance().getDataBase().dbInsert("megawalls_booster", new KeyValue("booster", booster).add("id", "37"));
        getBooster();
    }

    public static void voteMap(String map, int score) {
        if (MegaWallsLobby.getInstance().getDataBase().dbExist(SQLSettings.TABLE_MAPVOTE, new KeyValue("mapname", map))) {
            int a = 0;
            String s = MegaWallsLobby.getInstance().getDataBase().dbSelectFirst(SQLSettings.TABLE_MAPVOTE, "score", new KeyValue("mapname", map));
            if (s == null) {
                a = 0;
            } else {
                a = Integer.parseInt(s);
            }

            MegaWallsLobby.getInstance().getDataBase().dbUpdate(SQLSettings.TABLE_MAPVOTE, new KeyValue("score", a + score), new KeyValue("mapname", map));
        } else {
            MegaWallsLobby.getInstance().getDataBase().dbInsert(SQLSettings.TABLE_MAPVOTE, new KeyValue("score", score).add("mapname", map));
        }
    }

    public void onEnable() {
        SQL sql = new SQL();
        instance = this;
        this.config = new FileConfig(this);
        String expectedLicense = MegaWallsLobby.getInstance().getConfig().getString("code");
        List<String> actualLicenseLines = sql.getLicenseFromGitee();
        boolean licenseMatched = false;
        for (String line : actualLicenseLines) {
            if (line.equals(expectedLicense)) {
                licenseMatched = true;
                break;
            }
        }
        if (!licenseMatched) {
            getLogger().severe(ChatColor.RED + "许可证不正确，插件启动失败！");
            getServer().getPluginManager().disablePlugin(this);
            Bukkit.shutdown();
            return;
        }
        PluginUpdate pl = new PluginUpdate();
        pl.updatePlugin();
        this.commandHandler = new CommandHandler();
        this.inventoryManager = new InventoryManager(this);
        this.inventoryManager.init();
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        ClassesManager.registerAll();
        RewardManager.registerAll();
        cn.infnetwork.megawallslobby.inventory.InventoryManager.registerAll();
        this.database = DataBase.create(this.getConfig().getConfigurationSection("database"));
        this.database.createTables("megawalls_stats", SQLSettings.KV_STATS, null);
        this.database.createTables("megawalls_effects", SQLSettings.KV_EFFECTS, null);
        this.database.createTables("spectator_settings", SQLSettings.KV_SPECTATOR_SETTINGS, null);
        this.database.createTables("megawalls_challenges", SQLSettings.KV_CHALLENGES, null);
        this.database.createTables("megawalls_rejoin", SQLSettings.KV_REJOIN, null);
        this.database.createTables("megawalls_activemode", SQLSettings.KV_ACTIVEMODE, null);
        this.database.createTables("megawalls_mythicmode",SQLSettings.KV_MYTHICMODE,null);
        this.database.createTables("megawalls_servers", SQLSettings.KV_SERVERS, null);
        this.database.createTables("megawalls_booster", SQLSettings.KV_BOOSTER, null);
        this.database.createTables(SQLSettings.TABLE_MAPVOTE, SQLSettings.KV_MAPVOTE, null);
        Iterator var1 = RewardManager.getTasks().iterator();

        while (var1.hasNext()) {
            Task task = (Task) var1.next();
            this.database.createTables("megawalls_reward_" + task.getId(), SQLSettings.KV_REWARD, (String) null);
        }

        var1 = ClassesManager.getClasses().iterator();

        while (var1.hasNext()) {
            Classes classes = (Classes) var1.next();
            this.database.createTables("classes_" + classes.getName(), SQLSettings.KV_CLASSES, (String) null);
        }

        new PlayerListener(this);
        Bukkit.getScheduler().runTaskTimer(this, () -> {
            for (GamePlayer gamePlayer : GamePlayer.getOnlinePlayers()) {
                Bukkit.getScheduler().runTask(this, new ScoreBoardTimer(gamePlayer));
            }
        }, 0L, 20L);
        this.hologramManager = new HologramManager();
        Bukkit.getPluginCommand("mp").setExecutor(new PlayerPack());
        Bukkit.getScheduler().runTaskTimer(this, this.hologramManager, 0L, 12000L);
        Bukkit.getScheduler().runTaskTimer(this, () -> {
            if (!isActiveMode()) {
                String s = getDataBase().dbSelectFirst("megawalls_activemode", "time", new KeyValue("enable", "true"));
                if (s == null) return;
                activeMode = Long.parseLong(s);
                getBooster();
            }
        }, 20 * 10, 20 * 20);
        Bukkit.getScheduler().runTaskTimer(this, () -> {
            if (!isMythicMode()) {
                String s = getDataBase().dbSelectFirst("megawalls_mythicmode", "time", new KeyValue("enable", "true"));
                if (s == null) return;
                mythicMode = Long.parseLong(s);
                getBooster();
            }
        }, 20 * 10, 20 * 20);
    }

    public void onDisable() {
        try {
            if (this.database != null) {
                this.database.close();
            }
        } catch (Exception var2) {
        }

    }

    public FileConfig getConfig() {
        return this.config;
    }

    public DataBase getDataBase() {
        return this.database;
    }

    public CommandHandler getCommandHandler() {
        return this.commandHandler;
    }

    public InventoryManager getInventoryManager() {
        return this.inventoryManager;
    }

    public HologramManager getHologramManager() {
        return this.hologramManager;
    }

}
