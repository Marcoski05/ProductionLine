import java.awt.Graphics;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * @author Marco Cecchi-Rivas
 * @see ProductionLine
 * This class holds test methods for ProductionLine and handles its graphical simulation.
 */
public class Run extends JComponent {

	private ProductionLine pL;
	private JFrame window;
	private final int WIDTH = 1215;
	private final int HEIGHT = 687;

	/**
	 * Constructor that creates the ProductionLine and window. It sets up the window's properties.
	 */
	public Run() {
		window = new JFrame();
		pL = new ProductionLine(window);

		window.setTitle("Production Line");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(WIDTH, HEIGHT);
		window.setLocationRelativeTo(null);
		window.getContentPane().add(this);
		window.setVisible(true);
	}

	/**
	 * Methods called when repainting. Draws background elements and then calls the ProductionLine's drawMe.
	 * @param g Graphics object
	 */
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 550, 500, 100);
		g.fillRect(700, 550, 500, 100);
		g.fillRect(575, 450, 50, 200);
		g.fillRect(500, 425, 200, 25);

		g.setColor(Color.LIGHT_GRAY);
		pL.drawMe(g);
	}

	/**
	 * Adds specified amount of random r=1-100 disks to the ProductionLine, processes them, and prints them.
	 * @param amount of disks to be added to input
	 */
	public void test(int amount) {
		for (int i = 0; i < amount; i++)
			pL.addDisk(new Disk((int) (Math.random() * 100) + 1));
		pL.process();
		printOutput();
	}

	/**
	 * Adds specified disks from fileName to the ProductionLine, processes them, and prints them.
	 * @param fileName File that disk info should be grabbed from.
	 */
	public void testFile(String fileName) {
		File file = new File(fileName);
		Scanner sc;

		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			test(50);
			return;
		}

		while (sc.hasNextInt())
			pL.addDisk(new Disk(sc.nextInt()));
		sc.close();
		pL.process();
		printOutput();
	}

	/**
	 * Prints ProductionLine's output Queue
	 */
	private void printOutput() {
		Tower next = pL.removeTower();
		do {
			System.out.println(next);
			next = pL.removeTower();
		} while (next != null);
		System.out.println();
	}

	/**
	 * main method that starts the simulation and tests
	 * @param args filename for Disks to be grabbed from
	 */
	public static void main(String[] args) {
		Run sim = new Run();

		sim.test(100);

//		if (args.length > 0)
//			sim.testFile("..\\" + args[0]);
//		else
//			sim.test(50);
	}
}
