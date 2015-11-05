package kadaiQU01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String args[]) {
		// ファイル存在チェック
		File file = new File(args[0]);
		if (file.exists()) {
			long fileLineCount = CountNumberOfTextLines(args[0]);

			// ファイルの行数が1行以上ある場合
			if (fileLineCount > 0) {
				System.out.println(fileLineCount + "行あります");
			}
			// 空ファイルの場合何もしないで終了
		} else {
			System.out.println("ファイルが存在しません");
		}
	}

	private static long CountNumberOfTextLines(String filePath) {

		long lineCount = 0;
		BufferedReader bufferedReader = null;
		FileReader fileReader = null;
		try {
			// ファイルを読み込みモードでオープンする
			fileReader = new FileReader(filePath);
			bufferedReader = new BufferedReader(fileReader);
			String line = null;

			// 1行目を読んでみる
			// 空のファイルなら、line には null がセットされる。
			line = bufferedReader.readLine();

			// ファイルの最後まで来て null が返ってくるまで、処理を繰り返す
			while (line != null) {
				lineCount++;

				// readLineメソッドを使ってもう1行読み込む
				line = bufferedReader.readLine();
			}
		}

		catch (IOException e) {
			// tryでエラーが発生するとここに来る
			System.out.println(e);
		} finally {
			try {
				bufferedReader.close();
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return lineCount;
	}
}
