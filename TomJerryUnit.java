/**
 *This class builds the Tom and Jerry character
 * @author
 * Thomas Parisi
 * @version 1.0
*/
public class TomJerryUnit extends Attacker {
    private int numTimesSpawned;
    private boolean homingRocket;
    private boolean offerCheese;
    private boolean hiding;
    private final int MAX_NUM_SPAWNED = 1;

    public TomJerryUnit(char symbol, String name, double health, double healthModifier, double damage,
                        double damageModifier, int luck, int xCor, int yCor, int movement, int movementModifier,
                        boolean homingRocket, boolean offerCheese, boolean hiding, String teamColor, int numAttacks, int livesTaken) {

        super(symbol, name, health, healthModifier, damage, damageModifier,
                luck, xCor, yCor, movement, movementModifier, teamColor, numAttacks, livesTaken);

        this.homingRocket = homingRocket;
        this.offerCheese = offerCheese;
        this.hiding = hiding;
    }

    public TomJerryUnit() {
        this('T', "Tom & Jerry", 100.0, 0.0, 25.0, 0.0,
                0, 5, 5, 1, 0, true, true, false, "Purple", 0, 0);
    }

    public boolean canHomingRocket() {
        return this.homingRocket;
    }

    public boolean canOfferCheese() {
        return this.offerCheese;
    }

    public boolean isHiding() {
        return this.hiding;
    }
    public void setNumTimesSpawned(int numTimesSpawned) {
        this.numTimesSpawned = numTimesSpawned;
    }

    public void setHomingRocket(boolean homingRocket) {
        this.homingRocket = homingRocket;
    }

    public void setOfferCheese(boolean offerCheese) {
        this.offerCheese = offerCheese;
    }

    public void setHiding(boolean hiding) {
        this.hiding = hiding;
    }

    public int getNumTimesSpawned() {
        return numTimesSpawned;
    }

    public boolean canSpawn() {
        return true;
    }
    @Override
    public TomJerryUnit spawn() {
        if (canSpawn()) {
            TomJerryUnit newTJ = new TomJerryUnit();
            newTJ.setSymbol(Character.toLowerCase(this.getSymbol()));
            newTJ.setName("Bart Simpson");
            newTJ.setHealth(100.0);
            newTJ.setHealthModifier(5.0);
            newTJ.setDamage(25.0);
            newTJ.setDamageModifier(10.0);
            newTJ.setLuck(0);
            newTJ.setxCor(1);
            newTJ.setyCor(1);
            newTJ.setMovement(1);
            newTJ.setMovementModifier(1);
            newTJ.setHomingRocket(true);
            newTJ.setOfferCheese(true);
            newTJ.setHiding(false);
            return newTJ;
        }
        else {
            return null;
        }
    }


    public double dealDamage() {
        double totalDamage = getDamage() + getDamageModifier();
        if (canHomingRocket()){
            totalDamage += 10;
        }
        return totalDamage;
    }

    public void takeDamage(double damage) {
        if (!isHiding()) {
            double currentHealth = getHealth();
            currentHealth -= damage;
            setHealth(currentHealth);
        }
    }
    @Override
    public boolean validMovePath(int fromRow, int fromCol, int toRow, int toCol) {
        return true;
    }

    @Override
    public boolean validSpawnPath(int fromRow, int fromCol, int toRow, int toCol) {
        return true;
    }
    @Override
    public boolean validAttackPath(int fromRow, int fromCol, int toRow, int toCol) {
        //Checks if move is on row not up or down column, allowed to attack across row
        if (fromRow == toRow) {
            return true;
        }
        //Checks if move is up or down two columns MAX
        else if (Math.abs(toRow - fromRow) <= 2) {
            //Makes sure no move is across the row when attacking up or down
            if (fromCol == toCol) {
                return true;
            }
        }
        return false;
    }

}