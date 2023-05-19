public abstract class Recruiter extends Unit {
    private int numRecruits;

    public Recruiter(char symbol, String name, double health, double healthModifier,
                     double damage, double damageModifier, int luck, int xCor, int yCor,
                     int movement, int movementModifier, String teamColor, int numRecruits, int livesTaken){
        super(symbol, name, health, healthModifier, damage, damageModifier,
                luck, xCor, yCor, movement, movementModifier, teamColor, livesTaken);
        this.numRecruits = numRecruits;
    }
    public int getNumRecruits() {
        return numRecruits;
    }
    public void setNumRecruits(int numRecruits) {
        this.numRecruits = numRecruits;
    }

    public abstract boolean validRecruitPath(int fromRow, int fromCol, int toRow, int toCol);
}