package me.DarthChungo.Flying;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FlyingCommand implements TabExecutor {
    public List<Player> players = new ArrayList<>();

    public FlyingCommand(Flying plugin) {
        Objects.requireNonNull(plugin.getCommand("fly")).setExecutor(this);;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player) {
            if(players.contains((Player)commandSender)) {
                players.remove((Player)commandSender);
                ((Player)commandSender).setGliding(false);

                commandSender.sendMessage(ChatColor.GREEN + "Stopped flying.");

            } else {
                players.add((Player)commandSender);
                ((Player)commandSender).setGliding(true);

                commandSender.sendMessage(ChatColor.GREEN + "Whoosh!");
            }

        } else {
            commandSender.sendMessage(ChatColor.RED + "You must be a player to execute this command!");
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        return new ArrayList<>();
    }
}
