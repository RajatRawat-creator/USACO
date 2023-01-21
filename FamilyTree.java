import java.io.*;
import java.util.*;
public class FamilyTree {
    static  HashMap<String, ArrayList<String>> mothers = new HashMap<>();
    public static void main(String[] args) throws Exception {
        // Great-Great-GrandMother: great-great aunt, great-great grandmother
        //                           Great-Great-GrandMother
        // 
        // 
        // 
        Scanner scan = new Scanner(new BufferedReader(new FileReader("family.in")));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("family.out")));
        int n = scan.nextInt();
        String cow1 = scan.next();
        String cow2 = scan.next();
        for (int i = 0; i < n; i++) {
            String first = scan.next();
            String second = scan.next();
            if (mothers.containsKey(first)) {
                mothers.get(first).add(second);
            }
            else {
                ArrayList<String> tempList = new ArrayList<>();
                tempList.add(second);
                mothers.put(first, tempList);
            }
        }
        // cow1 gm of cow2
        // cow2 that's a grandmother of cow1

        // check if cow1 and cow2 are siblings
        if (mother(cow1).equals(mother(cow2))) {
            pw.println("SIBLINGS");
            pw.close();
            scan.close();
            return;
        }
        // check if cow1 is direct descendent of cow2
        int num1 = isDirectDescendant(cow1, cow2);
        int num2 = isDirectDescendant(cow2, cow1);
        if (num1 != -1) {
            String str = "grand-mother";
            if (num1 == 1) {
                str = "mother";
            }
            else if (num1 == 2) {
                str = "grand-mother";
            }
            else {
                for (int i = 0; i < num1 - 2; i++) {
                    str = "great-" + str;
                }
            }
            pw.println(cow1 + " is the " + str  + " of " + cow2);
            scan.close();
            pw.close();
            return;
        }
        // check if cow2 is direct desc. of cow1
        if (num2 != -1) {
            String str = "grand-mother";
            if (num2 == 1) {
                str = "mother";
            }
            else if (num2 == 2) {
                str = "grand-mother";
            }
            else {
                for (int i = 0; i < num2 - 2; i++) {
                    str = "great-" + str;
                }
            }
            pw.println(cow2 + " is the " + str  + " of " + cow1);
            scan.close();
            pw.close();
            return;
        }

        // check if cow1 is child of anscestor of cow2
        if (doAunt(cow1, cow2, pw)) {
            scan.close();
            pw.close();
            return;
        }

        // check if cow2 is child of anscestor of cow1
        if (doAunt(cow2, cow1, pw)) {
            scan.close();
            pw.close();
            return;
        }

        // check if cow1 and cow2 share a common anscestor
        if (commonAnscestor(cow1, cow2, pw)) {
            pw.println("COUSINS");
            scan.close();
            pw.close();
            return;
        }
        
        // output NOT RELATED
        pw.println("NOT RELATED");
        scan.close();
        pw.close();
    }

    public static int isDirectDescendant(String ansc, String desc) {
        // ansc : cow1, cow2, cow3 
        // cow1 : desc
        int count = 1;
        String mot = mother(desc);
        while (!(mot.equals("") || mot.equals(ansc))) {
            mot = mother(mot);
            count++;
        }
        if (mot.equals("")) {
            return -1;
        }
        return count;
    }
    
    public static String mother(String desc) {    
        for (String str : mothers.keySet()) {
            ArrayList<String> children = mothers.get(str);
            if (children.contains(desc)) {
                return str;
            }
        }
        return "";
    }
    /*
     * Checks if . is aunt of .
     * prints output if so and returns true
     * otherwise returns false
     */
    public static boolean doAunt(String aunt, String niece, PrintWriter pw) {
        String mot = mother(aunt);
        int num = isDirectDescendant(mot, niece);
        if (num != -1) {
            String str = "aunt";
            for (int i = 0; i < num - 2; i++) {
                str = "great-" + str;
            }
            pw.println(aunt + " is the " + str + " of " + niece);
            return true;
        }   
        return false;
    }
    public static boolean commonAnscestor(String cow1, String cow2, PrintWriter pw) {
        String mot1 = mother(cow1);
        while (isDirectDescendant(mot1, cow2) == -1 && !(mot1.equals(""))) {
            mot1 = mother(mot1);
        }
        if (!mot1.equals("")) {
            return true;
        }
        mot1 = mother(cow2);
        while (isDirectDescendant(mot1, cow1) == -1 && !(mot1.equals(""))) {
            mot1 = mother(mot1);
        }
        if (!mot1.equals("")) {
            return true;
        }
        return false;
    }
}
