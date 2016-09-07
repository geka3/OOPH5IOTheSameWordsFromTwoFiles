package net.ukr.geka3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String [] doubleWords = new String [0];
		try {
		doubleWords = Words.twoFileWords(new File("one.txt"), new File("Two.txt"));
		} catch (NullPointerException | NoFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(Arrays.toString(doubleWords));
		if(doubleWords.length > 0){
			try(FileWriter fw = new FileWriter(new File("result.txt"))){
				for (String string : doubleWords) {
					fw.write(string + " ");
					System.out.println(string + " is added to file ");
				}
				
				
		}catch (IOException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		}
		
	}

}
