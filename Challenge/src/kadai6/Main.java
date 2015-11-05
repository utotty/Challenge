package kadai6;

public class Main {

	public static void main(String[] args) {

		int a = 0;
		//1から100までの偶数の足し算をして合計を表示する。
		for(int f = 1;f <= 100;f++) {

			if(f%2 == 0)
			{
				a += f;
			}

		}
		System.out.println(a);
	}

}
