package tech.teamfour.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Grid {
    protected List<List<Point>> vertexes;
    protected Point start;
    protected Point end;

    public ArrayList<List<Point>> generateGrid(int size) {
	return null;
    }

    public Point getUp(Point point) {
	return getPoint(point.getX(), point.getY() + 1);
    }

    public Point getDown(Point point) {
	return getPoint(point.getX(), point.getY() - 1);
    }

    public Point getRight(Point point) {
	return getPoint(point.getX() + 1, point.getY());
    }

    public Point getLeft(Point point) {
	return getPoint(point.getX() - 1, point.getY());
    }

    /**
     * @param grid to merge paths with another grid.
     */
    public void mergePaths(Grid grid) {
	int size = vertexes.size() - 1;
	for (int x = 0; x <= size; x++) {
	    for (int y = size; y >= 0; y--) {
		if (getPoint(x, y).isDead() && !grid.getPoint(x, y).isDead()) {
		    getPoint(x, y).setDead(false);
		    getPoint(x, y).setZone(grid.getPoint(x, y).getZone());
		}
	    }
	}
    }

    /**
     * Clears a maze setting them all to dead points, no required points, and no zones.
     */
    public void clear() {
	for (List<Point> row : getVertexes()) {
	    for (Point point : row) {
		point.setDead(true);
		point.setRequired(false);
		point.setZone(0);
	    }
	}
    }

    public Point getPoint(Point point) {
	return this.vertexes.get(point.getX()).get(vertexes.size() - 1 - point.getY());
    }

    public Point getPoint(int x, int y) {
	return this.vertexes.get(x).get(vertexes.size() - 1 - y);
    }

}