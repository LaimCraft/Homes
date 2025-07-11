package ru.laimcraft.homes.config;

import org.bukkit.ChatColor;
import ru.laimcraft.homes.Homes;
import ru.laimcraft.homes.SaveVariant;

import static ru.laimcraft.api.log.Debug.info;

public class HomeConfig {

    private static HomeConfigObject homeConfigObject;

    public static String dbType;
    public static String schema;
    public static String db;
    public static String table;

    public static void init(Homes homes) {
        homes.saveDefaultConfig();
        var config = homes.getConfig();
        SaveVariant saveVariant;

        try {
            saveVariant = SaveVariant.valueOf(config.getString("storage.type").toUpperCase());
        } catch (IllegalArgumentException e) {
            info(ChatColor.AQUA + "[Homes]" + ChatColor.RED + " Unrecognized method of storing data");
            return;
        }

        if(saveVariant == SaveVariant.FILE) homeConfigObject = new HomeConfigFile(config);
        if(saveVariant == SaveVariant.MYSQL) homeConfigObject = new HomeConfigMySQL(config);
    }

    public static HomeConfigObject get() {
        return homeConfigObject;
    }


}