import java.awt.Graphics;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * @author mcecc
 *
 */
public class Run extends JComponent {

	private ProductionLine pL;
	private JFrame window;
	private final int WIDTH = 1215;
	private final int HEIGHT = 687;

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

	public void test(int amount) {
		for (int i = 0; i < amount; i++)
			pL.addDisk(new Disk((int) (Math.random() * 100) + 1));
		pL.process();
		printOutput();
	}

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

	private void printOutput() {
		Tower next = pL.removeTower();
		do {
			System.out.println(next);
			next = pL.removeTower();
		} while (next != null);
		System.out.println();
	}

	public static void main(String[] args) {
		Run sim = new Run();

		sim.test(100);

//		if (args.length > 0)
//			sim.testFile("..\\" + args[0]);
//		else
//			sim.test(50);
	}
}
