
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ccc11s1 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int t = 0;
		int s = 0;
		for (int i = 0; i < n; i++) {
			String[] text = br.readLine().split("");
			for (int j = 0; j < text.length; j++) {
				if(text[j].equalsIgnoreCase("t")) {
					t++;
				}
				else if(text[j].equalsIgnoreCase("s")) {
					s++;
				}
			}

		}
		if(t > s){
			System.out.println("English");
		}
		else {
			System.out.println("French");
		}

	}

}
