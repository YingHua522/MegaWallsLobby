package cn.infnetwork.megawallslobby.hologram;

import cn.infnetwork.megawallslobby.MegaWallsLobby;
import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.ClassesManager;
import cn.infnetwork.megawallslobby.database.DataBase;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.game.GamePlayer.TopToggle;
import com.gmail.filoghost.holographicdisplays.api.Hologram;
import com.gmail.filoghost.holographicdisplays.api.HologramsAPI;
import com.gmail.filoghost.holographicdisplays.api.line.TextLine;
import org.bukkit.Location;
import org.bukkit.Sound;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HologramManager implements Runnable {
    private static final Location location = MegaWallsLobby.getInstance().getConfig().getBlockLocation("hologram-location");
    private static final DataBase database = MegaWallsLobby.getInstance().getDataBase();
    private final Map<GamePlayer, Hologram> hologramMap = new HashMap<>();
    private final Map<GamePlayer, Hologram> hologramWinsMap = new HashMap<>();
    private final Map<GamePlayer, Hologram> hologramFkMap = new HashMap<>();
    private final Map<Classes, List<ResultLine>> winsResult = new HashMap<>();
    private final Map<Classes, List<ResultLine>> fkResult = new HashMap<>();

    public void createHologram(GamePlayer gamePlayer) {
        Hologram hologram = HologramsAPI.createHologram(MegaWallsLobby.getInstance(), location.clone().add(-5.0d, 0.0d, 0.0d));
        hologram.getVisibilityManager().setVisibleByDefault(false);
        hologram.getVisibilityManager().showTo(gamePlayer.getPlayer());
        updateHologram(gamePlayer, hologram);
        this.hologramMap.put(gamePlayer, hologram);
        Hologram hologramWins = HologramsAPI.createHologram(MegaWallsLobby.getInstance(), location.clone());
        hologramWins.getVisibilityManager().setVisibleByDefault(false);
        hologramWins.getVisibilityManager().showTo(gamePlayer.getPlayer());
        updateWins(hologramWins, gamePlayer.getTopToggle().now());
        this.hologramWinsMap.put(gamePlayer, hologramWins);
        Hologram hologramFk = HologramsAPI.createHologram(MegaWallsLobby.getInstance(), location.clone().add(5.0d, 0.0d, 0.0d));
        hologramFk.getVisibilityManager().setVisibleByDefault(false);
        hologramFk.getVisibilityManager().showTo(gamePlayer.getPlayer());
        updateFk(hologramFk, gamePlayer.getTopToggle().now());
        this.hologramFkMap.put(gamePlayer, hologramFk);
    }

    public void updateHologram(GamePlayer gamePlayer) {
        updateHologram(gamePlayer, this.hologramMap.get(gamePlayer));
        updateWins(this.hologramWinsMap.get(gamePlayer), gamePlayer.getTopToggle().now());
        updateFk(this.hologramFkMap.get(gamePlayer), gamePlayer.getTopToggle().now());
    }

    public void removeHologram(GamePlayer gamePlayer) {
        this.hologramMap.get(gamePlayer).delete();
        this.hologramMap.remove(gamePlayer);
        this.hologramWinsMap.get(gamePlayer).delete();
        this.hologramWinsMap.remove(gamePlayer);
        this.hologramFkMap.get(gamePlayer).delete();
        this.hologramFkMap.remove(gamePlayer);
    }

    private void updateHologram(GamePlayer gamePlayer, Hologram hologram) {
        hologram.clearLines();
        hologram.appendTextLine("§b§l§n点击切换！");
        List<Classes> list = GamePlayer.TopToggle.classesList;
        int index = gamePlayer.getTopToggle().getIndex();
        createClickableLine(hologram, "§a§l" + list.get(index).getDisplayName());
        for (int amount = 0; amount < 9; amount++) {
            index++;
            if (index >= list.size()) {
                index = 0;
            }
            createClickableLine(hologram, "§7" + list.get(index).getDisplayName());
        }
    }

    private void updateWins(Hologram hologram, Classes classes) {
        hologram.clearLines();
        hologram.appendTextLine("§b§l" + classes.getDisplayName() + " 胜场数");
        for (int i = 1; i <= 10; i++) {
            ResultLine resultLine = getResultLine(this.winsResult.get(classes), i);
            if (resultLine != null) {
                createClickableLine(hologram, "§e" + resultLine.getRank() + ". §7" + resultLine.getName() + " - §e" + resultLine.getValue());
            }
        }
    }

    private void updateFk(Hologram hologram, Classes classes) {
        hologram.clearLines();
        hologram.appendTextLine("§b§l" + classes.getDisplayName() + " 最终击杀");
        for (int i = 1; i <= 10; i++) {
            ResultLine resultLine = getResultLine(this.fkResult.get(classes), i);
            if (resultLine != null) {
                createClickableLine(hologram, "§e" + resultLine.getRank() + ". §7" + resultLine.getName() + " - §e" + resultLine.getValue());
            }
        }
    }

    private ResultLine getResultLine(List<ResultLine> list, int rank) {
        for (ResultLine resultLine : list) {
            if (resultLine.getRank() == rank) {
                return resultLine;
            }
        }
        return null;
    }

    private void createClickableLine(Hologram hologram, String text) {
        TextLine textLine = hologram.appendTextLine(text);
        textLine.setTouchHandler(player -> {
            GamePlayer gamePlayer = GamePlayer.get(player.getUniqueId());
            if (gamePlayer != null) {
                gamePlayer.getTopToggle().next();
            }
            if (gamePlayer != null) {
                gamePlayer.sendMessage("§a正在展示§b§l" + TopToggle.classesList.get(gamePlayer.getTopToggle().getIndex()).getDisplayName() + "§a排名！");
            }
            if (gamePlayer != null) {
                gamePlayer.playSound(Sound.CLICK, 1.0f, 3.0f);
            }
            HologramManager.this.updateHologram(gamePlayer);
        });
    }

    @Override // java.lang.Runnable
    public void run() {
        for (Classes classes : ClassesManager.getClasses()) {
            try {
                ResultSet rs = database.getDataBaseCore().executeQuery("select * from classes_" + classes.getName() + " order by wins desc limit 10;");
                List<ResultLine> list = new ArrayList<>();
                int rank = 1;
                while (rs.next()) {
                    String name = rs.getString("realname");
                    int wins = rs.getInt("wins");
                    list.add(new ResultLine(rank, name, wins));
                    rank++;
                }
                this.winsResult.put(classes, list);
                ResultSet rs2 = database.getDataBaseCore().executeQuery("select * from classes_" + classes.getName() + " order by finalKills desc limit 10;");
                List<ResultLine> list2 = new ArrayList<>();
                int rank2 = 1;
                while (rs2.next()) {
                    String name2 = rs2.getString("realname");
                    int finalKills = rs2.getInt("finalKills");
                    list2.add(new ResultLine(rank2, name2, finalKills));
                    rank2++;
                }
                this.fkResult.put(classes, list2);
            } catch (SQLException ignored) {
            }
        }
    }
}
