import java.io.*;
import java.util.*;
public class HoofBall2 {
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
        for (int i = 1; i < n; i++) {
            if (direction[i - 1] == 'R') {
                leftHand[i] = true;
            }
            else {
                leftHand[i] = false;
            }
        }
        for (int i = 0; i < n - 1; i++) {
            if (direction[ i + 1] == 'L') {
                rightHand[i] = true;
            }
            else {
                rightHand[i] = false;
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!rightHand[i] && !leftHand[i]) {
                count++;
            }
        }
        pw.println(count);
        scan.close();
        pw.close();
    }
}