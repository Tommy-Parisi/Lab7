/**
 * This is non-public class for a GameEventNode
 * @Author Joey Dare
 * @Version 1.0
 */
class GameEventNode {

    private GameEvent gameState; // stores a specific game event
    private GameEventNode next; // stores the next game event node.

    public GameEventNode(GameEvent gameState) {
        this.gameState = gameState;
        this.next = null;
    }

    public GameEvent getGameState() {
        return gameState;
    }

    public void setGameState(GameEvent gameState) {
        this.gameState = gameState;
    }

    public GameEventNode getNext() {
        return next;
    }

    public void setNext(GameEventNode next) {
        this.next = next;
    }
}
