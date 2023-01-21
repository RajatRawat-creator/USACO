import java.util.*;
import java.io.*;
public class CitiesAndStates2 {
    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(new BufferedReader(new FileReader("citystate.in")));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("citystate.out")));
        // MIAMI FLORIDA  "MIFL"
        // map key is 4-letter code: value is # of occurrences
        // after filling we go over it and count pairs
        /*
        6
        MIAMI FL
        DALLAS TX
        FLINT MI
        CLEMSON SC
        BOSTON MA
        ORLANDO FL
         */
        HashMap<String, Integer> codes = new HashMap<String, Integer>();
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            String city = scan.next();
            String state = scan.next();
            String code = city.substring(0,2) + state;
            if (codes.containsKey(code)) {
                int count = codes.get(code) + 1;
                codes.put(code, count);
            }
            else {
                codes.put(code, 1);
            }
        }
        int count = 0;
        // loop over every code: look for swtiched backward code. add to count
        for (String key : codes.keySet()) {
            String first = key.substring(2);
            String second = key.substring(0, 2);
            String temp = first + second;
            if (codes.containsKey(temp) && !first.equals(second)) {
                int add = codes.get(key) * codes.get(temp);
                count += add;
            }
        }
        count = count/2;
        pw.println(count);
        scan.close();
        pw.close();
    }
}
