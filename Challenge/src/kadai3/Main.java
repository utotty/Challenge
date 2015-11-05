package kadai3;

public class Main {

	public static void main(String[] args) {

		for (String temp : args) {

			int sum = Integer.parseInt(temp);
			if (sum <= 100) {
				System.out.println("小さい");
			} else {
				System.out.println("大きい");
			}
		}

	}

}
