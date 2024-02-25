import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author justice_va
 * @date 24.02.25
 * @link https://www.acmicpc.net/problem/15961
 * @keyword_solution 슬라이딩 윈도우
 * 행사에 참여하여 다양한 종류의 초밥 먹기
 * 벨트위에 같은 종류의 초밥 둘 이상 있을 수 있음
 * 행사 2가지
 * 1. 벨트의 임의의 한 위치부터 k개의 접시를 연속해서 먹을 경우 할인된 정액 가격으로 제공
 * 2. 각 고객에세 초밥 쿠폰 발행, 1번 행사에 참가할 경우 이 쿠폰에 적힌 종류의 초밥 하나 무료 제공
 * 	  해당 초밥이 벨트 위에 없을 경우, 요리사가 새로 만들어서 제공
 * @input 
 * 회전초밥 벨트에 놓인 접시 수: 2 <= n <= 3,000,000
 * 초밥 가짓 수: 2 <= d <= 3,000
 * 연속해서 먹는 접시 수: 2 <= k <= 3,000 (k<=N)
 * -> 반복문으로 경우의 수 구하기: 3,000,000*3,000 => 시간초과
 * -> 슬라이딩 윈도우로 경우의 수 구하기: 3,000,000 => 가능 
 * @output
 * 손님이 먹을 수 있는 초밥 가짓 수의 최댓값
 * @time_complex O(N)
 * @perf 
 */

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,d,k,c;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int[] dish = new int[n];
		for (int i=0; i<n; i++) {
			dish[i] = Integer.parseInt(br.readLine());
		}
		int[] choiceCnt = new int[3001]; // 선택한 초밥 개수 세기
		choiceCnt[c]++; // 쿠폰으로 먹는 초밥
		int cnt = 1;
		int result = 0;

		// 처음 초밥 k개
		for (int j=0; j<k; j++) {
			if (choiceCnt[dish[j]]==0)
				cnt++;
			choiceCnt[dish[j]]++;
		}
		result = Math.max(result, cnt);
		for (int j=0; j<n; j++) {
			// 앞 빼기
			choiceCnt[dish[j]]--;
			if (choiceCnt[dish[j]]==0)
				cnt--;
			// 뒤 추가
			if (choiceCnt[dish[(j+k)%n]]==0)
				cnt++;
			choiceCnt[dish[(j+k)%n]]++;
			result = Math.max(result, cnt);	
		}
		System.out.println(result);
	}
}