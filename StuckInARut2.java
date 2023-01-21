import java.util.*;
public class StuckInARut2 {
    static ArrayList<Cow> cows = new ArrayList<>();
    static int n;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            char ch = scan.next().charAt(0);
            int xI = scan.nextInt();
            int yI = scan.nextInt();
            cows.add(new Cow (xI, yI, ch));
        }
        
    }

    // other static functions

    /*
     * Returns the next time that cow1 and cow2 collide.
     * Returns infinity (max_value) if they will never collide
     */
    static int nextCollide(Cow cow1, Cow cow2, boolean whichDied[]) {
        if (cow1.dir == cow2.dir) {
            return Integer.MAX_VALUE;
        }
        if (!cow1.isAlive || !cow2.isAlive) return Integer.MAX_VALUE;
        Cow cowE;
        Cow cowN;
        int cowEastNum = 0;
        if (cow1.dir == 'E') {
            cowE = cow1;
            cowN = cow2;
        } else {
            cowE = cow2;
            cowN = cow1;
            cowEastNum = 1;
        }
        if (cowE.startX > cowN.startX || cowN.startY > cowE.startY) {
            return Integer.MAX_VALUE;
        }
        // int x = cowN.curX;
        // int y = cowE.curY;
        // assuming in derfault case that cowE is above cowN
        // positive value
        int nDist = cowE.curY - cowN.curY;
        // assuming cowN is to the east of cowE
        int eDist = cowN.curX - cowE.curX;
        // calculate a hypothetical time that cowE hits cowN
        // cowEdist is part of that but we also need to see if it hits a rut left by cowN

        // calculate a hypothetical time that cowN hits cowE
        whichDied[0] = false;
        whichDied[1] = false;
        if (eDist < nDist) {
            whichDied[1 - cowEastNum] = true;
        } else if (nDist < eDist) {
            whichDied[cowEastNum] = true; 
        }
        return Math.max(nDist, eDist);
    }
    
    static void advance() {
        int[][][] whichDied = new int[n][n][2];
        int minAdvance = Integer.MAX_VALUE;


    }

    static class Cow {
        int startX;
        int startY;
        int curX;
        int curY;
        char dir;
        boolean isAlive;
        public Cow(int startX, int startY, char dir) {
            this.startX = startX;
            this.startY = startY;
            curX = startX;
            curY = startY;
            this.dir = dir;
            isAlive = true;
        }
    }
}
