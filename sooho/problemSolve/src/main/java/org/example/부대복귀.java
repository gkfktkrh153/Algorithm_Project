package main.java.org.example;

import java.util.*;

public class 부대복귀 {

    public static int[] bfs(int destination, ArrayList<ArrayList<Integer>> rlt, int[]visit) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(destination);
        visit[destination] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (Integer integers : rlt.get(cur)) {
                if (visit[integers] == -1) {
                    queue.add(integers);
                    visit[integers] = visit[cur] + 1;
                }
            }
        }

        return visit;
    }

    public static void main(String[] args) {

        int n = 3;
        int destination = 1;
        int[][] roads = {{1, 2}, {2, 3}};
        int[] sources = {2, 3};
        int[] visit = new int[n+1];

        ArrayList<ArrayList<Integer>>rlt = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            rlt.add(new ArrayList<>());
            visit[i] = -1;
        }

        for (int[] i : roads) {
            rlt.get(i[0]).add(i[1]);
            rlt.get(i[1]).add(i[0]);
        }

        ArrayList<Integer> visit_rlt = new ArrayList<>();
        bfs(destination, rlt, visit);
        for (int source : sources) {
            visit_rlt.add(visit[source]);
        }
        System.out.println(visit_rlt);
        System.out.println(Arrays.toString(visit));
    }
}
