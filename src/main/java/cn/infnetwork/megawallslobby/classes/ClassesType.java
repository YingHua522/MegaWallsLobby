package cn.infnetwork.megawallslobby.classes;

public enum ClassesType {
    NOVICE("起始", 0),
    NORMAL("普通", 1),
    MYTHIC("神话", 2);

    private String name;
    private int priority;

    private ClassesType(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return this.name;
    }

    public int getPriority() {
        return this.priority;
    }
}
