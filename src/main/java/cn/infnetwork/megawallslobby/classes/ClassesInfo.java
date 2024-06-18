package cn.infnetwork.megawallslobby.classes;

public class ClassesInfo {
    public ClassesInfo() {
    }

    public static enum Orientation {
        WARRIOR("§2战士"),
        HURT("§c伤害"),
        TANK("§1坦克"),
        ASSIST("§d辅助"),
        AGILITY("§b敏捷"),
        CHARGER("§4冲锋者"),
        REMOTE("§3远程"),
        CONTROL("§6控场");

        private String text;

        private Orientation(String text) {
            this.text = text;
        }

        public String getText() {
            return this.text;
        }
    }

    public static enum Difficulty {
        ONE("§a●§7●●●", 1),
        TWO("§e●●§7●●", 2),
        THREE("§c●●●§7●", 3),
        FOUR("§4●●●●", 4);

        private String text;
        private int priority;

        private Difficulty(String text, int priority) {
            this.text = text;
            this.priority = priority;
        }

        public String getText() {
            return this.text;
        }

        public int getPriority() {
            return this.priority;
        }
    }
}
