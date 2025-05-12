import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int now = -1;
        int cnt = 0;
        for (int i=0; i<progresses.length; i++){
            int day = (int)Math.ceil((100.0-progresses[i])/speeds[i]);
            if (now == -1){
                now = day;
            }
            else if (now < day){
                now = day;
                answer.add(cnt);
                cnt = 0;
            }
            cnt++;
        }
        answer.add(cnt);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}