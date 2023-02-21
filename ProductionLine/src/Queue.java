import java.util.LinkedList;
import java.awt.Graphics;

/**
 * @author Marco Cecchi-Rivas
 * @see Disk, Tower
 * This class holds a queue of objects, but is specifically made for Disks and Towers.
 */
public class Queue {

	private LinkedList<Object> linkedList;

	/**
	 * Constructor that creates a linked list to use as the queue
	 */
	public Queue() {
		linkedList = new LinkedList<Object>();
	}

	/**
	 * Draws the queue horizontally. Clones the queue and destroys the clone to do so.
	 * @param g Graphics object
	 * @param x X location for the queue to be drawn at
	 * @param y Y location for the queue to be drawn at
	 */
	public void drawMe(Graphics g, int x, int y) {
		@SuppressWarnings("unchecked")
		LinkedList<Object> clone = (LinkedList<Object>) linkedList.clone();

		try {
			Disk d = (Disk) clone.peek();
		} catch (ClassCastException e) {
			for (int i = clone.size(); i > 0; i--) {
				Tower t = (Tower) clone.remove();
				t.drawMe(g, x + (200 * i) - 100, y + 25);
			}
			return;
		}
		for (int i = clone.size(); i > 0; i--) {
			Disk d = (Disk) clone.remove();
			d.drawMe(g, x + (200 * i) - 100 - d.getRadius(), y);
		}
	}

	/**
	 * Adds newData to the Queue from the back
	 * @param newData the Object to be enqueued to the Queue
	 */
	public void enqueue(Object newData) {
		linkedList.add(newData);
	}

	/**
	 * Removes the object at the front of the Queue
	 * @return the object at the front of the queue
	 */
	public Object dequeue() {
		if (peek() == null)
			return null;

		return linkedList.remove();
	}

	/**
	 * Looks at, but does not remove, the object at the front of the Queue
	 * @return object at the front of the Queue
	 */
	public Object peek() {
		return linkedList.peek();
	}

	/**
	 * returns the number of elements in this Queue
	 * @return the number of  elements in the Queue
	 */
	public int size() {
		return linkedList.size();
	}
}