package Bingo.data;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




public class countWord {

	static String path;
	private static InputStream flie;
	private static Pattern codelPattern;

	public static int Cnum(File file) {
		int getc = 0;
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String s;
	    while((s = br.readLine())!= null) {
	    	getc +=s.length();
	    }
		} catch (Exception e) {
			e.printStackTrace();

		}
		return getc;
		}

	public static int Linenum(File file) throws IOException {
		int getline = 0;
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		try {
			while(br.readLine() !=null ){
				getline++;
		}
	} catch (Exception e) {
		e.printStackTrace();

	}
		return getline;
	}
	public static int Wordnum(File file) throws IOException {
		int getword = 0;
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String l=null;
			while((l=br.readLine())!=null) {
				String w ="[a-zA-Z]+";
				Pattern pattern=Pattern.compile(w);
				Matcher mat = pattern.matcher(l);
				while(mat.find()) {
					getword++;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return getword;
	}	
	public static void CodeState(File file) throws FileNotFoundException {
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		int noteline=0;
		int blanknessline=0;
		int codeline=0;
		String l=null;
		boolean flag=false;		
		try {
			while((l=br.readLine())!=null){			
				l=l.trim();			
				if(l.startsWith("//")){				
					noteline++;			
					}else if(l.startsWith("/*")&&l.endsWith("*/")){				
						noteline++;			
						}else if(l.startsWith("/*")&&!l.endsWith("*/")||flag){				
							flag=true;				
							noteline++;				
							if(l.endsWith("*/")){					
								flag=false;				
								}			
							}else if(l.isEmpty()||l.startsWith("{")||l.endsWith("}")){				
								blanknessline++;			
								}else{				
									codeline++;			
									}			
					}
		} catch (IOException e) {
			e.printStackTrace();
		}		
				
		System.out.println("注释行数为："+noteline);
		System.out.println("空白行数为："+blanknessline);
		System.out.println("代码行数为："+codeline);
		
	}
	
	
	
	public static int CodeState1(File file) throws FileNotFoundException {
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		int noteline=0;
		int blanknessline=0;
		int codeline=0;
		String l=null;
		boolean flag=false;		
		try {
			while((l=br.readLine())!=null){			
				l=l.trim();			
				if(l.startsWith("//")){				
					noteline++;			
					}else if(l.startsWith("/*")&&l.endsWith("*/")){				
						noteline++;			
						}else if(l.startsWith("/*")&&!l.endsWith("*/")||flag){				
							flag=true;				
							noteline++;				
							if(l.endsWith("*/")){					
								flag=false;				
								}			
							}else if(l.isEmpty()||l.startsWith("{")||l.endsWith("}")){				
								blanknessline++;			
								}else{				
									codeline++;			
									}			
					}
		} catch (IOException e) {
			e.printStackTrace();
		}		
	return noteline;
	
	
	}
	
	
	public static int CodeState2(File file) throws FileNotFoundException {
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		int noteline=0;
		int blanknessline=0;
		int codeline=0;
		String l=null;
		boolean flag=false;		
		try {
			while((l=br.readLine())!=null){			
				l=l.trim();			
				if(l.startsWith("//")){				
					noteline++;			
					}else if(l.startsWith("/*")&&l.endsWith("*/")){				
						noteline++;			
						}else if(l.startsWith("/*")&&!l.endsWith("*/")||flag){				
							flag=true;				
							noteline++;				
							if(l.endsWith("*/")){					
								flag=false;				
								}			
							}else if(l.isEmpty()||l.startsWith("{")||l.endsWith("}")){				
								blanknessline++;			
								}else{				
									codeline++;			
									}			
					}
		} catch (IOException e) {
			e.printStackTrace();
		}		
	return blanknessline;
	
	
	}
	
	
	
	
	public static int CodeState3(File file) throws FileNotFoundException {
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		int noteline=0;
		int blanknessline=0;
		int codeline=0;
		String l=null;
		boolean flag=false;		
		try {
			while((l=br.readLine())!=null){			
				l=l.trim();			
				if(l.startsWith("//")){				
					noteline++;			
					}else if(l.startsWith("/*")&&l.endsWith("*/")){				
						noteline++;			
						}else if(l.startsWith("/*")&&!l.endsWith("*/")||flag){				
							flag=true;				
							noteline++;				
							if(l.endsWith("*/")){					
								flag=false;				
								}			
							}else if(l.isEmpty()||l.startsWith("{")||l.endsWith("}")){				
								blanknessline++;			
								}else{				
									codeline++;			
									}			
					}
		} catch (IOException e) {
			e.printStackTrace();
		}		
	return codeline;
	
	
	}
	
	
}

