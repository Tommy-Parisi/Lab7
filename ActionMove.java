public class ActionMove extends Action {
    public ActionMove(int fromRow, int fromCol, int toRow, int toCol, Game game) {
        super(fromRow, fromCol, toRow, toCol, game);
    }

    public void performAction() {
        BoardSquare[][] square = this.game.getBoardSquares();
        if(square[toRow][toCol].isSpecial()){ //if its square special
            square[toRow][toCol].ejectUnit(); //eject the unit occupying the space
        }
        else {
            Unit unit = square[fromRow][fromCol].removeUnit();
            square[toRow][toCol].setUnit(unit);
            this.game.changeTurn();
        }
    }

}