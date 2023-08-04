
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int N;
    static int M;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        visited = new boolean[N+1];
        ArrayList<Integer> arr = new ArrayList<>();
        func(arr, 0);
        /**
         * 1 2
         *   3
         *   4
         * 2
         * 3
         * 4
         */
    }
    public static void func(ArrayList<Integer> arr, int current){
        if(arr.size() == M){
            for(int i : arr)
                System.out.print(i + " ");
            System.out.println();
            return;
        }
/**
 * 1(2,3,4)
 *   2(3,4)
 *     3(4)
 *       4
 */
        for(int i = 1 ; i <= N; i++){
            if(visited[i] == false){
                arr.add(i);
                visited[i] = true;
                func(arr, current + 1);
                visited[i] = false;
                arr.remove(arr.size()-1);
            }
        }
    }
}
