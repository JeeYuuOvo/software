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
		JFrame frame = new JFrame("���������ϵ�ṹ��ѧ���");
		frame.setSize(1500, 800);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		JTabbedPane tab = new JTabbedPane();
		//�ֱ���������panel����ʽ����ͬС�죬����ͨ��ͬһ��ģ�����
		tab.add("������-�ӳ���",createPanel(1));
		tab.add("�������",createPanel(2));
		tab.add("�¼�ϵͳ",createPanel(3));
		tab.add("�ܵ�-����",createPanel(4));
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
			content_desc = "������/�ӳ�����ϵͳ��֯�ɲ�νṹ��\n����һ���������һϵ���ӳ���\n"
					+ "��Ҫ�����ܹ���ϵͳ��������ηֽ�Ϊ���˳��ִ�в����ϵͳ��";
			content_imgurl = "images and other files/1.png";
			content_code = "���Ĵ���:\r\n"
					+ "public static void main(String[] args) {\r\n"
					+ "        demo1 kwic = new demo1();\r\n"
					+ "        kwic.input(\"images and other files/input.txt\");\r\n"
					+ "        kwic.shift();\r\n"
					+ "        kwic.alphabetizer();\r\n"
					+ "        kwic.output(\"images and other files/output.txt\");\r\n"
					+ "    }";
		}
		else if(type == 2) {
			content_desc = "�������ʽ���ϵͳ��֯Ϊ��������Ķ���\nÿ�������װ���ڲ������ݣ�\n���������ݶ����ṩ����\n"
					+ "��������Щ�ܹ�����������Ϣ�ֽ����֯�����ϵͳ��";
			content_imgurl = "images and other files/2.png";
			content_code = "���Ĵ���:\r\n"
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
			content_desc = "�۲���ģʽ������һ��һ�Զ��������ϵ��\n�ö���۲��߶���ͬʱ����ĳһ���������\n"
					+ "������������״̬�仯ʱ��\n��֪ͨ���еĹ۲��߶���\nʹ�����ܹ��Զ������Լ���\n������ʵ�ֱ�ʾ��������߼���ķ��롣";
			content_imgurl = "images and other files/3.png";
			content_code = "���Ĵ���:\r\n"
					+ "public static void main(String[] args) {\r\n"
					+ "        //��������\r\n"
					+ "        KWICSubject kwicSubject = new KWICSubject();\r\n"
					+ "        //�����۲���\r\n"
					+ "        Input input = new Input(\"images and other files/input.txt\");\r\n"
					+ "        Shift shift = new Shift(input.getLineTxt());\r\n"
					+ "        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());\r\n"
					+ "        Output output = new Output(alphabetizer.getKwicList(), \"images and other files/output.txt\");\r\n"
					+ "\r\n"
					+ "        // ���۲��߼�������\r\n"
					+ "        kwicSubject.addObserver(input);\r\n"
					+ "        kwicSubject.addObserver(shift);\r\n"
					+ "        kwicSubject.addObserver(alphabetizer);\r\n"
					+ "        kwicSubject.addObserver(output);\r\n"
					+ "        // �𲽵��ø����۲���\r\n"
					+ "        kwicSubject.startKWIC();\r\n"
					+ "    }";
		}
		else if(type == 4) {
			content_desc = "�ܵ�-������ģʽ�ṹ������һ����Ʒ�ӹ���ˮ�ߣ�\nԭ��������ˮ���Ͼ���һ�������˵ļӹ���\n������������Ʒ��\n"
					+ "�����ں����׵ر��ֽ��һ����ɢ�ġ������Ĳ���������";
			content_imgurl = "images and other files/4.png";
			content_code = "���Ĵ���:\r\n"
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
		//��Ϊ5�飬����˵����ԭ��ͼ�����롢���а�ť��չʾ����
		JTextArea desc = new JTextArea(content_desc);
		JScrollPane scroll_desc = new JScrollPane(desc);
		scroll_desc.setFont(new Font(null, Font.PLAIN, 50));
		GridBagConstraints gridBagConstraints_1 = new GridBagConstraints();
		gridBagConstraints_1.gridy = 0;//��
		gridBagConstraints_1.gridx = 0;//��
		gridBagConstraints_1.weightx = 0.2;
		gridBagConstraints_1.weighty = 0.5;
		gridBagConstraints_1.fill = GridBagConstraints.BOTH;
		panel.add(scroll_desc,gridBagConstraints_1);
		
		
		ImageIcon img = new ImageIcon(content_imgurl);
		//ע���ÿ��ͼƬ�ı�һ���ı���
		img.setImage(img.getImage().getScaledInstance(500, 240, 0));
		JLabel label = new JLabel(img);
		GridBagConstraints gridBagConstraints_2 = new GridBagConstraints();
		gridBagConstraints_2.gridy = 0;//��
		gridBagConstraints_2.gridx = 1;//��

		gridBagConstraints_2.weightx = 0.3;
		gridBagConstraints_2.weighty = 0.5;
		gridBagConstraints_2.fill = GridBagConstraints.HORIZONTAL;
		panel.add(label,gridBagConstraints_2);
		
		JTextArea result = new JTextArea("���н��");
		JScrollPane scroll_result = new JScrollPane(result);
		scroll_result.setFont(new Font(null, Font.PLAIN, 20));
		GridBagConstraints gridBagConstraints_5 = new GridBagConstraints();
		gridBagConstraints_5.gridy = 0;//��
		gridBagConstraints_5.gridx = 2;//��
		gridBagConstraints_5.gridheight = 2;
		gridBagConstraints_5.weightx = 0.4;
		gridBagConstraints_5.weighty = 1;
		gridBagConstraints_5.fill = GridBagConstraints.BOTH;
		panel.add(scroll_result,gridBagConstraints_5);
		
		JTextArea code = new JTextArea(content_code);
		JScrollPane scroll_code = new JScrollPane(code);
		scroll_result.setFont(new Font(null, Font.PLAIN, 10));
		GridBagConstraints gridBagConstraints_3 = new GridBagConstraints();
		gridBagConstraints_3.gridy = 1;//��
		gridBagConstraints_3.gridx = 0;//��
		gridBagConstraints_3.weightx = 0.5;
		gridBagConstraints_3.weighty = 0.5;
		gridBagConstraints_3.fill = GridBagConstraints.BOTH;
		panel.add(scroll_code,gridBagConstraints_3);
		
		JButton button = new JButton("����");
		GridBagConstraints gridBagConstraints_4 = new GridBagConstraints();
		button.setFont(new Font(null, Font.BOLD, 30));
		button.setForeground(Color.GREEN);
		button.setBackground(Color.WHITE);
		gridBagConstraints_4.gridy = 1;//��
		gridBagConstraints_4.gridx = 1;//��
		gridBagConstraints_4.weightx = 0.1;
		gridBagConstraints_4.weighty = 0.5;
		gridBagConstraints_4.ipadx = 200;
		gridBagConstraints_4.ipady = 100;
		panel.add(button,gridBagConstraints_4);
		
		//������Ӽ�����
		if(type == 1) {
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						//����
						result.setText("������-�ӳ�����ʾ���н����");//��ʾ���
						clearFile();//����ļ�����
						func1.demo1.main(null);
	    				//��ȡ�ļ�����ʾ���
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
						//����
						result.setText("���������ʾ���н����");//��ʾ���
						clearFile();//����ļ�����
						func2.Main.main(null);
	    				//��ȡ�ļ�����ʾ���
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
						//����
						result.setText("�¼�ϵͳ-�۲���ģʽ��ʾ���н����");//��ʾ���
						clearFile();//����ļ�����
						func3.Main.main(null);
	    				//��ȡ�ļ�����ʾ���
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
						//����
						result.setText("�ܵ�-������ʾ���н����");//��ʾ���
						clearFile();//����ļ�����
						func4.Main.main(null);
	    				//��ȡ�ļ�����ʾ���
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
