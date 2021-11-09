package tech.teamfour.services;

import tech.teamfour.model.Player;
import tech.teamfour.model.Score;

import java.util.List;
import java.util.Optional;

public interface PlayerService {
    public abstract void addPlayer(Player player);
    public void updatePlayerPassword(String newPassword, Player player);
    public void deleterPlayer(long id);
    public List<Player> getPlayers();
    public Player getPlayer(Long id);
    public List<Score> getHighScores();
    public void setHighScore(int score, Long id);
    public Optional<Player> getPlayerByName(String name);
}
