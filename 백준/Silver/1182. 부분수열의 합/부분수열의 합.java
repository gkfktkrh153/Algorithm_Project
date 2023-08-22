import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    static int N;
    static int S;
    static int[] arr;//
    static boolean[] visited;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        S = Integer.parseInt(s[1]);
        visited = new boolean[N];
        String[] s1 = br.readLine().split(" ");
        arr = Stream.of(s1).mapToInt(Integer::parseInt).toArray();
        for(int i = 1; i <= N;i++){
            DFS(new ArrayList<>(), i, 0);
        }
        System.out.println(cnt);
    }

    static void DFS(List<Integer> list, int dest, int current){
        if(dest == list.size())
        {
            int sum = list.stream().mapToInt(Integer::intValue).sum();
            if(sum == S)
                cnt += 1;
            return;
        }
        for(int i = current; i < N; i++){
            if(visited[i] == false){
                list.add(arr[i]);
                visited[i] =true;
                DFS(list, dest, i + 1);
                visited[i] =false;
                list.remove(list.size() - 1);
            }
        }

    }
}

