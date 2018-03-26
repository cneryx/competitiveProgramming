import java.util.Scanner;

public class Nukit {

	static int[][][][] combo;

	public static boolean aabdd(int a, int b, int c, int d) {
		boolean flag = a >= 2 && b >= 1 && d >= 2;
		return flag;
	}

	public static boolean abcd(int a, int b, int c, int d) {
		boolean flag = a >= 1 && b >= 1 && c >= 1 && d >= 1;
		return flag;
	}

	public static boolean ccd(int a, int b, int c, int d) {
		boolean flag = c >= 2 && d >= 1;
		return flag;
	}

	public static boolean bbb(int a, int b, int c, int d) {
		boolean flag = b >= 3;
		return flag;
	}

	public static boolean ad(int a, int b, int c, int d) {
		boolean flag = a >= 1 && d >= 1;
		return flag;
	}

	public static boolean canMove(int a, int b, int c, int d) {
		boolean flag = aabdd(a, b, c, d) || abcd(a, b, c, d) || ccd(a, b, c, d) || bbb(a, b, c, d) || ad(a, b, c, d);
		return flag;
	}

	public static boolean losingCombo(int a, int b, int c, int d) {
		if (combo[a][b][c][d] != 0) {
			if (combo[a][b][c][d] == 1) {
				return true;
			}
			return false;
		}
		if (!canMove(a, b, c, d)) {
			combo[a][b][c][d] = 1;
			return true;
		} else {
			boolean flag = true;
			if (aabdd(a, b, c, d))
				flag = flag && winningCombo(a - 2, b - 1, c, d - 2);
			if (abcd(a, b, c, d))
				flag = flag && winningCombo(a - 1, b - 1, c - 1, d - 1);
			if (ccd(a, b, c, d))
				flag = flag && winningCombo(a, b, c - 2, d - 1);
			if (bbb(a, b, c, d))
				flag = flag && winningCombo(a, b - 3, c, d);
			if (ad(a, b, c, d))
				flag = flag && winningCombo(a - 1, b, c, d - 1);
			if (flag)
				combo[a][b][c][d] = 1;
			else
				combo[a][b][c][d] = 2;
			return flag;
		}
	}

	public static boolean winningCombo(int a, int b, int c, int d) {
		if (combo[a][b][c][d] != 0) {
			if (combo[a][b][c][d] == 1) {
				return false;
			}
			return true;
		}
		if (aabdd(a, b, c, d) && losingCombo(a - 2, b - 1, c, d - 2)) {
			combo[a][b][c][d] = 2;
			return true;
		} else if (abcd(a, b, c, d) && losingCombo(a - 1, b - 1, c - 1, d - 1)) {
			combo[a][b][c][d] = 2;
			return true;
		} else if (ccd(a, b, c, d) && losingCombo(a, b, c - 2, d - 1)) {
			combo[a][b][c][d] = 2;
			return true;
		} else if (bbb(a, b, c, d) && losingCombo(a, b - 3, c, d)) {
			combo[a][b][c][d] = 2;
			return true;
		} else if (ad(a, b, c, d) && losingCombo(a - 1, b, c, d - 1)) {
			combo[a][b][c][d] = 2;
			return true;
		}
		combo[a][b][c][d] = 1;
		return false;
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int a, b, c, d;
		combo = new int[31][31][31][31];
		for (int i = 0; i < n; i++) {
			a = scanner.nextInt();
			b = scanner.nextInt();
			c = scanner.nextInt();
			d = scanner.nextInt();
			if (winningCombo(a, b, c, d)) {
				System.out.println("Patrick");
			} else {
				System.out.println("Roland");
			}
		}
		scanner.close();

	}

}
