import java.util.*;
import java.io.*;
public class WhyDidCowCrossRoad2 {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new BufferedReader(new FileReader("maxcross.in")));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("maxcross.out")));
        int n = scan.nextInt();
        int k = scan.nextInt();
        int b = scan.nextInt();
        int[] brokenWalks = new int[b];
        int[] prefix = new int[n+1];
        int min = Integer.MAX_VALUE;
        HashSet<Integer> broken = new HashSet<>();
        ArrayList<Integer> adjustedPrefix0 = new ArrayList<>();
        ArrayList<Integer> adjustedPrefixnon0 = new ArrayList<>();
        prefix[0] = 0;
        for (int i = 0; i < b; i++) {
            int num = scan.nextInt();
            brokenWalks[i] = num;
            broken.add(num);
        }
        for (int i = 1; i < prefix.length; i++) {
            if (broken.contains(i)) {
                prefix[i] = 0;
            }
            else {
                prefix[i] = prefix[i-1] + 1;
            }
        }
        for (int i = 1; i < prefix.length; i++) {
            int count = 0;
            while (i < prefix.length && prefix[i] == 0) {
                count++;
                i++;
            }
            adjustedPrefix0.add(count);
            while (i < prefix.length && prefix[i] != 0) {
                i++;
            }
            i--;
        }
        for (int i = 1; i < prefix.length; i++) {
            int count = 0;
            while (i < prefix.length && prefix[i] != 0) {
                count++;
                i++;
            }
            adjustedPrefixnon0.add(count);
            while (i < prefix.length && prefix[i] == 0) {
                i++;
            }
            i--;
        }
        for (int i = 0; i < adjustedPrefixnon0.size(); i++) {
            int cur = 0;
            int removals = 0;
            int ind = i;
            while (ind < adjustedPrefixnon0.size() && cur < k) {
                cur += adjustedPrefixnon0.get(ind);
                if (cur >= k && ind == i) {
                    break;
                }
                removals += adjustedPrefix0.get(ind);
                cur += adjustedPrefix0.get(ind);
                ind++;
            }
            if (cur >= k) {
                min = Math.min(min, removals);
            }
        }
        pw.println(min);
        scan.close();
        pw.close();
    }
}
