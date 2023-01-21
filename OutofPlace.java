import java.io.*;
import java.util.*;
public class OutofPlace {
    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(new BufferedReader(new FileReader("outofplace.in")));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("outofplace.out")));
        int n = scan.nextInt();
        int[] cowHeights = new int[n];
        int indBessie = -1;
        int indFinal = -1;
        for (int i = 0; i < n; i++) {
            cowHeights[i] = scan.nextInt();
        }
        int ind;
        for (ind = 0; ind < n; ind++) {
            if (ind == 0) {
                if (cowHeights[0] > cowHeights[1]) {
                    indBessie = 0;
                    break;
                }
            }
            else if (ind == n - 1) {
                if (cowHeights[n - 1] < cowHeights[n - 2]) {
                    indBessie = n -1;
                    break;
                }
            }
            else {
                if (cowHeights[ind-1] > cowHeights[ind]) {
                    if (cowHeights[ind - 1] >= cowHeights[ind - 2] && cowHeights[ind - 1] <= cowHeights[ind + 1]) {
                        indBessie = ind;
                    }
                    else {
                        indBessie = ind - 1;
                    }
                    break;
                }
            }
        }
        int heightBessie = cowHeights[indBessie];
        Arrays.sort(cowHeights);
        for (int i = 0; i < cowHeights.length; i++) {
            if (cowHeights[i] == heightBessie) {
                indFinal = i;
            }
        }
        int minInd = Math.min(indBessie, indFinal);
        int maxInd = Math.max(indBessie, indFinal);
        HashSet<Integer> switches = new HashSet<>();
        for (int i = minInd; i <= maxInd; i++) {
            switches.add(cowHeights[i]);
        }
        switches.remove(heightBessie);
        //pw.println(minInd + " " + maxInd);
        pw.println(switches.size());
        // 6   2 4 7 7 9 3
        //       ^ ^   ^ ^
        //       3 4   7 9
        //     2 3 4 7 7 9
        
        // 5
        //     5 1 2 4 5 
        //     ^ ^ ^ ^
        //     1 2 4 5 5

        //     2 4 7 7 3 9
        //     2 4 3 7 7 9
        //     2 3 4 7 7 9
        // 
        /*int bessieHeight = cowHeights[indBessie];
        for (int i = 0; i < n; i++) {
            if (i == 0 && cowHeights[indBessie] <= cowHeights[0]) {
                indFinal = 0;
                break;
            }
            else if (i == n - 1 && cowHeights[indBessie] >= cowHeights[n-1]) {
                indFinal = n - 1;
                break;
            }
            if (i!= n -1 && cowHeights[indBessie] >= cowHeights[i] && cowHeights[indBessie] <= cowHeights[i+1]) {
                indFinal = i + 1;
                break;
            }
        }
        pw.println(indBessie + " " + indFinal);
        HashSet<Integer> uniqueHeights = new HashSet<>();
        if (indBessie > indFinal) {
            for (int i = indBessie -1; i >= indFinal; i--) {
                uniqueHeights.add(cowHeights[i]);
            }
        }
        else {
            for (int i = indBessie+1; i <= indFinal; i++) {
                uniqueHeights.add(cowHeights[i]);
            }
        }
        uniqueHeights.remove(bessieHeight);
        pw.println(uniqueHeights.size());*/
        scan.close();
        pw.close();
    }
}
