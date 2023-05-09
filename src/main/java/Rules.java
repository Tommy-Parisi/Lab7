/**
 This class contains the rules to check if an action is valid or not
 @author
 Joey Dare
 @version 1.0
 */
public class Rules {
    /**
     * @param gamePlayed
     * @param fromRow
     * @param fromCol
     * @param toRow
     * @param toCol
     * @param actionType
     * @return boolean, true if the action performed is valid, else it returns false
     */
    public static boolean checkValidAction(Game gamePlayed, int fromRow, int fromCol,
                                           int toRow, int toCol, char actionType) {
                actionType = Character.toLowerCase(actionType);
                System.out.println(fromRow);
        System.out.println(fromCol);
        System.out.println(toRow);
        System.out.println(toCol);
        System.out.println(actionType);
        // Check that the from and to square indexes are in bounds
        if ((gamePlayed.getGameBoard().inBounds(fromRow, fromCol) == false) ||
                gamePlayed.getGameBoard().inBounds(toRow, toCol) == false) {
            return false;
        } else {
            /**
             * Gets the unit making the action by getting the BoardSquare[][] and
             * then using the getUnit() on the rowIndexMake and colIndexMake passed into this method
             */
            BoardSquare[][] findUnit = gamePlayed.getGameBoard().getSquares();
            Unit fromUnit = findUnit[fromRow][fromCol].getUnit();
            Unit toUnit = findUnit[toRow][toCol].getUnit();

            // Check that the unit on the from square belongs to the current team
            if (!(fromUnit.getTeamColor().equals(gamePlayed.getCurrentPlayer().getTeam().getTeamColor()))) {
                return false;
            }
            else {
                if (actionType == 'm' && findUnit[toRow][toCol].isEmpty() && fromUnit.validMovePath()) {
                    return true;
                }
                else if (actionType == 's' && findUnit[toRow][toRow].isEmpty() && fromUnit.validSpawnPath() && fromUnit.canSpawn()){
                    return true;
                }
                else if (actionType == 'r' && (!(findUnit[toRow][toCol].isEmpty())) && fromUnit instanceof BartSimpsonUnit && fromUnit.validRecruitPath()){
                    return true;
                }
                else if (actionType == 'a' && (!(findUnit[toRow][toCol].isEmpty())) && fromUnit instanceof TomJerryUnit && fromUnit.validAttackPath()){
                    return true;
                }
                else {
                    return false;
                }
            }
        }

    }
}
