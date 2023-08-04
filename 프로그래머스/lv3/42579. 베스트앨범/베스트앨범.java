import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 장르 별 재생 횟수를 담은 map
        // 장르 별 노래 리스트를 담은 map
        HashMap<String, Integer> countMap = new HashMap<>();
        HashMap<String, List<int[]>> playsMap = new HashMap<>();
        //장르 별 재생 횟수를 구한다
        for(int i = 0; i < genres.length; i++){
            if(countMap.containsKey(genres[i])){
                countMap.put(genres[i], countMap.get(genres[i]) + plays[i]);
                playsMap.get(genres[i]).add(new int[]{i,plays[i]});
            } 
            else{
                countMap.put(genres[i], plays[i]);
                List<int[]> list = new ArrayList<>();
                list.add(new int[]{i, plays[i]});
                playsMap.put(genres[i], list);
            }
            
        }
        //System.out.print(countMap);
        List<String> keys = new ArrayList<>(countMap.keySet());
        
        Collections.sort(keys, (v1, v2) -> countMap.get(v2) - countMap.get(v1));
        
        ArrayList<Integer> a = new ArrayList<>();
        for(String key : keys){
            List<int[]> playList = playsMap.get(key);
            Collections.sort(playList, (o1, o2) -> o2[1] - o1[1]);
            if(playList.size() == 1)
                a.add(playList.get(0)[0]);
            else{
                a.add(playList.get(0)[0]);
                a.add(playList.get(1)[0]);
            }

        }
        int[] answer = a.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}