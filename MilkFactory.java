import java.util.*;
import java.io.*;
public class MilkFactory {
    static ArrayList<ArrayList<Integer>> stations;
    static int n;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(new BufferedReader(new FileReader("factory.in")));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("factory.out")));
        n = scan.nextInt();
        stations = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            stations.add(new ArrayList<>());
        }
        for (int i = 0; i < n-1; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            stations.get(b-1).add(a-1);
        }
        visited = new boolean[n];
        int finStation = -1;
        for (int i = 0; i < n; i++) {
            if (checkOneStation(i)) {
                finStation = i + 1;
                break;
            }
        }
        pw.println(finStation);
        /*
        3
        1 2
        3 2
         */
        scan.close();
        pw.close();
    }

    /*
     * Checking whether 'station' could the "the one" that 
     * connects out to everything.
     * Base this on calling floodFill and then checking 
     *  'visited'
     */
    public static boolean checkOneStation(int station) {
        visited = new boolean[n];
        floodFill(station);
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    public static void floodFill(int station) {
        if (visited[station]) {
            return;
        }
        visited[station] = true;
        for (int adjacent : stations.get(station)) {
            floodFill(adjacent);
        }
    }
}
