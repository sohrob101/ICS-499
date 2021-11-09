package tech.teamfour.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.teamfour.model.Player;
import tech.teamfour.model.Score;
import tech.teamfour.repositories.PlayerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService{

    private PlayerRepository playerRepo;

    @Autowired
    public PlayerServiceImpl(PlayerRepository pr){
        this.playerRepo = pr;
    }

    @Override
    public void addPlayer(Player player) {
        if(player.playerID != null && player.getUserName() != null){
            playerRepo.save(player);
        }
    }

    @Override
    public void updatePlayerPassword(String newPassword, Player player) {
        Player updatedPlayer = playerRepo.getById(player.getPlayerID());
        updatedPlayer.setPassword(newPassword);
        playerRepo.deleteById(player.playerID);
        addPlayer(updatedPlayer);
    }

    @Override
    public void deleterPlayer(long id) {
        if(checkExistance(id)) playerRepo.deleteById(id);
    }

    @Override
    public List<Player> getPlayers() {
        return playerRepo.findAll();
    }

    @Override
    public Player getPlayer(Long id) {
        return playerRepo.getById(id);
    }

    @Override
    public List<Score> getHighScores(){
        List<Player> sortedPlayers = getPlayers();
        sortedPlayers.sort((p1, p2)
                -> ((Integer)p1.getBestScore()).compareTo((Integer)p2.getBestScore()));
        
        List<Score> sortedScores = new ArrayList<Score>();
        ListIterator<Player> iter = sortedPlayers.listIterator();
        
        while (iter.hasNext()) {	
        	Player nextPlayer = iter.next();
        	Score nextScore = new Score(nextPlayer.getUserName(),nextPlayer.getBestScore());
        	sortedScores.add(nextScore);
        }               
        return sortedScores;
    }

    @Override
    public void setHighScore(int score, Long id) {
        if(checkExistance(id)){
            Player p = getPlayer(id);
            p.setBestScore(score);
            playerRepo.save(p);
        }
    }

    @Override
    public Optional<Player> getPlayerByName(String name) {
        return this.playerRepo.findByUserName(name);
    }

    private boolean checkExistance(long id){
        if(playerRepo.existsById(id)){
            return true;
        }
        return false;
    }






}
