class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int pCnt = 0;
        int yCnt = 0;
        s = s.toLowerCase();
        for (char c : s.toCharArray()){
            if (c=='p') pCnt++;
            else if (c=='y') yCnt++;
        }
        return pCnt==yCnt;
    }
}