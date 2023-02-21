import java.util.LinkedList;
import java.awt.Graphics;

/**
 * @author mcecc
 *
 */
public class Queue {

	private LinkedList<Object> linkedList;

	public Queue() {
		linkedList = new LinkedList<Object>();
	}

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

	public int size() {
		return linkedList.size();
	}
}