package kadaiUT03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Person {
	private String lastName;
	private String firstName;
	private String address;
	private String birthday;
	private int age;

	public Person(String lastName, String firstName, String address,
			String birthday, int age) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.address = address;
		this.birthday = birthday;
		this.age = age;
	}

	// 苗字
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	// 名前
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	// 住所
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	// 生年月日
	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;

	}

	private int getAgeFromBirthday(String birthday) {

		// String型のbirthdayをDate型に変換
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Date date = null;
		try {
			date = format.parse(birthday);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// 生年月日のインスタンス取得
		GregorianCalendar birthdayCal = new GregorianCalendar();
		birthdayCal.setTime(date);
		// 計算日のインスタンス取得
		Calendar toDayCal = Calendar.getInstance();
		toDayCal.getTime().toString();
		// 計算日の年と誕生日の年の差をintに入れる
		int age = toDayCal.get(Calendar.YEAR) - birthdayCal.get(Calendar.YEAR);
		// ただし誕生月・日より年齢計算月日が前であれば年齢は1歳少ない
		// 仕様上マイナス年齢になることがある
		if (!birthdayCal.isLeapYear(toDayCal.get(Calendar.YEAR))) {
			// 誕生日が閏ではない場合
			if (birthdayCal.get(Calendar.DAY_OF_MONTH) == 2
					&& birthdayCal.get(Calendar.DATE) >= 29) {
				// 誕生日を3/1にする
				birthdayCal.set(Calendar.DAY_OF_MONTH, 3);
				birthdayCal.set(Calendar.DATE, 1);
			}
		}
		if (toDayCal.get(Calendar.MONTH) < birthdayCal.get(Calendar.MONTH)) {
			age--;
		} else if (toDayCal.get(Calendar.MONTH) == birthdayCal
				.get(Calendar.MONTH)
				&& toDayCal.get(Calendar.DAY_OF_MONTH) < birthdayCal
						.get(Calendar.DAY_OF_MONTH)) {
			age--;
		}
		return age;
	}

	public int getAge() {
		// 生年月日から年齢を計算したものをageに入れる
		// 日付での年齢差は考慮外
		age = getAgeFromBirthday(birthday);
		return age;
	}

	@Override
	public String toString() {
		return firstName + ", " + address + ", " + birthday;
	}
}
