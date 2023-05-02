package org.example;

public class ActionSpawn extends Action{
    public ActionSpawn(Game game, int fromRow, int fromCol, int toCol, int toRow){
        super(game, fromRow, fromCol, toCol, toRow);
    }
    @Override
    public void performAction(){
        BoardSquare[][] fromSquare = this.game.getBoardSquares();
        Unit fromUnit = fromSquare[fromRow][fromCol].getUnit();
        Team currentTeam = game.getCurrentPlayer().getTeam();
        currentTeam.addUnitsToTeam(fromUnit);
        fromSquare[toRow][toCol].setUnit(fromUnit);
        game.changeTurn();
    }


}
