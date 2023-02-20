/**
 * @author mcecc
 *
 */
public class Run {
	
	static ProductionLine pL = new ProductionLine();
	
	public static void test(int amount) {
		for (int i = 0; i < amount; i++)
			pL.addDisk(new Disk((int)(Math.random()*100)+1));
		pL.process();
		printOutput();
	}
	
	private static void printOutput() {
		Tower next = pL.removeTower();
		do {
			System.out.println(next);
			next = pL.removeTower();
		} while (next != null);
		System.out.println();
	}
	
	public static void main(String[] args) {
		test(-1);
		test(0);
		test(1);
		test(10);
		test(100);
	}
}
