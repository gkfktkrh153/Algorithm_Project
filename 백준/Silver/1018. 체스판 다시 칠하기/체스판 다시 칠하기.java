import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String[] str = br.readLine().split(" ");
        int N  = Integer.parseInt(str[0]);
        int M  = Integer.parseInt(str[1]);

        ArrayList<String[]> arr = new ArrayList<>();
        for(int i = 0; i < N; i++)
        {
            arr.add(br.readLine().split(""));
        }
        int min = 1000000;
        for(int i = 0; i <= N - 8; i++)
        {

            for(int j = 0; j <= M - 8; j++){

                for(int k = 0; k < 2; k++) {
                    String start;
                    int count = 0;
                    if(k == 0)
                        start = "B";
                    else
                        start = "W";
                    for (int a = 0; a < 8; a++) {
                        for (int b = 0; b < 8; b++) {

                            if ((a + b) % 2 == 0) {
                                if (!arr.get(a + i)[b + j].equals(start))
                                    count++;
                            } else {
                                if (arr.get(a + i)[b + j].equals(start))
                                    count++;
                            }
                        }
                    }

                    min = Math.min(count, min);
                }
            }
        }


        System.out.println(min);

    }
}
