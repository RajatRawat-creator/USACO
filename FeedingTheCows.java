import java.util.*;
public class FeedingTheCows {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scan.nextInt();
            int k = scan.nextInt();
            String cows = scan.next();
            System.out.println(findConfig(cows, k));
        }
        scan.close();
    }
    public static String findConfig(String cows, int k) {
        char[] config = new char[cows.length()];
        Arrays.fill(config, '.');
        int num = 0;
        int finG = -1;
        int finH = -1;
        for (int i = 0; i < cows.length(); i++) { //g
            int ind = findNextInd(cows, 'G', i);
            if (ind == -1) {
                break;
            }
            else if (ind + k >= cows.length()) {
                finG = ind;
                break;
            }
            else {
                config[ind + k] = 'G';
                num++;
                i = ind + k + k;
            }
        }
        for (int i = 0; i < cows.length(); i++) { //H
            int ind = findNextInd(cows, 'H', i);
            if (ind == -1) {
                break;
            }
            else if (ind + k >= cows.length()) {
                finH = ind;
                break;
            }
            else {
                config[ind + k] = 'H';
                num++;
                i = ind + k + k;
            }
        }
        if (finG != -1) {
            int lastInd = findLastInd(cows, 'G');
            for (int i = lastInd - k; i < cows.length(); i++) {
                if (i >= 0 && config[i] == '.') {
                    config[i] = 'G';
                    num++;
                    break;
                }
            }
        }
        if (finH != -1) {
            int lastInd = findLastInd(cows, 'H');
            for (int i = lastInd - k; i < cows.length(); i++) {
                if (i >= 0 && config[i] == '.') {
                    config[i] = 'H';
                    num++;
                    break;
                }
            }
        }
        System.out.println(num);
        return String.copyValueOf(config);
    }
    public static int findNextInd(String cows, char ch, int start) {
        for (int i = start; i < cows.length(); i++) {
            if (cows.charAt(i) == ch) {
                return i;
            }
        }
        return -1;
    }
    public static int findLastInd(String cows, char ch) {
        for (int i = cows.length() - 1; i >= 0; i--) {
            if (cows.charAt(i) == ch) {
                return i;
            }
        }
        return -1;
    }
}
