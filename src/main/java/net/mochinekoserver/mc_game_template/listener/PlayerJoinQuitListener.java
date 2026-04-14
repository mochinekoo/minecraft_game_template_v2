package net.mochinekoserver.mc_game_template.listener;

import net.mochinekoserver.mc_game_template.manager.ConfigManager;
import net.mochinekoserver.mc_game_template.manager.GameManager;
import net.mochinekoserver.mc_game_template.manager.ScoreboardManager;
import net.mochinekoserver.mc_game_template.manager.TeamManager;
import net.mochinekoserver.mc_game_template.status.GameStatus;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerJoinQuitListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        var player = event.getPlayer();
        var gameManager = GameManager.getInstance();
        var scoreboardManager = ScoreboardManager.getInstance(player.getUniqueId());
        var teamManager = TeamManager.getInstance();
        var configManager = ConfigManager.getInstance();
        scoreboardManager.setScoreboard();

        if (gameManager.getStatus() == GameStatus.RUNNING) {
            var joinTeam = teamManager.getJoinGameTeam(player);
            if (joinTeam == null) {
                teamManager.randomJoinTeam(player); //ランダムにチームに参加させる
            }
            var teamSpawn = configManager.getTeamSpawnLocation(joinTeam);
            player.teleport(teamSpawn);
        }
        else {
            var lobbyLoc = configManager.getLobby();
            player.teleport(lobbyLoc);
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        var player = event.getPlayer();
        var gameManager = GameManager.getInstance();
        var scoreboardManager = ScoreboardManager.getInstance(player.getUniqueId());
        scoreboardManager.release();
    }

}
