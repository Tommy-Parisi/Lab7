package org.example;

/*
This class builds the Tom and Jerry character
@author
Thomas Parisi
@version 1.0
*/
public class TomJerryUnit extends Unit{
    private int numTimesSpawned; //the number of times this piece has spawned
    private boolean homingRocket; //can use special attack “homing rocket”
    private boolean offerCheese; //can use special ability “offer cheese”
    private boolean hiding; //is the unit hidden on the board
    private final int MAX_NUM_SPAWNED = 1;

    public TomJerryUnit(char symbol, String name, double health, double healthModifier, double damage,
                        double damageModifier, int luck, int xCor, int yCor, int movement, int movementModifier,
                        boolean homingRocket, boolean offerCheese, boolean hiding, String teamColor) {

        super(symbol, name, health, healthModifier, damage, damageModifier,
                luck, xCor, yCor, movement, movementModifier, teamColor);

        this.homingRocket = homingRocket;
        this.offerCheese = offerCheese;
        this.hiding = hiding;
    }

    public TomJerryUnit() {
        this('T', "Tom & Jerry", 100.0, 0.0, 25.0, 0.0,
                0, 5, 5, 1, 0, true, true, false, "Purple");
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

    @Override
    public boolean canRecruit() {
        return recruit;
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
    public Unit spawn() {
            if (canSpawn()) {
                TomJerryUnit newUnit = new TomJerryUnit('b', "Bart Simpson", 100.0,
                        5.0, 25.0, 10.0, 0,
                        1, 1, 1, 1, true,
                        true, true, "Yellow");
                newUnit.setNumTimesSpawned(numTimesSpawned + 1);
                return newUnit;
            } else {
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
}
