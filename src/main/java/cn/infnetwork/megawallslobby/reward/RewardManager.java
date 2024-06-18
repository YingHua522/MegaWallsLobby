package cn.infnetwork.megawallslobby.reward;

import cn.infnetwork.megawallslobby.MegaWallsLobby;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.reward.Task.Type;
import cn.infnetwork.megawallslobby.stats.TaskStatsContainer;
import cn.infnetwork.megawallslobby.util.StringUtils;
import com.google.gson.JsonObject;
import org.bukkit.Bukkit;

import java.util.*;

public class RewardManager {
    public static final JsonObject defaultChallenge = new JsonObject();
    private static final Map<Integer, Task> taskMap = new HashMap();
    private static final Map<Integer, Challenge> challengeMap = new HashMap();
    private static boolean registered = false;

    public RewardManager() {
    }

    public static Task getTask(int id) {
        return (Task) taskMap.getOrDefault(id, null);
    }

    public static void registerTask(Task task) {
        taskMap.put(task.getId(), task);
    }

    public static List<Task> getTasks() {
        return new ArrayList(taskMap.values());
    }

    public static Challenge getChallenge(int id) {
        return (Challenge) challengeMap.getOrDefault(id, null);
    }

    public static void registerChallenge(Challenge challenge) {
        challengeMap.put(challenge.getId(), challenge);
    }

    public static List<Challenge> getChallenges() {
        return new ArrayList(challengeMap.values());
    }

    public static boolean registerAll() {
        if (registered) {
            return false;
        } else {
            registerTask(new Task(1, Type.DAILY, "每日一场") {
                public List<String> getInfo(TaskStatsContainer container) {
                    int now = container.getJsonObject().get("games").getAsInt();
                    if (now > 1) {
                        now = 1;
                    }

                    return Arrays.asList("§7玩一场超级战墙 §b(§6" + now + "§b/§61§b)");
                }

                public List<String> getRewardInfo() {
                    return Arrays.asList("§8+§6" + StringUtils.formattedCoins(4500) + " §7超级战墙硬币");
                }

                public void giveRewarad(GamePlayer gamePlayer) {
                    gamePlayer.getPlayerStats().giveCoins(4500);
                }

                public boolean isFinish(TaskStatsContainer container) {
                    int now = container.getJsonObject().get("games").getAsInt();
                    return now >= 1;
                }

                public JsonObject defaultData() {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("games", 0);
                    return jsonObject;
                }
            });
            registerTask(new Task(2, Type.DAILY, "胜利") {
                public List<String> getInfo(TaskStatsContainer container) {
                    int now = container.getJsonObject().get("games").getAsInt();
                    if (now > 1) {
                        now = 1;
                    }

                    return Arrays.asList("§7在超级战墙中,赢一场比赛", "§7并且至少获得1击杀 §b(§6" + now + "§b/§61§b)");
                }

                public List<String> getRewardInfo() {
                    return Arrays.asList("§8+§6" + StringUtils.formattedCoins(1500) + " §7超级战墙硬币");
                }

                public void giveRewarad(GamePlayer gamePlayer) {
                    gamePlayer.getPlayerStats().giveCoins(1500);
                }

                public boolean isFinish(TaskStatsContainer container) {
                    int now = container.getJsonObject().get("games").getAsInt();
                    return now >= 1;
                }

                public JsonObject defaultData() {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("games", 0);
                    return jsonObject;
                }
            });
            registerTask(new Task(3, Type.MYTHIC, "信仰") {
                public List<String> getInfo(TaskStatsContainer container) {
                    int games = container.getJsonObject().get("games").getAsInt();
                    if (games > 3) {
                        games = 3;
                    }

                    int wins = container.getJsonObject().get("wins").getAsInt();
                    if (wins > 1) {
                        wins = 1;
                    }

                    return Arrays.asList("§7参与3次超级战墙标准模式 §b(§6" + games + "§b/§63§b)", "§7获得1场超级战墙标准模式胜利 §b(§6" + wins + "§b/§61§b)");
                }

                public List<String> getRewardInfo() {
                    return Arrays.asList("§8+§e1超级战墙神话之尘");
                }

                public void giveRewarad(GamePlayer gamePlayer) {
                    gamePlayer.getPlayerStats().giveMythicDust(1);
                }

                public boolean isFinish(TaskStatsContainer container) {
                    int games = container.getJsonObject().get("games").getAsInt();
                    int wins = container.getJsonObject().get("wins").getAsInt();
                    return games >= 3 && wins >= 1;
                }

                public JsonObject defaultData() {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("games", 0);
                    jsonObject.addProperty("wins", 0);
                    jsonObject.addProperty("mvps",0);
                    return jsonObject;
                }
            });
            registerTask(new Task(4, Type.DAILY, "击杀") {
                public List<String> getInfo(TaskStatsContainer container) {
                    int kills = container.getJsonObject().get("kills").getAsInt();
                    if (kills > 15) {
                        kills = 15;
                    }

                    return Arrays.asList("§7在超级战墙中杀死15名玩家 §b(§6" + kills + "§b/§615§b)");
                }

                public List<String> getRewardInfo() {
                    return Arrays.asList("§8+§6" + StringUtils.formattedCoins(1500) + " §7超级战墙硬币");
                }

                public void giveRewarad(GamePlayer gamePlayer) {
                    gamePlayer.getPlayerStats().giveCoins(1500);
                }

                public boolean isFinish(TaskStatsContainer container) {
                    int kills = container.getJsonObject().get("kills").getAsInt();
                    return kills >= 15;
                }

                public JsonObject defaultData() {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("kills", 0);
                    return jsonObject;
                }
            });
            registerTask(new Task(5, Type.WEEKLY, "超级战墙玩家") {
                public List<String> getInfo(TaskStatsContainer container) {
                    int games = container.getJsonObject().get("games").getAsInt();
                    if (games > 15) {
                        games = 15;
                    }

                    int kills = container.getJsonObject().get("kills").getAsInt();
                    if (kills > 25) {
                        kills = 25;
                    }

                    return Arrays.asList("§7玩15场超级战墙 §b(§6" + games + "§b/§615§b)", "§7在超级战墙中杀死25名玩家 §b(§6" + kills + "§b/§625§b)");
                }

                public List<String> getRewardInfo() {
                    return Arrays.asList("§8+§6" + StringUtils.formattedCoins(3500) + " §7超级战墙硬币");
                }

                public void giveRewarad(GamePlayer gamePlayer) {
                    gamePlayer.getPlayerStats().giveCoins(3500);
                }

                public boolean isFinish(TaskStatsContainer container) {
                    int games = container.getJsonObject().get("games").getAsInt();
                    int kills = container.getJsonObject().get("kills").getAsInt();
                    return games >= 15 && kills >= 25;
                }

                public JsonObject defaultData() {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("games", 0);
                    jsonObject.addProperty("kills", 0);
                    return jsonObject;
                }
            });
            registerChallenge(new Challenge(1, "凋零") {
                public List<String> getInfo() {
                    return Arrays.asList("§7在一局游戏中对凋零造成", "§7至少200点伤害。");
                }

                public List<String> getRewardInfo() {
                    return Arrays.asList("§8+§6" + StringUtils.formattedCoins(100) + " §7超级战墙硬币");
                }

                public void giveRewarad(GamePlayer gamePlayer) {
                    gamePlayer.getPlayerStats().giveCoins(100);
                }
            });
            registerChallenge(new Challenge(2, "保卫者") {
                public List<String> getInfo() {
                    return Arrays.asList("§7在守卫你的凋零时,", "§7取得了至少10次击杀/助攻。");
                }

                public List<String> getRewardInfo() {
                    return Arrays.asList("§8+§6" + StringUtils.formattedCoins(100) + " §7超级战墙硬币");
                }

                public void giveRewarad(GamePlayer gamePlayer) {
                    gamePlayer.getPlayerStats().giveCoins(100);
                }
            });
            registerChallenge(new Challenge(3, "狂怒") {
                public List<String> getInfo() {
                    return Arrays.asList("§7在一局游戏中获得最终击杀前三名。");
                }

                public List<String> getRewardInfo() {
                    return Arrays.asList("§8+§6" + StringUtils.formattedCoins(100) + " §7超级战墙硬币");
                }

                public void giveRewarad(GamePlayer gamePlayer) {
                    gamePlayer.getPlayerStats().giveCoins(100);
                }
            });
            registerChallenge(new Challenge(4, "翻盘") {
                public List<String> getInfo() {
                    return Arrays.asList("§7在己方凋零已经死亡的情况下赢得一局游戏。");
                }

                public List<String> getRewardInfo() {
                    return Arrays.asList("§8+§6" + StringUtils.formattedCoins(100) + " §7超级战墙硬币");
                }

                public void giveRewarad(GamePlayer gamePlayer) {
                    gamePlayer.getPlayerStats().giveCoins(100);
                }
            });
            Iterator var0 = getChallenges().iterator();

            while (var0.hasNext()) {
                Challenge challenge = (Challenge) var0.next();
                defaultChallenge.addProperty(String.valueOf(challenge.getId()), 0);
                defaultChallenge.addProperty(challenge.getId() + "_lastFinished", "2019-01-01");
            }

            registered = true;
            return true;
        }
    }

    public static void addProgress(GamePlayer gamePlayer, int taskId, String name, int amount) {
        addProgress(gamePlayer, taskId, name, amount, true);
    }

    public static void addProgress(final GamePlayer gamePlayer, int taskId, String name, int amount, boolean message) {
        final Task task = getTask(taskId);
        if (task != null) {
            final TaskStatsContainer container = gamePlayer.getPlayerStats().getTaskStats(task);
            if (container.isAccept() && !task.isFinish(container) && Task.isLater(Task.current(), container.getLastFinished(), task.getType())) {
                container.addProgress(name, amount);
            }

            if (message) {
                Bukkit.getScheduler().runTaskLater(MegaWallsLobby.getInstance(), new Runnable() {
                    public void run() {
                        if (container.isAccept() && task.isFinish(container) && Task.isLater(Task.current(), container.getLastFinished(), task.getType())) {
                            container.updateAccept(false);
                            container.setFinished();
                            task.giveRewarad(gamePlayer);
                            gamePlayer.sendMessage(" ");
                            gamePlayer.sendMessage("§a" + task.getType().getName() + "任务: " + task.getName() + "已完成！");
                            Iterator var1 = task.getRewardInfo().iterator();

                            while (var1.hasNext()) {
                                String line = (String) var1.next();
                                gamePlayer.sendMessage(" " + line);
                            }

                            gamePlayer.sendMessage(" ");
                        }

                    }
                }, 40L);
            }

        }
    }

    public static void addChallenge(final GamePlayer gamePlayer, final int challengeId, int amount) {
        final Challenge challenge = getChallenge(challengeId);
        if (challenge != null) {
            JsonObject jsonObject = gamePlayer.getPlayerStats().getChallenges();
            if (!challenge.isFinish(jsonObject)) {
                gamePlayer.getPlayerStats().addChallenge(challengeId, amount);
            }

            Bukkit.getScheduler().runTaskLater(MegaWallsLobby.getInstance(), new Runnable() {
                public void run() {
                    if (challenge.isFinish(gamePlayer.getPlayerStats().getChallenges())) {
                        gamePlayer.getPlayerStats().setChallengeFinished(challengeId);
                    }

                    challenge.giveRewarad(gamePlayer);
                    gamePlayer.sendMessage(" ");
                    gamePlayer.sendMessage("§a" + challenge.getName() + "已完成！");
                    Iterator var1 = challenge.getRewardInfo().iterator();

                    while (var1.hasNext()) {
                        String line = (String) var1.next();
                        gamePlayer.sendMessage(" " + line);
                    }

                    gamePlayer.sendMessage(" ");
                    gamePlayer.sendMessage("§7你今日还可以完成§e" + (10 - gamePlayer.getPlayerStats().getChallenge(challengeId)) + "§7个挑战。");
                    gamePlayer.sendMessage(" ");
                }
            }, 40L);
        }
    }
}
