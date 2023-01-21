import java.util.*;
import java.io.*;
public class LifeGuards {
    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(new BufferedReader(new FileReader("lifeguards.in")));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));
        int n = scan.nextInt();
        int[] dif = new int[1000001];
        int[] real = new int[1000000];
        for (int i = 0; i < n; i++) {
            int start = scan.nextInt();
            int end = scan.nextInt();
            dif[start]++;
            if (end != 1000000) {
                dif[end+1]--;
            }
        }
        real[0] = dif[1];
        for (int i = 1; i < 1000000; i++) {
            real[i] = real[i-1] + dif[i+1];
        }
        
        scan.close();
        pw.close();
    }
    static class Point {
        int start;
        int end;
        public Point(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
