
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    
    static List<int[]>[] edge;
    static int[] weightList;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(br.readLine());
        
        edge=new ArrayList[v+1];
        
        for(int i=0; i<v+1; i++){
            edge[i]=new ArrayList<>();
        }

        weightList=new int[v+1];
        Arrays.fill(weightList,Integer.MAX_VALUE);
        
        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            //출발, 도착, 가중치
            edge[a].add(new int[]{b, c});




        }

        dijk(k);

        for(int i=1; i<v+1; i++){
            if(weightList[i]==Integer.MAX_VALUE){
                System.out.println("INF");
            }
            else {
                System.out.println(weightList[i]);
            }
        }
    }

    public static void dijk(int start){
        PriorityQueue<int[]> heap=new PriorityQueue<>(
                (o1,o2)->o1[1]-o2[1]
        );

        weightList[start]=0;
        heap.offer(new int[]{start, 0});

        while (!heap.isEmpty()) {
            int[] tmp = heap.poll();
            int cur=tmp[0];
            int curWeight=tmp[1];

            if(weightList[cur]<curWeight){
                continue;
            }

            for (int[] ints : edge[cur]) {
                int next=ints[0];
                int nextWeight=ints[1];

                if(weightList[next]>curWeight+nextWeight){
                    weightList[next]=curWeight+nextWeight;
                    heap.offer(new int[] {next,curWeight+nextWeight});
                }
            }
        }

    }
}
