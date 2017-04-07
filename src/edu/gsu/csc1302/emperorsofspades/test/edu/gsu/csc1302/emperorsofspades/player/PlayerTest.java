package edu.gsu.csc1302.emperorsofspades.player;

import edu.gsu.csc1302.emperorsofspades.player.Player;
import edu.gsu.csc1302.emperorsofspades.player.ai.WildcardPlayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the functionality of a Player
 *
 * @author Roger Williams
 */
class PlayerTest {
    private final Player roger = new WildcardPlayer("Roger");

    @Test
    void getName() {
        assertEquals("Roger", roger.getName()  );
    }

    @Test
    void placeBid() {
        final int bid = roger.placeBid();
        assert bid >= 4 && bid <= 10;
    }

}