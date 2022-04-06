import java.util.Random;
import java.awt.Color;

public class Octopus extends Critter {

    // store all nearby enemy String types
    private String nearby = "";

    // list of possible directions we can look for neighbors
    private final Direction[] moves = {Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST};
    
    // WE DO: always pounce
    public Attack fight(String opponent) {
		return Attack.POUNCE;
	}

    // WE DO: always yellow
    public Color getColor() {
        return Color.YELLOW;
    }

    // WE DO: scan the area for other Critters and add to String nearby
    public Direction getMove(String[][] grid) {
        int sz = 5;
        nearby = "";
        for (int i = getX() - sz; i < getX() + sz; i++){
            for (int j = getY() - sz; j < getY() + sz; j++){

            }
        }
        // does not move
        return Direction.CENTER;
    }

    // WE DO: mimic neighbor, else pose as a random nearby Critter, else "#"
	public String toString() {
        // WE DO: if neighbor is an enemy, mimic them

        // no critters nearby -> relax
        if (nearby.equals("")) return "#";

        // WE DO: pose as random nearby critter
        Random rand = new Random();
        int index;
        return "";
	}

    // WE DO: determine if String test contains an enemy Critter
    private boolean isEnemy(String test) {
        return false;
    }
}
