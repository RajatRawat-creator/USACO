import java.util.*;
import java.io.*;
public class SwapitySwap {
    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(new BufferedReader(new FileReader("planting.in")));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("planting.out")));
        // 1: [2]
        // 2: [1, 3]
        // 3: [2, 4]
        // 4: [3]
        // want to look up a key: field #
        // field i is stored at index i
        int n = scan.nextInt();
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int field1 = scan.nextInt();
            int field2 = scan.nextInt();
            edges.get(field1  - 1).add(field2 - 1);
            edges.get(field2 - 1).add(field1 - 1);
        }
        
        scan.close();
        pw.close();
    }   
}
