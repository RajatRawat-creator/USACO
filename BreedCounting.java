import java.util.*;
import java.io.*;
public class BreedCounting {
    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(new BufferedReader(new FileReader("bcount.in")));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("bcount.out")));
        int n = scan.nextInt();
        int q = scan.nextInt();
        int[] hol = new int[n+1];
        int[] gur = new int[n+1];
        int[] jer = new int[n+1];
        hol[0] = 0;
        gur[0] = 0;
        jer[0] = 0;
        for (int i = 1; i <= n; i++) {
            int cow = scan.nextInt();
            hol[i] = hol[i-1];
            gur[i] = gur[i-1];
            jer[i] = jer[i-1];
            if (cow == 1) {
                hol[i]++;
            }
            else if (cow == 2) {
                gur[i]++;
            }
            else if (cow == 3) {
                jer[i]++;
            }
        }
        for (int i = 0; i < q; i++) {
            int start = scan.nextInt();
            int end = scan.nextInt();
            pw.print(hol[end] - hol[start - 1] + " ");
            pw.print(gur[end] - gur[start - 1] + " ");
            pw.println(jer[end] - jer[start - 1]);
        }
        scan.close();
        pw.close();
    }
}
