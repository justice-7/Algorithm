import java.util.*;

class Solution {
    static Map<String, Integer> map = new HashMap<>();
    
    public int solution(String[][] clothes) {
        int answer = 1;
        
        for (int i = 0; i < clothes.length; i++) {
            String type = clothes[i][1]; 
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        for (int cnt: map.values()){
            answer *= (cnt+1); // 안 입는 경우
        }
        
        return answer-1; // 아예 안 입는 경우
    }
    

}