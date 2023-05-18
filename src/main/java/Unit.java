
public abstract class Unit {
    protected char symbol; //text representation of the piece
    protected String name; //the units name
    protected double health; //the units base health
    protected double healthModifier; //modifications to units health
    protected double damage; //the units base damage
    protected double damageModifier; //modifications to units damage
    protected int luck; //our random luck mechanism
    protected int xCor; //current coord on x axis
    protected int yCor; //current coord on y axis
    protected int movement; //amount unit can move
    protected int movementModifier; //modifications to units movement
    protected String teamColor; //the color for the team

    public Unit(char symbol, String name, double health, double healthModifier, double damage, double damageModifier,
                int luck, int xCor, int yCor, int movement, int movementModifier, String teamColor){
        this.symbol = symbol;
        this.name = name;
        this.health = health;
        this.healthModifier = healthModifier;
        this.damage = damage;
        this.damageModifier = damageModifier;
        this.luck = luck;
        this.xCor = xCor;
        this.yCor = yCor;
        this.movement = movement;
        this.movementModifier = movementModifier;
    }
    public char getSymbol(){
        return this.symbol;
    }
    public String getName(){
        return this.name;
    }
    public double getHealth(){
        return this.health;
    }
    public double getHealthModifier(){
        return this.healthModifier;
    }
    public double getDamage(){
        return this.damage;
    }
    public double getDamageModifier(){
        return this.damageModifier;
    }
    public int getLuck(){
        return this.luck;
    }
    public int getxCor(){
        return this.xCor;
    }
    public int getyCor(){
        return this.yCor;
    }
    public int getMovement(){
        return this.movement;
    }
    public int getMovementModifier(){
        return this.movementModifier;
    }
    public String getTeamColor(){
        return this.teamColor;
    }
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setHealth(double health) {
        this.health = health;
    }
    public void setHealthModifier(double healthModifier) {
        this.healthModifier = healthModifier;
    }
    public void setDamage(double damage) {
        this.damage = damage;
    }
    public void setDamageModifier(double damageModifier) {
        this.damageModifier = damageModifier;
    }
    public void setLuck(int luck) {
        this.luck = luck;
    }
    public void setxCor(int xCor) {
        this.xCor = xCor;
    }
    public void setyCor(int yCor) {
        this.yCor = yCor;
    }
    public void setMovement(int movement) {
        this.movement = movement;
    }
    public void setMovementModifier(int movementModifier) {
        this.movementModifier = movementModifier;
    }
    public void setTeamColor(String teamColor) {
        this.teamColor = teamColor;
    }
    public abstract boolean canSpawn();

    @Override
    public String toString(){
        return getTeamColor() + " " + getSymbol();
    }
    public abstract Unit spawn();

    public abstract boolean validMovePath(int fromRow, int fromCol, int toRow, int toCol);

    public abstract boolean validSpawnPath(int fromRow, int fromCol, int toRow, int toCol);

    public abstract boolean validPushPath(int fromRow, int fromCol, int toRow, int toCol);

}