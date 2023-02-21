import java.awt.Graphics;

/**
 * @author Marco Cecchi-Rivas
 * This class represents disks with a given radius.
 */
public class Disk implements Comparable<Disk> {

	private int radius;
	private final int HEIGHT = 25;

	/**
	 * Constructor that sets radius.
	 * @param r Disk's radius
	 */
	public Disk(int r) {
		radius = r;
	}

	/**
	 * Draws the Disk as a rectangle with proper radius.
	 * @param g Graphics object
	 * @param x X location for Disk to be drawn at.
	 * @param y Y location for Disk to be drawn at.
	 */
	public void drawMe(Graphics g, int x, int y) {
		g.fillRect(x, y, radius * 2, HEIGHT);
	}

	/**
	 * Compares Disk to given Disk, other, by their radii
	 * @param other Disk to be compared to
	 * @return positive number if this is greater than other, negative if this is less than other, 0 if equal.
	 */
	@Override
	public int compareTo(Disk other) {
		return radius - other.radius;
	}

	/**
	 * Tells whether Disk other is equal to this Disk, using their radius
	 * @param other Disk to be compared to
	 * @return true if disks are equal, false if not
	 */
	@Override
	public boolean equals(Object other) {
		if (other instanceof Disk)
			return this.compareTo((Disk) other) == 0;

		return false;
	}

	/**
	 * returns the radius of the Disk
	 * @return the int radius of the Disk
	 */
	public int getRadius() {
		return radius;
	}

	/**
	 * returns a String giving the radius
	 * @return string formatted like "radius: " + radius
	 */
	@Override
	public String toString() {
		return "radius: " + radius;
	}
}
