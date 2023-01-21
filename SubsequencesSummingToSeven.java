import java.util.*;
import java.io.*;
public class SubsequencesSummingToSeven {
    static long[] prefix;
    static int n;
    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(new BufferedReader(new FileReader("div7.in")));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("div7.out")));
        n = scan.nextInt();
        prefix = new long[n+1];
        prefix[0] = 0;
        int finNum = 0;
        for (int i = 1; i <= n; i++) {
            long num = scan.nextLong();
            prefix[i] = (prefix[i - 1] + num)%7;
        }
        // naturally be put into an array; loop over 0 to 6

        // different more natural way to find the last occurrence of a number

        // 
        int start0 = 0;
        int end0 = 0;
        int start1 = 0;
        int end1 = 0;
        int start2 = 0;
        int end2 = 0;
        int start3 = 0;
        int end3 = 0;
        int start4 = 0;
        int end4 = 0;
        int start5 = 0;
        int end5 = 0;
        int start6 = 0;
        int end6 = 0;
        for (int i = 1; i <= n; i++) {
            if (prefix[i] == 0) {
                end0 = i;
                if (start0 == 0) {
                    start0 = i;
                }
            }
            if (prefix[i] == 1) {
                end1 = i;
                if (start1 == 0) {
                    start1 = i;
                }
            }
            if (prefix[i] == 2) {
                end2 = i;
                if (start2 == 0) {
                    start2 = i;
                }
            }
            if (prefix[i] == 3) {
                end3 = i;
                if (start3 == 0) {
                    start3 = i;
                }
            }
            if (prefix[i] == 4) {
                end4 = i;
                if (start4 == 0) {
                    start4 = i;
                }
            }
            if (prefix[i] == 5) {
                end5 = i;
                if (start5 == -1) {
                    start5 = i;
                }
            }
            if (prefix[i] == 6) {
                end6 = i;
                if (start6 == 0) {
                    start6 = i;
                }
            }
        }
        if (start0 == 0 && start1 == 0 && start2 == 0 && start3 == 0 && start4 == 0 && start5 == 0 && start6 == 0) {
            pw.println(0);
            scan.close();
            pw.close();
            return;
        }
        // get rid of this exception condition
        else if (start0 != 0) {
            finNum = 1;
        }
        int max = Math.max(end0 - start0, end1 - start1);
        max = Math.max(max, end2 - start2);
        max = Math.max(max, end3 - start3);
        max = Math.max(max, end4 - start4);
        max = Math.max(max, end5 - start5);
        max = Math.max(max, end6 - start6);
        max = Math.max(max, finNum);
        pw.println(max);
        scan.close();
        pw.close();
    }
}
