import java.awt.Color;

public class FireAnt extends Ant {
  // static variables accessible by all fire ants
  private static int moundX;
  private static int moundY;

  private static int maxNumToMate;
  private static int numToMate;
  private static double numVisits;

  // variables unique to each fire ant
  private boolean mated;

  private boolean visited;
  private int slopeX;
  private int slopeY;

  // NOTE: Ant parent class provides a few more unique vars

  public FireAnt(boolean whatever) {
    super(whatever);
    updateMateVars();
  }

  // HELPER: inc numToMate, try to update maxNumToMate
  public void updateMateVars() {
    numToMate++;
    if (maxNumToMate < numToMate) maxNumToMate = numToMate;
  }

  // only eat if already mated
  public boolean eat() {
    return !mated;
  }

  // ant -> fireAnt : red -> orange
  public Color getColor() {
    return Color.ORANGE;
  }

  // crowd around mounds move behavior
  public Direction getMove(String[][] grid) {

    // if 4+ fire ants are still able to mate...
    if (numToMate > 3)
    
      // crowding: if has mated, return to mound less often
      if (mated && steps % (maxNumToMate * 1.5) == 0) {
        visited = false;
        steps++;
      }
      // else report to mound by unmated pop count, at least every 2 steps
      else if (steps % Math.max(numToMate, 2) == 0) visited = false;

    // move the mound if visited by majority of unmated ants
    if (numVisits > numToMate / 2) {
      moundX = (int) (Math.random() * getWidth());
      moundY = (int) (Math.random() * getHeight());
      numVisits = 0;
    }

    // directions to reach the mound
    slopeX = moundX - getX();
    slopeY = moundY - getY();

    // event: if mound is visited, update visit status
    if (slopeX == 0 && slopeY == 0) {
      visited = true;

      // unmated fire ants count for a whole visit, else half visit
      if (!mated) numVisits++;
      else numVisits += 0.5;
    }

    // default ant behaviour until next visit status update
    if (visited) return super.getMove(grid);

    // step in x or y towards the mound pending dx <> dy 
    if (Math.abs(slopeX) > Math.abs(slopeY)) {
      if (slopeX > 0)
        return Direction.EAST;
      else
        return Direction.WEST;
    } else {
      if (slopeY > 0)
        return Direction.SOUTH;
      else
        return Direction.NORTH;
    }
  }

  // Critter class event: update unmated pop count
  public void mateEnd() {
    mated = true;
    numToMate--;
  }

  // Critter class event: update unmated pop count
  public void lose() {
    if (!mated) numToMate--;
  }
}
