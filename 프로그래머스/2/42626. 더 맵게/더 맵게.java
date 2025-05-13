import java.util.*;
class Solution {
    static PriorityQueue<Integer> pq;
    public int solution(int[] scoville, int K) {
        int answer = 0;
        pq = new PriorityQueue<>();
        for (int sco:scoville)
            pq.offer(sco);
        while (pq.size()>=2 && pq.peek()<K){
            pq.offer(pq.poll()+(pq.poll())*2);
            answer++;
        }
        return pq.poll()<K?-1:answer;
    }
}