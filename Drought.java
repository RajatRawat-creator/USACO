import java.util.*;
public class Drought {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long t = scan.nextLong();
        for (long i = 0; i < t; i++) {
            int n = scan.nextInt();
            long[] hunger = new long[n];
            for (int j = 0; j < n; j++) {
                hunger[j] = scan.nextLong();
            }
            System.out.println(findMinBags(hunger));
        }

        scan.close();
    }
    public static long findMinBags(long[] hunger) {
        long count = 0;
        long len = hunger.length;
        if (len == 1) {
            return 0;
        }
        if (len == 2) {
            if (hunger[0] == hunger[1]) {
                return 0;
            }
            else {
                return -1;
            }
        }
        for (int i = 1; i < len; i++) {
            if (i == 1 && hunger[0] > hunger[1]) { //Check for Special case of size = 1
                return -1;
            }
            else if (i == len - 1) {
                if (hunger[i] > hunger[i-1]) {
                    return -1;
                }
                else if (hunger[i] < hunger[i-1]){
                    if (len % 2 == 0) {
                        return -1;
                    }
                    else {
                        count =  (count * 2 + (len-1) * (hunger[i-1] - hunger[i]))/2;
                    }
                }
            }
            else {
                if (hunger[i] > hunger[i - 1]) {
                    count += hunger[i] - hunger[i-1];
                    hunger[i+1] = hunger[i+1] -  (hunger[i] - hunger[i-1]);
                    hunger[i] = hunger[i-1];
                }
                else if (hunger[i] < hunger[i-1]) {
                    if (i%2 == 1) {
                        return -1;
                    }
                    else {
                        count = count + (i/2) * (hunger[i-1] - hunger[i]);
                    }
                }
            }
        }
        for (int i = 0; i < len; i++) {
            if (hunger[i] < 0) {
                return -1;
            }
        }
        return count*2;
    }
}
