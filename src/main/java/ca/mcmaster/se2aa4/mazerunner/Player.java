package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Player {

    private static final Logger logger = LogManager.getLogger();

    private String inputFlag = "";
    private String checkPathFlag = "";
    public String givenMazePath = "";

    public String getInputFlag() {return this.inputFlag;}
    public String getCheckPathFlag() {return this.checkPathFlag;}
    public String getGivenMazePath() {return this.givenMazePath;}

    public void setInputFlag(String inputflag) {this.inputFlag = inputflag;}
    public void setCheckPathFlag(String checkPathFlag) {this.checkPathFlag = checkPathFlag;}
    public void setGivenMazePath(String givenMazePath) {this.givenMazePath = givenMazePath;}

    public void PlayerFlags(String[] args) {
        if(args[0].equals("-i")) {
            setInputFlag(args[0]);
        }
        else {
            logger.error("Did not input -i flag. Exiting program.");
            System.exit(1);
        }
        try {
            if(args[2] != null) {
                setCheckPathFlag(args[2]);
                if (args[3] != null) {
                    setGivenMazePath(args[3]);
                }

            }}
        catch(ArrayIndexOutOfBoundsException e) {
            ;
        }
    }
}
