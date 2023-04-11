package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n과m_4 {

    static StringBuilder sb = new StringBuilder();
    static boolean[] visit;

    static String[] split;
    static int[] lst;

    public static void back(int root, int depth) {
        if (depth == Integer.parseInt(split[1])) {
            for (int val : lst) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = root; i < Integer.parseInt(split[0]); i++) {
            visit[i] = true;
            lst[depth] = i + 1;
            back(i, depth + 1);
            visit[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        split = bf.readLine().split(" ");
        visit = new boolean[Integer.parseInt(split[0])];
        lst = new int[Integer.parseInt(split[1])];

        back(0, 0);

        System.out.println(sb);
    }
}
