import java.util.*;
import java.io.*;
public class LemonadeLine {
    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(new BufferedReader(new FileReader("lemonade.in")));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lemonade.out")));
        int n = scan.nextInt();
        int[] cows = new int[n];
        for (int i = 0; i < cows.length; i++) {
            cows[i] = scan.nextInt();
        }
        Arrays.sort(cows);
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (count > cows[i]) {
                break;
            }
            count++;
        }
        pw.println(count);
        scan.close();
        pw.close();
    }
}
