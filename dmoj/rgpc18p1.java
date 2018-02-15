
import java.util.Scanner;

public class rgpc18p1 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		if(n % m == 0) {
			System.out.println("yes " + n/m);
		} else {
			for(int i = 1; i <= n-m; i++) {
				if(n % (m+i) == 0) {
					System.out.println("no " + i);
					break;
				}
			}
		}
	}

}
