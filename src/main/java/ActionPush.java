/**
 New Action Modification:
 This class creates the Push action which will push an enemy to a corner if it is within two spaces of the fromUnit
@author
Joey Dare
@version 1.0
*/
public class ActionPush extends Action{

    public ActionPush(int fromRow, int fromCol, int toRow, int toCol, Game game) {
        super(fromRow, fromCol, toRow, toCol, game);
    }

    @Override
    public void performAction() {
        BoardSquare[][] findSquare = this.game.getGameBoard().getSquares();
        Unit toUnit = findSquare[toRow][toCol].getUnit();
         if (findSquare[7][7].isEmpty()) {
             findSquare[7][7].setUnit(toUnit);
             findSquare[toRow][toCol].removeUnit();
             this.game.changeTurn();
             System.out.println("Enemy Unit was pushed to bottom right corner!");
         }
        else if (findSquare[0][7].isEmpty()) {
            findSquare[0][7].setUnit(toUnit);
            findSquare[toRow][toCol].removeUnit();
            this.game.changeTurn();
            System.out.println("Enemy Unit was pushed to top right corner!");
        }
         else if (findSquare[0][0].isEmpty()) {
             findSquare[0][0].setUnit(toUnit);
             findSquare[toRow][toCol].removeUnit();
             this.game.changeTurn();
             System.out.println("Enemy Unit was pushed to top left corner!");
         }
         else if (findSquare[7][0].isEmpty()) {
             findSquare[7][0].setUnit(toUnit);
             findSquare[toRow][toCol].removeUnit();
             this.game.changeTurn();
             System.out.println("Enemy Unit was pushed to bottom left corner!");
         }

    }

}
