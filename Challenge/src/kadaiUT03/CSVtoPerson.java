package kadaiUT03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class CSVtoPerson {
	public static List<Person> personCSVList(String csvFile)
			throws ParseException {

		// 変数定義
		String lastName = "", firstName = "", address = "";
		String birthday = "";
		int age = 0;

		// 格納用のオブジェクト生成

		// 要素がPerson型のListのインスタンス作り、データセット
		List<Person> personList = new ArrayList<Person>();
		BufferedReader bufferedReader = null;
		FileReader fileReader = null;

		try {
			fileReader = new FileReader(csvFile);
			bufferedReader = new BufferedReader(fileReader);
			String line;

			// 一行毎に読み込む、nullになるまで
			while ((line = bufferedReader.readLine()) != null) {
				Person person = new Person(lastName, firstName, address,
						birthday, age);
				// コロンで区切った単語で、string配列に入れる
				String[] col = line.split(",");
				person.setLastName(col[0]);
				person.setFirstName(col[1]);
				person.setAddress(col[2]);
				person.setBirthday(col[3]);
				personList.add(person);

			}
			if (personList.isEmpty()) {
				System.out.println("中身がありません。");
			}
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
				fileReader.close();

			} catch (IOException e) {

				e.printStackTrace();
			}

		}
		return personList;
	}
}
