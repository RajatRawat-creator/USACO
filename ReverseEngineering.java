import java.util.*;
public class ReverseEngineering {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int i = 0; i < t; i++) {
            int bits = scan.nextInt();
            int cases = scan.nextInt();
            ArrayList<String> inputs = new ArrayList<>();
            ArrayList<String> outputs = new ArrayList<>();
            for (int j = 0; j < cases; j++) {
                inputs.add(scan.next());
                outputs.add(scan.next());
            }
            if (test(bits, cases, inputs, outputs)) {
                System.out.println("OK");
            }
            else {
                System.out.println("LIE");
            }
        }
        scan.close();
    }

    public static boolean test(int bits, int cases, ArrayList<String> inputs, ArrayList<String> outputs) {
        char[] type = {'0', '1'};
        boolean fin = true;
        while (inputs.size() != 0 && fin) {
            fin = false;
            for (int i = 0; i < bits; i++) {
                for (char ch : type) {
                    ArrayList<Integer> removable = new ArrayList<>();
                    HashSet<Character> endCheck = new HashSet<>();
                    for (int j = 0; j < inputs.size(); j++) {
                        if (inputs.get(j).charAt(i) == ch) {
                            endCheck.add(outputs.get(j).charAt(0));
                            removable.add(j);
                        }
                    }
                    if (endCheck.size() == 1) {
                        for (int j = removable.size()-1; j >= 0; j--) {
                            int ind = removable.get(j);
                            inputs.remove(ind);
                            outputs.remove(ind);
                        }
                        fin = true;
                    }
                }
            }
        }
        if (inputs.size() == 0) {
            return true;
        }
        return false;
    }
}
