package cn.infnetwork.megawallslobby.inventory;
/*
 * @Author huanmeng_qwq
 * @Date 2020/8/22 19:54
 * MegaWallsLobby
 */

import cn.infnetwork.megawallslobby.MegaWallsLobby;
import cn.infnetwork.megawallslobby.command.CommandFastJoin;
import cn.infnetwork.megawallslobby.database.KeyValue;
import cn.infnetwork.megawallslobby.game.Server;
import cn.infnetwork.megawallslobby.stats.SQLSettings;
import cn.infnetwork.megawallslobby.util.ItemBuilder;
import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.SmartInventory;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class MatchServerMenu {
    public static SmartInventory build() {
        final SmartInventory.Builder inv = SmartInventory.builder();
        inv.size(6, 9);
        inv.type(InventoryType.CHEST);
        inv.title("超级战墙");
        inv.provider(new InventoryProvider() {
            @Override
            public void init(Player player, InventoryContents contents) {
                int row = 1;
                int column = 1;
                for (Server s : getWaitServer()) {
                    contents.set(row, column, ClickableItem.of(new ItemBuilder(Material.PAPER).setDisplayName("&a" + s.getMapName()).setLore("&a" + s.getOnline() + "&b/" + "&e80", "   ", "&a等待中..").build(), e -> {
                        if (player.hasPermission("megawalls.mapseletor")) {
                            e.setCancelled(true);
                            MegaWallsLobby.tpServer(player, MegaWallsLobby.translateServerByGame(s));
                        } else {
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c你没有权限使用"));
                        }
                    }));
                    if (column + 1 > 7) {
                        ++row;
                        column = 1;
                    } else {
                        ++column;
                    }
                    if (row == 4) break;
                }
                contents.set(4, 4, ClickableItem.of(new ItemBuilder(Material.FIREWORK).setDisplayName("&a随机地图").setLore("&8Normal", "   ", "&a▶点击进行游戏").build(), e -> {
                    e.setCancelled(true);
                    MegaWallsLobby.tpServer(player, MegaWallsLobby.translateServerByGame(CommandFastJoin.fastJoin()));
                }));

                contents.set(5, 4, ClickableItem.of(new ItemBuilder(Material.ARROW).setDisplayName("&7返回到超级战墙").build(), e -> {
                    e.setCancelled(true);
                    buildMain().open(player);
                }));

            }

            @Override
            public void update(Player var1, InventoryContents contents) {
            }
        });
        return inv.build();
    }

    public static SmartInventory buildMain() {
        SmartInventory.Builder builder = SmartInventory.builder();
        builder.size(4, 9);
        builder.type(InventoryType.CHEST);
        builder.title("游玩超级战墙");
        builder.provider(new InventoryProvider() {
            @Override
            public void init(Player player, InventoryContents contents) {
                contents.set(1, 3, ClickableItem.of(new ItemBuilder(Material.SOUL_SAND, 1).setDisplayName("&a超级战墙 (普通模式)").setLore("&7游玩超级战墙普通模式", " ", "&e点击开始游戏").build(), e -> {
                    e.setCancelled(true);
                    MegaWallsLobby.tpServer(player, MegaWallsLobby.translateServerByGame(CommandFastJoin.fastJoin()));
                }));

                contents.set(1, 5, ClickableItem.of(new ItemBuilder(Material.SIGN, 1).setDisplayName("&a地图选择器").setLore("&7从可用服务器列表中", "&7选择你想玩的服务器", " ", "&e点击浏览").build(), e -> {
                    e.setCancelled(true);
                    build().open(player);
                }));

                contents.set(3, 4, ClickableItem.of(new ItemBuilder(Material.BARRIER, 1).setDisplayName("&c关闭").build(), e -> {
                    e.setCancelled(true);
                    player.closeInventory();
                }));
                contents.set(3, 8, ClickableItem.of(new ItemBuilder(Material.ENDER_PEARL, 1).setDisplayName("&c点击这里重新加入！").setLore("&7如果你掉线了,点击这里可以重新回到游戏.").build(), e -> {
                    e.setCancelled(true);
                    player.closeInventory();
                    Bukkit.dispatchCommand(player, "rejoin");
                }));
            }

            @Override
            public void update(Player player, InventoryContents contents) {

            }
        });
        return builder.build();
    }

    public static List<Server> getWaitServer() {
        List<Server> servers = new ArrayList<>();
        for (KeyValue keyValue : MegaWallsLobby.getInstance().getDataBase().dbSelectA(SQLSettings.TABLE_GAME, new KeyValue("game", "game").add("mapname", "mapname"), new KeyValue("state", "lobby"))) {
            String s = MegaWallsLobby.getInstance().getDataBase().dbSelectFirst(SQLSettings.TABLE_ONLINE, "online", new KeyValue("game", keyValue.getString("game")));
            servers.add(new Server().setName(keyValue.getString("game")).setMapName(keyValue.getString("mapname")).setOnline(s != null ? Integer.parseInt(s) : 0));
        }
        return servers;
    }
}
