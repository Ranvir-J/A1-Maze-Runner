package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

public interface PathStrategy {
    ArrayList<String> navigateMaze(int[] startingCoordinates, ArrayList<ArrayList<String>> mazeArray, int rows, int cols, String path);
}
