package cn.infnetwork.megawallslobby.reward;

import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.TaskStatsContainer;
import com.google.gson.JsonObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public abstract class Task {
    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    private int id;
    private Task.Type type;
    private String name;

    public Task(int id, Task.Type type, String name) {
        this.id = id;
        this.type = type;
        this.name = name;
    }

    public static boolean isLater(String date1, String date2, Task.Type type) {
        try {
            long time1 = format.parse(date1).getTime();
            long time2 = format.parse(date2).getTime();
            long l = type == Task.Type.WEEKLY ? 604800000L : 86400000L;
            return time1 - time2 >= l;
        } catch (ParseException var9) {
            return false;
        }
    }

    public static String current() {
        return format.format(new Date());
    }

    public abstract List<String> getInfo(TaskStatsContainer var1);

    public abstract List<String> getRewardInfo();

    public abstract void giveRewarad(GamePlayer var1);

    public abstract boolean isFinish(TaskStatsContainer var1);

    public abstract JsonObject defaultData();

    public int getId() {
        return this.id;
    }

    public Task.Type getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public static enum Type {
        DAILY("每日"),
        MYTHIC("神话"),
        WEEKLY("每周");

        private String name;

        private Type(String name) {
            this.name = name;
        }

        public String getInfo() {
            return this == WEEKLY ? "§8§o每周任务可以每周完成一次。" : "§8§o每天只能完成一次每日任务。";
        }

        public String getName() {
            return this.name;
        }
    }
}
