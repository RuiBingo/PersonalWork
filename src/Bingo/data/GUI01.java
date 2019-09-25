package Bingo.data;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class GUI01 extends JFrame {

	protected static final String LINE_SEPARATOR = System.getProperty("line.separator");
	private JPanel contentPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI01 frame = new GUI01();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI01() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("\u9009\u62E9\u6587\u4EF6");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openFile(e);						
			}
		});
		button.setBounds(0, 0, 131, 44);
		contentPane.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 57, 548, 262);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}
	protected void openFile(ActionEvent e) {
		JFileChooser chooser=new JFileChooser();
		int returnVal=chooser.showOpenDialog(this);
		if(returnVal==JFileChooser.CANCEL_OPTION) {
			return;
		}
		File file=chooser.getSelectedFile();
		countWord c=new countWord();
		String C="字符数：";
		String L="行数：";
		String W="单词数：";
		String N="注释行数：";
		String B="空白行数：";
		String Code="代码行数：";
		//File file=new File();
		if(file.exists()) {
			//textArea.setText(file.getPath());
			textArea.append(file.getPath()+LINE_SEPARATOR);
			textArea.append(C+c.Cnum(file)+LINE_SEPARATOR);
			try {
				textArea.append(L+c.Linenum(file)+LINE_SEPARATOR);
				textArea.append(W+c.Wordnum(file)+LINE_SEPARATOR);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				textArea.append(N+c.CodeState1(file)+LINE_SEPARATOR);
				textArea.append(B+c.CodeState2(file)+LINE_SEPARATOR);
				textArea.append(Code+c.CodeState3(file)+LINE_SEPARATOR);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
	}
}
