package ru.laimcraft.homes.config.strategy;

import ru.laimcraft.homes.home.PlayerHome;

public abstract interface HomeStorageStrategy {
    PlayerHome getPlayerHomes(Object key);
}
