package cn.infnetwork.megawallslobby.skin;

import cn.infnetwork.megawallslobby.skin.Dreadlord.Dreadlord;
import cn.infnetwork.megawallslobby.skin.herobrine.SnowHeroBrine;

import java.util.HashMap;
import java.util.Map;

public class SkinProviderRegistry {
    private final Map<String, SkinProvider> providers = new HashMap<>();

    public SkinProviderRegistry() {
        register("HIM", new SnowHeroBrine());
        register("Dreadlord",new Dreadlord());
    }

    public void register(String className, SkinProvider provider) {
        providers.put(className.toLowerCase(), provider);
    }

    public SkinProvider getProvider(String className) {
        return providers.get(className.toLowerCase());
    }
}
