import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Array;
import java.util.ArrayList;

public class PlayerTest {
    @Test
    public void testConstructorWithAllFields() {
        Team team1 = new Team("Purple", new ArrayList<Unit>());
        Player player = new Player(1, true, team1);

        assertEquals(1, player.getPlayerNumber());
        assertTrue(player.isTurn());
        assertEquals(team1, player.getTeam());
    }

    @Test
    public void testConstructorWithIntAndBoolean() {
        Team team1 = new Team("Purple", new ArrayList<>());
        Player player = new Player(1, team1);
        assertEquals(1, player.getPlayerNumber());
        assertFalse(player.isTurn());
        assertEquals(team1, player.getTeam());
    }

    @Test
    public void testDefaultConstructor() {
        Player player = new Player();
        assertEquals(1, player.getPlayerNumber());
        assertFalse(player.isTurn());
    }

    @Test
    public void testSettersAndGetters() {
        Team team1 = new Team("Purple", new ArrayList<Unit>());
        Team team2 = new Team("Orange", new ArrayList<Unit>());
        Player player = new Player();

        player.setPlayerNumber(2);
        player.setTurn(false);
        player.setTeam(team1);

        assertEquals(2, player.getPlayerNumber());
        assertFalse(player.isTurn());
        assertEquals(team1, player.getTeam());

        player.setTeam(team2);

        assertEquals(team2, player.getTeam());
    }
}
    
