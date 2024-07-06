import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<participant.length; i++){
            String nowKey = participant[i];
            if (map.containsKey(nowKey)){
                map.put(nowKey,map.get(nowKey)+1);
            }
            else {
                map.put(nowKey,1);
            }
        }
        for (int j=0; j<completion.length; j++){
            String nowKey = completion[j];
            if (map.get(nowKey)-1==0){
                map.remove(nowKey);
            }
            else {
                map.put(nowKey, map.get(nowKey)-1);
            }
        }
        System.out.println();
        return (String)map.keySet().toArray()[0];
    }
}