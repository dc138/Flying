/*
   Flying plugin by DarthChungo

   MIT License
   Copyright (c) 2020 Antonio de Haro

*/

package me.DarthChungo.Flying;

import org.bukkit.command.TabExecutor;
import org.bukkit.plugin.java.JavaPlugin;


public class Flying extends JavaPlugin implements TabExecutor {
    public FlyingCommand fc;
    public FlyingEvent fe;

    @Override
    public void onEnable() {
        fc = new FlyingCommand(this);
        fe = new FlyingEvent(this);

        this.getLogger().info("Flying plugin by DarthChungo enabled.");
    }

    @Override
    public void onDisable() {
        this.getLogger().info("Flying plugin by DarthChungo disabled.");
    }
}
