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
      return linkedList.remove();
   }
   
   public Object peek() {   
	   return linkedList.peek();
   }
}