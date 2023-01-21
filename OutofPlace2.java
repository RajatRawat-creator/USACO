/*import java.io.*;
import java.util.*;
public class OutofPlace2 {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new BufferedReader(new FileReader("outofplace.in")));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("outofplace.out")));
        int n = scan.nextInt();
        int[] cowHeights1 = new int[n];
        int[] cowHeights2 = new int[n];
        for (int i = 0; i < n; i++) {
            cowHeights1[i] = scan.nextInt();
        }
        cowHeights2 = Arrays.copyOf(cowHeights1, n);
        Arrays.sort(cowHeights2);
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (cowHeights1[i] != cowHeights2[i]) {
                count++;
            }
        }
        pw.println(count-1);
        scan.close();
        pw.close();
    }
}*/
