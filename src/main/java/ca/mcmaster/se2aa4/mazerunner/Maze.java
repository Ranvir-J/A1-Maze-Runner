package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Maze {

    private static final Logger logger = LogManager.getLogger();
    int arb = 50;
    char[][] mazeArray = new char[arb][arb];
    int x = -1;
    int y = 0;
    int cols = 0;

    public void loadMaze(String[] args) {
        logger.info("** Starting Maze Runner");
        
        try {
            logger.trace("**** Reading the maze from file " + args[1]);
            BufferedReader reader = new BufferedReader(new FileReader(args[1]));
            String line;
            int rows = 0;
            
            while ((line = reader.readLine()) != null) {

                logger.info(line);
                cols = line.length();
                rows++;
                for (int idx = 0; idx < line.length(); idx++) {
                    if (line.charAt(idx) == '#') {
                        mazeArray[rows][idx] = '#';
                        logger.info("Boring");
                    } else if (line.charAt(idx) == ' ') {
                        mazeArray[rows][idx] = ' ';
                        logger.info("Entering");
                        if ((x == -1) && (idx == 0)) {
                            logger.trace("Updating");
                            x = rows;
                        }
                    }
                }
                //logger.info(System.lineSeparator());
                }

        } catch(IOException e) {
            logger.error("/!\\ An error has occured /!\\");
        }
        
    }

}
