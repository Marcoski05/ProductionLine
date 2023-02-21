import javax.swing.JFrame;
import java.awt.Graphics;

/**
 * @author Marco Cecchi-Rivas
 * @see Disk, Tower, Queue
 * This class takes Disks as input and outputs pyramids made from the Disks in the order they were given. The input is stored in a queue, processed by a "robotic arm" into an inverted pyramid, then flipped back over into the output queue of Towers.
 */
public class ProductionLine {

	private Queue input;
	private Queue output;
	private Tower arm;
	private JFrame window;

	/**
	 * Initializes empty Queues for input and output and an empty Tower for the arm, as well as the JFrame pointer.
	 * @param w JFrame used to repaint during Process
	 */
	public ProductionLine(JFrame w) {
		input = new Queue();
		output = new Queue();
		arm = new Tower();
		window = w;
	}

	/**
	 * Draws the input, arm, and output
	 * @param g Graphics object
	 */
	public void drawMe(Graphics g) {
		input.drawMe(g, 550 - (200 * input.size()), 525);
		arm.drawMe(g, 600, 425);
		output.drawMe(g, 650, 525);
	}

	/**
	 * Adds given Disk to the input Queue
	 * @param d Disk being added to the input Queue
	 */
	public void addDisk(Disk d) {
		input.enqueue(d);
	}

	/**
	 * Unloads the inverted pyramid off of the Robot into a regular pyramid in the output Queue.
	 */
	private void unloadRobot() {
		if (arm.empty())
			return;

		Tower tower = new Tower();
		while (!arm.empty())
			tower.push(arm.pop());

		output.enqueue(tower);
	}

	/**
	 * Sends all disks in the input Queue through the robot arm to be sorted into pyramids in the output Queue. Calls repaint and pauses the thread to make the simulation possible to follow.
	 */
	public void process() {
		while (input.peek() != null) {
			if (arm.peek() == null || ((Disk) input.peek()).compareTo(arm.peek()) >= 0)
				arm.push((Disk) input.dequeue());
			else
				unloadRobot();
			window.repaint();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		unloadRobot();
	}

	/**
	 * dequeues a tower from the output Queue and returns it
	 * @return the Tower removed from the output Queue
	 */
	public Tower removeTower() {
		return (Tower) output.dequeue();
	}

}