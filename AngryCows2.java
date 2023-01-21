import java.util.*;
import java.io.*;
public class AngryCows2 {
    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(new BufferedReader(new FileReader("angry.in")));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));
        int n = scan.nextInt();
        int[] locs = new int[n];
        for (int i = 0; i < n; i++) {
            locs[i] = scan.nextInt();
        }
        Arrays.sort(locs);
        // locs = {0, 2, 6, 9, 11, 12, 14}
        // index into locs: 4th bale locs[3] = 9
        //   don't confuse index into locs with position of bales
        // idxStart
        // locCurrent
        // idxStart = 4 ^
        // idxCurrent $
        // radius = 2
        // locExpl = 9
        // 0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15
        //          o     o  o  o  o  o        o  o 
        //                         ^
        //                         $     

        int maxExplosions = 0;
        for (int idxStart = 0; idxStart < n; idxStart++) {
            int idxCurrent = idxStart;
            int radius = 1;
            int rightExplosions = 0;
            // advance idxCurrent to the right until we run out of explosions
            while (true) {
                // establish a loop invariant - something that is true at the start of every loop
                // loop invariant: idxCurrent is index of where explosion took place
                int locExpl = locs[idxCurrent];
                // loop invariant: locCurrent is location of where last explosion took place
                // advance within current radius
                // explosions will take place up to locCurrent+radius
                int loopCount = 0;
                while (idxCurrent < n && locs[idxCurrent] <= locExpl + radius) {    
                    idxCurrent++;
                    loopCount++;
                }
                // here check for termination
                if (idxCurrent == n || loopCount == 1) {
                    rightExplosions = idxCurrent - idxStart;
                    break;
                }
                // idxCurrent - idxStart is # of explosions
                idxCurrent--;
                radius++;
            }
            int leftExplosions = 0;
            idxCurrent = idxStart;
            radius = 1;
            while (true) {
                int locExpl = locs[idxCurrent];
                int loopCount = 0;
                while (idxCurrent >= 0 && locs[idxCurrent] >= locExpl - radius) {
                    idxCurrent--;
                    loopCount++;
                }
                if (idxCurrent < 0 || loopCount == 1) {
                    leftExplosions = idxStart - idxCurrent;
                    break;
                }
                idxCurrent++;
                radius++;
            }
            // check total explosions
            maxExplosions = Math.max(maxExplosions, leftExplosions + rightExplosions - 1);
        }
        pw.println(maxExplosions);
        scan.close();
        pw.close();
    }
}
