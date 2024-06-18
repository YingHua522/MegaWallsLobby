package cn.infnetwork.megawallslobby.inventory;

import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.reward.Challenge;
import cn.infnetwork.megawallslobby.reward.RewardManager;
import cn.infnetwork.megawallslobby.reward.Task;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;
import cn.infnetwork.megawallslobby.stats.TaskStatsContainer;
import cn.infnetwork.megawallslobby.util.ItemBuilder;
import cn.infnetwork.megawallslobby.util.StringUtils;
import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.SmartInventory;
import fr.minuskube.inv.SmartInventory.Builder;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskMenu {

    public static SmartInventory build() {
        Builder builder = SmartInventory.builder();
        builder.title("超级战墙");
        builder.size(5, 9);
        builder.closeable(true);
        builder.provider(new InventoryProvider() {
            public void init(Player player, InventoryContents contents) {
                GamePlayer gamePlayer = GamePlayer.get(player.getUniqueId());
                contents.set(0, 4, createTaskAndChallengeItem());
                createTasks(contents, gamePlayer, player);
                createChallenges(contents, gamePlayer, player);
                if (gamePlayer != null) {
                    createAutoAcceptTaskItem(contents, gamePlayer, player);
                }
            }

            public void update(Player player, InventoryContents contents) {
            }
        });
        return builder.build();
    }

    private static ClickableItem createTaskAndChallengeItem() {
        return ClickableItem.of((new ItemBuilder(Material.SOUL_SAND)).setDisplayName("§a超级战墙 任务与挑战").setLore(new String[]{"§7查看所有参与超级战墙", "§7可完成的任务和挑战。"}).build(), (e) -> {});
    }

    private static void createTasks(InventoryContents contents, GamePlayer gamePlayer, Player player) {
        int column = 2;
        for (int id = 1; id <= 5; ++id) {
            Task task = RewardManager.getTask(id);
            TaskStatsContainer container = gamePlayer.getPlayerStats().getTaskStats(task);
            contents.set(id == 3 ? 2 : 1, column, createTaskItem(task, container, gamePlayer, player, contents));
            ++column;
        }
    }

    private static ClickableItem createTaskItem(Task task, TaskStatsContainer container, GamePlayer gamePlayer, Player player, InventoryContents contents) {
        ItemBuilder itemBuilderx = (new ItemBuilder(task.getId() == 3 ? Material.SKULL_ITEM : Material.PAPER, 1, (byte) (task.getId() == 3 ? 3 : 0))).setDisplayName("§a" + task.getType().getName() + "任务: " + task.getName());
        List<String> lorexx = new ArrayList<>(task.getInfo(container));
        lorexx.add(" ");
        lorexx.add("§7奖励:");
        lorexx.addAll(task.getRewardInfo());
        lorexx.add(" ");
        lorexx.add(task.getType().getInfo());
        lorexx.add(" ");
        if (!Task.isLater(Task.current(), container.getLastFinished(), task.getType())) {
            lorexx.add("§c还不能开始此任务！");
        } else if (container.isAccept() && !task.isFinish(container)) {
            lorexx.add("§a已开始此任务！");
            itemBuilderx.addGlow();
        } else {
            lorexx.add("§e点击开始此任务！");
        }

        itemBuilderx.setLore(lorexx);
        return ClickableItem.of(itemBuilderx.build(), (e) -> {
            if (!Task.isLater(Task.current(), container.getLastFinished(), task.getType())) {
                gamePlayer.playSound(Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
                player.sendMessage("§c还不能开始此任务！");
            } else if (container.isAccept() && !task.isFinish(container)) {
                gamePlayer.playSound(Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
                player.sendMessage("§c你已经开始了 §6" + task.getType().getName() + "任务: " + task.getName() + " §c任务！");
                player.sendMessage("§e状态:");

                for (String message : task.getInfo(container)) {
                    player.sendMessage(message);
                }
            } else {
                gamePlayer.playSound(Sound.NOTE_PLING, 1.0F, 3.0F);
                container.accept();
                player.sendMessage("§a你开始了 §6" + task.getType().getName() + "任务: " + task.getName() + " §a任务！");
                contents.inventory().open(player);
            }
        });
    }

    private static void createChallenges(InventoryContents contents, GamePlayer gamePlayer, Player player) {
        int column = 2;
        for (int id = 1; id <= 4; ++id) {
            Challenge challenge = RewardManager.getChallenge(id);
            contents.set(4, id >= 3 ? column + 1 : column, createChallengeItem(challenge, gamePlayer, player));
            ++column;
        }
    }

    private static ClickableItem createChallengeItem(Challenge challenge, GamePlayer gamePlayer, Player player) {
        ItemBuilder itemBuilder = (new ItemBuilder(Material.EMPTY_MAP)).setDisplayName("§a" + challenge.getName() + "挑战");
        List<String> lorex = new ArrayList();
        lorex.addAll(challenge.getInfo());
        lorex.add(" ");
        lorex.add("§7奖励:");
        lorex.addAll(challenge.getRewardInfo());
        lorex.add(" ");
        lorex.add("§8§o你每天可以完成多个");
        lorex.add("§8§o相同的挑战,但每局");
        lorex.add("§8§o游戏只能完成一次。");
        lorex.add(" ");
        if (!Challenge.isLater(Challenge.current(), gamePlayer.getPlayerStats().getChallengeLastFinished(challenge.getId()))) {
            lorex.add("§c今天已经完成了该挑战！");
        } else {
            lorex.add("§7今天剩余可完成挑战次数: §a" + (10 - gamePlayer.getPlayerStats().getChallenge(challenge.getId())));
        }

        itemBuilder.setLore(lorex);
        return ClickableItem.of(itemBuilder.build(), (e) -> {
            gamePlayer.playSound(Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
            player.sendMessage("§c你不需要手动启用这些挑战！加入游戏可自动启用！");
        });
    }

    private static void createAutoAcceptTaskItem(InventoryContents contents, GamePlayer gamePlayer, Player player) {
        ItemBuilder itemBuilderxx = (new ItemBuilder(Material.INK_SACK, 1, (byte) (gamePlayer.getPlayerStats().isAutoAccept() ? 10 : 8))).setDisplayName("§a自动接受任务:" + (gamePlayer.getPlayerStats().isAutoAccept() ? "§a开启" : "§c关闭"));
        List<String> lore = new ArrayList<>();
        lore.add("§7点击开启自动");
        lore.add("§7接受你所进入的");
        lore.add("§7大厅中的任务。");
        lore.add(" ");
        if (!player.hasPermission("MegaWalls.autoaccept")) {
            lore.add("§c没有足够权限使用此功能！");
        } else {
            lore.add("§e点击" + (!gamePlayer.getPlayerStats().isAutoAccept() ? "开启" : "关闭") + "！");
        }

        itemBuilderxx.setLore(lore);
        contents.set(4, 8, ClickableItem.of(itemBuilderxx.build(), (e) -> {
            if (!player.hasPermission("MegaWalls.autoaccept")) {
                gamePlayer.playSound(Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
                player.sendMessage("§c没有足够权限使用此功能！");
            } else {
                lore.add("§e点击" + (!gamePlayer.getPlayerStats().isAutoAccept() ? "开启" : "关闭") + "！");
                gamePlayer.getPlayerStats().setAutoAccept(!gamePlayer.getPlayerStats().isAutoAccept());
                player.sendMessage("§a你" + (gamePlayer.getPlayerStats().isAutoAccept() ? "开启" : "关闭") + "了自动接受任务！");
                contents.inventory().open(player);
            }
        }));
    }

    public static String getUpgradeBar(Skill skill, KitStatsContainer kitStats, int level, int max) {
        return StringUtils.upgradeBar(level, max) + " §7" + skill.getName();
    }

    public static String getUpgradeBar(String name, KitStatsContainer kitStats, int level, int max) {
        return StringUtils.upgradeBar(level, max) + " §7" + name;
    }

    public static String getMasterStar(int level) {
        if (level < 2) {
            return "";
        } else {
            StringBuilder sb = new StringBuilder(" §6");

            for (int i = 2; i <= level; ++i) {
                sb.append("✫");
            }

            return sb.toString();
        }
    }
}