
import java.util.Scanner;

public class rgpc18p2 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		double s = scanner.nextDouble();
		int a = 0, b = 0, c = 0, d = 0, e = 0, combo = 0, maxCombo = 0;
		for (int i = 0; i < n; i++) {
			int score = Math.abs(scanner.nextInt());
			if (score >= 0 && score <= 50) {
				a++;
				combo++;
			} else if (score >= 51 && score <= 100) {
				b++;
				combo++;
			} else if (score >= 101 && score <= 150) {
				c++;
				combo++;
			} else if (score >= 151 && score <= 200) {
				d++;
				combo++;
			} else {
				e++;
				if (combo > maxCombo) {
					maxCombo = combo;
				}
				combo = 0;
			}
		}
		if (combo > maxCombo) {
			maxCombo = combo;
		}
		double newScore = 1.5 * a + b + c + 0.5 * d - e + 0.5 * maxCombo;
		if (newScore - s < 0) {
			System.out.println("0.0");
		} else {
			System.out.printf("%.1f", newScore - s);
		}
	}

}
