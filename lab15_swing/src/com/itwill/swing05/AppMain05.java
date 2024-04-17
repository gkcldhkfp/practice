package com.itwill.swing05;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JScrollPane;

public class AppMain05 {

	private JFrame frame;
	private JTextField textFieldName;
	private JTextField textFieldPhone;
	private JTextField textFieldEmail;
	private JTextArea textAreaResult;
	private JButton btnInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain05 window = new AppMain05();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppMain05() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(152, 251, 152));
		frame.setBounds(100, 100, 700, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("이름");
		lblName.setBounds(80, 76, 100, 30);
		frame.getContentPane().add(lblName);
		
		JLabel lblPhone = new JLabel("전화번호");
		lblPhone.setBounds(80, 137, 100, 30);
		frame.getContentPane().add(lblPhone);
		
		JLabel lblEmail = new JLabel("이메일");
		lblEmail.setForeground(new Color(0, 0, 0));
		lblEmail.setBackground(new Color(128, 128, 64));
		lblEmail.setBounds(80, 198, 100, 30);
		frame.getContentPane().add(lblEmail);
		
		btnInput = new JButton("입력");
		btnInput.addActionListener((e) -> insert());
		btnInput.setBounds(575, 202, 80, 30);
		frame.getContentPane().add(btnInput);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(184, 81, 300, 30);
		frame.getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setColumns(10);
		textFieldPhone.setBounds(184, 142, 300, 30);
		frame.getContentPane().add(textFieldPhone);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(184, 203, 300, 30);
		frame.getContentPane().add(textFieldEmail);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 264, 561, 118);
		frame.getContentPane().add(scrollPane);
		
		textAreaResult = new JTextArea();
		scrollPane.setViewportView(textAreaResult);
		textAreaResult.setFont(new Font("D2Coding", Font.PLAIN, 16));
	}
	
	private void insert() {
		String email = textFieldEmail.getText();
		String name =textFieldName.getText();
		String phone =textFieldPhone.getText();
		
		String result = String.format("이름 : %s 전화번호 : %s 이메일 : %s\n",name, phone, email );
		
//		textAreaResult.setText(result); 기존 내용을 지우고 새로 씀
		textAreaResult.append(result);  // 기존에 작성된 내용 끝에 추가.
		
		// 모든 JTextField의 입력된 내용을 지움.
		textFieldName.setText("");
		textFieldEmail.setText("");
		textFieldPhone.setText("");
	}
}
