
package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;





public class PlayerTest {

    @Test
    public void checkInputFlags() { //
        String args[] = {"java", "-jar", "target/mazerunner.jar", "-i", "./examples/straight.maz.txt"};
        Player player = new Player();
        player.PlayerFlags(args);

        String inputFlags[] = {player.getInputFlag(), player.getCheckPathFlag(), player.getGivenMazePath()};
        assertEquals(args[0], inputFlags[0]);
        assertEquals(args[2], inputFlags[1]);
        assertEquals(args[3], inputFlags[2]);
    }
}
