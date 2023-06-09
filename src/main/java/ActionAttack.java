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

        if ((fromUnit instanceof TomJerryUnit || fromUnit instanceof StewieGriffinUnit) && fromUnit != null && !this.game.getOpponentPlayer().getTeam().equals(this.game.getCurrentPlayer().getTeam())) {
            //damage dealt and received
            if (fromUnit instanceof TomJerryUnit) {
                if (toUnit instanceof TomJerryUnit) {
                    double toUnitDamage = ((TomJerryUnit)toUnit).dealDamage();
                    System.out.println("Damage dealt to unit: " + toUnitDamage + "!");
                    ((TomJerryUnit)toUnit).takeDamage(toUnitDamage);
                    System.out.println("Health is now at: " + toUnit.getHealth());
                }
                if (toUnit instanceof StewieGriffinUnit) {
                    double toUnitDamage = ((StewieGriffinUnit)toUnit).dealDamage();
                    System.out.println("Damage dealt to unit: " + toUnitDamage + "!");
                    ((StewieGriffinUnit)toUnit).takeDamage(toUnitDamage);
                    System.out.println("Health is now at: " + toUnit.getHealth());
                }
                if (toUnit.getHealth() <= 0) { // Notifies how many points a player recieved
                    System.out.println(game.getCurrentPlayer().getTeam().getTeamColor() + " gets " + toUnit.getPoints() + " points.");
                }
            }
            else if (fromUnit instanceof StewieGriffinUnit) {
                if (toUnit instanceof TomJerryUnit) {
                    double toUnitDamage = ((TomJerryUnit)toUnit).dealDamage();
                    System.out.println("Damage dealt to unit: " + toUnitDamage + "!");
                    ((TomJerryUnit)toUnit).takeDamage(toUnitDamage);
                    System.out.println("Health is now at: " + toUnit.getHealth());
                }
                if (toUnit instanceof StewieGriffinUnit) {
                    double toUnitDamage = ((StewieGriffinUnit)toUnit).dealDamage();
                    System.out.println("Damage dealt to unit: " + toUnitDamage + "!");
                    ((StewieGriffinUnit)toUnit).takeDamage(toUnitDamage);
                    System.out.println("Health is now at: " + toUnit.getHealth());
                }
                if (toUnit.getHealth() <= 0) { //Notifies how many points a player revieves
                    System.out.println(game.getCurrentPlayer().getTeam().getTeamColor() +
                            " gets " + toUnit.getPoints() + " points.");
                }
            }

            // If the defending unit is a TomJerryUnit or StewieGriffinUnit and its health is 0 or less, remove from the opponent's team
            if((toUnit instanceof TomJerryUnit || toUnit instanceof StewieGriffinUnit) && toUnit.getHealth() <= 0) {
                this.game.getCurrentPlayer().getTeam().addPointsToTeam(toUnit); // adds points to a team
                this.game.getOpponentPlayer().getTeam().removeUnitsFromTeam(toUnit);

                findUnit[fromRow][fromCol].getUnit().incrementLivesTaken(); //adds one to livesTaken
                if (findUnit[fromRow][fromCol].getUnit().getLivesTaken() == 2){
                    System.out.println("Two Unit Killstreak!");
                    System.out.println("A TomJerryUnit has been added to your team!");
                    TomJerryUnit tomJerry = new TomJerryUnit();
                    game.getCurrentPlayer().getTeam().addUnitsToTeam(tomJerry);
                    game.getGameBoard().findRandomEmptySpace().setUnit(tomJerry);
                    tomJerry.setTeamColor(findUnit[fromRow][fromCol].getUnit().teamColor);
                }

                findUnit[toRow][toCol].removeUnit();
                findUnit[toRow][toCol].setUnit(fromUnit);
                findUnit[fromRow][fromCol].removeUnit();

            }
            // If the unit being attacked is a BartSimpsonUnit or SquidwardUnit, remove it
            else if(toUnit instanceof BartSimpsonUnit || toUnit instanceof SquidwardUnit) {
                this.game.getCurrentPlayer().getTeam().addPointsToTeam(toUnit); // adds points to a team
                System.out.println(game.getCurrentPlayer().getTeam().getTeamColor() +
                        " gets " + toUnit.getPoints() + " points.");

                findUnit[fromRow][fromCol].getUnit().incrementLivesTaken(); //adds one to livesTaken
                if (findUnit[fromRow][fromCol].getUnit().getLivesTaken() == 2){
                    System.out.println("Two Unit Killstreak!");
                    System.out.println("A TomJerryUnit has been added to your team!");
                    TomJerryUnit tomJerry = new TomJerryUnit();
                    game.getCurrentPlayer().getTeam().addUnitsToTeam(tomJerry);
                    game.getGameBoard().findRandomEmptySpace().setUnit(tomJerry);
                    tomJerry.setTeamColor(findUnit[fromRow][fromCol].getUnit().teamColor);
                }

                this.game.getOpponentPlayer().getTeam().removeUnitsFromTeam(toUnit);
                findUnit[toRow][toCol].removeUnit();
                findUnit[toRow][toCol].setUnit(fromUnit);
                findUnit[fromRow][fromCol].removeUnit();


            }
            // Change the turn
            this.game.changeTurn();
        }
    }

}


