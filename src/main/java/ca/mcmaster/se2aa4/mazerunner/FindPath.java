package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;

public class FindPath implements PathStrategy {

    @Override
    public ArrayList<String> navigateMaze(int[] startingCoordinates, ArrayList<ArrayList<String>> mazeArray, int rows, int cols, String path) {
        final Logger logger = LogManager.getLogger();
        logger.info(mazeArray);

        ArrayList<String> canonicalPath = new ArrayList<>();

        ExplorePath explorePath = new ExplorePath();
        explorePath.setPosition(0,startingCoordinates[0]);
        explorePath.setPosition(1, startingCoordinates[1]);
        explorePath.setRows(rows);
        explorePath.setCols(cols);
        explorePath.setEndingColumn(cols);
        explorePath.setdirection(1);
        logger.info(startingCoordinates[0] + " " + startingCoordinates[1]);

        while (!explorePath.atExit()) {
            logger.info("Entering while loop");
            if (explorePath.canMove(explorePath.rightOf(explorePath.getdirection()), mazeArray)) {
                explorePath.turnRight();
                explorePath.moveForward();
                canonicalPath.add("R"); 
                canonicalPath.add("F");
                logger.info(canonicalPath);

            } else if (explorePath.canMove(explorePath.getdirection(), mazeArray)) {
                explorePath.moveForward();
                canonicalPath.add("F");
                logger.info(canonicalPath);

            } else {
                explorePath.turnLeft();
                canonicalPath.add("L");
                logger.info(canonicalPath);

            }

        }
        logger.info(canonicalPath);
        return canonicalPath;
    }
}
