
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};
    static int N;
    static int M;
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        int K = Integer.parseInt(s[2]);

        graph = new int[N+1][M+1];
        for(int i = 0; i < K; i++){
            String coordinate[] = br.readLine().split(" ");
            int y = Integer.parseInt(coordinate[0]);
            int x = Integer.parseInt(coordinate[1]);
            graph[y][x] = 1;
        }
        int max = 0;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if(graph[i][j] == 1){
                    max = Math.max(bfs(new int[]{i,j}), max);
                }
            }
        }
        System.out.println(max);
    }
    static int bfs(int[] start){
        Queue<int[]> queue = new LinkedList<>();
        int count = 1;
        graph[start[0]][start[1]] = 0;
        queue.add(start);
        while(queue.size() > 0){
            int[] current = queue.poll();
            
            for(int i = 0; i < 4; i++){
                int nextY = current[0] + dy[i];
                int nextX = current[1] + dx[i];
                if(0 < nextY  && nextY <= N && 0 < nextX && nextX <= M) {
                    if (graph[nextY][nextX] == 1) {
                        count++;
                        graph[nextY][nextX] = 0; // 방문처리
                        queue.add(new int[]{nextY, nextX});
                    }
                }
            }

        }
        return count;
    }


}
