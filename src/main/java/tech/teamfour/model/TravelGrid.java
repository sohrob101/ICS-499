package tech.teamfour.model;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@NoArgsConstructor
public class TravelGrid extends Grid {
    public TravelGrid(int size) {
	Random rand = new Random();
	size -= 1;
	int start_offset = rand.nextInt(size);
	int end_offset = rand.nextInt(size);
	this.vertexes = new ArrayList<List<Point>>(size);

	for (int x = 0; x <= size; x++)
	{
	    List<Point> row = new ArrayList<Point>(size);
	    for (int y = size; y >= 0; y--) {

		if (x == 0 && y == size - end_offset) {
		    this.end = new Point(x, y, 1);
		    row.add(this.end);
		}
		else if (x == size && y == start_offset) {
		    this.start = new Point(x, y, 0);
		    row.add(this.start);
		}
		else row.add(new Point(x, y));   

	    }
	    this.vertexes.add(row);
	}
    }
    
    /**
     * @param path is the travel path.
     * @param point is the current point.
     * <br>Check to see if there is a valid move north of the grid.
     */
    public boolean checkUp(Line path, Point point) {
	boolean temp = false;
	if (point.getY() < getVertexes().size() - 1)
	    temp = true;
	else 
	    return temp;

	if (getUp(point).isVisited()) 
	    if (getUp(point) != getPoint(path.getLine().peek()))
		temp = false;
	    else
		temp = true;

	if (getUp(point).isDead()) 
	    temp = false;

	return temp;
    }

    public boolean checkDown(Line path, Point point) {
	boolean temp = false;
	if (point.getY() > 0) 
	    temp = true; 
	else 
	    return temp;

	if (getDown(point).isVisited()) 
	    if (getDown(point) != getPoint(path.getLine().peek()))
		temp = false;
	    else
		temp = true;

	if (getDown(point).isDead()) 
	    temp = false;

	return temp;
    }

    public boolean checkLeft(Line path, Point point) {
	boolean temp = false;
	if (point.getX() > 0) 
	    temp = true;
	else 
	    return temp;

	if (getLeft(point).isVisited()) 
	    if (getLeft(point) != getPoint(path.getLine().peek()))
		temp = false;
	    else
		temp = true;

	if (getLeft(point).isDead())
	    temp = false;

	return temp;
    }

    public boolean checkRight(Line path, Point point) {
	boolean temp = false;
	if (point.getX() < getVertexes().size() - 1) 
	    temp = true;
	else 
	    return temp;

	if (getRight(point).isVisited())
	    if (getRight(point) != getPoint(path.getLine().peek()))
		temp = false;
	    else
		temp = true;

	if (getRight(point).isDead())
	    temp = false;

	return temp;
    }
}
