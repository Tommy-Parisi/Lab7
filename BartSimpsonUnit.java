/*
This class builds the Bart Simpson character
@author
Thomas Parisi
@version 1.0
*/
public class BartSimpsonUnit extends Recruiter {
    private int numTimesSpawned;
    private boolean distract;
    protected boolean recruit; //can recruit other units
    private final int MAX_NUM_SPAWNED = 1;

    public BartSimpsonUnit(char symbol, String name, double health, double healthModifier,
                           double damage, double damageModifier, int luck, int xCor, int yCor,
                           int movement, int movementModifier, int numTimesSpawned,
                           boolean distract, boolean recruit, String teamColor, int numRecruits, int livesTaken) {

        super(symbol, name, health, healthModifier, damage, damageModifier,
                luck, xCor, yCor, movement, movementModifier, teamColor, numRecruits, livesTaken);

        this.numTimesSpawned = numTimesSpawned;
        this.distract = distract;
        setRecruit(recruit);
    }

    public BartSimpsonUnit() {
        this('B', "Bart Simpson", 100.0, 0.0, 25.0,
                0.0, 0, 5, 5, 1, 0,
                0, true, true, "Yellow", 0, 0);
    }

    public int getNumTimesSpawned() {
        return numTimesSpawned;
    }

    public boolean isDistract() {
        return distract;
    }

    public void setNumTimesSpawned(int numTimesSpawned) {
        this.numTimesSpawned = numTimesSpawned;
    }

    public void setDistract(boolean distract) {
        this.distract = distract;
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

    public void distracted() {
        boolean distracted = isDistract();
        if (distracted) {
            System.out.println("Unit Distracted!");
        }
    }

    @Override
    public BartSimpsonUnit spawn() {
        if (canSpawn()) {
            BartSimpsonUnit newBart = new BartSimpsonUnit();
            newBart.setSymbol(Character.toLowerCase(this.getSymbol()));
            newBart.setName("Bart Simpson");
            newBart.setHealth(100.0);
            newBart.setHealthModifier(5.0);
            newBart.setDamage(25.0);
            newBart.setDamageModifier(10.0);
            newBart.setLuck(0);
            newBart.setxCor(1);
            newBart.setyCor(1);
            newBart.setMovement(1);
            newBart.setMovementModifier(1);
            newBart.setDistract(true);
            newBart.setRecruit(true);
            setNumTimesSpawned(this.getNumTimesSpawned() + 1);
            return newBart;
        } else {
            return null;
        }
    }
    @Override
    public boolean validRecruitPath(int fromRow, int fromCol, int toRow, int toCol) {
        //Check if move is on the same column
        if (fromCol == toCol) {
            return true;
        }
        // Check if the move is within two spaces across the row
        else if (Math.abs(toCol - fromCol) <= 2) {
            // Check if the move is exactly two spaces across and no spaces down the column
            if (toRow == fromRow) {
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean validMovePath(int fromRow, int fromCol, int toRow, int toCol) {
        //Check if move is on the same column
        if (fromCol == toCol) {
                return true;
            }
        // Check if the move is exactly two spaces or fewer across and no spaces down the column
        else if (Math.abs(toCol - fromCol) <= 2) {
            if (toRow == fromRow) {
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean validSpawnPath(int fromRow, int fromCol, int toRow, int toCol) {
        //Check if move is on the same column
        if (fromCol == toCol) {
            return true;
        }
        // Check if the move is exactly two spaces or fewer across and no spaces down the column
        else if (Math.abs(toCol - fromCol) <= 2) {

            if (toRow == fromRow) {
                return true;
            }
        }
        return false;
    }


}