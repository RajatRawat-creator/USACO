import java.util.*;
import java.io.*;
public class AngryCows {
    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(new BufferedReader(new FileReader("angry.in")));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));
        int n = scan.nextInt();
        int[] locs = new int[n];
        for (int i = 0; i < n; i++) {
            locs[i] = scan.nextInt();
        }
        Arrays.sort(locs);
        int maxHit = 0;
        for (int i = 0; i < n; i++) {
            int curHit = 0;
            boolean active = true;
            int cter = 1;
            int start = locs[i];
            int startInd = i;
            int endInd = i;
            int end = locs[i];
            while (active && start >= 0) {
                start = start - cter;
                cter = cter * 2;
                boolean found = false;
                if (start > locs[startInd - 1]) {
                    active = false;
                }
                else {
                    while (!found) {
                        if (locs[startInd -1] > start) {
                            startInd = startInd - 1;
                        }
                        else {
                            found = true;
                        }
                    }
                }
            }
            
        }

        pw.println(maxHit);
        scan.close();
        pw.close();
    }
}
