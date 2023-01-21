import java.util.*;
import java.io.*;
public class TamingTheHerd2 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new BufferedReader(new FileReader("taming.in")));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("taming.out")));
        int n = scan.nextInt();
        int[] log = new int[n];
        for (int i = 0; i < n; i++) {
            log[i] = scan.nextInt();
        }
        if (log[0] != -1 && log[0] != 0) {
            pw.println(-1);
            scan.close();
            pw.close();
            return;
        }
        log[0] = 0;
        for (int i = n - 2; i >= 0; i--) {
            // list cases
            // -1 2
            // 2 3
            // 1 3
            // -1 -1
            // 0 1 2 3 0 
            if (log[i] == -1 && log[i+1] != -1) {
                log[i] = log[i+1] -1;
            }
            else if (log[i] != -1 && log[i+1] != -1) {
                if (log[i] == log[i+1]-1) {
                    
                } else {
                    // add another if here
                    if (log[i+1] != 0) {
                        pw.println(-1);
                        pw.close();
                        scan.close();
                        return;
                    }
                }
            } 
        }
        int minBreakout = 0;
        int maxBreakout = 0;
        for (int i = 0; i < n; i++) {
            if (log[i] == 0) {
                minBreakout++;
                maxBreakout++;
            }
            else if (log[i] == -1) {
                maxBreakout++;
            }
        }
        pw.println(minBreakout + " " + maxBreakout);
        scan.close();
        pw.close();
    }
}
