import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        
        int min = Arrays.stream(arr).min().getAsInt();
        int[] answer = Arrays.stream(arr).filter(a -> a != min).toArray();
        
        if (answer.length == 0) 
            return new int[] {-1};
        else
            return answer;
    }
}