package player;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import func1.*;
import func2.*;
import func2.Alphabetizer;
import func2.Input;
import func2.Output;
import func2.Shift;
import func3.*;
import func4.*;

public class UI {
	public static void main(String[] args){
		JFrame frame = new JFrame("经典软件体系结构教学软件");
		frame.setSize(1500, 800);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		JTabbedPane tab = new JTabbedPane();
		//分别设置四种panel的样式，大同小异，可以通过同一个模板产生
		tab.add("主程序-子程序",createPanel(1));
		tab.add("面向对象",createPanel(2));
		tab.add("事件系统",createPanel(3));
		tab.add("管道-过滤",createPanel(4));
		tab.setSelectedIndex(0);

		frame.setContentPane(tab);
		frame.setVisible(true);
	}
	private static JComponent createPanel(int type) {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		String content_desc = new String();
		String content_imgurl = new String();
		String content_code = new String();
		if(type == 1) {
			content_desc = "主程序/子程序风格将系统组织成层次结构，\n包括一个主程序和一系列子程序，\n"
					+ "主要用于能够将系统功能依层次分解为多个顺序执行步骤的系统。";
			content_imgurl = "images and other files/1.png";
			content_code = "核心代码:\r\n"
					+ "public static void main(String[] args) {\r\n"
					+ "        demo1 kwic = new demo1();\r\n"
					+ "        kwic.input(\"images and other files/input.txt\");\r\n"
					+ "        kwic.shift();\r\n"
					+ "        kwic.alphabetizer();\r\n"
					+ "        kwic.output(\"images and other files/output.txt\");\r\n"
					+ "    }";
		}
		else if(type == 2) {
			content_desc = "面向对象式风格将系统组织为多个独立的对象，\n每个对象封装其内部的数据，\n并基于数据对外提供服务，\n"
					+ "适用于那些能够基于数据信息分解和组织的软件系统。";
			content_imgurl = "images and other files/2.png";
			content_code = "核心代码:\r\n"
					+ "public static void main(String[] args) {\r\n"
					+ "        Input input = new Input();\r\n"
					+ "        input.input(\"images and other files/input.txt\");\r\n"
					+ "        Shift shift = new Shift(input.getLineTxt());\r\n"
					+ "        shift.shift();\r\n"
					+ "        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());\r\n"
					+ "        alphabetizer.sort();\r\n"
					+ "        Output output = new Output(alphabetizer.getKwicList());\r\n"
					+ "        output.output(\"images and other files/output.txt\");\r\n"
					+ "    }";
		}
		else if(type == 3) {
			content_desc = "观察者模式定义了一种一对多的依赖关系，\n让多个观察者对象同时监听某一个主题对象。\n"
					+ "这个主题对象在状态变化时，\n会通知所有的观察者对象，\n使他们能够自动更新自己。\n它可以实现表示层和数据逻辑层的分离。";
			content_imgurl = "images and other files/3.png";
			content_code = "核心代码:\r\n"
					+ "public static void main(String[] args) {\r\n"
					+ "        //创建主题\r\n"
					+ "        KWICSubject kwicSubject = new KWICSubject();\r\n"
					+ "        //创建观察者\r\n"
					+ "        Input input = new Input(\"images and other files/input.txt\");\r\n"
					+ "        Shift shift = new Shift(input.getLineTxt());\r\n"
					+ "        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());\r\n"
					+ "        Output output = new Output(alphabetizer.getKwicList(), \"images and other files/output.txt\");\r\n"
					+ "\r\n"
					+ "        // 将观察者加入主题\r\n"
					+ "        kwicSubject.addObserver(input);\r\n"
					+ "        kwicSubject.addObserver(shift);\r\n"
					+ "        kwicSubject.addObserver(alphabetizer);\r\n"
					+ "        kwicSubject.addObserver(output);\r\n"
					+ "        // 逐步调用各个观察者\r\n"
					+ "        kwicSubject.startKWIC();\r\n"
					+ "    }";
		}
		else if(type == 4) {
			content_desc = "管道-过滤器模式结构就像是一条产品加工流水线，\n原材料在流水线上经过一个个工人的加工，\n最终生产出产品。\n"
					+ "适用于很容易地被分解成一组离散的、独立的步骤的软件。";
			content_imgurl = "images and other files/4.png";
			content_code = "核心代码:\r\n"
					+ "public static void main(String[] args) throws IOException {\r\n"
					+ "        File inFile = new File(\"images and other files/input.txt\");\r\n"
					+ "        File outFile = new File(\"images and other files/output.txt\");\r\n"
					+ "        Pipe pipe1 = new Pipe();\r\n"
					+ "        Pipe pipe2 = new Pipe();\r\n"
					+ "        Pipe pipe3 = new Pipe();\r\n"
					+ "        Input input = new Input(inFile, pipe1);\r\n"
					+ "        Shift shift = new Shift(pipe1, pipe2);\r\n"
					+ "        Alphabetizer alphabetizer  = new Alphabetizer(pipe2, pipe3);\r\n"
					+ "        Output output = new Output(outFile,pipe3);\r\n"
					+ "        input.transform();\r\n"
					+ "        shift.transform();\r\n"
					+ "        alphabetizer.transform();\r\n"
					+ "        output.transform();\r\n"
					+ "    }";
		}
		else {
			return null;
		}
		//分为5块，文字说明、原理图、代码、运行按钮、展示区域
		JTextArea desc = new JTextArea(content_desc);
		JScrollPane scroll_desc = new JScrollPane(desc);
		scroll_desc.setFont(new Font(null, Font.PLAIN, 50));
		GridBagConstraints gridBagConstraints_1 = new GridBagConstraints();
		gridBagConstraints_1.gridy = 0;//行
		gridBagConstraints_1.gridx = 0;//列
		gridBagConstraints_1.weightx = 0.2;
		gridBagConstraints_1.weighty = 0.5;
		gridBagConstraints_1.fill = GridBagConstraints.BOTH;
		panel.add(scroll_desc,gridBagConstraints_1);
		
		
		ImageIcon img = new ImageIcon(content_imgurl);
		//注意对每张图片改变一定的比例
		img.setImage(img.getImage().getScaledInstance(500, 240, 0));
		JLabel label = new JLabel(img);
		GridBagConstraints gridBagConstraints_2 = new GridBagConstraints();
		gridBagConstraints_2.gridy = 0;//行
		gridBagConstraints_2.gridx = 1;//列

		gridBagConstraints_2.weightx = 0.3;
		gridBagConstraints_2.weighty = 0.5;
		gridBagConstraints_2.fill = GridBagConstraints.HORIZONTAL;
		panel.add(label,gridBagConstraints_2);
		
		JTextArea result = new JTextArea("运行结果");
		JScrollPane scroll_result = new JScrollPane(result);
		scroll_result.setFont(new Font(null, Font.PLAIN, 20));
		GridBagConstraints gridBagConstraints_5 = new GridBagConstraints();
		gridBagConstraints_5.gridy = 0;//行
		gridBagConstraints_5.gridx = 2;//列
		gridBagConstraints_5.gridheight = 2;
		gridBagConstraints_5.weightx = 0.4;
		gridBagConstraints_5.weighty = 1;
		gridBagConstraints_5.fill = GridBagConstraints.BOTH;
		panel.add(scroll_result,gridBagConstraints_5);
		
		JTextArea code = new JTextArea(content_code);
		JScrollPane scroll_code = new JScrollPane(code);
		scroll_result.setFont(new Font(null, Font.PLAIN, 10));
		GridBagConstraints gridBagConstraints_3 = new GridBagConstraints();
		gridBagConstraints_3.gridy = 1;//行
		gridBagConstraints_3.gridx = 0;//列
		gridBagConstraints_3.weightx = 0.5;
		gridBagConstraints_3.weighty = 0.5;
		gridBagConstraints_3.fill = GridBagConstraints.BOTH;
		panel.add(scroll_code,gridBagConstraints_3);
		
		JButton button = new JButton("运行");
		GridBagConstraints gridBagConstraints_4 = new GridBagConstraints();
		button.setFont(new Font(null, Font.BOLD, 30));
		button.setForeground(Color.GREEN);
		button.setBackground(Color.WHITE);
		gridBagConstraints_4.gridy = 1;//行
		gridBagConstraints_4.gridx = 1;//列
		gridBagConstraints_4.weightx = 0.1;
		gridBagConstraints_4.weighty = 0.5;
		gridBagConstraints_4.ipadx = 200;
		gridBagConstraints_4.ipady = 100;
		panel.add(button,gridBagConstraints_4);
		
		//分情况加监听器
		if(type == 1) {
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						//运行
						result.setText("主程序-子程序演示运行结果：");//表示清空
						clearFile();//清空文件内容
						func1.demo1.main(null);
	    				//读取文件，显示结果
						String result_content = getFileContent();
						result.append(result_content);
					}
					catch (Exception e1) {
			            e1.printStackTrace();
			        }
				}
			});
		}
		else if(type == 2) {
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						//运行
						result.setText("面向对象演示运行结果：");//表示清空
						clearFile();//清空文件内容
						func2.Main.main(null);
	    				//读取文件，显示结果
						String result_content = getFileContent();
						result.append(result_content);
					}
					catch (Exception e1) {
			            e1.printStackTrace();
			        }
				}
			});
		}
		else if(type == 3) {
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						//运行
						result.setText("事件系统-观察者模式演示运行结果：");//表示清空
						clearFile();//清空文件内容
						func3.Main.main(null);
	    				//读取文件，显示结果
						String result_content = getFileContent();
						result.append(result_content);
					}
					catch (Exception e1) {
			            e1.printStackTrace();
			        }
				}
			});
		}
		else if(type == 4) {
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						//运行
						result.setText("管道-过滤演示运行结果：");//表示清空
						clearFile();//清空文件内容
						func4.Main.main(null);
	    				//读取文件，显示结果
						String result_content = getFileContent();
						result.append(result_content);
					}
					catch (Exception e1) {
			            e1.printStackTrace();
			        }
				}
			});
		}
		else {
			return null;
		}
		
		return panel;
	}
	public static String getFileContent(){
		File file = new File("images and other files/output.txt");
	    StringBuilder result = new StringBuilder();
	    try{
	      BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
	      String res = null;
	      while((res = bufferedreader.readLine())!=null){
	        result.append(System.lineSeparator()+res);
	      }
	      bufferedreader.close();  
	    }catch(Exception e){
	      e.printStackTrace();
	    }
	    return result.toString();
	  }
	public static void clearFile(){
		File file = new File("images and other files/output.txt");
		FileWriter filewriter;
		try {
			filewriter = new FileWriter (file);
			filewriter.write("");
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
