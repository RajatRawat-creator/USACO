import java.io.*;
import java.util.*;
public class HoofBall {
    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(new BufferedReader(new FileReader("hoofball.in")));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("hoofball.out")));
        int n = scan.nextInt();
        int[] positions = new int[n];
        for (int i = 0; i < n; i++) {
            positions[i] = scan.nextInt();
        }
        Arrays.sort(positions);
        char[] direction = new char[n];
        boolean[] leftHand = new boolean[n];
        boolean[] rightHand = new boolean[n];      
        int countFin = 0;
        // 1 3 6 7 11 12
        // R L R L R  L
        direction[0] = 'R';
        direction[n-1] = 'L';
        leftHand[0] = false;
        rightHand[n-1] = false;
        for (int i = 1; i < n-1; i++) {
            if (positions[i] - positions[i-1] <= positions[i+1] - positions[i]) {
                direction[i] = 'L';
            }
            else {
                direction[i] = 'R';
            }
        }
        HashMap<Integer, Integer> rightCows = new HashMap<>();
        HashMap<Integer, Integer> leftCows = new HashMap<>();
        for (int i = 0; i < n-1; i++) {
            if (direction[i] == 'R' && direction[i+1] == 'R') {
                int count = 1;
                int start = i;
                while (i < n && direction[i+1] == 'R') {
                    i++;
                    count++;
                }
                rightCows.put(start, count);
            }
            else if (direction[i] == 'L' && direction[i+1] == 'L') {
                int count = 1;
                int start = i;
                while (i < n-1 && direction[i+1] == 'L') {
                    i++;
                    count++;
                }
                leftCows.put(start, count);
            }
        }
        for (Integer key: rightCows.keySet()) {
            int covered = rightCows.get(key);
            for (int i = key; i < key + covered; i++) {
                direction[i] = 'P';
            }
            if (key + (covered - 1) < n -1) {
                direction[key + covered] = 'P';
            }
            countFin++;
        }
        for (Integer key : leftCows.keySet()) {
            int covered = leftCows.get(key);
            for (int i = key; i < key + covered; i++) {
                direction[i] = 'P';
            }
            if (key > 0) {
                direction[key - 1] = 'P';
            }
            countFin++;
        }
        
        for (int i = 0; i < n; i++) {
            if (direction[i] != 'P') {
                if (direction[i] == 'R') {
                    if (i + 1 < n && direction[i+1] == 'L') {
                        countFin++;
                        direction[i] = 'P';
                        direction[i+1] = 'P';
                    }
                    else {
                        countFin++;
                        direction[i] = 'P';
                    }
                }
                else {
                    countFin++;
                    direction[i] = 'P';
                }
                
            }
        }
        pw.println(countFin);
        //for (int i = 0; i < n-1)
        // requires two
        // 1   3   4   7   11
        // R   R   L   L   L
        //                   1   2   7   8   9   12   14  15  16
        //                   R   L   R   L   L   R    L   L   R
        // handed from R     Y   .   Y   Y   .   Y    .   
        // handed from L     .   Y   .   Y   .   .    Y
        //
        // have origin spots: places we MUST hand a ball to
        //   if handed from right or left: not an origin spot
        //
        // look at each ball, is it handed a ball from left or right
        // not asking where do we hand? asking where handed from to that ball

        scan.close();
        pw.close();
    }
}