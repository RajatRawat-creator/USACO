import java.util.*;
import java.io.*;
public class ModernArt {
    static HashSet<Character> colorsVis = new HashSet<>();
    static char[][] painting;
    static HashSet<Character> intruders = new HashSet<>();
    static int n;
    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(new BufferedReader(new FileReader("art.in")));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("art.out")));
        /*
         4
        0201
        2230
        2737
        2777
        0000
         */
        n = scan.nextInt();
        painting = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = scan.next();
            for (int j = 0; j < n; j++) {
                char ch = s.charAt(j);
                if ((ch != '0')) {
                    colorsVis.add(ch);
                }
                painting[i][j] = ch;
            }
        }
        for (char color : colorsVis) {
            tryColor(color);
        }
        pw.println(colorsVis.size() - intruders.size());
        scan.close();
        pw.close();
    }
    public static void tryColor(char color) {
        int iMin = Integer.MAX_VALUE;
        int iMax = Integer.MIN_VALUE;
        int jMin = Integer.MAX_VALUE;
        int jMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (painting[i][j] == color) {
                    // i is going to be every row at which there is 'color'
                    // min(i) gives iMin, iMax
                    iMin = Math.min(i, iMin);
                    iMax = Math.max(i, iMax);
                    jMin = Math.min(j, jMin);
                    jMax = Math.max(j, jMax);
                }
            }
        }
        for (int i = iMin; i <= iMax; i++) {
            for (int j = jMin; j <= jMax; j++) {
                if (painting[i][j] != color) {
                    intruders.add(painting[i][j]);
                }
            }
        }
    }
}
