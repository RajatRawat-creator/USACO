import java.util.*;
public class CowCollege {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long[] tuition = new long[n];
        for (int i = 0; i < n; i++) {
            tuition[i] = scan.nextLong();
        }
        Arrays.sort(tuition);
        long maxProfit = -1;
        long tuitionSmallest = -1;
        for (int i = 0; i < n; i++) {
            long price = tuition[i];
            int cowsAttending = n - i; //check later
            if (price * cowsAttending > maxProfit) {
                maxProfit = price * cowsAttending;
                tuitionSmallest = price;
            }
            else if (price * cowsAttending == maxProfit) {
                tuitionSmallest = Math.min(tuitionSmallest, price);
            }
        }
        System.out.println(maxProfit + " " + tuitionSmallest);
    }
}