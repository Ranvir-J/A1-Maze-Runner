package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

public class FindPathCommand implements MazeCommand {

    private final DisplayResults displayResults;
    private final int startX, startY, rows, cols;
    private final ArrayList<ArrayList<String>> mazeArray;

    public FindPathCommand(DisplayResults displayResults, int startX, int startY, ArrayList<ArrayList<String>> mazeArray, int rows, int cols) {
        this.displayResults = displayResults;
        this.startX = startX;
        this.startY = startY;
        this.mazeArray = mazeArray;
        this.rows = rows;
        this.cols = cols;
    }

    @Override
    public void execute() {
        displayResults.showCanonicalPath(new FindPath().navigateMaze(new int[]{startX, startY}, mazeArray, rows, cols, "N/A"));
    }
}
