package Bingo.data;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;



public class command {

	public void go() {
		
		System.out.println("--------------------------------------------------------------");
		System.out.println("wc exe���ܣ�");
		System.out.println("---------  wc.exe -c �����ļ����е��ַ���");
		System.out.println("---------  wc.exe -w �����ļ����ݵĵ�����");
		System.out.println("---------  wc.exe -l�����ļ����ݵ�������");
		System.out.println("---------  wc.exe -a�����ļ����ݵ���ע���������ܿհ��������ܴ�������");
		System.out.println("---------  wc.exe -x����ͼ�ν�����ļ����в�ѯ����");
		System.out.println("---------  wc.exe -f��������");
		System.out.println("-------------  -s��ʾ������ͬ��׺���ļ�������������ǵ��ַ���������������������ע���������ܿհ��������ܴ�������");
		System.out.println("-------------  -o���أ���������·��");
		System.out.println("--------------------------------------------------------------");
		System.out.println("��ӭʹ�ã�wc exe������·��ѡ����");
		Scanner scanner = new Scanner(System.in);
		File file = new File(scanner.nextLine());
		String str=file.getPath();
		if (file.isDirectory()) {
			System.out.println("---------------------------------------------------------------------------------------------------------------");
			System.out.println("���������һ��Ŀ¼");
			System.out.println("��������ȷ���ļ�·���������뺬��ͨ���(?|*)��ģ��·��ȥ�����ļ�");
			System.out.println("------------- wc.exe -o���أ���������·��");
			System.out.println("---------------------------------------------------------------------------------------------------------------");
			Scanner sc1=new Scanner(System.in);
			String str1=sc1.nextLine();
			String st="-o";
			if(str1.equals(st)) {
				go();
			}else {
				System.out.println("������󣬳������(ע�⣺Ҫ���롰-o��!)");
			}
		}else if(Pattern.matches("(.+\\*\\..+)|(.+\\?\\..+)", str)){
			System.out.println("---------------------------------------------------------------------------------------------------------------");
			System.out.println("���������һ��Ŀ¼");
			System.out.println("��ѡ��ִ�й��ܣ�-s��ʾ������ͬ��׺���ļ�������������ǵ��ַ���������������������ע���������ܿհ��������ܴ�������");
			System.out.println("-------------  -o���أ���������·��");
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
				System.out.println("��������");
				break;
			}
		}else {
			if (file.exists() == false) {
				System.out.println("�ļ�������");
				go();
			} else {
				System.out.println("--------------------------------------------------------------");
				System.out.println("��ѡ���ܣ�");
				System.out.println("---------  wc.exe -c �����ļ����е��ַ���");
				System.out.println("---------  wc.exe -w �����ļ����ݵĵ�����");
				System.out.println("---------  wc.exe -l�����ļ����ݵ�������");
				System.out.println("---------  wc.exe -a�����ļ����ݵ���ע���������ܿհ��������ܴ�������");
				System.out.println("---------  wc.exe -x����ͼ�ν�����ļ����в�ѯ����");
				System.out.println("---------  wc.exe -f��������");
				System.out.println("--------------------------------------------------------------");
				Scanner sc2 = new Scanner(System.in);
				String str2 = sc2.nextLine();
				String a = new String("-f");
				if (a.equals(str2)) {
					System.out.println("�������");
				} else {
					switch (str2) {

					case "-c":
						countWord c1 = new countWord();
						c1.Cnum(file);
						System.out.println(file.getName());
						System.out.println("�ַ�����" + c1.Cnum(file));
						go();
						break;

					case "-l":
						countWord c2 = new countWord();
						try {
							c2.Linenum(file);
							System.out.println(file.getName());
							System.out.println("������" + c2.Linenum(file));
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
							System.out.println("��������" + c3.Wordnum(file));
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
						System.out.println("��������");
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
