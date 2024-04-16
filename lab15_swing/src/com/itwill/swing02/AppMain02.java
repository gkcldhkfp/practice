package com.itwill.swing02;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain02 {

	private JFrame frame;
	private JTextField textInput;
	private JLabel lblMessage;
	private JButton btnInput;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain02 window = new AppMain02();
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
	public AppMain02() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(650, 350, 677, 288);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null); // Absolute layout
		
		lblMessage = new JLabel("메시지를 입력하세요...");
		lblMessage.setHorizontalAlignment(SwingConstants.LEFT);
		lblMessage.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblMessage.setBounds(12, 10, 637, 48);
		frame.getContentPane().add(lblMessage);
		
		textInput = new JTextField();
		textInput.setFont(new Font("D2Coding", Font.PLAIN, 22));
		textInput.setBounds(22, 68, 614, 85);
		frame.getContentPane().add(textInput);
		textInput.setColumns(10);
		
		btnInput = new JButton("입 력");

		// 버튼에 ActionListener 이벤트 핸들러를 설정(등록)
		btnInput.addActionListener(new ActionListener() {
			@Override // 버튼이 클릭됐을 때 할 일을 작성.
			public void actionPerformed(ActionEvent e) {
				// (지역) 내부 클래스에서는 외부 클래스의 메서드를 사용할 수 있음.
				handleInputButtonClick();
			}
		});
		btnInput.setIcon(null);
		btnInput.setFont(new Font("D2Coding", Font.BOLD, 23));
		btnInput.setBounds(284, 163, 97, 48);
		frame.getContentPane().add(btnInput);
	}

	private void handleInputButtonClick() {
		// 1. JTextField에 입력된 문자열을 읽음.
		String msg = textInput.getText();
		// 2. (1)에서 읽은 내용을 JLabel에 씀.
		lblMessage.setText(msg);
		// 3. JTextFiled를 비움(JTextField에 입력된 내용을 지움).
		textInput.setText("");
	}
}
