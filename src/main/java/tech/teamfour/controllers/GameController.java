package tech.teamfour.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.teamfour.services.GameServce;
import tech.teamfour.services.GameServceImpl;

// FOR DEBUG USE

@RestController
public class GameController {
    final GameServce gameServce;

    @Autowired
    public GameController(GameServceImpl gameServce) {
        this.gameServce = gameServce;
    }

    @GetMapping("game/newGame")
    public ResponseEntity getNewGame(@RequestParam(defaultValue = "5", required = false) int gridSize){
        return new ResponseEntity<>(gameServce.getNewPuzzle(gridSize), HttpStatus.OK);
    }

    @GetMapping("game/currentGame")
    public ResponseEntity getPlayerMove(@RequestParam int keyPressed){
        boolean wasMoveSuccessful = gameServce.validatePlayerMove(keyPressed);
        if(wasMoveSuccessful){
            return new ResponseEntity(gameServce.getUpdatedPuzzle(), HttpStatus.OK);
        }else{
            return new ResponseEntity("Invalid Move", HttpStatus.OK);
        }
    }

    @GetMapping("game/currentTime")
    public ResponseEntity getCurrentTime(){
        return new ResponseEntity(this.gameServce.getGameTime(), HttpStatus.OK);
    }
}