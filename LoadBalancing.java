import java.util.*;
import java.io.*;
public class LoadBalancing {    
    static PointX[] arrPointXs;
    static PointY[] arrPointYs;
    static int n;
    static int finMin = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new BufferedReader(new FileReader("balancing.in")));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("balancing.out")));
        n = scan.nextInt();
        arrPointXs = new PointX[n];
        arrPointYs = new PointY[n];
        for (int i = 0; i < n; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            arrPointXs[i] = new PointX(x, y);
            arrPointYs[i] = new PointY(x, y);
        }
        Arrays.sort(arrPointXs);
        Arrays.sort(arrPointYs);
        int upperRight = 0;
        int lowerRight = 0;
        int upperLeft = n;
        int lowerLeft = 0;
        int xVal = arrPointXs[0].x - 1; 
        int yVal = arrPointYs[0].y - 1;
        for (int i = 0; i < n; i++) {
            upperRight = upperLeft;
            lowerRight = lowerLeft;
            upperLeft = 0;
            lowerLeft = 0;
            while (i < n - 1 && arrPointYs[i].y == arrPointYs[i + 1].y) {
                i++;
                upperRight--;
                lowerRight++;
            }
            yVal = arrPointYs[i].y + 1;
            upperRight--;
            lowerRight++;
            int max1 = Math.max(lowerRight, lowerLeft);
            int max2 = Math.max(upperRight, upperLeft);
            int max = Math.max(max1, max2);
            finMin = Math.min(max, finMin);
            for (int j = 0; j < n; j++) {
                while (j < n - 1 && arrPointXs[j].x == arrPointXs[j + 1].x) {
                    if (arrPointXs[j].y > yVal) {
                        upperRight--;
                        upperLeft++;
                    }
                    else {
                        lowerRight--;
                        lowerLeft++;
                    }
                    j++;
                }
                xVal = arrPointXs[j].x + 1;
                if (arrPointXs[j].y > yVal) {
                    upperRight--;
                    upperLeft++;
                }
                else {
                    lowerRight--;
                    lowerLeft++;
                }
                max1 = Math.max(lowerRight, lowerLeft);
                max2 = Math.max(upperRight, upperLeft);
                max = Math.max(max1, max2);
                finMin = Math.min(max, finMin);
            }
        }
        pw.println(finMin);
        scan.close();
        pw.close();
    }
    static class PointX implements Comparable<PointX> {
        int x;
        int y;
        public PointX(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(PointX other) {
            return Integer.compare(this.x, other.x);
        }
    }
    static class PointY implements Comparable<PointY> {
        int x;
        int y;
        public PointY(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(PointY other) {
            return Integer.compare(this.y, other.y);
        }
    }
}
