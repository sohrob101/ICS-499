package tech.teamfour;

import java.util.Scanner;

import tech.teamfour.model.*;

public class GameDebug {
    LinePuzzle game;
    Line path;
    Point location;
    Point end;
    Scanner scanner = new Scanner(System.in);

    public GameDebug(LinePuzzle puzzle) {
	this.game = puzzle;
	this.path = new Line();
	game.generate();
	setLocation(game.getMainGrid().getStart());
	game.getMainGrid().getStart().setVisited(true);
	this.end = game.getMainGrid().getEnd();
    }

    public void RunGame() throws InterruptedException {
	while (!end.isVisited()) {
	    System.out.println("\r" + game.toString() + "\nEnter Up, Down, Left or Right to Move");
	    System.out.println("S is the Start, E is the end, O are points you can travel on, ! are required points, # are traveled points and X is unpassable");
	    if (Move(scanner.nextLine()))
		ChangeLocation();
	    if (end.isVisited()) {
		if (!game.isComplete()) {
		    setLocation(game.retry());
		    System.out.println("Invalid Solution");
		}
	    }
	}
	scanner.close();
	System.out.println("Level Complete");
    }

    private void ChangeLocation() {
	if (game.getMainGrid().getPoint(location).isVisited() == true) {
	    Point lastLocation = path.getLine().pop();
	    path.getLine().pop();
	    game.getMainGrid().getPoint(lastLocation).setVisited(false);
	}
	game.getMainGrid().getPoint(location).setVisited(true);
    }

    private boolean Move(String nextLine) throws InterruptedException {
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

    public int getGridSize() {
	return game.getMainGrid().getVertexes().size();
    }

    public Point getLocation() {
	return location;
    }

    public void setLocation(Point location) {
	this.location = new Point(location);
    }

    public LinePuzzle getGame() {
	return game;
    }

    public void setGame(LinePuzzle game) {
	this.game = game;
    }
}