package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;

public class Maze {

    private static final Logger logger = LogManager.getLogger();

    private ArrayList<ArrayList<String>> mazeArray = new ArrayList<>();
    private int startingXCoordinate = -1;
    private int startingYCoordinate = 0;
    private int cols = 0;
    private int rows = 0;

    public void setStartingXCoordinate(int startingXCoordinate) {this.startingXCoordinate = startingXCoordinate;}
    public void setStartingYCoordinate(int startingYCoordinate) {this.startingYCoordinate = startingYCoordinate;}
    public void setCols(int cols) {this.cols = cols;}
    public void incrementRows() {this.rows++;}
    public void setMazeArray(ArrayList<String> arrayRow) {this.mazeArray.add(arrayRow);}

    public int getStartingXCoordinate() {return this.startingXCoordinate;}
    public int getStartingYCoordinate() {return this.startingYCoordinate;}
    public int getCols() {return this.cols;}
    public int getRows() {return this.rows;}
    //public String getMazeArraySingle(int i, int j) {return this.mazeArray.get(i).get(j);}
    public ArrayList<ArrayList<String>> getMazeArray() {return this.mazeArray;}


    public void displayMazeArray() {
        ArrayList<ArrayList<String>> mazeArray = new ArrayList<>();
        mazeArray = getMazeArray();
        String shownMaze = "\n";
        for(int i = 0; i < getRows(); i++) {
            for(int j = 0; j < getCols(); j++) {
                shownMaze += mazeArray.get(i).get(j);            
            }
        shownMaze += "\n";
        }
        logger.info(shownMaze);
    }

    public void InitializeMaze(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[1]));
            String line;
            
            while ((line = reader.readLine()) != null) {
                setCols(line.length());
                incrementRows();
                ArrayList<String> arrayRow = new ArrayList<>();
                for (int idx = 0; idx < line.length(); idx++) {
                    if (line.charAt(idx) == '#') {
                        arrayRow.add("#");
                    } else if (line.charAt(idx) == ' ') {
                        arrayRow.add(" ");
                        if ((getStartingXCoordinate() == -1) && (idx == 0)) {
                            setStartingXCoordinate(getRows());
                        }
                    }
                }
                setMazeArray(arrayRow);
                //logger.info(arrayRow);
                }
                //logger.info(getMazeArray());

        } 
        catch(IOException e) {
            logger.error("/!\\ An error has occured with initializing the maze/!\\");
        }
        }
        
}

