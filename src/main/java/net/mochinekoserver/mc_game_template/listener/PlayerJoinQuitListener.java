package net.mochinekoserver.mc_game_template.listener;

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
        scoreboardManager.setScoreboard();

        if (gameManager.getStatus() == GameStatus.RUNNING) {
            teamManager.randomJoinTeam(player); //ランダムにチームに参加させる
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
