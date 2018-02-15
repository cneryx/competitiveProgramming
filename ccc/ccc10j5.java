import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ccc10j5 {
	public static int least = -1;

	public static Integer[] a = new Integer[2];
	public static Integer[] b = new Integer[2];

	public static HashMap<String, Integer> board = new HashMap<String, Integer>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		a[0] = scanner.nextInt();
		a[1] = scanner.nextInt();
		b[0] = scanner.nextInt();
		b[1] = scanner.nextInt();
		board.put(a[0] + "." + a[1], 0);
		scanner.close();
		if (a[0] == b[0] && a[1] == b[1]) {
			System.out.println(0);
		} else {
			loop(a, 0);
			System.out.println(least);
		}
	}

	static ArrayList<Integer[]> nextMove(Integer[] a, int moves) {
		ArrayList<Integer[]> list = new ArrayList<Integer[]>();
		for (int i = 1; i <= 8; i++) {
			Integer[] coord = move(i, a, moves);
			if (coord == null) {
				return null;
			} else if (!coord[0].equals(0) && !coord[1].equals(0)) {
				list.add(coord);
			}
		}
		return list;
	}

	static Integer[] move(int moveType, Integer[] a, int moves) {
		Integer[] coord = { a[0], a[1] };
		switch (moveType) {
		case 1:
			coord[0] += 2;
			coord[1] += 1;
			break;
		case 2:
			coord[0] += 2;
			coord[1] -= 1;
			break;
		case 3:
			coord[0] += 1;
			coord[1] += 2;
			break;
		case 4:
			coord[0] += 1;
			coord[1] -= 2;
			break;
		case 5:
			coord[0] -= 2;
			coord[1] += 1;
			break;
		case 6:
			coord[0] -= 2;
			coord[1] -= 1;
			break;
		case 7:
			coord[0] -= 1;
			coord[1] += 2;
			break;
		case 8:
			coord[0] -= 1;
			coord[1] -= 2;
			break;
		}
		if (coord[0].intValue() > 0 && coord[0].intValue() <= 8 && coord[1].intValue() > 0
				&& coord[1].intValue() <= 8) {

			if (board.containsKey(coord[0] + "." + coord[1])) {
				if (board.get(coord[0] + "." + coord[1]).intValue() <= moves) {
					return new Integer[] { 0, 0 };
				} else {
					return coord;
				}
			} else if (coord[0].equals(b[0]) && coord[1].equals(b[1])) {
				return null;
			} else {
				return coord;
			}
		}
		return new Integer[] { 0, 0 };
	}

	static void loop(Integer[] arr, int moves) {
		ArrayList<Integer[]> list = nextMove(arr, moves);
		moves++;
		if (list == null) {
			if (moves < least || least == -1) {
				least = moves;
			}
			return;
		} else if (list.size() == 0) {
			return;
		}
		for (int i = 0; i < list.size(); i++) {
			if (board.containsKey(list.get(i)[0] + "." + list.get(i)[1])) {
				board.replace(list.get(i)[0] + "." + list.get(i)[1], moves);
			} else {
				board.put(list.get(i)[0] + "." + list.get(i)[1], moves);
			}
			loop(list.get(i), moves);
		}
		return;
	}
}
