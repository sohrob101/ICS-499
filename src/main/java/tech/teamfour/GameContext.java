package tech.teamfour;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import tech.teamfour.events.TimerStart;
import tech.teamfour.events.TimerStop;
import tech.teamfour.events.TimerTickedEvent;
import tech.teamfour.model.Line;
import tech.teamfour.model.LinePuzzle;
import tech.teamfour.model.Point;
import tech.teamfour.timer.Notifiable;
import tech.teamfour.timer.Timer;

@Data
@NoArgsConstructor
public class GameContext implements Notifiable {

    private LinePuzzle game;
    private Line path;
    private Point location;
    private Point end;
    private Timer timer;

    @Autowired
    public GameContext(LinePuzzle puzzle) {
	this.game = puzzle;
	this.path = puzzle.getPath();
	game.generate();
	setLocation(game.getMainGrid().getStart());
	game.getMainGrid().getStart().setVisited(true);
	this.end = game.getMainGrid().getEnd();
	this.timer = new Timer(this, 0);
	timer.start();
    }

    private void changeLocation() {
	if(game.getMainGrid().getPoint(location).isVisited() == true) {
	    Point lastLocation = path.getLine().pop();
	    path.getLine().pop();
	    game.getMainGrid().getPoint(lastLocation).setVisited(false);
	}
	game.getMainGrid().getPoint(location).setVisited(true);
    }

    public boolean move(String nextLine) throws InterruptedException {
	switch (nextLine.toUpperCase()) {
	case "UP":
	    if (game.getMainGrid().checkUp(path, location)) {
		path.getLine().push(new Point(location));
		location.setY(location.getY() + 1);
	    } else {
		System.out.println("Illegal Move");
		return false;
	    } break;

	case "DOWN":
	    if (game.getMainGrid().checkDown(path, location)) {
		path.getLine().push(new Point(location));
		location.setY(location.getY() - 1);
	    } else {
		System.out.println("Illegal Move");
		return false;
	    } break;

	case "LEFT":
	    if (game.getMainGrid().checkLeft(path, location)) {
		path.getLine().push(new Point(location));
		location.setX(location.getX() - 1);
	    } else {
		System.out.println("Illegal Move");
		return false;
	    } break;

	case "RIGHT":
	    if (game.getMainGrid().checkRight(path, location)) {
		path.getLine().push(new Point(location));
		location.setX(location.getX() + 1);
	    } else {
		System.out.println("Illegal Move");
		return false;
	    } break;
	default:
	    return false;
	}
	return true;
    }

    public int getTime(){
	return this.timer.getTimeValue();
    }

    public int getGridSize() {
	return game.getMainGrid().getVertexes().size();
    }

    @Override
    public void handleEvent(TimerTickedEvent event) {

    }

    @Override
    public void handleEvent(TimerStart event) {

    }

    @Override
    public void handleEvent(TimerStop event) {

    }
}
