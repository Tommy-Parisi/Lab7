public class Team {
    private String color;
    private ArrayList<Unit> teamUnit;
    public Team(String color, ArrayList<Unit> team) {
        this.color = color;
        this.teamUnit = team;
    }
    public String getTeamColor() {
        return this.color;
    }
    public ArrayList<Unit> getTeamUnits() {
        return this.teamUnit;
    }
    public void removeUnitsFromTeam(Unit unit) {
        this.teamUnit.remove(unit);
    }
    public void addUnitsToTeam(Unit unit) {
        unit.setColor(this.color);
        this.teamUnit.add(unit);
    }
    @Override
    public String toString() {
        String output = "Team " + this.color + " Units : \n";
        for (Unit unit : this.teamUnit) {
            output += unit.toString() + " ";
        }
        return output;
    }
}




}
