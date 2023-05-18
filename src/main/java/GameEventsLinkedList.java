public class GameEventsLinkedList implements Comparable<GameEventsLinkedList>{
    private GameEventNode head;
    private int size;

    public GameEventsLinkedList(){
        this.head = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return this.head == null;
    }

    public void push(GameEventNode eventNode){
        if (isEmpty()) {
            this.head = eventNode;
        }
        else {
            eventNode.setNext(this.head);
            this.head = eventNode;
            this.size++;
        }
    }

    public GameEvent pop() {
        GameEventNode temp = this.head;
        this.head = this.head.getNext();
        temp.setNext(null);
        this.size--;
        return temp.getGameState();
    }

    public GameEventsLinkedList pop(String eventType){
        GameEventNode current = head;
        GameEventNode lastNode = null;
        GameEventsLinkedList list = new GameEventsLinkedList();
        while (current.getNext() != null) {
            if (current.getGameState().getEventType().equals(eventType)) {
                if (lastNode == null) {
                    this.head = current.getNext();
                }
                else {
                    lastNode.setNext(current.getNext());
                }
                current.setNext(null);
                list.push(current);
                this.size--;
                if (lastNode == null) {
                    current = this.head;
                }
                else {
                    current = lastNode.getNext();
                }
            }
            else {
                lastNode = current;
                current = current.getNext();
            }
        }
        return list;
    }

    public void display() {
        GameEventNode current = head;
        while (current != null) {
            System.out.println(current.getGameState().getEventDetails());
            current = current.getNext();
        }
    }

    // New modification
    public int countEvents(){
        int count = 0;
        GameEventNode current = head;
        while (current != null) {
            count += 1;
            current = current.getNext();
        }
        return count;
    }


    @Override
    public int compareTo(GameEventsLinkedList otherList){
        return Integer.valueOf(this.size).compareTo(otherList.size);
    }

}