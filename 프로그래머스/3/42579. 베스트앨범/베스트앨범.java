import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> cnt = new HashMap<>();
        Map<String, Map<Integer,Integer>> map = new HashMap<>();
        for (int i=0; i<genres.length; i++){
            if(cnt.containsKey(genres[i])){
                cnt.put(genres[i], cnt.get(genres[i])+plays[i]);
                map.get(genres[i]).put(i, plays[i]);
            }
            else{
                Map<Integer,Integer> ind  = new HashMap<>();
                ind.put(i,plays[i]);
                cnt.put(genres[i], plays[i]);
                map.put(genres[i], ind);
            }
        }
        List<Map.Entry<String,Integer>> genList = new ArrayList<>(cnt.entrySet());
        genList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        for (Map.Entry<String, Integer> gg : genList){
            String g = gg.getKey();
            List<Map.Entry<Integer, Integer>> music = new ArrayList<>(map.get(g).entrySet());
            music.sort((e1, e2) -> {
                int tmp = e2.getValue().compareTo(e1.getValue());
                if (tmp==0)
                    return e1.getKey().compareTo(e2.getKey());
                return tmp;
            });
            
            int end = 0;
            for (Map.Entry<Integer, Integer> e : music) {
                if (end++ < 2)
                    answer.add(e.getKey());
                else
                    break;
            }
        }
        int[] a = new int[answer.size()];
        for (int k =0; k<a.length; k++){
            a[k] = answer.get(k);
        }
        return a;
    }
}