import java.util.*;
import java.io.*;
public class SleepyCowSorting {
    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(new BufferedReader(new FileReader("sleepy.in")));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("sleepy.out")));
        int n = scan.nextInt();
        int[] order = new int[n];
        for (int i = 0; i < n; i++) {
            order[i] = scan.nextInt();
        }
        int sortCount = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (order[i] < order[i+1]) {
                sortCount++;
            }
            else {
                break;
            }
        }
        if (n == 1) {
            pw.println(0);
        }
        else {
            pw.println(n - sortCount);
        }
        scan.close();
        pw.close();
    }
}
