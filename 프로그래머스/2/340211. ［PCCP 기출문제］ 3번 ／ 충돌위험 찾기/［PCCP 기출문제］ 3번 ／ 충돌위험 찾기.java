import java.util.*;
class Solution {
    static int answer = 0;
    static Set[][] map = new Set[101][101];
    public int solution(int[][] points, int[][] routes) {
        for (int i = 0; i<=100; i++){
            for (int j=0; j<=100; j++){
                map[i][j] = new HashSet();
            }
        }
        for (int i=0; i<routes.length; i++){
            int ind = 1;
            if (map[points[routes[i][0]-1][0]][points[routes[i][0]-1][1]].contains(ind) && !map[points[routes[i][0]-1][0]][points[routes[i][0]-1][1]].contains(ind*-1)){
                map[points[routes[i][0]-1][0]][points[routes[i][0]-1][1]].add(ind*-1);
                answer++;
            }
            else {
                map[points[routes[i][0]-1][0]][points[routes[i][0]-1][1]].add(ind);
            }
            ind++;
            for (int j=0; j<routes[i].length-1; j++){
                int[] start = Arrays.copyOf(points[routes[i][j]-1],2);
                int[] end = Arrays.copyOf(points[routes[i][j+1]-1],2);

                while (start[0]!=end[0]){
                    
                    if (start[0]<end[0])
                        start[0]+=1;
                    else 
                        start[0]-=1;
                    if (map[start[0]][start[1]].contains(ind) && !map[start[0]][start[1]].contains(ind*-1)){
                        map[start[0]][start[1]].add(ind*-1);
                        answer++;
                    }
                    else {
                        map[start[0]][start[1]].add(ind);
                    }
                    ind++;
                }

                while (start[1]!=end[1]){
                   
                    if (start[1]<end[1])
                        start[1]+=1;
                    else 
                        start[1]-=1;
                     if (map[start[0]][start[1]].contains(ind) && !map[start[0]][start[1]].contains(ind*-1)){
                        map[start[0]][start[1]].add(ind*-1);
                        answer++;
                    }
                    else {
                        map[start[0]][start[1]].add(ind);
                    }
                    ind++;
                
                }
            } 
        }
        return answer;
    }
    

}