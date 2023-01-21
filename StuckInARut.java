import java.util.*;
public class StuckInARut {
    static boolean collide = true;
    static ArrayList<Cow> cowsEast = new ArrayList<>();
    static ArrayList<Cow> cowsNorth = new ArrayList<>();
    // static ArrayList<Cow> cows = new ArrayList<>();
    static int n;
    static int minTime = Integer.MAX_VALUE;
    static Cow deadCow = new Cow(-1, -1, -1, -1);
    static int[] grassEaten = new int[n];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            char ch = scan.next().charAt(0);
            int xI = scan.nextInt();
            int yI = scan.nextInt();
            if (ch == 'E') {
                cowsEast.add(new Cow(xI, yI, xI, yI));
            }
            else {
                cowsNorth.add(new Cow(xI, yI, xI, yI));
            }
        }
        int eastSize = cowsEast.size();
        int northSize = cowsNorth.size();
        while (collide) {
            minTime = Integer.MAX_VALUE;
            for (Cow eastCow : cowsEast) {
                for (Cow northCow : cowsNorth) {
                    calcTime(eastCow, northCow);
                }
            }
            for (int i = eastSize - 1; i >= 0; i--) {
                Cow cow = cowsEast.get(i);
                if (cow.xI == deadCow.xI && cow.yI == deadCow.yI) {
                    cowsEast.remove(i);
                }
                else {
                    cow = new Cow(cow.startX, cow.startY, cow.xI + minTime, cow.yI);
                    cowsEast.set(i, cow);
                }
            }
            for (int i = 0; i < northSize; i++) {
                Cow cow = cowsNorth.get(i);
                if (cow.xI == deadCow.xI && cow.yI == deadCow.yI) {
                    cowsNorth.remove(i);
                }
                else {
                    cow = new Cow(cow.startX, cow.startY, cow.xI, cow.yI + minTime);
                    cowsNorth.set(i, cow);
                }
            }
            checkInf();
        }
        scan.close();
    }
    static class Cow {
        int xI;
        int yI;
        int startX;
        int startY;
        public Cow(int tempxI, int tempyI, int x, int y) {
            this.startX = tempxI;
            this.startY = tempyI;
            startX = x;
            startY = y;
        }
    }
    public static void calcTime(Cow eastCow, Cow northCow) {
        if (northCow.startX > eastCow.startX && eastCow.startY > northCow.startY) {
            if (eastCow.xI > northCow.xI) {
                int time = eastCow.yI - northCow.yI;
                if (time < minTime) {
                    deadCow = new Cow(northCow.startX, northCow.startY, northCow.xI, northCow.yI+time);
                    minTime = time;
                }
            }
            else if (northCow.yI > eastCow.yI) {
                int time = northCow.xI - eastCow.xI;
                if (time < minTime) {
                    deadCow = new Cow(eastCow.startX, eastCow.startY, eastCow.xI+time, eastCow.yI);
                    minTime = time;
                }
            }
            else {
                int xDist = northCow.xI - eastCow.xI;
                int yDist = eastCow.yI - northCow.yI;
                if (xDist > yDist) {
                    int time = xDist;
                    if (time < minTime) {
                        deadCow = new Cow(eastCow.startX, eastCow.startY, eastCow.xI+time, eastCow.yI);
                        minTime = time;
                    }
                }
                else if (xDist == yDist) {

                }
                else {
                    int time = yDist;
                    if (time < minTime) {
                        deadCow = new Cow(northCow.startX, northCow.startY, northCow.xI, northCow.yI+time);
                        minTime = time;
                    }
                }
            }
        }
    }
    public static void checkInf() {
        
    }
}
