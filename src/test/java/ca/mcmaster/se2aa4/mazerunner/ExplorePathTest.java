
package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;

public class ExplorePathTest {
    static ArrayList<ArrayList<String>> mazeArray = new ArrayList<>();

    @BeforeAll
    static void initializeMazeArray() {

        for (int i = 0; i < 2; i++) {
            ArrayList<String> temp = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                temp.add("WALL");
            }
            mazeArray.add(temp);
        }
        ArrayList<String> temp = new ArrayList<>();
        for (int j = 0; j < 5; j++) {
            temp.add("PASS");
        }
        mazeArray.add(temp);
        for (int i = 0; i < 2; i++) {
            ArrayList<String> temp2 = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                temp2.add("WALL");
            }
            mazeArray.add(temp2);
        }
    }
    @Test
    public void checkIsValid() {
        ExplorePath explore = new ExplorePath();

        explore.setRows(5);
        explore.setCols(5);
        assertEquals(true, explore.isValidMove(3, 2, mazeArray));
    }
    
    @Test
    public void checkCanMove() { //
        ExplorePath explore = new ExplorePath();
        explore.setPosition(0,2);
        explore.setPosition(1,0);
        explore.setRows(5);
        explore.setCols(5);
        assertEquals(true, explore.canMove(2,mazeArray));
    } 

    @Test
    public void checkAtExit() {
        ExplorePath explore = new ExplorePath();
        explore.setEndingColumn(5);
        explore.setPosition(1, 4);

        assertEquals(true, explore.atExit());
    }
}
