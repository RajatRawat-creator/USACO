import java.util.*;
import java.io.*;
public class TheGreatRevegetation {
    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(new BufferedReader(new FileReader("revegetate.in")));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("revegetate.out")));
        int n = scan.nextInt();
        int m = scan.nextInt();
        ArrayList<ArrayList<Integer>> fields = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            fields.add(i, new ArrayList<Integer>());
        }
        for (int i = 0; i < m; i++) {
            int past1 = scan.nextInt();
            int past2 = scan.nextInt();
            fields.get(past1 - 1).add(past2 - 1);
            fields.get(past2 - 1).add(past1 - 1);
        }
        int[] grass = new int[n];
        grass[0] = 1;
        for (int i = 1; i < n; i++) { 
            // inside of for loop: one or more loops, maybe nested
            for (int grassType = 1; grassType <= 4; grassType++) {
                // see if any connected fields are using that type
                boolean works = true;
                ArrayList<Integer> a = fields.get(i);
                for (int j = 0; j < a.size(); j++) {
                    int field = a.get(j);
                    if (field < i && grass[field] == grassType) {
                        works = false;   
                        break;
                    }
                }
                if (works) {
                    grass[i] = grassType;
                    break;
                }
            }
        }
        for (int grass2 : grass) {
            pw.print(grass2);
        }
        // Outer for loop goes through each field starting at 1 to the end
        // For every field determine grasstype
        // to determine grasstype, check types 1 through 4
        // to check a type, see if any connected field is using the type
        // 0: 3, 1, 4
        // 1: 3, 0
        // 2: 3
        // 3: 0, 1, 2
        // 4: 0, 1
        // 1234
        scan.close();
        pw.close();
    }
}
