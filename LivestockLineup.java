import java.util.*;
import java.io.*;
// (a, b, c)
// abc
// acb
// bac
// bca
// cab
// cba
//
// recursion break the problem down into a initial part and 
// then pass sthe rest off to a recursive call

// choose the first letter
// a 
// find all permutations of [bc] bc cb
// asked to find the perms of [bc]
// chosing the first letter b
//    pass ing off [c] to recursive call : c
//    bc
// choose the first letter c
//    cb



// abc abc
// choose b
public class LivestockLineup {
    // static ArrayList<ArrayList<String>> allLists= new ArrayList<>();
    // static ArrayList<Integer> chooseLists = new ArrayList<>(); 
    static String[] cows = {"Beatrice", "Sue", "Belinda", "Bessie", "Betsy", "Blue", "Bella", "Buttercup"};
    static boolean[] used = {false, false, false, false, false, false, false, false};
    static ArrayList<String> cowList = new ArrayList<>();
    static ArrayList<Pair> constraints = new ArrayList<>();
    public static void main2(String[] args) {
        ArrayList<Integer> foo = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> foo2 = new ArrayList<>(foo);
        foo.add(4);
        System.out.println("foo: " + foo);
        System.out.println("foo2: " + foo2);
        // recurse();
        // System.out.println(allLists);
    }
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new BufferedReader(new FileReader("lineup.in")));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lineup.out")));
        int n = scan.nextInt();
        scan.nextLine();
        Arrays.sort(cows);
        for (int i = 0; i < n; i++) {
            String s = scan.nextLine();
            String firstCow = s.substring(0, s.indexOf(' '));
            String secondCow = s.substring(s.lastIndexOf(' ') + 1);
            Pair pair = new Pair(firstCow, secondCow);
            constraints.add(pair);
        }
        recurse();
        for (String s : cowList) {
            pw.println(s);
        }
        scan.close();
        pw.close();
    }
    // [[a, b, c], [a, b, c], [a, b, c]]

    // invariants:
    // 
    // *** return value indicates whether done ***
    public static boolean recurse() {
        if (cowList.size() == 8) {
            // check permutation right now
            // allLists.add(new ArrayList<String>(cowList));
            return check(cowList);
        }
        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                // here is where you call recurse
                // you're going to modifie global variables
                // boolean[] used and ArrayList<String> cowList
                cowList.add(cows[i]);
                used[i] = true;
                // if retValue is true we are done recursing
                if(recurse()) return true;
                // after you're done you change 'used' and 'cowList'
                // back to the way they were
                used[i] = false;
                cowList.remove(cowList.size()-1);
            }
        }
        return false;
    }
    
    public static boolean check(ArrayList<String> list) {
        for (int i = 0; i < constraints.size(); i++) {
            Pair pair = constraints.get(i);
            String firstCow = pair.firstCow;
            String secondCow = pair.secondCow;
            int firstInd = list.indexOf(firstCow);
            int secondInd = list.indexOf(secondCow);
            int dif = firstInd - secondInd;
            if (Math.abs(dif) != 1) {
                return false;
            }
        }
        return true;
    }
    static class Pair {
        String firstCow;
        String secondCow;
        public Pair(String first, String second) {
            firstCow = first;
            secondCow = second;
        }
    }
    
}
