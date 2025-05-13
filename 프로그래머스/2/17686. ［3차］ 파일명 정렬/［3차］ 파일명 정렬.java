// head 사전순, 대소문자 상관X -> Number 숫자순 -> 입력순
import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        List<List<String>> list = new ArrayList<>();
        StringBuilder sb;
        
        for(String f:files){
            int num = 0;
            List<String> temp = new ArrayList<>();
            sb = new StringBuilder();
            for (int i=0; i<f.length(); i++){
                if (0<=f.charAt(i)-'0' && f.charAt(i)-'0' <= 9){
                    if (num==0){
                        num = 1;
                        temp.add(sb.toString());
                        sb = new StringBuilder();
                    }
                    sb.append(f.charAt(i));
                }
                else if (num==0){
                    sb.append(f.charAt(i));
                }
                else if (num==1){
                    num = 0;
                    temp.add(sb.toString());
                    temp.add(f.substring(i));
                    break;
                }
            }
            if (temp.size()==1) 
                temp.add(sb.toString());
            
            list.add(new ArrayList<>(temp));
        }
        list.sort((a,b)->{
            if (a.get(0).toLowerCase().equals(b.get(0).toLowerCase()))
                return Integer.compare(Integer.parseInt(a.get(1)), Integer.parseInt(b.get(1)));
            return a.get(0).toLowerCase().compareTo(b.get(0).toLowerCase());
        });
        return list.stream().map(x -> String.join("",x)).toArray(String[]::new);
    }
}