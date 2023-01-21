import java.util.*;
import java.io.*;
public class WhiteSheet {
    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(System.in);
        int x1 = scan.nextInt();
        int y1 = scan.nextInt();
        int x2 = scan.nextInt();
        int y2 = scan.nextInt();
        int x3 = scan.nextInt();
        int y3 = scan.nextInt();
        int x4 = scan.nextInt();
        int y4 = scan.nextInt();
        int x5 = scan.nextInt();
        int y5 = scan.nextInt();
        int x6 = scan.nextInt();
        int y6 = scan.nextInt();

        if (x3 <= x1 && y3 <= y1 && x4 >= x2 && y4 >= y2){
            System.out.println("No");
        }
        else if (x5 <= x1 && y5 <= y1 && x6 >= x2 && y6 >= y2){
            System.out.println("No");
        }
        else {
            int interX1 = Math.max(x3, x1);
            int interY1 = Math.max(y3, y1);
            int interX2 = Math.min(x4, x2);
            int interY2 = Math.min(y4, y2);

            int interX3 = Math.max(x5, x1);
            int interY3 = Math.max(y5, y1);
            int interX4 = Math.min(x6, x2);
            int interY4 = Math.min(y6, y2);

            

            if (interX1 == x1 && interY1 == y1 && interX4 == x2 && interY4 == y2){
                if (interX2 == x2 && interX3 == x1 && interY3 <= interY2){
                    System.out.print("no");
                }
                else if (interY2 == y2 && interY3 == y1 && interX2 >= interX3){
                    System.out.print("no");
                }
            }
            else if (interX3 == x1 && interY3 == y1 && interX2 == x2 && interY2 == y2){
                if (interX4 == x2 && interX1 == x1 && interY1 <= interY4){
                    System.out.print("no");
                }
                else if (interY4 == y2 && interY1 == y1 && interX4 >= interX1){
                    System.out.print("no");
                }
            }
            else {
                System.out.print("yes");
            }

            
        }


    }
}
