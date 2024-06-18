package cn.infnetwork.megawallslobby.stats;

import cn.infnetwork.megawallslobby.MegaWallsLobby;
import cn.infnetwork.megawallslobby.database.DataBase;
import cn.infnetwork.megawallslobby.database.KeyValue;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.reward.Task;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Iterator;
import java.util.Map.Entry;

public class TaskStatsContainer {
    private static DataBase database = MegaWallsLobby.getInstance().getDataBase();
    private GamePlayer gamePlayer;
    private Task task;
    private boolean accept;
    private JsonObject jsonObject;
    private String lastFinished;

    public TaskStatsContainer(GamePlayer gamePlayer, Task task, boolean accept, JsonObject jsonObject, String lastFinished) {
        this.gamePlayer = gamePlayer;
        this.task = task;
        this.accept = accept;
        this.jsonObject = jsonObject;
        this.lastFinished = lastFinished;
    }

    public void accept() {
        this.accept = true;
        JsonObject defaultData = this.task.defaultData();
        this.jsonObject = defaultData;
        database.dbUpdate("megawalls_reward_" + this.task.getId(), (new KeyValue("accept", "true")).add("progress", defaultData.toString()), new KeyValue("uuid", this.gamePlayer.getUuid().toString()));
    }

    public void updateAccept(boolean accept) {
        this.accept = accept;
        database.dbUpdate("megawalls_reward_" + this.task.getId(), new KeyValue("accept", String.valueOf(accept)), new KeyValue("uuid", this.gamePlayer.getUuid().toString()));
    }

    public void addProgress(String name, int amount) {
        JsonObject newJson = new JsonObject();
        Iterator var4 = this.jsonObject.entrySet().iterator();

        while (var4.hasNext()) {
            Entry<String, JsonElement> entry = (Entry) var4.next();
            if (((String) entry.getKey()).equals(name)) {
                newJson.addProperty(name, this.jsonObject.get(name).getAsInt() + amount);
            } else {
                newJson.add((String) entry.getKey(), (JsonElement) entry.getValue());
            }
        }

        this.jsonObject = newJson;
        database.dbUpdate("megawalls_reward_" + this.task.getId(), new KeyValue("progress", this.jsonObject.toString()), new KeyValue("uuid", this.gamePlayer.getUuid().toString()));
    }

    public void setFinished() {
        String current = Task.current();
        this.lastFinished = current;
        database.dbUpdate("megawalls_reward_" + this.task.getId(), new KeyValue("lastFinished", this.lastFinished), new KeyValue("uuid", this.gamePlayer.getUuid().toString()));
    }

    public GamePlayer getGamePlayer() {
        return this.gamePlayer;
    }

    public Task getTask() {
        return this.task;
    }

    public boolean isAccept() {
        return this.accept;
    }

    public void setAccept(boolean accept) {
        this.accept = accept;
    }

    public JsonObject getJsonObject() {
        return this.jsonObject;
    }

    public void setJsonObject(JsonObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public String getLastFinished() {
        return this.lastFinished;
    }

    public void setLastFinished(String lastFinished) {
        this.lastFinished = lastFinished;
    }
}
