import java.util.*;
import java.io.*;
public class Censoring{
    static char[] buffer = new char[10000000];
    static int bufferLen = 0;
    static String s;
    static String t;
    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(new BufferedReader(new FileReader("censor.in")));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("censor.out")));
        
        // whatthemomooofun
        //            ^
        // moo
        // w h a t t h e f u n
        // ^
        // removing from the end is O(1) - character array

        // "a" -> "ab" -> "a"
        // char[] buffer = new char[100000];
        // int bufLength = 0;
        // buffer[0] = 'a';
        // bufLength++;
        // buffer[1] = 'b';
        // bufLength++;
        // bufLength--;
        
        // buffer[bufLength++] = 'm';

        // for (int i = 0; i < bufLength; i++){
        //     pw.print(buffer[i]);
        // }
        

        // for loop for adding each character
        // in for loop check last length String characters of buffer and see if it is the same string as t
        // if it is then decrement bufferLen
        s = scan.next();
        t = scan.next();
        for (int i = 0; i < s.length(); i++){
            String temp = "";
            // some functioin that checks ir the end matches
            buffer[bufferLen++] = s.charAt(i);
            if (endMatches()) {
                bufferLen -= t.length();
            }     
        }

        for (int i = 0; i < bufferLen; i++){
            pw.print(buffer[i]);
        }
        scan.close();
        pw.close();   
    }
    public static boolean endMatches(){
        // test: buffer: aaa t: aaa
        int temp = bufferLen - 1;
        for (int k = t.length()-1; k >= 0; k--){
            // make sure tmep is okay
            if (temp < 0){
                return false;
            }       
            if (t.charAt(k) != buffer[temp]){
                return false;
            } 
            temp--; // check at top of loop
        }
        return true;
    }
}