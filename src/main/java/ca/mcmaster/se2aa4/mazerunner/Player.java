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
        try {
            setInputFlag(args[0]);
        }
        catch(ArrayIndexOutOfBoundsException e) {
            ;
        }
        try {
            setCheckPathFlag(args[2]);
            setGivenMazePath(args[3]);
            }
        catch(ArrayIndexOutOfBoundsException e) {
            ;
        }
    }
}
