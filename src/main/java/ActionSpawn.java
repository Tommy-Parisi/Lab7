public class ActionSpawn extends Action{
    public ActionSpawn(int fromRow, int fromCol, int toRow, int toCol, Game game){
        super(fromRow, fromCol, toRow, toCol, game);
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