package ru.laimcraft.homes.home;

import ru.laimcraft.homes.config.HomeConfig;

public class PlayerHome {

    Home[] homes = new Home[0];

    public PlayerHome(Object object) {
        HomeConfig.get().storage.getPlayerHomes(object);
    }
}
