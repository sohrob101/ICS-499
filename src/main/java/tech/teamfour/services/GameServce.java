package tech.teamfour.services;

import tech.teamfour.enums.GameStateEnum;
import tech.teamfour.model.LinePuzzle;
import tech.teamfour.model.Point;

public interface GameServce {
    public abstract LinePuzzle getNewPuzzle(int gridSize);
    public abstract Point getUpdatedPuzzle();
    public abstract boolean validatePlayerMove(int keyPressed);
    public abstract GameStateEnum checkGameStatus();
    public abstract int getGameTime();
}
