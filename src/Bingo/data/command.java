package Bingo.data;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;



public class command {

	public void go() {
		
		System.out.println("--------------------------------------------------------------");
		System.out.println("wc exe功能：");
		System.out.println("---------  wc.exe -c 计算文件含有的字符数");
		System.out.println("---------  wc.exe -w 计算文件内容的单词数");
		System.out.println("---------  wc.exe -l计算文件内容的总行数");
		System.out.println("---------  wc.exe -a计算文件内容的总注释行数，总空白行数和总代码行数");
		System.out.println("---------  wc.exe -x调出图形界面对文件进行查询操作");
		System.out.println("---------  wc.exe -f结束程序");
		System.out.println("-------------  -s显示所有相同后缀的文件，并计算出他们的字符数，单词数，行数，总注释行数，总空白行数和总代码行数");
		System.out.println("-------------  -o返回，重新输入路径");
		System.out.println("--------------------------------------------------------------");
		System.out.println("欢迎使用：wc exe，输入路径选择功能");
		Scanner scanner = new Scanner(System.in);
		File file = new File(scanner.nextLine());
		String str=file.getPath();
		if (file.isDirectory()) {
			System.out.println("---------------------------------------------------------------------------------------------------------------");
			System.out.println("你输入的是一个目录");
			System.out.println("请输入正确的文件路径或者输入含有通配符(?|*)的模糊路径去搜索文件");
			System.out.println("------------- wc.exe -o返回，重新输入路径");
			System.out.println("---------------------------------------------------------------------------------------------------------------");
			Scanner sc1=new Scanner(System.in);
			String str1=sc1.nextLine();
			String st="-o";
			if(str1.equals(st)) {
				go();
			}else {
				System.out.println("输入错误，程序结束(注意：要输入“-o”!)");
			}
		}else if(Pattern.matches("(.+\\*\\..+)|(.+\\?\\..+)", str)){
			System.out.println("---------------------------------------------------------------------------------------------------------------");
			System.out.println("你输入的是一个目录");
			System.out.println("请选择执行功能：-s显示所有相同后缀的文件，并计算出他们的字符数，单词数，行数，总注释行数，总空白行数和总代码行数");
			System.out.println("-------------  -o返回，重新输入路径");
			System.out.println("---------------------------------------------------------------------------------------------------------------");
			Scanner sc1=new Scanner(System.in);
			String str1=sc1.nextLine();
			String s=file.getPath();
			String[] s1= s.split("(\\*\\.)|(\\?\\.)");
			File f1=new File(s1[0]);
			switch (str1) {
			
			case "-o":
				go();
				break;
				
			case "-s":
				fangfa f=new fangfa();
				try {
					f.shuru(f1,s1);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				go();
				break;
				

			default:
				System.out.println("输入有误");
				break;
			}
		}else {
			if (file.exists() == false) {
				System.out.println("文件不存在");
				go();
			} else {
				System.out.println("--------------------------------------------------------------");
				System.out.println("请选择功能：");
				System.out.println("---------  wc.exe -c 计算文件含有的字符数");
				System.out.println("---------  wc.exe -w 计算文件内容的单词数");
				System.out.println("---------  wc.exe -l计算文件内容的总行数");
				System.out.println("---------  wc.exe -a计算文件内容的总注释行数，总空白行数和总代码行数");
				System.out.println("---------  wc.exe -x调出图形界面对文件进行查询操作");
				System.out.println("---------  wc.exe -f结束程序");
				System.out.println("--------------------------------------------------------------");
				Scanner sc2 = new Scanner(System.in);
				String str2 = sc2.nextLine();
				String a = new String("-f");
				if (a.equals(str2)) {
					System.out.println("程序结束");
				} else {
					switch (str2) {

					case "-c":
						countWord c1 = new countWord();
						c1.Cnum(file);
						System.out.println(file.getName());
						System.out.println("字符数：" + c1.Cnum(file));
						go();
						break;

					case "-l":
						countWord c2 = new countWord();
						try {
							c2.Linenum(file);
							System.out.println(file.getName());
							System.out.println("行数：" + c2.Linenum(file));
						} catch (IOException e) {
							e.printStackTrace();
						}
						go();
						break;

					case "-w":
						countWord c3 = new countWord();
						try {
							c3.Wordnum(file);
							System.out.println(file.getName());
							System.out.println("单词数：" + c3.Wordnum(file));
						} catch (IOException e) {
							e.printStackTrace();
						}
						go();
						break;

					case "-a":
						countWord c4 = new countWord();
						System.out.println(file.getName());
						try {
							c4.CodeState(file);
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						}
						go();
						break;
						
					case "-x":
						GUI01 frame = new GUI01();
						frame.setVisible(true);
						System.out.println("------------------------");
						go();
						break;

					default:
						System.out.println("输入有误");
						break;

					}

				}
			}
		}
	}

	public static void main(String[] args) throws IOException {

		command e1 = new command();

		e1.go();
	}

}
