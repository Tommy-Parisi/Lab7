public class ActionMove extends Action {
    public ActionMove(int fromRow, int fromCol, int toRow, int toCol, Game game) {
        super(fromRow, fromCol, toRow, toCol, game);
    }

    public void performAction() {
        BoardSquare[][] findSquare = this.game.getBoardSquares();
        Unit fromUnit = findSquare[fromRow][fromCol].getUnit();
        Unit toUnit = findSquare[toRow][toCol].getUnit();

        if(findSquare[toRow][toCol].isSpecial()){ //if its BoardSquare special
            this.game.getCurrentPlayer().getTeam().removeUnitsFromTeam(fromUnit);
            findSquare[fromRow][fromCol].ejectUnit(); //eject the unit occupying the space
            Unit unit = findSquare[fromRow][fromCol].removeUnit();
            System.out.println("Your unit stepped on a hidden springboard!");
            System.out.println("Your unit was ejected from the game.");
            this.game.changeTurn();
        }
        else {
            Unit unit = findSquare[fromRow][fromCol].removeUnit();
            findSquare[toRow][toCol].setUnit(unit);
            this.game.changeTurn();
        }
    }

}