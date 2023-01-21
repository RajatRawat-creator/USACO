import java.util.*;
import java.io.*;
public class MilkingOrder {
    static ArrayList<Integer> reverseSpecActPos = new ArrayList<>();
    static int[] hie;
    static HashMap<Integer, Integer> specIndCows;
    static int n;
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new BufferedReader(new FileReader("milkorder.in")));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("milkorder.out")));
        n = scan.nextInt();
        int m = scan.nextInt();
        int k = scan.nextInt();
        int[] availSpots = new int[n];
        hie = new int[m];
        specIndCows = new HashMap<>();
        int cur = n-1;
        for (int i = 0; i < m; i++) {
            hie[i] = scan.nextInt();
        }
        for (int i = 0; i < k; i++) {
            int cow = scan.nextInt();
            int ind = scan.nextInt();
            specIndCows.put(cow, ind-1);
        }
        for (int cow : specIndCows.keySet()) {
            availSpots[specIndCows.get(cow)] = cow;
        }
        int finVal = findInd1() + 1;
        if (finVal == 0) {
            for (int i = m - 1; i >= 0; i--) {
                int cow = hie[i];
                if (specIndCows.containsKey(cow)) {
                    cur = specIndCows.get(cow);
                    cur--;
                }
                else {
                    while (cur >= 0 && availSpots[cur] != 0) {
                        cur--;
                    }
                    availSpots[cur] = cow;
                    cur--;
                }
            }
            for (int i = 0; i < n; i++) {
                if (availSpots[i] == 0) {
                    finVal = i + 1;
                    break;
                }
            }
        }
        pw.println(finVal);
        pw.close();
        scan.close();
    } 
    public static int findInd1() {
        boolean fin = false;
        for (int cow : specIndCows.keySet()) {
            if (cow == 1) {
                return specIndCows.get(1);
            }
        }
        for (int i = 0; i < hie.length; i++) {
            if (hie[i] == 1) {
                fin = true;
            }
        }
        if (!fin) {
            return -1;
        }
        int cur = 0;
        int[] availSpots = new int[n];
        for (int cow : specIndCows.keySet()) {
            availSpots[specIndCows.get(cow)] = cow;
        }
        for (int cow : hie) {
                if (specIndCows.containsKey(cow)) {
                    cur = specIndCows.get(cow);
                    cur++;
                }
                else {
                    while (cur < n && availSpots[cur] != 0) {
                        cur++;
                    }
                    availSpots[cur] = cow;
                    if (cow == 1) {
                        return cur;
                    }
                    cur++;
                }
        }
        return -1;
    }
}
