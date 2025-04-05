package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

public class CheckPathCommand implements MazeCommand {

    private final DisplayResults displayResults;
    private final int startX, startY, rows, cols;
    private final ArrayList<ArrayList<String>> mazeArray;
    private final String pathToCheck;

    public CheckPathCommand(DisplayResults displayResults, int startX, int startY, ArrayList<ArrayList<String>> mazeArray, int rows, int cols, String pathToCheck) {
        this.displayResults = displayResults;
        this.startX = startX;
        this.startY = startY;
        this.mazeArray = mazeArray;
        this.rows = rows;
        this.cols = cols;
        this.pathToCheck = pathToCheck;
    }

    @Override
    public void execute() {
        System.out.println(new CheckPath().navigateMaze(new int[]{startX, startY}, mazeArray, rows, cols, pathToCheck).get(0));
    }
}
