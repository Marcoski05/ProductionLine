import java.util.LinkedList;

/**
 * @author mcecc
 *
 */
public class Queue {
   
   private LinkedList<Object> linkedList;
    
   public Queue() {
       linkedList = new LinkedList<Object>();
   }
   
   public void enqueue(Object newData) {
      linkedList.add(newData);
   }
   
   public Object dequeue() {
	   if (peek() == null)
		   return null;
	   
	   return linkedList.remove();
   }
   
   public Object peek() {   
	   return linkedList.peek();
   }
}