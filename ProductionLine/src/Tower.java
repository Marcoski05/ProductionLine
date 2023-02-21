import java.util.Stack;

/**
 * @author mcecc
 *
 */
public class Tower {
   
   Stack<Disk> pyramid;
   
   public Tower() {
      pyramid = new Stack<Disk>();
   }
   
   public void push(Disk d) {
	   pyramid.push(d);
   }
   
   public Disk pop() {
	   try {
		   pyramid.peek();
	   } catch (Exception e) {
		   return null;
	   }
	   
	   return pyramid.pop();
   }
   
   public Disk peek() {
	   try {
		   pyramid.peek();
	   } catch (Exception e) {
		   return null;
	   }
	   return pyramid.peek();
   }
   
   public boolean empty() {
	   return peek() == null;
   }
   
   @Override
   public String toString() {
      @SuppressWarnings("unchecked")
	Stack<Disk> clone = (Stack<Disk>)pyramid.clone();
      
      String output = "(";
      while (!clone.empty()) {
         output += clone.pop() + ", ";
      }
      if (output.length() > 1)
    	  output = output.substring(0, output.length()-2) + ")";
      
      return output;
   }
}
