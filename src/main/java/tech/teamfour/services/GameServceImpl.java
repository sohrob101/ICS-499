package tech.teamfour.services;

import org.springframework.stereotype.Service;
import tech.teamfour.GameContext;
import tech.teamfour.enums.GameStateEnum;
import tech.teamfour.model.LinePuzzle;
import tech.teamfour.model.Point;

@Service
public class GameServceImpl implements GameServce{


    private GameContext gameContext;

    @Override
    public LinePuzzle getNewPuzzle(int gridSize) {
	gameContext = new GameContext(new LinePuzzle(gridSize));
	return gameContext.getGame();
    }

    @Override
    public Point getUpdatedPuzzle() {
	return gameContext.getGame().getPath().getLine().peek();
    }

    @Override
    public boolean validatePlayerMove(int keyPressed) {
	String stringMoveRequest;
	switch(keyPressed){
	case 38: stringMoveRequest = "Up";
	break;
	case 40: stringMoveRequest = "Down";
	break;
	case 37: stringMoveRequest = "Left";
	break;
	case 39: stringMoveRequest = "Right";
	break;
	default: stringMoveRequest = "ERROR";
	break;

	}

	try {
	    boolean moveSuccessful = gameContext.move(stringMoveRequest);
	    if(moveSuccessful) return true;
	} catch(Exception e) {
	    return false;
	}
	return false;
    }

    @Override
    public GameStateEnum checkGameStatus() {
	return null;
    }

    @Override
	public int getGameTime(){
    	return this.gameContext.getTime();
	}
}
