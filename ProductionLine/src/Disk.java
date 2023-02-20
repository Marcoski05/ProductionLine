/**
 * @author mcecc
 *
 */
public class Disk implements Comparable<Disk> {
   
   int radius;
   
   public Disk (int r) {
      radius = r;
   }
   
   @Override
   public int compareTo(Disk other) {
      return radius - other.radius;
   }
   
   @Override
   public boolean equals(Object other) {
      if (other instanceof Disk)
         return this.compareTo((Disk)other) == 0;
      
      return false;
   }
   
   @Override
   public String toString() {
	   return "radius: " + radius;
   }
}
