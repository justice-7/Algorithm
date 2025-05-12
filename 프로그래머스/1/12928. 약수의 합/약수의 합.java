import java.util.*;

class Solution {
    public int solution(int n) {
        Set<Integer> set = new HashSet<>();
        for (int i=1; i<=Math.sqrt(n); i++){
            if (n%i==0){
                set.add(i);
                set.add(n/i);
            }
        }
        
        int answer = set.stream().mapToInt(Integer::intValue).sum();
        
        return answer;
    }
}