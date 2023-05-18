/**
This class builds the Squidward character
@author
Joey Dare
@version 1.0
*/
public class SquidwardUnit extends Recruiter {
    
        private int numTimesSpawned;
        //New Unit Modifications: if Squidward has his clarinet he can recruit units on his whole row
        //Without the clarinet he can only recruit units within two spaces infront or behind of him
        private boolean clarinet;
        protected boolean recruit; //can recruit other units
        private final int MAX_NUM_SPAWNED = 1;

        public SquidwardUnit(char symbol, String name, double health, double healthModifier,
                               double damage, double damageModifier, int luck, int xCor, int yCor,
                               int movement, int movementModifier, int numTimesSpawned,
                               boolean clarinet, boolean recruit, String teamColor, int numRecruits) {

            super(symbol, name, health, healthModifier, damage, damageModifier,
                    luck, xCor, yCor, movement, movementModifier, teamColor, numRecruits);

            this.numTimesSpawned = numTimesSpawned;
            this.clarinet = clarinet;
            setRecruit(recruit);
        }

        public SquidwardUnit() {
            this('S', "Squidward", 100.0, 0.0, 25.0,
                    0.0, 0, 5, 5, 1, 0,
                    0, true, true, "Yellow", 0);
        }

        public int getNumTimesSpawned() {
            return this.numTimesSpawned;
        }

        public boolean hasClarinet() {
            return this.clarinet;
        }

        public void setNumTimesSpawned(int numTimesSpawned) {
            this.numTimesSpawned = numTimesSpawned;
        }

        public void setClarinet(boolean clarinet) {
            this.clarinet = clarinet;
        }

        public void setRecruit(boolean recruit) {
            this.recruit = recruit;
        }

        public boolean canRecruit() {
            return this.recruit;
        }

        public boolean canSpawn() {
            // Check if the unit is an original piece
            if (Character.isUpperCase(getSymbol())) {
                // Check if the unit hasn't reached its maximum number of spawns
                return numTimesSpawned < MAX_NUM_SPAWNED;
            } else {
                // Non-original pieces can't spawn
                return false;
            }
        }

        @Override
        public SquidwardUnit spawn() {
            if (canSpawn()) {
                SquidwardUnit newSquidward = new SquidwardUnit();
                newSquidward.setSymbol(Character.toLowerCase(this.getSymbol()));
                newSquidward.setName("Squidward");
                newSquidward.setHealth(100.0);
                newSquidward.setHealthModifier(5.0);
                newSquidward.setDamage(25.0);
                newSquidward.setDamageModifier(10.0);
                newSquidward.setLuck(0);
                newSquidward.setxCor(1);
                newSquidward.setyCor(1);
                newSquidward.setMovement(1);
                newSquidward.setMovementModifier(1);
                newSquidward.setClarinet(true);
                newSquidward.setRecruit(true);
                setNumTimesSpawned(this.getNumTimesSpawned() + 1);
                return newSquidward;
            } else {
                return null;
            }
        }
        @Override
        public boolean validRecruitPath(int fromRow, int fromCol, int toRow, int toCol) {
            //New Unit Modifications: hasClarinet (Can recruit whole row)
            if (hasClarinet()) {
                if (toRow == fromRow) {
                    return true;
                }
            }
            else if (Math.abs(toCol - fromCol) <= 2) {
                if (toRow == fromRow) {
                    return true;
                }
            }
            return false;
        }
        //Squidward can move 3 spaces up or down, OR, 3 spaces forward or back
        @Override
        public boolean validMovePath(int fromRow, int fromCol, int toRow, int toCol) {
            //Check if move is on the same column
            if (fromCol == toCol) {
                if (Math.abs(toRow - fromRow) <= 3) {
                    return true;
                }
            }
            // Check if the move is exactly two spaces or fewer across and no spaces down the column
            else if (Math.abs(toCol - fromCol) <= 3) {
                if (toRow == fromRow) {
                    return true;
                }
            }
            return false;
        }
        //Squidward can spawn units either in his row or column (essentially in a '+' pattern)
        @Override
        public boolean validSpawnPath(int fromRow, int fromCol, int toRow, int toCol) {
            //Check if move is on the same column
            if (fromCol == toCol) {
                return true;
            }
            // Check if the move is exactly two spaces or fewer across and no spaces down the column
            else if (fromRow == toRow) {
                return true;
            }
            return false;
        }

    //New Action Modification validPushPath (Checks if toUnit is within two spaces of fromUnit)
    @Override
    public boolean validPushPath(int fromRow, int fromCol, int toRow, int toCol) {
        if (Math.abs(toCol - fromCol) <= 2) {
            if (toRow == fromRow) {
                return true;
            }
        }
        return false;
    }

    }
