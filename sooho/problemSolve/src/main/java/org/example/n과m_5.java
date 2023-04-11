package org.example;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class n과m_5 {

    static StringBuilder sb = new StringBuilder();
    static boolean[] visit;

    static int n, m;

    static int[] lst;
    static int[] nums;

    public static void back(int cnt) {
        if (cnt == m) {
            for (int val : lst) {
                sb.append(val).append(" ");
            } sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                lst[cnt] = nums[i];
                back(cnt + 1);
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); m = sc.nextInt();

        visit = new boolean[n];
        lst = new int[m];
        nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);

        back(0);

        System.out.println(sb);
    }
}