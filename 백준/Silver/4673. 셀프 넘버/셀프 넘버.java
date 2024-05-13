public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		int[] ar = new int[10001];
		for (int i=1; i<10000; i++) {
			int sum =i;
			while (sum<10000) {
				int num = sum;
				while (num/10!=0) {
					sum+=num%10;
					num/=10;
				}
				sum+=num;
				if (sum<=10000) {
					if (ar[sum]==1)
						break;
					else
						ar[sum]=1;
				}
			}
		}
		for (int j=1; j<=10000; j++) {
			if (ar[j]==0)
				sb.append(j+"\n");
		}
		System.out.println(sb);
	}

}