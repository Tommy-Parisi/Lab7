/**
This class builds the Stewie Griffin character
@author
Joey Dare
@version 1.0
*/
public class StewieGriffinUnit extends Attacker {

    private int numTimesSpawned;
    //New Unit Modifications: if Stewie has a laser gun it increases the damage modifier by 20.0
    private boolean laserGun;
    //New Unit Modifications: if Stewie has his Tricycle he can only attack and move in 3x3 radius
    //else he can only attack and move 2 spaces infront or above him
    private boolean Tricycle;
    //New Unit Modifications: if Stewie is in his crib he takes half damage
    private boolean crib;
    private final int MAX_NUM_SPAWNED = 1;

    public StewieGriffinUnit(char symbol, String name, double health, double healthModifier, double damage,
                        double damageModifier, int luck, int xCor, int yCor, int movement, int movementModifier,
                        boolean laserGun, boolean Tricycle, boolean crib, String teamColor, int numAttacks, int points) {

        super(symbol, name, health, healthModifier, damage, damageModifier,
                luck, xCor, yCor, movement, movementModifier, teamColor, numAttacks, points);

        this.laserGun = laserGun;
        this.Tricycle = Tricycle;
        this.crib = crib;
    }

    public StewieGriffinUnit() {
        this('G', "Stewie Griffin", 100.0, 0.0, 25.0, 0.0,
                0, 5, 5, 1, 0, true, true, false, "Purple", 0, 2);
    }

    public boolean hasLaserGun() {
        return this.laserGun;
    }

    public boolean hasTricycle() {
        return this.Tricycle;
    }

    public boolean inCrib() {
        return this.crib;
    }
    public void setNumTimesSpawned(int numTimesSpawned) {
        this.numTimesSpawned = numTimesSpawned;
    }

    public void setLaserGun(boolean laserGun) {
        this.laserGun = laserGun;
    }

    public void setTricycle(boolean Tricycle) {
        this.Tricycle = Tricycle;
    }

    public void setCrib(boolean crib) {
        this.crib = crib;
    }

    public int getNumTimesSpawned() {
        return numTimesSpawned;
    }

    public boolean canSpawn() {
        return true;
    }
    @Override
    public StewieGriffinUnit spawn() {
        if (canSpawn()) {
            StewieGriffinUnit newSG = new StewieGriffinUnit();
            newSG.setSymbol(Character.toLowerCase(this.getSymbol()));
            newSG.setName("Stewie Griffin");
            newSG.setHealth(100.0);
            newSG.setHealthModifier(5.0);
            newSG.setDamage(25.0);
            newSG.setDamageModifier(10.0);
            newSG.setLuck(0);
            newSG.setxCor(1);
            newSG.setyCor(1);
            newSG.setMovement(1);
            newSG.setMovementModifier(1);
            newSG.setLaserGun(true);
            newSG.setTricycle(true);
            newSG.setCrib(false);
            newSG.setPoints(1);
            return newSG;
        }
        else {
            return null;
        }
    }

    //New Unit Modifications: hasLaserGun (Increases damage modifier)
    public double dealDamage() {
        double totalDamage = getDamage() + getDamageModifier();
        if (hasLaserGun()){
            setDamageModifier(20.0);
            totalDamage = getDamage() + getDamageModifier();
        }
        return totalDamage;
    }

    public void takeDamage(double damage) {
        if (!inCrib()) {
            double currentHealth = getHealth();
            currentHealth -= damage;
            setHealth(currentHealth);
        }
        //New Unit Modifications: inCrib (Half Damage)
        else if (inCrib()) {
            double currentHealth = getHealth();
            currentHealth -= (damage / 2);
            setHealth(currentHealth);
        }
    }
    //New Unit Modifications: hasTricycle (Increases movement)
    @Override
    public boolean validMovePath(int fromRow, int fromCol, int toRow, int toCol) {
        if (hasTricycle()) {
            if (Math.abs(toRow - fromRow) <= 3) {
                if (Math.abs(toCol - fromCol) <= 3) {
                    return true;
                }
            }
        }
        else if (Math.abs(toCol - fromCol) <= 2) {
            if (toRow == fromRow) {
                return true;
            }
        }
        else if (Math.abs(toRow - fromRow) <= 2) {
            if (toCol == fromCol) {
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean validSpawnPath(int fromRow, int fromCol, int toRow, int toCol) {
        return true;
    }
    //New Unit Modifications: hasTricycle (Increases attack radius)
    @Override
    public boolean validAttackPath(int fromRow, int fromCol, int toRow, int toCol) {
        if (hasTricycle()) {
            if (Math.abs(toRow - fromRow) <= 3) {
                if (Math.abs(toCol - fromCol) <= 3) {
                    return true;
                }
            }
        }
        else if (Math.abs(toCol - fromCol) <= 2) {
            if (toRow == fromRow) {
                return true;
            }
        }
        else if (Math.abs(toRow - fromRow) <= 2) {
            if (toCol == fromCol) {
                return true;
            }
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
