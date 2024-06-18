package cn.infnetwork.megawallslobby.effect;

import java.text.SimpleDateFormat;
import java.util.*;

public class EffectManager {
    private static final SimpleDateFormat format = new SimpleDateFormat("MM/dd/yy");
    private static final List<HologramEffect> hologramEffects = new ArrayList();
    private static final List<KillMessage> killMessages = new ArrayList();

    static {
        registerHologramEffect(HologramEffect.DEFAULT);
        registerHologramEffect("2", "#完爆", 1);
        registerHologramEffect("3", "获得好评", 1);
        registerHologramEffect("4", "我的妈妈呀", 1);
        registerHologramEffect("5", "简单的要命！", 1);
        registerHologramEffect("6", "#不用开镜,也能爆头！", 1);
        registerHologramEffect("7", "L", 5);
        registerKillMessage(KillMessage.DEFAULT);
        Map<String, String> messages = new HashMap();
        messages.put("Arrow", "中箭无数");
        messages.put("Snowball", "被冻住了");
        messages.put("Attack", "被逼入了末路");
        messages.put("Poison", "输了一场饮酒比赛");
        messages.put("Explode", "被炸药炸死");
        messages.put("Magic", "输掉了对决");
        registerKillMessage("2", "西部", 5, messages);
        messages = new HashMap();
        messages.put("Arrow", "被击倒");
        messages.put("Snowball", "折戟沉沙");
        messages.put("Attack", "被化为灰烬");
        messages.put("Poison", "被融化");
        messages.put("Explode", "被焚烧");
        messages.put("Magic", "被蒸发");
        registerKillMessage("3", "火焰", 5, messages);
        messages = new HashMap();
        messages.put("Arrow", "被丘比特之箭射中");
        messages.put("Snowball", "受到冷淡");
        messages.put("Attack", "被抱得太紧");
        messages.put("Poison", "饮下了爱情药水");
        messages.put("Explode", "被爱情炸弹击中");
        messages.put("Magic", "不敌你");
        registerKillMessage("4", "爱情", 5, messages);
        messages = new HashMap();
        messages.put("Arrow", "被远距离杀死");
        messages.put("Snowball", "被公正地终结");
        messages.put("Attack", "被净化了");
        messages.put("Poison", "被神圣之水杀死");
        messages.put("Explode", "被施以复仇的正义");
        messages.put("Magic", "被归为尘土");
        registerKillMessage("5", "圣骑士", 5, messages);
        messages = new HashMap();
        messages.put("Arrow", "被射杀");
        messages.put("Snowball", "被雪球砸死");
        messages.put("Attack", "被塞进了戴维 · 琼斯的箱子");
        messages.put("Poison", "被朗姆酒杀死");
        messages.put("Explode", "被加农炮击中");
        messages.put("Magic", "被魔法击杀");
        registerKillMessage("6", "海盗", 5, messages);
        messages = new HashMap();
        messages.put("Arrow", "被烤成了肉串");
        messages.put("Snowball", "被撒上了辣椒粉");
        messages.put("Attack", "被切成片");
        messages.put("Poison", "被煮焦了");
        messages.put("Explode", "被深度油炸");
        messages.put("Magic", "被煮开了");
        registerKillMessage("7", "烧烤", 5, messages);
    }

    public EffectManager() {
    }

    public static HologramEffect getHologramEffect(String name) {
        Iterator var1 = hologramEffects.iterator();

        HologramEffect hologramEffect;
        do {
            if (!var1.hasNext()) {
                return HologramEffect.DEFAULT;
            }

            hologramEffect = (HologramEffect) var1.next();
        } while (!hologramEffect.getName().equals(name));

        return hologramEffect;
    }

    public static KillMessage getKillMessage(String name) {
        Iterator var1 = killMessages.iterator();

        KillMessage killMessage;
        do {
            if (!var1.hasNext()) {
                return KillMessage.DEFAULT;
            }

            killMessage = (KillMessage) var1.next();
        } while (!killMessage.getName().equals(name));

        return killMessage;
    }

    public static void registerHologramEffect(HologramEffect hologramEffect) {
        hologramEffects.add(hologramEffect);
    }

    public static void registerHologramEffect(String name, String line, int price) {
        hologramEffects.add(new HologramEffect(name, line, price));
    }

    public static void registerKillMessage(KillMessage killMessage) {
        killMessages.add(killMessage);
    }

    public static void registerKillMessage(String name, String displayName, int price, Map<String, String> messages) {
        killMessages.add(new KillMessage(name, displayName, price, messages));
    }

    public static List<HologramEffect> getHologramEffects() {
        return hologramEffects;
    }

    public static List<KillMessage> getKillMessages() {
        return killMessages;
    }
}
