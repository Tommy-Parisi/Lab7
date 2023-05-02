/**
 This class contains the Action to attack units
 @author
 Joey Dare
 @version 1.0
 */
public class ActionAttack extends Action {

    public ActionAttack(int fromRow, int fromCol, int toRow, int toCol, Game game) {
        super(fromRow, fromCol, toRow, toCol, game);
    }

    //Method to perform Action
    @Override
    public void performAction() {
        BoardSquare[][] findUnit = this.game.getGameBoard().getSquares();
        Unit fromUnit = findUnit[fromRow][fromCol].getUnit();
        Unit toUnit = findUnit[toRow][toCol].getUnit();

        if (fromUnit instanceof TomJerryUnit && fromUnit != null && !this.game.getOpponentPlayer().getTeam().equals(this.game.getCurrentPlayer().getTeam())) {
            //damage dealt and received
            double toUnitDamage = ((TomJerryUnit)toUnit).dealDamage();
            System.out.println("Damage dealt to unit: " + toUnitDamage + "!");
            ((TomJerryUnit)toUnit).takeDamage(toUnitDamage);
            System.out.print("Health is now at: " + toUnit.getHealth());

            // If the defending unit is a TomJerryUnit and its health is 0 or less, remove from the opponent's team
            if(fromUnit instanceof TomJerryUnit && fromUnit.getHealth() <= 0) {
                this.game.getOpponentPlayer().getTeam().removeUnitsFromTeam(toUnit);
                findUnit[toRow][toCol].setUnit(fromUnit);
                findUnit[fromRow][fromCol].removeUnit();
            }
            // If the unit being attacked is a BartSimpsonUnit, remove it
            else if(fromUnit instanceof BartSimpsonUnit) {
                findUnit[toRow][toCol].removeUnit();
                findUnit[toRow][toCol].setUnit(fromUnit);
                findUnit[fromRow][fromCol].removeUnit();
            }
            // Change the turn
            this.game.changeTurn();
        }
    }

}


