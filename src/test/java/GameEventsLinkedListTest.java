/**
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class GameEventsLinkedListTest {
    @Test
    void testEmptyList() {
        GameEventsLinkedList emptyList = new GameEventsLinkedList();
        assertTrue(emptyList.isEmpty());
    }

    @Test
    void testNonEmptyList() {
        GameEventsLinkedList nonEmptyList = new GameEventsLinkedList();
        nonEmptyList.add(new GameEventNode(new GameEvent(0, "Type", "Details")));
        assertFalse(nonEmptyList.isEmpty());
    }

    @Test
    void testAdd() {
        GameEventsLinkedList addList = new GameEventsLinkedList();
        GameEventNode node = new GameEventNode(new GameEvent(0, "Type", "Details"));
        addList.add(node);
        assertFalse(addList.isEmpty());
        assertEquals(1, addList.getSize());
        assertEquals(node, addList.getHead());
    }

    @Test
    void testRemoveEmpty() {
        GameEventsLinkedList emptyList = new GameEventsLinkedList();
        assertNull(emptyList.remove(new GameEventNode(new GameEvent(1, "Type", "Details"))));
        assertTrue(emptyList.isEmpty());
        assertEquals(0, emptyList.getSize());
        assertNull(emptyList.getHead());
    }

    @Test
    void testRemoveNonEmpty() {
        GameEventsLinkedList nonEmptyList = new GameEventsLinkedList();
        GameEventNode newNode = new GameEventNode(new GameEvent(1, "Type1", "Details1"));
        GameEventNode newNode1 = new GameEventNode(new GameEvent(2, "Type2", "Details2"));
        nonEmptyList.add(newNode);
        nonEmptyList.add(newNode1);
        assertFalse(nonEmptyList.isEmpty());
        assertEquals(newNode, nonEmptyList.getHead());
        assertEquals(2, nonEmptyList.getSize());
        assertEquals(newNode.getGameState(), nonEmptyList.remove(newNode));
        assertEquals(1, nonEmptyList.getSize());
        assertEquals(newNode1, nonEmptyList.getHead());
    }

    @Test
    void testExtractEmpty() {
        GameEventsLinkedList extractList = new GameEventsLinkedList();
        GameEventsLinkedList extractedList = extractList.extract("Type");
        assertTrue(extractList.isEmpty());
        assertTrue(extractedList.isEmpty());
        assertEquals(0, extractList.getSize());
        assertEquals(0, extractedList.getSize());
        assertNull(extractList.getHead());
        assertNull(extractedList.getHead());
    }

    @Test
    void testExtractNonEmptyList() {
        GameEventsLinkedList nonEmptyList = new GameEventsLinkedList();
        GameEventNode newNode = new GameEventNode(new GameEvent(1, "Type1", "Details1"));
        GameEventNode newNode1 = new GameEventNode(new GameEvent(2, "Type2", "Details2"));
        GameEventNode newNode2 = new GameEventNode(new GameEvent(3, "Type1", "Details3"));
        nonEmptyList.add(newNode);
        nonEmptyList.add(newNode1);
        nonEmptyList.add(newNode2);
        GameEventsLinkedList extractedList = nonEmptyList.extract("Type1");
        assertFalse(nonEmptyList.isEmpty());
        assertEquals(3, nonEmptyList.getSize());
        assertFalse(extractedList.isEmpty());
        assertEquals(2, extractedList.getSize());
        assertEquals(newNode, nonEmptyList.getHead());
        assertEquals(newNode.getGameState().getEventType(), extractedList.getHead().getGameState().getEventType());
    }

}
**/