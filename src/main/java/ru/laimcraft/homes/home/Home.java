package ru.laimcraft.homes.home;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public final class Home {

    public final String name;
    public final String lore;
    public final String world;
    public final double x;
    public final double y;
    public final double z;
    public final float pitch;
    public final float yaw;

    public Home(String name, String lore, String world, double x, double y, double z, float pitch, float yaw) {
        this.name = name;
        this.lore = lore;
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
        this.pitch = pitch;
        this.yaw = yaw;
    }

    public Location getLocation() {
        return new Location(Bukkit.getWorld(world), x, y, z, pitch, yaw);
    }

}
