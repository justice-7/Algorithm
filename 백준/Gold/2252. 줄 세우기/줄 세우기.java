import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * @author justice_va 
 * @date 24.02.20
 * @link https://www.acmicpc.net/problem/2252
 * @keyword_solution 위상정렬
 * 1. a,b 받으면서 하나하나 사이에 집어 넣기
 * 32,000 (리스트 사이에 삽입 O(n)) * 100,000(키 비교 횟수) = 3,200,000,000 => 불가능
 * 2. 그래프
 * 인접 행렬: 32,000 * 32,000 *4byte = 약 3906mb => 메모리 초과 -> 인접 리스트 사용
 * 2-1. 그래프 저장
 * 2-2. 큐 위상정렬
 * @input 
 * 학생 수: 1 <= N <= 32,000
 * 키 비교 횟수: 1<= M <=100,000
 * @output 학생들을 앞에서부터 줄을 세운 결과
 * @time_complex O(N+M)
 * @perf 
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int n,m;
	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		List<List<Integer>> g = new ArrayList<>();
		int[] cnt = new int[n+1];
		for (int i=0; i<=n; i++) {
			g.add(new ArrayList<>());
		}
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			g.get(a).add(b);
			cnt[b]++;
		}
		Queue<Integer> q = new ArrayDeque<Integer>();
		for (int i=1; i<=n; i++) {
			if (cnt[i]==0)
				q.offer(i);
		}
		while (!q.isEmpty()) {
			int now = q.poll();
			sb.append(now+" ");
			List<Integer> child = g.get(now);
			for (int j=0; j<child.size(); j++) {
				if (--cnt[child.get(j)]==0) {
					q.offer(child.get(j));
				}
			}
		}
		System.out.println(sb);
	}
}