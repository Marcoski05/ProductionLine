import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
	
	public static void testFile(String fileName) {
		File file = new File(fileName);
		Scanner sc;
		
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			test(50);
			return;
		}
			
		while(sc.hasNextInt())
			pL.addDisk(new Disk(sc.nextInt()));
		sc.close();
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
		if (args.length > 0)
			testFile("..\\" + args[0]);
		else
			test(50);
	}
}
