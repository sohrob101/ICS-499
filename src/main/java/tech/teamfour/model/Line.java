package tech.teamfour.model;

import lombok.Data;

import java.util.Stack;

@Data
public class Line {
    private Stack<Point> line;

    public Line() {
	this.setLine(new Stack<Point>());
    }

}