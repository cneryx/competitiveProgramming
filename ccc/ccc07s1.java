import java.util.Scanner;

public class ccc07s1 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			int y = scanner.nextInt();
			int m = scanner.nextInt();
			int d = scanner.nextInt();
			if (y < 1989) {
				System.out.println("Yes");
			} else if (y > 1989) {
				System.out.println("No");
			} else if (m > 2) {
				System.out.println("No");
			} else if (m < 2) {
				System.out.println("Yes");
			} else if (d > 27) {
				System.out.println("No");
			} else if (d <= 27) {
				System.out.println("Yes");
			}
		}

	}

}
