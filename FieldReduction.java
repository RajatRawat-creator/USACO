import java.util.*;
import java.io.*;
public class FieldReduction {
    static PointX[] xVals;
    static PointY[] yVals;
    static int n;
    static int finArea = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new BufferedReader(new FileReader("reduce.in")));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("reduce.out")));
        // remove every set of 3 points O(n^3)
        // compute area afterward of remaining points O(n)
        // O(n^4)
        // three outermost left, three o.m. right, top, bottom
        // any combination of any three of these points and calculate
        // area
        n = scan.nextInt();
        xVals = new PointX[n];
        yVals = new PointY[n];
        for (int i = 0; i < n; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            xVals[i] = new PointX(x, y);
            yVals[i] = new PointY(x, y);
        }
        Arrays.sort(xVals);
        Arrays.sort(yVals);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = n - 1; k > n - 5; k--) {
                    for (int l = n - 1; l > n - 5; l--) {
                        findCowsAndArea(xVals[k].x, yVals[l].y, xVals[i].x, yVals[j].y, xVals[k].y, yVals[l].x, xVals[i].y, yVals[j].x);
                    }
                }
            }
        }
        pw.println(finArea);
        scan.close();
        pw.close();
    }

    public static void findCowsAndArea(int upperX, int upperY, int lowerX, int lowerY, int y2, int x2, int y3, int x3) {
        upperX = Math.max(upperX, lowerX);
        upperY = Math.max(upperY, lowerY);
        lowerX = Math.min(upperX, lowerX);
        lowerY = Math.min(upperY, lowerY);
        int tempArea = (upperX - lowerX) * (upperY - lowerY);
        if (!(upperX < x2 || upperX < x3 || lowerX > x2 || lowerX > x3 || upperY < y2 || upperY < y3 || lowerY > y2 || lowerY > y3)) {
            if (upperX == lowerX || upperY == lowerY) {
                return;
            }
            HashSet<Integer> indices = new HashSet<>();
            for (int i = 0; i < xVals.length; i++) {
                if ((xVals[i].x > upperX || xVals[i].x < lowerX) || (xVals[i].y > upperY || xVals[i].y < lowerY)) {
                    indices.add(i);
                }
            }
            int len = indices.size();
            if (len <= 3 && tempArea < finArea) {
                finArea = tempArea;
                System.out.println(upperX + " " + upperY + " " + lowerX + " " + lowerY);
            }
        }
    }
    static class PointX implements Comparable<PointX> {
        int x;
        int y;
        public PointX(int x2, int y2) {
            x = x2;
            y = y2;
        }
        @Override
        public int compareTo(PointX other) {
            return Integer.compare(this.x, other.x);
        }
    }
    static class PointY implements Comparable<PointY> {
        int x;
        int y;
        public PointY(int x2, int y2) {
            x = x2;
            y = y2;
        }
        @Override
        public int compareTo(PointY other) {
            return Integer.compare(this.y, other.y);
        }
    }
}
