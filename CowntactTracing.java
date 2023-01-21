import java.util.*;
import java.io.*;
public class CowntactTracing {
    static Interaction[] ints;
    static HashSet<Integer> startCows = new HashSet<>();
    static int n;
    static String fin;
    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(new BufferedReader(new FileReader("tracing.in")));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("tracing.out")));
        n = scan.nextInt();
        int t = scan.nextInt();
        fin = scan.next();
        ints = new Interaction[t];
        for (int i = 0; i < t; i++) {
            int time = scan.nextInt();
            int cow1 = scan.nextInt();
            int cow2 = scan.nextInt();
            ints[i] = new Interaction(time, cow1, cow2);
        }
        Arrays.sort(ints);
        int minK = Integer.MAX_VALUE;
        int maxK = 0;
        HashSet<Integer> validCows = new HashSet<>();
        for (int i = 1; i <= n; i++) {    
            for (int k = 0; k <= t; k++) {
                if (runTimes(i, k)) {
                    minK = Math.min(k, minK);
                    maxK = Math.max(k, maxK);
                    validCows.add(i);
                }
            }
            if (checkInf(i)) {
                validCows.add(i);
                maxK = Integer.MAX_VALUE;
            }
        }
        pw.print(validCows.size() + " ");
        if (minK == Integer.MAX_VALUE) {
            pw.print("Infinity ");
        }
        else {
            pw.print(minK + " ");
        }
        if (maxK == Integer.MAX_VALUE) {
            pw.println("Infinity");
        }
        else {
            pw.println(maxK);
        }
        scan.close();
        pw.close();
    }

    public static boolean runTimes(int startCow, int k) {
        // make this array boolean
        char[] finArray = new char[n];
        Arrays.fill(finArray, '0');
        // 
        int[] cowsInfected2 = new int[n];
        // cowsInfected2[x] == 0 means cow not infected?
        // == -1 means not infected?

        HashMap<Integer, Integer> cowsInfected = new HashMap<>();
        cowsInfected.put(startCow, 0);
        finArray[startCow - 1] = '1';
        if (k == 0) {
            cowsInfected.remove(startCow);
        }
        for (int i = 0; i < ints.length; i++) {
            int cow1 = ints[i].cow1;
            int cow2 = ints[i].cow2;
            if (cowsInfected.containsKey(cow1)) {
                if (cowsInfected.containsKey(cow2)) {
                    cowsInfected.put(cow1, cowsInfected.get(cow1)+1);
                    cowsInfected.put(cow2, cowsInfected.get(cow2)+1);
                }
                else {
                    cowsInfected.put(cow1, cowsInfected.get(cow1) + 1);
                    cowsInfected.put(cow2, 0);
                    finArray[cow2 - 1] = '1';
                }
            }
            else if (cowsInfected.containsKey(cow2)) {
                cowsInfected.put(cow2, cowsInfected.get(cow2) + 1);
                cowsInfected.put(cow1, 0);
                finArray[cow1 - 1] = '1';
            }
            if (cowsInfected.containsKey(cow1) && cowsInfected.get(cow1) >= k) {
                cowsInfected.remove(cow1);
            }
            if (cowsInfected.containsKey(cow2) && cowsInfected.get(cow2) >= k) {
                cowsInfected.remove(cow2);
            }
        }
        String str = String.copyValueOf(finArray);
        if (k == 1 && startCow == 4) {
            System.out.println(str);
        }
        // if (str.equals(fin)) {
        //     minK = Math.min(minK, k);
        //     maxK = Math.max(maxK, k);
        //     validCows.add(startCow);
        // }
        return str.equals(fin);
    }
    public static boolean checkInf(int startCow) {
        char[] finArray = new char[n];
        Arrays.fill(finArray, '0');
        finArray[startCow - 1] = '1';
        HashSet<Integer> cowsInfected = new HashSet<>();
        cowsInfected.add(startCow);
        for (int i = 0; i < ints.length; i++) {
            if (cowsInfected.contains(ints[i].cow1)) {
                cowsInfected.add(ints[i].cow2);
                finArray[ints[i].cow2 - 1] = '1';
            }
            else if (cowsInfected.contains(ints[i].cow2)) {
                cowsInfected.add(ints[i].cow1);
                finArray[ints[i].cow1 - 1] = '1';
            }
        }
        String str = String.copyValueOf(finArray);
        return str.equals(fin);
    }
    public static boolean allZeroes() {
        for (int i = 0; i < fin.length(); i++) {
            if (fin.charAt(i) == '1') {
                return false;
            }
        }
        return true;
    }

    public static class Interaction implements Comparable<Interaction> {
        int time;
        int cow1;
        int cow2;
        public Interaction(int time, int cow1, int cow2) {
            this.time = time;
            this.cow1 = cow1;
            this.cow2 = cow2;
        }
        @Override
        public int compareTo(Interaction other) {
            return Integer.compare(this.time, other.time);
        }
    }
}
