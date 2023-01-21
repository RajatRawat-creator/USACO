import java.util.*;
import java.io.*;
public class HoofPaperScissors {
    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(new BufferedReader(new FileReader("hps.in")));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));
        int n = scan.nextInt();
        int[] prefH = new int[n+1];
        int[] prefP = new int[n+1];
        int[] prefS = new int[n+1];
        prefH[0] = 0;
        prefP[0] = 0;
        prefS[0] = 0;
        for (int i = 1; i <= n; i++) {
            char ch = scan.next().charAt(0);
            prefH[i] = prefH[i - 1];
            prefP[i] = prefP[i - 1];
            prefS[i] = prefS[i - 1];
            if (ch == 'P') {
                prefP[i]++;
            }
            else if (ch == 'H') {
                prefH[i]++;
            }
            else if (ch == 'S') {
                prefS[i]++;
            }
        }
        int maxWon = -1;
        for (int i = 1; i < prefH.length; i++) {
            int startHwon = prefH[i];
            int endPwon = prefP[n] - prefP[i];
            int startPwon = prefP[i];
            int endHwon = prefH[n] - prefH[i];
            maxWon = Math.max(maxWon, Math.max(startHwon + endPwon, startPwon + endHwon));
        }
        for (int i = 1; i < prefP.length; i++) {
            int startPwon = prefP[i];
            int endSwon = prefS[n] - prefS[i];
            int startSwon = prefS[i];
            int endPwon = prefP[n] - prefP[i];
            maxWon = Math.max(maxWon, Math.max(startPwon + endSwon, startSwon + endPwon));
        }
        for (int i = 1; i < prefS.length; i++) {
            int startSwon = prefS[i];
            int endHwon = prefH[n] - prefH[i];
            int startHwon = prefH[i];
            int endSwon = prefS[n] - prefS[i];
            maxWon = Math.max(maxWon, Math.max(startSwon + endHwon, startHwon + endSwon));
        }
        pw.println(maxWon);
        scan.close();
        pw.close();
    }
}
