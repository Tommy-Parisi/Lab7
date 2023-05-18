/**
 * This class is for creating Board Squares for game board
 * @Author Joey Dare
 * @Version 1.0
 */
public class BoardSquare {
    private boolean empty;
    private Unit unit;
    private String color;
    private boolean special;
    /**
     * This constructor sets color to the color passed
     * The board square is empty by default
     * @param color String representing the board squares color
     */
    public BoardSquare (String color) {
        this.empty = true;
        this.color = color;
        this.special = false;
    }
    public Unit getUnit() {
        return this.unit;
    } // Returns the unit on the board square
    public boolean isEmpty() {
        return this.empty;
    } // returns whether the board square is empty or not
    public String getSquareColor() {
        return this.color;
    } //returns the Squares color
    public boolean isSpecial(){return this.special;} //returns if board square is empty or not

    //Mutator method for units
    public void setUnit(Unit newUnit) {
        this.unit = newUnit;
        this.empty = false;
    }
    //removes unit from the square and returns its unit type
    public Unit removeUnit() {
        Unit removedUnit = this.unit;
        this.unit = null;
        this.empty = true;
        return removedUnit;
    }
    //toString method for unit
    public String toString() {
        if (isEmpty()) {
            return "-------";
        }
        else {
            return "-" + getUnit().toString() + "-";
        }
    }
    //method to eject the unit when it lands on the special square
    public void ejectUnit() {
        if (unit != null){
            unit.setHealth(0.0); //Eject the unit from the game
            unit = null; //remove the unit from the square
        }
    }

    public void setSpecial(BoardSquare specialSquare){
        specialSquare.special = true;
    }
}
