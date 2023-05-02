package org.example;

public abstract class Action {
    Game game;
    int fromSquareRowIndex;
    int fromSquareColIndex;
    int toSquareRowIndex;
    int toSquareColIndex;
    public Action(Game game, int fromSquareRowIndex, int fromSquareColIndex, int toSquareColIndex, int toSquareRowIndex){
        this.game = game;
        this.fromSquareRowIndex = fromSquareRowIndex;
        this.fromSquareColIndex = fromSquareColIndex;
        this.toSquareRowIndex = toSquareRowIndex;
        this.toSquareColIndex = toSquareColIndex;
    }
    public abstract void performAction();


}
