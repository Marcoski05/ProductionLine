import java.awt.Graphics;

/**
 * @author mcecc
 *
 */
public class Disk implements Comparable<Disk> {

	private int radius;
	private final int HEIGHT = 25;

	public Disk(int r) {
		radius = r;
	}

	public void drawMe(Graphics g, int x, int y) {
		g.fillRect(x, y, radius * 2, HEIGHT);
	}

	@Override
	public int compareTo(Disk other) {
		return radius - other.radius;
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof Disk)
			return this.compareTo((Disk) other) == 0;

		return false;
	}

	public int getRadius() {
		return radius;
	}

	@Override
	public String toString() {
		return "radius: " + radius;
	}
}
