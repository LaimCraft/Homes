package ru.laimcraft.homes;

import org.bukkit.plugin.java.JavaPlugin;
import ru.laimcraft.homes.config.HomeConfig;

public final class Homes extends JavaPlugin {

    @Override
    public void onEnable() {
        HomeConfig.init(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
