import java.util.*;
import java.io.*;
public class DontBeLast {
  public static void main(String[] args) throws Exception{
    Scanner scan = new Scanner(new BufferedReader(new FileReader("notlast.in")));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("notlast.out")));
    int n = scan.nextInt();
    TreeMap<String, Integer> cowValString = new TreeMap<String, Integer>();
    cowValString.put("Bessie", 0);
    cowValString.put("Elsie", 0);
    cowValString.put("Daisy", 0);
    cowValString.put("Gertie", 0);
    cowValString.put("Annabelle", 0);
    cowValString.put("Maggie", 0);
    cowValString.put("Henrietta", 0);
    for (int i = 0; i < n; i++) {
      scan.nextLine();
      String cow = scan.next();
      int value = scan.nextInt();
      int tempVal = cowValString.get(cow);
      tempVal += value;
      cowValString.put(cow, tempVal);
    }
    // values tell us the production of each cow
    // look at those : 2nd minimum
    ArrayList<Integer> production = new ArrayList<>(cowValString.values());
    Collections.sort(production);
    int min = production.get(0);
    int idx = 0;
    while (idx < production.size()) {
        int temp = production.get(idx);
        if (temp > min) {
            min = temp;
            break;
        }
        idx++;
    }
    if (idx == production.size()) {
      pw.println("Tie");
    }
    else if (production.get(idx-1) == min || (idx != production.size() - 1 && production.get(idx+1) == min)) {
      pw.println("Tie");
    }
    else {
      for (String key : cowValString.keySet()) {
        if (cowValString.get(key) == min) {
          pw.println(key);
        }
      }
    }
    
    // loop terminates it will be pointing to 2nd minimum value
    scan.close();
    pw.close();
  }
}