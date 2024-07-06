import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Integer i:scoville){
            pq.offer(i);
        }
        while (pq.peek() < K){
            if (pq.size()==1){
                answer=-1;
                break;
            }
            answer++;
            int a = pq.poll();
            int b = pq.poll();
            pq.offer(a+b*2);
        }
        return answer;
    }
}