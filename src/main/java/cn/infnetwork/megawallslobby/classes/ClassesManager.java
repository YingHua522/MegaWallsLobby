package cn.infnetwork.megawallslobby.classes;

import cn.infnetwork.megawallslobby.classes.mythic.assassin.Assassin;
import cn.infnetwork.megawallslobby.classes.mythic.automaton.Automaton;
import cn.infnetwork.megawallslobby.classes.mythic.dragon.Dragon;
import cn.infnetwork.megawallslobby.classes.mythic.lawless.Lawless;
import cn.infnetwork.megawallslobby.classes.mythic.mole.Mole;
import cn.infnetwork.megawallslobby.classes.normal.oldspider.OldSpider;
import cn.infnetwork.megawallslobby.classes.mythic.phoenix.Phoenix;
import cn.infnetwork.megawallslobby.classes.mythic.snowman.Snowman;
import cn.infnetwork.megawallslobby.classes.mythic.werewolf.Werewolf;
import cn.infnetwork.megawallslobby.classes.normal.arcane.Arcane;
import cn.infnetwork.megawallslobby.classes.normal.blaze.Blaze;
import cn.infnetwork.megawallslobby.classes.normal.cow.Cow;
import cn.infnetwork.megawallslobby.classes.normal.creeper.Creeper;
import cn.infnetwork.megawallslobby.classes.normal.dreadlord.Dreadlord;
import cn.infnetwork.megawallslobby.classes.normal.hunter.Hunter;
import cn.infnetwork.megawallslobby.classes.normal.pigman.Pigman;
import cn.infnetwork.megawallslobby.classes.normal.pirate.Pirate;
import cn.infnetwork.megawallslobby.classes.normal.puppet.Puppet;
import cn.infnetwork.megawallslobby.classes.normal.shaman.Shaman;
import cn.infnetwork.megawallslobby.classes.normal.shark.Shark;
import cn.infnetwork.megawallslobby.classes.normal.spider.Spider;
import cn.infnetwork.megawallslobby.classes.normal.squid.Squid;
import cn.infnetwork.megawallslobby.classes.novice.enderman.Enderman;
import cn.infnetwork.megawallslobby.classes.novice.him.HIM;
import cn.infnetwork.megawallslobby.classes.novice.random.Random;
import cn.infnetwork.megawallslobby.classes.novice.skeleton.Skeleton;
import cn.infnetwork.megawallslobby.classes.novice.zombie.Zombie;
import cn.infnetwork.megawallslobby.game.GamePlayer;

import java.util.*;

public class ClassesManager {
    private static final List<Classes> classesList = new ArrayList();
    private static boolean registered = false;

    public ClassesManager() {
    }

    public static Classes getClassesByName(String ClassesName) {
        Iterator var1 = classesList.iterator();

        Classes classes;
        do {
            if (!var1.hasNext()) {
                return null;
            }

            classes = (Classes) var1.next();
        } while (!classes.getName().equalsIgnoreCase(ClassesName));

        return classes;
    }

    public static void registerClasses(Classes classes) {
        classesList.add(classes);
    }

    public static void registerAll() {
        if (registered) {
        } else {
            registerClasses(new HIM());
            registerClasses(new Zombie());
            registerClasses(new Enderman());
            registerClasses(new Skeleton());
            registerClasses(new Shaman());
            registerClasses(new Puppet());
            registerClasses(new Spider());
            registerClasses(new Cow());
            registerClasses(new Pigman());
            registerClasses(new Squid());
            registerClasses(new Dreadlord());
            registerClasses(new Blaze());
            registerClasses(new Arcane());
            registerClasses(new Creeper());
            registerClasses(new Pirate());
            registerClasses(new Hunter());
            registerClasses(new Mole());
            registerClasses(new Werewolf());
            registerClasses(new Phoenix());
            registerClasses(new Assassin());
            registerClasses(new Lawless());
            registerClasses(new OldSpider());
            registerClasses(new Snowman());
            registerClasses(new Automaton());
            registerClasses(new Shark());
            registerClasses(new Dragon());
            registered = true;
        }
    }

    public static List<Classes> getNormalClasses() {
        List<Classes> list = new ArrayList();
        Iterator var1 = classesList.iterator();

        while (var1.hasNext()) {
            Classes classes = (Classes) var1.next();
            if (classes.getClassesType() == ClassesType.NORMAL) {
                list.add(classes);
            }
        }

        return list;
    }

    public static List<Classes> getMythicClasses() {
        List<Classes> list = new ArrayList();
        Iterator var1 = classesList.iterator();

        while (var1.hasNext()) {
            Classes classes = (Classes) var1.next();
            if (classes.getClassesType() == ClassesType.MYTHIC) {
                list.add(classes);
            }
        }

        return list;
    }

    public static List<Classes> getClasses() {
        return classesList;
    }

    public static List<Classes> sort(List<Classes> list) {
        Collections.sort(list, new Comparator<Classes>() {
            public int compare(Classes classes1, Classes classes2) {
                return classes1.getClassesType() == classes2.getClassesType() ? classes1.getDifficulty().getPriority() - classes2.getDifficulty().getPriority() : classes1.getClassesType().getPriority() - classes2.getClassesType().getPriority();
            }
        });
        return list;
    }

    public static Classes getSelected(GamePlayer gamePlayer) {
        return gamePlayer.getPlayerStats().getSelected();
    }
}
