import java.util.*;
import java.io.*;
public class ContaminatedMilk {
    static drink[] drinks;
    static sick[] sickCows;
    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(new BufferedReader(new FileReader("badmilk.in")));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("badmilk.out")));
        int n = scan.nextInt();
        int m = scan.nextInt();
        int d = scan.nextInt();
        int s = scan.nextInt();
        drinks = new drink[d];
        sickCows = new sick[s];
        for (int i = 0; i < d; i++) {
            int cow = scan.nextInt();
            int milk = scan.nextInt();
            int time = scan.nextInt();
            drinks[i] = new drink(cow, time, milk);
        }
        for (int i = 0; i < s; i++) {
            int cow = scan.nextInt();
            int time = scan.nextInt();
            sickCows[i] = new sick(cow, time);
        }
        ArrayList<Integer> badMilks = new ArrayList<>();
        HashSet<Integer> posSickCows = new HashSet<>();
        for (int i = 0; i < s; i++) {
            sick sickCow = sickCows[i];
            for (int j = 0; j < d; j++) {
                int sickTime = sickCow.time;
                if (drinks[j].cow == sickCow.cow && drinks[j].time < sickTime) {
                    badMilks.add(drinks[j].milk);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < badMilks.size(); i++) {
            for (int j = 0; j < d; j++) {
                if (drinks[j].milk == badMilks.get(i)) {
                    posSickCows.add(drinks[j].cow);
                }
            }
            if (posSickCows.size() > max && everyPersonDrank(badMilks.get(i))) {
                max = posSickCows.size();
            }
            posSickCows.clear();
        }
        pw.println(max);
        scan.close();
        pw.close();
    }
    
    public static class drink {
        int cow;
        int time;
        int milk;
        public drink(int cow, int time, int milk) {
            this.cow = cow;
            this.time = time;
            this.milk = milk;
        }
    }
    public static class sick {
        int cow;
        int time;
        public sick(int cow, int time) {
            this.cow = cow;
            this.time = time;
        }
    }
    
    public static boolean everyPersonDrank(int milk) {
        boolean fin = false;
        for (int i = 0; i < sickCows.length; i++) {
            for (int j = 0; j < drinks.length; j++) {
                if (sickCows[i].cow == drinks[j].cow && milk == drinks[j].milk && drinks[j].time < sickCows[i].time) {
                    fin = true;
                    break;
                }
            }
            if (fin == false) {
                return false;
            }
            fin = false;
        }
        return true;
    }
}
