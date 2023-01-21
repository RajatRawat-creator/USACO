import java.util.*;
import java.io.*;
public class SleepingInClass {
    public static void main(String[] args) {
        // 3 1 2 3 1 1 1 3
        // 4 5
        // checking the sum number by number and stop when it equals 3
        // accumulator initialize to zero: add numbers one at a time 
        // until they equal 3. 
        // have a number in mind and try to make all other numbers equal that
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scan.nextInt();
            int[] sleep = new int[n];
            for (int j = 0; j < n; j++) {
                sleep[j] = scan.nextInt();
            }
            for (int j = 0; j < 1000000; j++) {
                int temp = works(j, sleep);
                if (temp != -1) {
                    System.out.println(temp);
                    break;
                }
            }
        }
    }
    static int works(int sum, int[] sleep) {
        int accum = 0;
        int count = 0; // count the numnber of series
        for (int i = 0; i < sleep.length; i++) {
            // if accum is 0 you're at the very beginning
            // of a new series
            // 
            accum += sleep[i];
            if (accum == sum) {
                count++;
                accum = 0;
            }
            else if (accum > sum) {
                return -1;
            }
        }
        return sleep.length - count;
        // 1 2 3 1 1 1 3
        // count the number of series that we've hit
        // 3 3 3 3: we've hit 3 series . is that number
        // related to the number of modifications?
        // S number of series we've hit
        // M number of modifications
        // as M goes up, does S tend to go up or down?
        // given a fixed length of the sleep array. 
        // if we know S? can we compute M? what else do we need to know?
        // L be the length of the sleep. can you write a formula relating
        // S, M and L?
    }
}