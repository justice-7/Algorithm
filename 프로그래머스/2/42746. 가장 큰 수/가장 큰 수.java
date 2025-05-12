import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String[] s = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(s, (a,b)-> (b+a).compareTo(a+b));
        return s[0].equals("0") ? "0" : String.join("",s);
    }
}