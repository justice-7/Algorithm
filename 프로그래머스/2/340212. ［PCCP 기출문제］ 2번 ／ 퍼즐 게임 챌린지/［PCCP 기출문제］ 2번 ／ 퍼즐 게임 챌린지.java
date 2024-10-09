// diff<=level: time_cur
// diff > level: (diff-level)*(time_cur+time_prev)+time_cur
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int start = 1; 
        int end = 100000;
        while (start<=end){
            int mid = start+(end-start)/2;
            long time = 0;
            for (int i=0; i<diffs.length; i++){
                if (diffs[i]<=mid){
                    time+=times[i];
                }
                else{
                    time+=(diffs[i]-mid)*(times[i]+times[i-1])+times[i];
                }
            }
            if (time<=limit){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        
        return start;
    }
}