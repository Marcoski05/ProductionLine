import javax.swing.JFrame;
import java.awt.Graphics;

/**
 * @author mcecc
 *
 */
public class ProductionLine {

	private Queue input;
	private Queue output;
	private Tower arm;
	private JFrame window;

	public ProductionLine(JFrame w) {
		input = new Queue();
		output = new Queue();
		arm = new Tower();
		window = w;
	}

	public void drawMe(Graphics g) {
		input.drawMe(g, 550 - (200 * input.size()), 525);
		arm.drawMe(g, 600, 425);
		output.drawMe(g, 650, 525);
	}

	public void addDisk(Disk d) {
		input.enqueue(d);
	}

	private void unloadRobot() {
		if (arm.empty())
			return;

		Tower tower = new Tower();
		while (!arm.empty())
			tower.push(arm.pop());

		output.enqueue(tower);
	}

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

	public Tower removeTower() {
		return (Tower) output.dequeue();
	}

}