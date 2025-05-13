import java.util.*;
class Solution {
    static PriorityQueue<Integer> pq;
    public int solution(int[] scoville, int K) {
        int answer = 0;
        pq = new PriorityQueue<>();
        for (int sco:scoville)
            pq.offer(sco);
        while (pq.peek()<K){
            if (pq.size()==1){
                answer=-1;
                break;
            }
            pq.offer(pq.poll()+(pq.poll())*2);
            answer++;
        }
        return answer;
    }
}