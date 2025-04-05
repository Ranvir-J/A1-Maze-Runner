
package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;

public class FindPathTest {

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
    public void checkNavigateMaze() {
        FindPath findPath = new FindPath();
        int[] startingCoordinates = {3,0};
        ArrayList<String> expected = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            expected.add("F");
        }

        assertEquals(expected,findPath.navigateMaze(startingCoordinates, mazeArray, 5, 5, "FFFF"));
    }


}
