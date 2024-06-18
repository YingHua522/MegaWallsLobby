package cn.infnetwork.megawallslobby.task;

import cn.infnetwork.megawallslobby.MegaWallsLobby;
import cn.infnetwork.megawallslobby.config.FileConfig;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.scoreboard.FixedBody;
import cn.infnetwork.megawallslobby.scoreboard.Line;
import cn.infnetwork.megawallslobby.scoreboard.SidebarBoard;
import cn.infnetwork.megawallslobby.scoreboard.TextLine;
import cn.infnetwork.megawallslobby.stats.PlayerStats;
import cn.infnetwork.megawallslobby.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ScoreBoardTimer implements Runnable {
    public static final Map<GamePlayer, SidebarBoard> scoreboards = new HashMap();
    public static final FileConfig congig = MegaWallsLobby.getInstance().getConfig();

    GamePlayer gamePlayer;

    public ScoreBoardTimer(GamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

    public void run() {
        SidebarBoard b;
        String WAIT_TITLE = "§c§l超级战墙";
        if (!scoreboards.containsKey(gamePlayer)) {
            b = SidebarBoard.of(MegaWallsLobby.getInstance(), gamePlayer.getPlayer());
            gamePlayer.getPlayer().setScoreboard(b.getScoreboard());
            b.setHead(TextLine.of(WAIT_TITLE));
            b.setBody(this.getBody(gamePlayer));
            scoreboards.put(gamePlayer, b);
        } else {
            b = scoreboards.get(gamePlayer);
            gamePlayer.getPlayer().setScoreboard(b.getScoreboard());
            b.setHead(TextLine.of(WAIT_TITLE));
            b.setBody(this.getBody(gamePlayer));
            b.update();
        }

    }

    private FixedBody getBody(GamePlayer gamePlayer) {
        ArrayList<Line> lines = new ArrayList<>();
        PlayerStats stats = gamePlayer.getPlayerStats();
        lines.add(TextLine.of(" "));
        lines.add(TextLine.of("§f已选择的职业:"));
        lines.add(TextLine.of("§a" + stats.getSelected().getDisplayName()));
        lines.add(TextLine.of("  "));
        lines.add(TextLine.of("§f击杀数: §a" + stats.getKills()));
        lines.add(TextLine.of("§f最终击杀数: §a" + stats.getFinalKills()));
        lines.add(TextLine.of("§f胜场次数: §a" + stats.getWins()));
        lines.add(TextLine.of("§fMVP次数: §a" + stats.getMvp()));
        lines.add(TextLine.of("   "));
        lines.add(TextLine.of("§f硬币: §6" + StringUtils.formattedCoins(stats.getCoins())));
        if (stats.getMythicDust() >=1) {
            lines.add(TextLine.of("§f神话之尘: §e" + stats.getMythicDust()));
        }
        lines.add(TextLine.of("    "));
        if (MegaWallsLobby.isActiveMode()) {
            lines.add(TextLine.of("§e§l快乐时段"));
            lines.add(TextLine.of("§6" + MegaWallsLobby.booster + "倍硬币,持续§a§l" + this.getFormattedTime(MegaWallsLobby.getActiveMode() - System.currentTimeMillis())));
            lines.add(TextLine.of("     "));
        }
        if (MegaWallsLobby.isMythicMode()) {
            lines.add(TextLine.of("§e§l神话游戏"));
            lines.add(TextLine.of("§6" + "神话职业满级，" + MegaWallsLobby.booster + "倍硬币,持续§a§l" + this.getFormattedTime(MegaWallsLobby.getMythicMode() - System.currentTimeMillis())));
            lines.add(TextLine.of("      "));
        }
        lines.add(TextLine.of(congig.getString("server-name").replace("&","§")));
        return FixedBody.of(lines);
    }

    private String getFormattedTime(long l) {
        int time = (int) l / 1000;
        int min = (int) Math.floor((double) time / 60);
        int sec = time % 60;
        String minStr = min < 10 ? "0" + min : String.valueOf(min);
        String secStr = sec < 10 ? "0" + sec : String.valueOf(sec);
        return minStr + ":" + secStr;
    }
}
