import java.awt.Color;

public class Ant extends Critter {
  protected boolean walkSouth;   // # steps in curr. Horiz. cycle 
  protected int steps; 
    
 public Ant(boolean whatever) {
   walkSouth = whatever; 
   steps = 0; 
   //  System.out.println(getClass().getName());
 }
 
 public boolean eat() {
   return true;
 }
 
 public Attack fight(String opponent) { 
   return Attack.SCRATCH;
 }
 
 public Color getColor() {
  return Color.RED;
 }
 
 public Direction getMove(String[][] grid) {
  steps++;
  if (walkSouth) 
    if (steps % 2 == 1) return Direction.SOUTH; 
    else return Direction.EAST; 
  else
    if (steps % 2 == 1) return Direction.NORTH; 
    else return Direction.EAST; 
 }

 public String toString() {
  return "%";
 }
}
