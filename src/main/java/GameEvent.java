/**
 * This is non-public class for when an event happens in game
 * @Author Joey Dare
 * @Version 1.0
 */

class GameEvent {
    private int playerNumber; // stores the unique identifier for a player
    private String eventType; // acts as a tag for different events
    private String eventDetails; // represents a description of the game event

    public GameEvent(int playerNumber, String eventType, String eventDetails) {
        this.playerNumber = playerNumber;
        this.eventType = eventType;
        this.eventDetails = eventDetails;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public String getEventType() {
        return eventType;
    }

    public String getEventDetails() {
        return eventDetails;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void setEventDetails(String eventDetails) {
        this.eventDetails = eventDetails;
    }
}