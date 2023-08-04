import java.io.*;
import java.util.ArrayList;

public class Main {
    static int N;
    static int M;
    static boolean[] visited;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        visited = new boolean[N+1];
        ArrayList<Integer> arr = new ArrayList<>();
        func(arr, 1);
        bw.flush();
        bw.close();
    }
    public static void func(ArrayList<Integer> arr, int current) throws IOException {
        if(arr.size() == M){
            for(int i : arr) {
                bw.write(i + " ");
            }
            bw.write("\n");

            return;
        }
/**
 * 1 2
 * 1 3
 * 1 4
 * 2 3
 * 2 4
 *
 *
 */
        for(int i = 1; i <= N; i++){
            //if(visited[i] == false){
                arr.add(i);
                //visited[i] = true;
                func(arr, i + 1);
                //visited[i] = false;
                arr.remove(arr.size()-1);
            //}
        }
    }
}
