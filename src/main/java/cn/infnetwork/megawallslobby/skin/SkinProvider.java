package cn.infnetwork.megawallslobby.skin;


import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.ClassesSkin;
import cn.infnetwork.megawallslobby.game.GamePlayer;

import java.util.List;

public interface SkinProvider {
    List<ClassesSkin> getSkinsForClass(Classes classes, GamePlayer gamePlayer);
}
