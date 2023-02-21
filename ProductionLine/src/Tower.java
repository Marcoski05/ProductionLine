import java.util.Stack;
import java.awt.Graphics;

/**
 * @author Marco Cecchi-Rivas
 * @see Disk
 * This class holds a stack of Disk objects.
 */
public class Tower {

	private Stack<Disk> pyramid;

	/**
	 * Constructor that creates an empty Stack of disks, pyramid
	 */
	public Tower() {
		pyramid = new Stack<Disk>();
	}

	/**
	 * Draws the Disks sitting on top of eachother, in order. Clones the Tower and destroys the clone to do so.
	 * @param g Graphics object
	 * @param x X location for Tower to be drawn at, from the middle of the bottom
	 * @param y Y location for Tower to be drawn at, from the middle of the bottom
	 */
	public void drawMe(Graphics g, int x, int y) {
		@SuppressWarnings("unchecked")
		Stack<Disk> clone = (Stack<Disk>) pyramid.clone();

		for (int i = clone.size(); i > 0; i--) {
			Disk d = clone.pop();
			d.drawMe(g, x - d.getRadius(), y - (25 * i));
		}
	}

	/**
	 * Pushes an item onto the top of this Tower.
	 * @param d Disk to be pushed onto Tower
	 */
	public void push(Disk d) {
		pyramid.push(d);
	}

	/**
	 * Removes the Disk at the top of this Tower and returns it.
	 * @return the disk at the top of this Tower
	 */
	public Disk pop() {
		try {
			pyramid.peek();
		} catch (Exception e) {
			return null;
		}

		return pyramid.pop();
	}

	/**
	 * Looks at the Disk at the top of this Tower without removing it.
	 * @return the object at the top of this Tower.
	 */
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

	/**
	 * Formats and returns a String that shows each Disk in order within parenthesis. Clones the Tower and destroys the clone to do so.
	 * @return the formatted String
	 */
	@Override
	public String toString() {
		@SuppressWarnings("unchecked")
		Stack<Disk> clone = (Stack<Disk>) pyramid.clone();

		String output = "(";
		while (!clone.empty()) {
			output += clone.pop() + ", ";
		}
		if (output.length() > 1)
			output = output.substring(0, output.length() - 2) + ")";

		return output;
	}
}
