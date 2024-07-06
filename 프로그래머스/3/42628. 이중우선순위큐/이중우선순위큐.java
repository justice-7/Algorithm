import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> max = new PriorityQueue<>((o1,o2)-> o2.compareTo(o1));
        PriorityQueue<Integer> min = new PriorityQueue<>();
        for (String s: operations){
            String[] ss = s.split(" ");
            if (ss[0].equals("I")){
                min.offer(Integer.parseInt(ss[1]));
                max.offer(Integer.parseInt(ss[1]));
            }
            else {
                if (max.size()>0){
                    if (Integer.parseInt(ss[1])>0){
                        min.remove(max.poll());
                    }
                    else {
                        max.remove(min.poll());
                    }
                }
            }
        }
        int[] answer = new int[2];
        if (max.size()>0) {
            answer[0] = max.poll();
            answer[1] = min.poll();
        }
        return answer;
    }
}