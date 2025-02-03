package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.Scanner;

public class CheckPath extends Path{

    @Override
    ArrayList<String> navigateMaze(int[] startingCoordinates, ArrayList<ArrayList<String>> mazeArray, int rows, int cols, String path) {
        ArrayList<String> result = new ArrayList<>();
        ExplorePath explorePath = new ExplorePath();
  
        explorePath.setPosition(0,startingCoordinates[0]);
        explorePath.setPosition(1, startingCoordinates[1]);
        explorePath.setRows(rows);
        explorePath.setCols(cols);
        explorePath.setEndingColumn(cols);
        explorePath.setdirection(1);
        int currentRow = explorePath.getPosition()[0];
        int currentCol = explorePath.getPosition()[1];
        int currentDirection = explorePath.getdirection();

        for (char move : path.toCharArray()) {
            if (move == 'R') {
                currentDirection = explorePath.rightOf(currentDirection);
            } else if (move == 'L') {
                currentDirection = explorePath.leftOf(currentDirection);
            } else if (move == 'F') {
                int newRow = currentRow + ExplorePath.DIRECTIONS[currentDirection][0];
                int newCol = currentCol + ExplorePath.DIRECTIONS[currentDirection][1];

                if (!explorePath.isValidMove(newRow, newCol, mazeArray)) {
                    result.add("Path invalid. Hit a wall.");
                    return result;
                }

                currentRow = newRow;
                currentCol = newCol;
            } else {
                result.add("Invalid input");
                return result;
            }
        }

        if(currentCol == explorePath.getEndingColumn()-1) {
            result.add("Path is valid");
            return result;
        }
        else {
            result.add("Did not reach the end of the maze");
            return result;
        }
        }
    
}
