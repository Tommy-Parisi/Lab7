public class Rules {

    public static boolean checkValidAction(Game gamePlayed, int fromRow, int fromCol,
                                           int toRow, int toCol, char actionType) {
                actionType = Character.toLowerCase(actionType);
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
            Unit unitMakingAction = findUnit[fromRow][fromCol].getUnit();

            // Check that the unit on the from square belongs to the current team
            if (!(unitMakingAction.getTeamColor().equals(gamePlayed.getCurrentPlayer().getTeam().getTeamColor()))) {
                return false;
            }
            else {
                if (actionType == 'm' && findUnit[fromRow][fromCol].isEmpty() && unitMakingAction.validMovePath()) {
                    return true;
                }
                else if (actionType == 's' && findUnit[fromRow][fromCol].isEmpty() && unitMakingAction.validSpawnPath() && unitMakingAction.canSpawn()){
                    return true;
                }
                else if (actionType == 'r' && findUnit[fromRow][fromCol].isEmpty() && unitMakingAction.validRecruitPath()){
                    return true;
                }
                else if (actionType == 'a' && findUnit[fromRow][fromCol].isEmpty() && unitMakingAction.validAttackPath()){
                    return true;
                }
                else {
                    return false;
                }
            }
        }

    }
}
