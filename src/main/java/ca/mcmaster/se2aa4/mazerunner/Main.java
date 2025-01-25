package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {


    public static void main(String[] args) {
        Maze maze = new Maze();
        if (args[0].equals("-i")) {
            maze.loadMaze(args);
        }

        Explore explore = new Explore(maze);
        if (args[2].equals("-p")) {
            explore.checkPath(args);
            
        }
    }
}
