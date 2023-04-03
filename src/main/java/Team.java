import java.util.ArrayList;

/**
 * This class creates a Team
 * @Author Joey Dare & Tommy Parisi
 * @Version 1.0
 */

public class Team {
    private String color;
    private ArrayList<Unit> teamUnit;
    /**
     * This constructor creates a team and assigns the color and Unit Team ArrayList to its properties
     * @param color assigns the color passed to the property value
     * @param team assigns the ArrayList of Units passed to the property value
     */
    public Team(String color, ArrayList<Unit> team) {
        this.color = color;
        this.teamUnit = team;
    }
    //Returns the team color
    public String getTeamColor() {
        return this.color;
    }
    //Returns the ArrayList of Units
    public ArrayList<Unit> getTeamUnits() {
        return this.teamUnit;
    }
    //This mutator method removes the unit passed into the function from the ArrayList of Units
    public void removeUnitsFromTeam(Unit unit) {
        this.teamUnit.remove(unit);
    }
    //This mutator method adds the unit passed into the function from the ArrayList of Units
    public void addUnitsToTeam(Unit unit) {
        unit.setTeamColor(this.color);
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

