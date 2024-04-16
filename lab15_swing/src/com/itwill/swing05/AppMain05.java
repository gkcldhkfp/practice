package com.itwill.swing05;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;

public class AppMain05 {

	private JFrame frame;
	private JTextField textFieldName;
	private JTextField textFieldPhone;
	private JTextField textFieldEmail;
	private JTextArea textAreaResult;
	private JButton btnNewButton;

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
		lblEmail.setBounds(80, 198, 100, 30);
		frame.getContentPane().add(lblEmail);
		
		btnNewButton = new JButton("입력");
		btnNewButton.addActionListener((e) -> insert());
		btnNewButton.setBounds(575, 202, 80, 30);
		frame.getContentPane().add(btnNewButton);
		
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
		
		textAreaResult = new JTextArea();
		textAreaResult.setFont(new Font("D2Coding", Font.PLAIN, 15));
		textAreaResult.setBounds(80, 272, 575, 118);
		frame.getContentPane().add(textAreaResult);
	}
	
	private void insert() {
		String x = textFieldEmail.getText();
		String y =textFieldName.getText();
		String z =textFieldPhone.getText();
		
		String result = String.format("이름 : %s \n전화번호 : %s \n이메일 : %s",y, z, x );
		
		textAreaResult.setText(result);
	}

}
