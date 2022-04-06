import java.util.Random;
import java.awt.Color;

public class Octopus extends Critter {

    // build this String with each new Critter we encounter
    private String nearby = "";

    // list of possible directions we can look for neighbors
    private final Direction[] moves = {Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST};
    
    // always pounce
    public Attack fight(String opponent) {
		return Attack.POUNCE;
	}

    // always yellow
    public Color getColor() {
        return Color.YELLOW;
    }

    public Direction getMove(String[][] grid) {
        int sz = 5;
        
        nearby = "";
        for (int i = getX() - sz; i < getX() + sz; i++){
            for (int j = getY() - sz; j < getY() + sz; j++){
                int x = Math.floorMod(i, getWidth());
                int y = Math.floorMod(j, getHeight());
                if (!grid[x][y].equals(" ") 
                        && !grid[x][y].equals(".")
                        && !grid[x][y].equals("#")
                    )
                    nearby += grid[x][y]; 
            }
        }
        return Direction.CENTER;
    }

    // mimic neighbor, else pose as a random nearby Critter, else "#"
	public String toString() {
        // mimic neighbor
        for (int i = 0; i < moves.length; i++) {
            String tmp = getNeighbor(moves[i]);
            if (!tmp.equals(" ")) return tmp;
        }

        // no critters nearby: relax
        if (nearby.equals("")) return "#";

        // pose as random nearby critter
        Random rand = new Random();
        int index = rand.nextInt(nearby.length());
        return nearby.substring(index, index+1);
	}
}
