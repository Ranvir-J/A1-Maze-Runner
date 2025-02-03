package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;

public abstract class Path {

	abstract ArrayList<String> navigateMaze(int[] startingCoordinates,ArrayList<ArrayList<String>> mazeArray, int rows, int cols, String path);

}