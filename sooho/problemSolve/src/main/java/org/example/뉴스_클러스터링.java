package main.java.org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 뉴스_클러스터링 {
    public static int solution(String str1, String str2) {

        List<String> arr1 = Arrays.stream(str1.split("")).collect(Collectors.toList());
        List<String> arr2 = Arrays.stream(str2.split("")).collect(Collectors.toList());


        ArrayList<String> block1 = new ArrayList<>();
        ArrayList<String> block2 = new ArrayList<>();

        ArrayList<String> inter = new ArrayList<>();
        ArrayList<String> union = new ArrayList<>();

        ArrayList<String> tmp = new ArrayList<>();

        blockMaker(arr1, block1, tmp);
        tmp.clear();
        blockMaker(arr2, block2, tmp);

        System.out.println(block1);
        System.out.println(block2);


        for(String s : block1){
            if(block2.remove(s)){
                inter.add(s);
            }
            union.add(s);
        }
        union.addAll(block2);

        if (inter.size() == 0 && union.size() == 0)
            return 65536;

        double rlt = (double)inter.size()/(double)union.size();
        return (int)(rlt*65536);
    }

    private static void blockMaker(List<String> arr, ArrayList<String> block, ArrayList<String> tmp) {
        for (String str : arr) {
            str = str.toLowerCase();
            boolean isTrue = str.charAt(0) >= 'a' && str.charAt(0) <= 'z';
            if (tmp.size() != 1 && isTrue) {
                tmp.add(str);
            } else {
                tmp.add(str);
                for (String s : tmp) {
                    if (!(s.charAt(0) >= 'a' && str.charAt(0) <= 'z')) {
                        tmp.clear();
                        break;
                    }
                }
                if (tmp.size() != 0) {
                    block.add(String.join("", tmp));
                    tmp.clear();
                    tmp.add(str);
                }
            }
        }
    }

    public static void main(String[] args) {

        String str1 = "FRANCE";
        String str2 = "french";

        System.out.println(solution(str1, str2));
    }
}
