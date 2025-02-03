package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DisplayResults {

    public void showCanonicalPath(ArrayList<String> unformattedPath) {
        String canonicalString = "";

        canonicalString += unformattedPath.get(0);

        for(int i = 1;i < unformattedPath.size(); i++) {
            if(unformattedPath.get(i).equals(unformattedPath.get(i-1))){
                canonicalString += unformattedPath.get(i);
            }
            else {
                canonicalString += " " + unformattedPath.get(i);
            }
        }
        System.out.println(canonicalString + "\n");
    }

    public void showFactorizedPath(ArrayList<String> unformattedPath) {
        String factorizedString = "";
        int counter = 1;

        for(int i = 1;i < unformattedPath.size(); i++) {

            if(unformattedPath.get(i).equals(unformattedPath.get(i-1)) && (i == (unformattedPath.size()-1))){
                counter += 1;
                factorizedString += counter + unformattedPath.get(i-1) + " ";
            }
            else if(unformattedPath.get(i).equals(unformattedPath.get(i-1))){
                counter += 1;
            }
            else if(!unformattedPath.get(i).equals(unformattedPath.get(i-1)) && (counter > 1)){
                factorizedString += counter + unformattedPath.get(i-1) + " ";
                counter = 1;
            }
            else if(!unformattedPath.get(i).equals(unformattedPath.get(i-1)) && (counter <= 1) && (i == (unformattedPath.size()-1))){
                factorizedString += unformattedPath.get(i-1) + " ";
                factorizedString += unformattedPath.get(i);
            }
            else {
                factorizedString += unformattedPath.get(i-1) + " ";
            }
        }
        System.out.println(factorizedString + "\n");

    }

    public void showResults(String inputFlag, String checkPathFlag, int startingXCoordinate, int startingYCoordinate, ArrayList<ArrayList<String>> mazeArray,
    int rows, int cols, String path) {
        final Logger logger = LogManager.getLogger();
        FindPath findPath = new FindPath();
        CheckPath checkPath = new CheckPath();
        int[] startingCoordinates = {startingXCoordinate, startingYCoordinate};

        if(inputFlag.equals("-i")) {
            logger.info("Finding path");
            ArrayList<String> unformattedPath = (findPath.navigateMaze(startingCoordinates, mazeArray, rows, cols, "N/A"));
            showCanonicalPath(unformattedPath);
            showFactorizedPath(unformattedPath);
        }
        else {
            return;
        }

        if(checkPathFlag.equals("-p")) {
            
            System.out.println(checkPath.navigateMaze(startingCoordinates, mazeArray, rows, cols, path).get(0));
        }
        else {
            return;
        }

    }

}
