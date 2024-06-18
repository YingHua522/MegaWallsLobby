package cn.infnetwork.megawallslobby.skin.herobrine;


import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.ClassesSkin;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.skin.SkinProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SnowHeroBrine implements SkinProvider {
    @Override
    public List<ClassesSkin> getSkinsForClass(Classes classes, GamePlayer gamePlayer) {
        List<ClassesSkin> skins = new ArrayList<>();
        if (classes.getName().equalsIgnoreCase("HIM")) {
            // 创建Warrior职业的皮肤
            ClassesSkin skin1 = new ClassesSkin("§a雪人HIM", "§a雪人HIM", Arrays.asList("§7一个披着大棉袄的Him","","§7时刻告诉自己要注意保暖不要着凉"), "ewogICJ0aW1lc3RhbXAiIDogMTcwOTM1Mzg1Nzc0NywKICAicHJvZmlsZUlkIiA6ICJmODRjNmE3OTBhNGU0NWUwODc5YmNkNDllYmQ0YzRlMiIsCiAgInByb2ZpbGVOYW1lIiA6ICJIZXJvYnJpbmUiLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWQ1OGFjNTc4ZDhkNDZiMDljNjFlNjUwOGNkOTFhNDI3NjA2ODI0MzQ0MjM0ZThlOGViMDgyY2FjMjhiNWI0MCIKICAgIH0KICB9Cn0=","FoApCYwCB70JV7Axld1kLBQf4QF2g4b6Dlh1V9V4iJqZkI8a2AqGgsBwiECrVmvNxve/2MnmRajVlaPKurlZZtg/J7vCUhLCkvy41AKH9B1Eu/A2sQtOZDnb0bHPo8u0EO4OjqHiHn6jHqaCrM2aLtxWOennV3ck/L2tM5vcCUt2xWTqgQLmdekxR0/sfHV6e4spgEZGXO9kpUejejwPVPbIHeesdjBmSsLnceDJPsqWiOLNoskUsWxsGxnhr7blpdx1H53l3NrD12wT/Pz3D5Tg3unS3ThQAwrfxWmPXMLjgcCTXhIb/xxNFJYXQJYq9aTCydW/j+YHimO2bPyCx8n/ihSpmOxrOUfAk79nQAhSleWQw0o0Lj25GsLrJiUarofao56KHa+L3D0eJZC3I/N5UcTmHHpdvI1tfdEkUpOgS0hdwNINiXi83QtniIS2ZBPuluDmJNM1mS+BopcDpyVt6gErwUItrbAMduJbzykHPe1FsYricFRqTGi4LmYR3RCKl/ZmSO1q/kjuwanvRGwil4BN1WFuPr+5FZbYUpiUeKnN0yFonu6UX0DeAnELlDCxrfMX9DkoodTn9HFmRyjrQkHpZ+07uVhEX2kpEOidXsRfnDyf57SggqQkF7I0F5yOLJp8YqvGN+o9XoRdgDHq5dj7eDzuTj8cA2sURrs=","Herobrine");
            // 将皮肤添加到列表中
            skins.add(skin1);
        }
        return skins;
    }
}
