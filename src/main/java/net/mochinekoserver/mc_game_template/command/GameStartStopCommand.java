package net.mochinekoserver.mc_game_template.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import java.util.List;

public class GameStartStopCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender send, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("game_start")) {

        }
        else if (cmd.getName().equalsIgnoreCase("game_stop")) {

        }
        return false;
    }

}
