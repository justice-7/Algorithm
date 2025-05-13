class Solution {
    static int cnt = 0;
    public int solution(int[] numbers, int target) {
        sol(0,0,numbers,target);
        return cnt;
    }
    public void sol(int ind, int hap, int[] numbers, int target){
        if (ind>=numbers.length){
            if (hap==target){
                cnt++;
            }
            return;
        }
        sol(ind+1, hap-numbers[ind], numbers,target);
        sol(ind+1, hap+numbers[ind], numbers,target);
    }
}