package main.java.org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 점프점프 {

    static int num;
    static int[] arr;

    static class nTime {

        int idx;
        int cnt;

        public nTime(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
    }

    public static int bfs(nTime root, boolean[] visited) {

        Queue<nTime> queue = new LinkedList<>();
        visited[root.idx] = true;

        queue.offer(root);
        while(!queue.isEmpty()) {

            nTime tmp = queue.poll();
            if(tmp.idx == arr.length-1) return tmp.cnt;

            for(int i = 1; i <= arr[tmp.idx]; i++) {
                int nidx = tmp.idx + i;
                if(nidx < num && arr[tmp.idx] != 0 && !visited[nidx]) {
                    queue.offer(new nTime(nidx, tmp.cnt+1));
                    visited[nidx] = true;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(bf.readLine());
        arr = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean[] visit = new boolean [num];

        nTime nTime = new nTime(0, 0);
        System.out.println(num + " " + arr.length);
        System.out.println(bfs(nTime, visit));
    }
}
