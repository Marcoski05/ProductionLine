import java.util.Stack;

/**
 * @author mcecc
 *
 */
public class ProductionLine {
   
   Queue input;
   Queue output;
   Tower arm;
   
   public ProductionLine() {
      input = new Queue();
      output = new Queue();
      arm = new Tower();
   }
   
   public void addDisk(Disk d) {
      input.enqueue(d);
   }
   
   private void unloadRobot() {
      if(arm.empty())
    	  return;
	   
	  Tower tower = new Tower();
      while (!arm.empty())
         tower.push(arm.pop());
      
      output.enqueue(tower);
   }
   
   public void process() {
	   while (input.peek() != null) {
    	  if (arm.peek() == null || ((Disk)input.peek()).compareTo(arm.peek()) >= 0) {
    		  arm.push((Disk)input.dequeue());}
         else {
            unloadRobot();}
      }
      unloadRobot();
   }
   
   public Tower removeTower() {
	  return (Tower)output.dequeue();
   }
   
}