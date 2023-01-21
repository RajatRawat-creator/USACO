import java.util.*;
import java.io.*;
public class SwapitySwap {
    static int[] cows;
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new BufferedReader(new FileReader("swap.in")));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("swap.out")));
        int n = scan.nextInt();
        int k = scan.nextInt();
        cows = new int[n];
        for (int i = 0; i < n; i++) {
            cows[i] = i;
        }
          int a1 = scan.nextInt();
          int a2 = scan.nextInt();
          int b1 = scan.nextInt();
          int b2 = scan.nextInt();
          ArrayList<int[]> cowPos = new ArrayList<>();
          cowPos.add(cows.clone());
          boolean fin = true;
          while (fin) {
            reverse(a1-1, a2-1);
            reverse(b1-1, b2-1);
            int[] tempCows = cows.clone();
            cowPos.add(tempCows);
            fin = check();
          }
          int lenArr = cowPos.size();
          int[] finArr = cowPos.get(k % (lenArr-1));
          for (int i = 0; i < finArr.length; i++) {
            pw.println(finArr[i] + 1);
          }
          /*
            1 1 1 1 
            3 4 1 2 5 6 
            1 2 3 4 5 6 
           */
          /*for (int i = 0; i < cowPos.size(); i++) {
            int[] arr = cowPos.get(i);
            for (int j = 0; j < arr.length; j++) {
              pw.print(arr[j] + 1 + " ");
            }
            pw.println();
          }*/
          scan.close();
          pw.close();
        }
        public static void reverse (int start, int end) {
          int lastInd = end;
          int startInd = start;
          while (startInd < lastInd) {
            int temp = cows[lastInd];
            cows[lastInd] = cows[startInd];
            cows[startInd] = temp;
            lastInd--;
            startInd++;
          }
        }
        public static boolean check() {
          for (int i = 0; i < cows.length; i++) {
            if (i != cows[i]) {
              return true;
            }
          }
          return false;
        }
      }
    


