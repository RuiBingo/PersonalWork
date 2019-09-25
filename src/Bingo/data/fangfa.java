package Bingo.data;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

//(.+\\*\\..+)|(.+\\?\\..+)判断路径正确与否
public class fangfa {
	public static void shuru(File f1,String[] s1) throws IOException {
		
	
		File[] file1=f1.listFiles();
		for (File file2 : file1) {
			String str=file2.getPath();
			String s2=s1[1];
			if(file2.isDirectory()) {				
				shuru(file2,s1);
			}else if(str.endsWith(s2)) {
				System.out.println(file2.getPath());
				System.out.println(file2.getName());
				countWord c=new countWord();
				
				try {
					
					c.Cnum(file2);
					System.out.println("字符数：" + c.Cnum(file2));
					c.Linenum(file2);
					System.out.println("行数：" + c.Linenum(file2));
					c.Wordnum(file2);
					System.out.println("单词数：" + c.Wordnum(file2));
					c.CodeState(file2);
					System.out.println("-----------------------------------------");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}

