public abstract class Attacker extends Unit {
    private int numAttacks;

    // Updated to include points
    public Attacker(char symbol, String name, double health, double healthModifier,
                    double damage, double damageModifier, int luck, int xCor, int yCor,
                    int movement, int movementModifier, String teamColor, int numAttacks, int points, int livesTaken){
        super(symbol, name, health, healthModifier, damage, damageModifier,
                luck, xCor, yCor, movement, movementModifier, teamColor, points, livesTaken);
        this.numAttacks = numAttacks;
    }
    public int getNumAttacks() {
        return numAttacks;
    }
    public void setNumAttacks(int numAttacks) {
        this.numAttacks = numAttacks;
    }

    public abstract boolean validAttackPath(int fromRow, int fromCol, int toRow, int toCol);
}
