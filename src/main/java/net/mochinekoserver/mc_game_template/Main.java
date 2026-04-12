package net.mochinekoserver.mc_game_template;

import net.mochinekoserver.mc_game_template.command.GameStartStopCommand;
import net.mochinekoserver.mc_game_template.command.GameTeamCommand;
import net.mochinekoserver.mc_game_template.listener.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        initCommand();
        initListener();

        getLogger().info("プラグインが有効になりました。");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void initCommand() {
        var startstop_command = new GameStartStopCommand();
        var team_command = new GameTeamCommand();

        getCommand("game_start").setExecutor(startstop_command);
        getCommand("game_stop").setExecutor(startstop_command);
        getCommand("game_team").setExecutor(team_command);

        getCommand("game_team").setTabCompleter(team_command);
    }

    private void initListener() {
        var pluginManager = getServer().getPluginManager();

        //ブロック
        pluginManager.registerEvents(new BlockBreakPlaceListener(), this);

        //プレイヤー
        pluginManager.registerEvents(new PlayerChatListener(), this);
        pluginManager.registerEvents(new PlayerDeathListener(), this);
        pluginManager.registerEvents(new PlayerJoinQuitListener(), this);
        pluginManager.registerEvents(new PlayerRespawnListener(), this);

        //other
        pluginManager.registerEvents(new InventoryClickListener(), this);
        pluginManager.registerEvents(new EntityDamageListener(), this);

    }
}
