package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

public class DisplayResultsTest {
    @Test
    public void checkDisplayFormatting() {
        ArrayList<String> unformattedPath = new ArrayList<>();
        Collections.addAll(unformattedPath, "F","F","F","R","R","L","R");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        DisplayResults displayResults = new DisplayResults();
        displayResults.showCanonicalPath(unformattedPath);

        assertEquals("FFF RR L R\n\n" , outContent.toString());
    }
    @Test
    public void checkDisplayFormattingTwo() {
        ArrayList<String> unformattedPath = new ArrayList<>();
        Collections.addAll(unformattedPath, "F","F","F","R","R","L","R");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        DisplayResults displayResults = new DisplayResults();
        displayResults.showFactorizedPath(unformattedPath);

        assertEquals("3F 2R L R\n\n", outContent.toString());
    }
}
