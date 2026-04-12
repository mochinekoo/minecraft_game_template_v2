package net.mochinekoserver.mc_game_template.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import java.util.List;

public class GameTeamCommand implements CommandExecutor, TabExecutor {

    @Override
    public boolean onCommand(CommandSender send, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("game_team")) {

        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        return List.of();
    }

}
