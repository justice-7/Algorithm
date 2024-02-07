import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n,x;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (Math.abs(o1)==Math.abs(o2))
					return Integer.compare(o1, o2);	
				return Integer.compare(Math.abs(o1), Math.abs(o2));
			}
		});

		n = Integer.parseInt(br.readLine());
		for (int i=0; i<n; i++) {
			x = Integer.parseInt(br.readLine());
			if (x==0) {
				if (pq.isEmpty())
					sb.append(0+"\n");
				else
					sb.append(pq.poll()+"\n");
			}
			else {
				pq.add(x);
			}
		}
		System.out.println(sb);
	}
}