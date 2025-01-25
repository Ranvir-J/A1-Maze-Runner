package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Explore {

    private static final Logger logger = LogManager.getLogger();

    private final Maze maze;

    public Explore(Maze maze) {
        this.maze = maze;
    }

    public int directionRow(int direction) {
        // Returns the change in row based on the direction
        return switch (direction) {
            case 0 -> 1;
            case 1 -> 0;
            case 2 -> -1;
            case 3 -> 0;
            default -> 0;
        };
    }

    private int directionCol(int direction) {
        return switch (direction) {
            case 0 -> 1; //north
            case 1 -> 0; //east
            case 2 -> -1; //south
            case 3 -> 0; //west
            default -> 0;
        };
    }

    public void findPath() {
        //Implement following right hand wall following here
        ;
    }

    public void checkPath(String[] args) {
        int currentRow = maze.x;
        int currentCol = maze.y;
        int direction = 1;
        int goingEast = 0;

        logger.info(currentRow + " " + currentCol);
        
        for (char move2: args[3].toCharArray()) {
            logger.info(move2);
            if (move2 == 'F'){
                currentRow = currentRow + directionRow(direction);
                currentCol = currentCol + directionCol(direction);
                logger.info(directionRow(direction) + " direction returns " + directionCol(direction) + " ");
                if (direction == 1) {
                    logger.info("adding");
                    goingEast = goingEast + 1;
                }
                if (maze.mazeArray[currentRow][currentCol] == '#') {
                    System.out.println("Invalid Path: Hit a wall");
                    System.exit(1);
            }

            }
            if (move2 == 'R') {
                direction = (direction + 1)%4;
                logger.info(direction);
                
            }
            if (move2 == 'L') {
                direction = (direction + 3)%4;
                logger.info(direction);

            }
            logger.info(currentCol + " " + currentRow);
            logger.info(maze.mazeArray[currentRow][currentCol]);
        }
        
        System.out.println(goingEast);
        System.out.println(maze.cols);
        if (goingEast == maze.cols) {
            logger.info("You passed through the maze");
        }
        else {logger.info("Did not reach the end of the maze");}
            
    }
}
