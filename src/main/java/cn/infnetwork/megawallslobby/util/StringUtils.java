package cn.infnetwork.megawallslobby.util;

import java.text.DecimalFormat;

public class StringUtils {
    private static final DecimalFormat coinsFormat = new DecimalFormat("#,###");

    public StringUtils() {
    }

    public static String formattedCoins(int coins) {
        return coinsFormat.format((long) coins);
    }

    public static String upgradeBar(int level, int max) {
        StringBuffer sb = new StringBuffer("§8");

        for (int i = 0; i < max; ++i) {
            if (i >= level) {
                sb.append("▒");
            } else {
                sb.append("█");
            }
        }

        return sb.toString();
    }

    public static String percent(double value) {
        DecimalFormat decimalFormat = new DecimalFormat("0%");
        return decimalFormat.format(value);
    }

    public static String level(int level) {
        switch (level) {
            case 1:
                return "I";
            case 2:
                return "II";
            case 3:
                return "III";
            case 4:
                return "IV";
            case 5:
                return "V";
            default:
                return "I";
        }
    }

    public static String formatLongTime(long time) {
        int hour = (int) Math.floor((double) (time / 3600000L));
        int min = (int) Math.floor((double) (time / 60000L));
        return hour > 0 ? hour + "小时" : min + "分钟";
    }
}
