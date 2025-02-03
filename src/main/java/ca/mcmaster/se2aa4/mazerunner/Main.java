package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        Player player = new Player();
        Maze maze = new Maze();
        DisplayResults displayResults = new DisplayResults();

        player.PlayerFlags(args);
        maze.InitializeMaze(args);
        maze.displayMazeArray();
        displayResults.showResults(player.getInputFlag(), player.getCheckPathFlag(), maze.getStartingXCoordinate(), maze.getStartingYCoordinate(), maze.getMazeArray(),
        maze.getRows(),maze.getCols(), player.getGivenMazePath());
    }
}
