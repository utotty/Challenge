package kadaiUT03;

import java.io.File;
import java.text.ParseException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) throws ParseException {
		// 入力されたcsvファイルを読み込み、csvの内容からPersonオブジェクトに変換する。
		// また、苗字＋年齢（生年月日ではない）で降順になるソートを行い、
		// 以下のコードで、名前＋住所＋生年月日を出力するプログラムを作成する。

		// ファイル存在チェック
		File csvFile = new File(args[0]);
		if (csvFile.exists()) {
			// personCSVListでcsvをPersonオブジェクトに変換
			// List型で返す
			List<Person> personList = CSVtoPerson.personCSVList(args[0]);
			// 年齢と苗字でソートする（名前は考慮していない）
			Collections.sort(personList, new Comparator<Person>() {
				// compareで名前と年齢を比較し、結果を返す
				@Override
				public int compare(Person p1, Person p2) {
					return p2.getLastName().compareTo(p1.getLastName())
							& p2.getAge() - p1.getAge();
				}
			});

			// Personを全て表示
			for (Person person : personList) {
				System.out.println(person.toString());
			}
		} else {
			System.out.println("ファイルが存在しません。");
		}
	}
}