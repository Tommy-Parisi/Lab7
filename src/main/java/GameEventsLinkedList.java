public class GameEventsLinkedList {

    private GameEventNode head; //  represents the first game event
    private int size; // stores the size of the Linked List

    public GameEventsLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public GameEventNode getHead() {
        return this.head;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void add(GameEventNode event) {
        if (isEmpty()) {
            this.head = event;
        } else {
            GameEventNode current = this.head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(event);
        }
        this.size += 1;
    }

    public GameEvent remove(GameEventNode event) {
        if (isEmpty()) {
            return null;
        }
        GameEventNode current = this.head;
        while (current.getNext() != null) {
            if (current.getNext() == event) {
                GameEventNode returning = current.getNext();
                current.setNext(null);
                this.size--;
                return returning.getGameState();
            }
            current = current.getNext();
        }
        return null;
    }

    public GameEventsLinkedList extract(String eventType) {
        GameEventsLinkedList newList = new GameEventsLinkedList();
        GameEventNode current = this.head;
        while (current != null) {
            if (current.getGameState().getEventType().equals(eventType)) {
                newList.add(new GameEventNode(current.getGameState()));
            }
            current = current.getNext();
        }
        return newList;
    }

    public void Display() {
        GameEventNode current = this.head;
        while (current != null) {
            System.out.println(current.getGameState().getEventDetails());
            current = current.getNext();
        }
    }


}

