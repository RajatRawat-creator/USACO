import java.util.*;
import java.io.*;
public class CitiesAndStates {
    public static void main(String[] args) throws Exception{
        HashMap<String, ArrayList<String>> states = new HashMap<String, ArrayList<String>>();
        Scanner scan = new Scanner(new BufferedReader(new FileReader("citystate.in")));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("citystate.out")));
        for (int i = 65; i <= 90; i++) {
            for (int j = 65; j <= 90; j++) {
                char ch1 = (char)i;
                char ch2 = (char)j;
                String str = "" + ch1 + ch2;
                ArrayList<String> temp = new ArrayList<String>();
                states.put(str, temp);
            }
        }
        int n = scan.nextInt();
        scan.nextLine();
        int count = 0;
        for (int i = 0; i < n; i++) {
            String city = scan.next();
            String state = scan.next();
            String tempStr = "" + city.charAt(0) + city.charAt(1);
            ArrayList<String> temp1 = states.get(tempStr);
            if (!state.equals(tempStr)) {
                for (String element : temp1) {
                    String city2 = "" + element.charAt(0) + element.charAt(1);
                    if (state.equals(city2)) {
                        count++;
                    }
                }
            }       
            ArrayList<String> temp2 = states.get(state);
            temp2.add(city);
            states.put(state, temp2);
        }
        pw.println(count);
        scan.close();
        pw.close();
        /*
        MI FL <-> FL MI
        
         6
    MIAMI FL
    DALLAS TX
    MIO   MI
    MIINT MI
    FLOW MI
    CLEMSON SC
    BOSTON MA
    ORLANDO FL
         */
    }
}