import java.util.*;
public class PhotoShoot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String lineup = scan.next();
        int len = lineup.length();
        String fin = "";
        String finFinal = "";
        for (int i = 0; i < len; i+=2) {
            if (lineup.charAt(i) == 'H' && lineup.charAt(i+1) == 'G') {
                fin = fin + 'a';
            }
            else if (lineup.charAt(i) == 'G' && lineup.charAt(i+1) == 'H') {
                fin = fin + 'b';
            }
        }
        char last = fin.charAt(0);
        finFinal = "" + fin.charAt(0);
        for (int i = 1; i < fin.length(); i++) {
            char cur = fin.charAt(i);
            if (!(cur == last && finFinal.charAt(finFinal.length()-1) == cur)){
                finFinal = finFinal + cur;
            }
            last = fin.charAt(i);
        }
        if (finFinal.equals("a")) {
            System.out.println(0);
        }
        else if (finFinal.equals("b")) {
            System.out.println(1);
        }
        else {
            String final2 = finFinal.substring(finFinal.length() - 2);
            if (final2.equals("ab")) {
                System.out.println(2 + Math.max(finFinal.length() - 2, 0));
            }
            else if (final2.equals("ba")) {
                System.out.println(1 + Math.max(finFinal.length() - 2, 0));
            }
        }
        scan.close();
        // ababab
        // 14
        // 0 1   2 3   4 5   6 7   8 9   10 11   12 13 
        // G G   G H   G H   H G   H H    H  G    H  G
        // .     b     b     a     .      a       a
        //
        // .bba.aa
        // bbaaa
        // ^^
        // baaa
        // ba
        // baba
        // abaa
        // aba
        // baa
        // aaa
        // a
        // ^ ^
        // abaa
        // aba
        // 
        // .baa.aa
        //
        // ababab
        // ababab   flip at 4
        // bababb 
        // flip 
        // 
        // 

        // as many a's as possible

        
    }
}
