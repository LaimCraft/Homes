package ru.laimcraft.homes.config;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import ru.laimcraft.homes.SaveFormat;
import ru.laimcraft.homes.config.strategy.HomeStorageStrategy;
import ru.laimcraft.homes.config.strategy.UUIDStorage;
import ru.laimcraft.homes.config.strategy.UsernameIgnoreCaseStorage;

import static ru.laimcraft.api.log.Debug.info;

public class HomeConfigObject {

    public SaveFormat saveFormat;
    public HomeStorageStrategy storage;

    public HomeConfigObject(FileConfiguration config) {
        try {
            saveFormat = SaveFormat.valueOf(config.getString("storage.save-format").toUpperCase());
        } catch (IllegalArgumentException e) {
            info(ChatColor.AQUA + "[Homes]" + ChatColor.RED + " Invalid value in SaveFormat");
            return;
        }

        storage = getStorage();
    }

    private HomeStorageStrategy getStorage() {
        return switch (saveFormat) {
            case UUID -> new UUIDStorage();
            case USERNAME -> new UUIDStorage();
            case USERNAMEIGNORECASE -> new UsernameIgnoreCaseStorage();
        };
    }
}
