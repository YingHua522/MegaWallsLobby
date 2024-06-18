package cn.infnetwork.megawallslobby.reward;

import cn.infnetwork.megawallslobby.game.GamePlayer;
import com.google.gson.JsonObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public abstract class Challenge {
    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    private int id;
    private String name;

    public Challenge(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static boolean isLater(String date1, String date2) {
        try {
            long time1 = format.parse(date1).getTime();
            long time2 = format.parse(date2).getTime();
            return time1 - time2 >= 86400000L;
        } catch (ParseException var6) {
            return false;
        }
    }

    public static String current() {
        return format.format(new Date());
    }

    public abstract List<String> getInfo();

    public abstract List<String> getRewardInfo();

    public abstract void giveRewarad(GamePlayer var1);

    public boolean isFinish(JsonObject jsonObject) {
        return jsonObject.get(String.valueOf(this.id)).getAsInt() >= 10;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
