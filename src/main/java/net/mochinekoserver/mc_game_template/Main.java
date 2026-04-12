package net.mochinekoserver.mc_game_template;

import net.mochinekoserver.mc_game_template.command.GameStartStopCommand;
import net.mochinekoserver.mc_game_template.command.GameTeamCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        var startstop_command = new GameStartStopCommand();
        var team_command = new GameTeamCommand();

        getCommand("game_start").setExecutor(startstop_command);
        getCommand("game_stop").setExecutor(startstop_command);
        getCommand("game_team").setExecutor(team_command);

        getCommand("game_team").setTabCompleter(team_command);

        getLogger().info("プラグインが有効になりました。");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
