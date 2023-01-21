import java.util.*;
import java.io.*;
public class TamingTheHerd {
    static int ind;
    static int n;
    static int[] log;
    static int lastBreakout;
    static int checked;
    static int minBreakout = 1;
    static int maxBreakout = 1;
    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(new BufferedReader(new FileReader("taming.in")));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("taming.out")));
        n = scan.nextInt();
        log = new int[n];
        for (int i = 1; i < n; i++) {
            log[i] = scan.nextInt();
        }
        for (ind = 0; ind < n; ind++) {
            if (log[ind] == 0) {
                minBreakout++;
                maxBreakout++;
            }
            else if (log[ind] == -1) {
                int valAddend = findAddend(ind);
                if (valAddend == -1) {
                    break;
                }
                maxBreakout += valAddend;
            }
            else if (log[ind] != log[ind - 1] + 1) {
                break;
            }
            pw.println(maxBreakout);
        }
        if (ind != n) {
            pw.println(-1);
        }
        else {
            pw.print(minBreakout + " ");
            pw.println(maxBreakout);
        }
        scan.close();
        pw.close();
    }
    public static int findAddend(int start) {
        // make sure ind is n - 1 at the end if -1 goes to the end
        int negCount = 1;
        while (ind < n-1 && log[ind+1] == -1) {
            ind++;
            negCount++;
        }
        if (start == 0) {
            maxBreakout--;
        }
        if (ind == n-1) {
            if (log[ind] == -1) {
                return negCount+1;
            }
            else {
                if (ind - log[ind] == start - 1 - log[start-1]) {
                    return 0;
                }
                else if (ind - log[ind] >= start - 1 - Math.abs(log[start-1])) {
                    return negCount - log[ind];
                }
                else {
                    return -1;
                }
            }
        }
        else {
            if (ind - log[ind] == start - 1 - log[start-1]) {
                return 0;
            }
            else if (ind - log[ind] >= start - 1 - log[start-1]) {
                return negCount - log[ind];
            }
            else {
                return -1;
            }
        }
    }
}
