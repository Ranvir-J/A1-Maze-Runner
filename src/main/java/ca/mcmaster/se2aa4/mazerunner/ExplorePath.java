package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ExplorePath {
    final Logger logger = LogManager.getLogger();

    private static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	private int direction; //0 is up, 1 is right, 2 is down, 3 is left
    private int[] position = new int[2]; //position coordinates 
    private int rows, cols; //size of maze
    private int endingColumn; //furthest column in maze

    public void setdirection(int direction) {this.direction = direction;}
    public void setPosition(int index, int position) {this.position[index] = position;}
    public void setEndingColumn(int column) {this.endingColumn = column;}
    public void setRows(int rows) {this.rows = rows;}
    public void setCols(int cols) {this.cols = cols;}

    public int getdirection() {return this.direction;}
    public int[] getPosition() {return this.position;}
    public int getEndingColumn() {return this.endingColumn;}
    public int getRows() {return this.rows;}
    public int getCols() {return this.cols;}

    public boolean canMove(int direction, ArrayList<ArrayList<String>> mazeArray) {
        int newRow = position[0] + DIRECTIONS[direction][0];
        int newCol = position[1] + DIRECTIONS[direction][1];
        logger.info("Direction: " + direction + " " + newRow + " " + newCol);
        return isValidMove(newRow, newCol, mazeArray);
    }
    public boolean isValidMove(int row, int col, ArrayList<ArrayList<String>> mazeArray) {

        logger.info("ROWs and shit" + " " + row + " " + col + " " + rows + " " + cols);
        //try {logger.info("Maze position is " + mazeArray.get(row).get(col));}
        //catch (ArrayIndexOutOfBoundsException e) {;}
        return row >= 0 && row < rows && col >= 0 && col < cols && mazeArray.get(row-1).get(col).equals("PASS");
    }
    public void moveForward() {
        position[0] += DIRECTIONS[direction][0];
        position[1] += DIRECTIONS[direction][1];
    }
    public boolean atExit() {
        logger.info("checking exit condition" + position[1] + " " + endingColumn);
        return position[1] == (endingColumn-1);
    }
    public void turnRight() {
        direction = rightOf(direction);
    }
    public void turnLeft() {
        direction = leftOf(direction);
    }
    public int rightOf(int direction) {
        return (direction + 1) % 4;
    }
    public int leftOf(int direction) {
        return (direction + 3) % 4;
    }

}