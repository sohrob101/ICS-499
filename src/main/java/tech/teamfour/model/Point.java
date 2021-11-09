package tech.teamfour.model;

import lombok.Data;

@Data
public class Point {
    private int x;
    private int y;
    private boolean visited;
    private boolean required;
    private boolean dead;
    private boolean start;
    private boolean end;
    private int zone;

    /**
     * No argument constructor
     */
    public Point() {
	this.setVisited(false);
	this.setRequired(false);
	this.setDead(true);
	this.setStart(false);
	this.setEnd(false);
	this.setZone(0);
    }
    
    /**
     * Initialize the point.
     */
    public Point(Point point) {
	this.setX(point.getX());
	this.setY(point.getY());
	this.setVisited(false);
	this.setRequired(false);
	this.setDead(true);
	this.setStart(false);
	this.setEnd(false);
	this.setZone(0);
    }
    
    /**
     * Initialize the point.
     */
    public Point(int x, int y) {
	this.setX(x);
	this.setY(y);
	this.setVisited(false);
	this.setRequired(false);
	this.setDead(true);
	this.setStart(false);
	this.setEnd(false);
	this.setZone(0);
    }

    /**
     * Initialize the point and flag for unique properties.
     *<br>Keys:
     *<br>0 = Start Adjacent
     *<br>1 = End Adjacent
     *<br>2 = Required Point
     */
    public Point(int x, int y, int flag) {
	this.setX(x);
	this.setY(y);
	this.setVisited(false);
	this.setRequired(false);
	this.setDead(true);
	this.setStart(false);
	this.setEnd(false);
	this.setZone(0);

	switch (flag) {
	case 0:
	    this.setStart(true);
	    break;
	case 1:
	    this.setEnd(true);
	    break;
	case 2:
	    this.setRequired(true);
	    break;
	default:
	    break;
	}
    }

    @Override
    public String toString() {
//	if (zone == 1) return "A,A"; // debug
//	if (zone == 2) return "B,B"; // debug
//	if (required) return "!,!"; // debug
//	return x + "," + y; // debug
	
	// ---
	
	if (zone == 1) return "A";
	if (zone == 2) return "B";
	if (start) return "S";
	if (end) return "E";
	if (dead) return "X";
	if (visited) return "#";
	if (required) return "!";
	return "O";
    }
}