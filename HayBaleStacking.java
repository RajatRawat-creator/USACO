import java.util.*;
import java.io.*;
public class HayBaleStacking {
    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(new BufferedReader(new FileReader("stacking.in")));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("stacking.out")));
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] prefixStacks = new int[n + 1];
        int[] realStacks = new int[n];
        prefixStacks[0] = 0;
        for (int i = 0; i < k; i++) {
            int start = scan.nextInt();
            int end = scan.nextInt();
            prefixStacks[start]++;
            if (end != n) {
                prefixStacks[end+1]--;
            }
        }
        realStacks[0] = prefixStacks[1];
        for (int i = 1; i < n; i++) {
            realStacks[i] = realStacks[i-1] + prefixStacks[i+1];
        }
        Arrays.sort(realStacks);
        pw.println(realStacks[n/2]);
        scan.close();
        pw.close();
    }  
}