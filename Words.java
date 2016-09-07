package net.ukr.geka3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Words {
	public static String[] twoFileWords(File fileOne, File fileTwo) throws NoFileException, NullPointerException {
		if (fileOne == null) {
			throw new NullPointerException();
		}
		if (fileTwo == null) {
			throw new NullPointerException();
		}
		if (!fileOne.isFile()) {
			throw new NoFileException();
		}
		if (!fileTwo.isFile()) {
			throw new NoFileException();
		}

		String[] result = new String[0];

		try (BufferedReader fbrOne = new BufferedReader(new FileReader(fileOne));
				BufferedReader fbrTwo = new BufferedReader(new FileReader(fileTwo))) {
			StringBuilder strbOne = new StringBuilder();
			StringBuilder strbTwo = new StringBuilder();
			String buffer = "";
			for (; (buffer = fbrOne.readLine()) != null;) {
				strbOne.append(buffer + " ");
			}

			for (; (buffer = fbrTwo.readLine()) != null;) {
				strbTwo.append(buffer + " ");
			}
			boolean mayAdd = false;
			String[] arrayOne = strbOne.toString().split(" ");
			String[] arrayTwo = strbTwo.toString().split(" ");
			System.out.println(Arrays.toString(arrayOne));
			System.out.println(Arrays.toString(arrayTwo));
			for (int i = 0; i < arrayOne.length; i++) {
				for (int j = 0; j < arrayTwo.length; j++) {
					
					if (arrayOne[i].equals(arrayTwo[j])) {
						mayAdd = true;
					}
					if (mayAdd) {
						for (int k = 0; k < result.length; k++) {
							if (arrayOne[i].equals(result[k])) {
								mayAdd = false;
							}

						}
					}

					if (mayAdd) {
						System.out.println(arrayOne[i] + " was added");
						int n = result.length;
						result = arrayPlusOne(result);
						result[n] = arrayOne[i];

					}
					mayAdd = false;

				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public static String[] arrayPlusOne(String[] str) {
		String[] temp = new String[str.length + 1];
		System.arraycopy(str, 0, temp, 0, str.length);
		return temp;
	}

}
