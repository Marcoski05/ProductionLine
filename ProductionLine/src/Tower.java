/**
 * @author mcecc
 *
 */
import java.util.Stack;

public class Tower {
   
   Stack<Disk> pyramid;
   
   public Tower() {
      pyramid = new Stack<Disk>();
   }
   
   public String toString() {
      Stack<Disk> clone = (Stack<Disk>) pyramid.clone();
      
      String output = "(";
      while (clone.empty() == true) {
         output += clone.pop() + ", ";
      }
      output = output.substring(0, output.length()-2) + ")";
      
      return output;
   }
}
