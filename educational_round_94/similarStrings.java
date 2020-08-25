package educational_round_94;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class stringSimilarity {
	static public PrintWriter out = new PrintWriter(System.out);

	// first substrings are created and taking their xor will give the result
	
	public static void main(String[] args) {
		FastScanner fs = new FastScanner();
		int T = fs.nextInt();
		for (int tt = 0; tt < T; tt++) {
			int l = fs.nextInt();
			String str = fs.next();
			int n = str.length();
			if (str.length() == 1) {
				out.println(str);
			} else {
				int arr[] = new int[l];
				int j = 0;
				for (int i = 1; i <= n - l + 1; i++) {
					String sub = str.substring(i - 1, i + l - 1);
					int decimalValue = Integer.parseInt(sub, 2);
					arr[j++] = decimalValue;
				}
				for (int i = 0; i < l; i++) {
					System.out.print(" " + toBinary(arr[i], l));
				}
				System.out.println();

				int res = arr[0];
				for (int i = 1; i < l; i++) {
					res = res ^ arr[i];
				}
				out.println(toBinary(res, l));
			}
		}
		out.close();
	}

	static String toBinary(int x, int len) {

		if (len > 0) {
			return String.format("%" + len + "s", Integer.toBinaryString(x)).replaceAll(" ", "0");
		}

		return null;
	}

	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");

		String next() {
			while (!st.hasMoreTokens())
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		long nextLong() {
			return Long.parseLong(next());
		}
	}

}


