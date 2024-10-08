class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int vl = ((video_len.charAt(0)-'0')*10+(video_len.charAt(1)-'0'))*60+(video_len.charAt(3)-'0')*10+(video_len.charAt(4)-'0');
        int po=((pos.charAt(0)-'0')*10+(pos.charAt(1)-'0'))*60+(pos.charAt(3)-'0')*10+(pos.charAt(4)-'0');
        int os = ((op_start.charAt(0)-'0')*10+(op_start.charAt(1)-'0'))*60+(op_start.charAt(3)-'0')*10+(op_start.charAt(4)-'0');
        int oe = ((op_end.charAt(0)-'0')*10+(op_end.charAt(1)-'0'))*60+(op_end.charAt(3)-'0')*10+(op_end.charAt(4)-'0');
        if(os<=po && po<=oe){
            po = oe;
        }
        for (int i=0; i<commands.length; i++){
            String s = commands[i];
            if (s.equals("prev")){
                po-=10;
                if (po<0)
                    po=0;
            }
            else if (s.equals("next")){
                po+=10;
                if (po>vl)
                    po = vl;
            }
            if(os<=po && po<=oe){
                po = oe;
            }
        }
        String answer = String.format("%02d:%02d",po/60,po%60);
        return answer;
    }
}