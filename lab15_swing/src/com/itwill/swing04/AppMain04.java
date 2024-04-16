package com.itwill.swing04;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain04 {

	private JFrame frame;
	private JTextField textField1;
	private JTextField textField2;
	private JButton btnPlus;
	private JButton btnMinus;
	private JButton btnMultiply;
	private JButton btnDivide;
	private JLabel lblNum2;
	private JLabel lblNum1;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain04 window = new AppMain04();
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
	public AppMain04() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 592, 529);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textArea.setBounds(31, 231, 516, 237);
		frame.getContentPane().add(textArea);

		lblNum1 = new JLabel("Number 1");
		lblNum1.setBounds(31, 26, 57, 38);
		frame.getContentPane().add(lblNum1);

		lblNum2 = new JLabel("Number 2");
		lblNum2.setBounds(31, 109, 57, 38);
		frame.getContentPane().add(lblNum2);

		textField1 = new JTextField();
		textField1.setBounds(117, 27, 305, 37);
		frame.getContentPane().add(textField1);
		textField1.setColumns(10);

		textField2 = new JTextField();
		textField2.setColumns(10);
		textField2.setBounds(117, 109, 305, 37);
		frame.getContentPane().add(textField2);

		btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleButtonClick(e);
			}
		});
		
		btnPlus.setFont(new Font("D2Coding", Font.PLAIN, 22));
		btnPlus.setBounds(31, 179, 97, 42);
		frame.getContentPane().add(btnPlus);

		btnMinus = new JButton("-");
		btnMinus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleButtonClick(e);
			}
		});

		btnMinus.setFont(new Font("D2Coding", Font.PLAIN, 22));
		btnMinus.setBounds(140, 179, 97, 42);
		frame.getContentPane().add(btnMinus);

		btnMultiply = new JButton("x");
		btnMultiply.addActionListener((e) -> handleButtonClick(e));
		btnMultiply.setFont(new Font("D2Coding", Font.PLAIN, 22));
		btnMultiply.setBounds(249, 179, 97, 42);
		frame.getContentPane().add(btnMultiply);

		btnDivide = new JButton("/");
		btnDivide.addActionListener(this::handleButtonClick);
		// AppMain04.this::handleButtonClick
		btnDivide.setFont(new Font("D2Coding", Font.PLAIN, 22));
		btnDivide.setBounds(358, 179, 97, 42);
		frame.getContentPane().add(btnDivide);
	}

	private void handleButtonClick(ActionEvent event) {
		// JTextField에 입력된 문자열을 숫자(double)로 변환
		double x = 0;
		double y = 0;
		try {
			x = Double.parseDouble(textField1.getText());
			y = Double.parseDouble(textField2.getText());
		} catch (NumberFormatException ex) {
			textArea.setText("Number1 또는 Number2에는 숫자를 입력하세요.");
			return; // 메서드 종료
		}

		double result = 0; // 사칙연산 결과를 저장할 변수
		String operator = ""; // 사칙연산 기호

		Object source = event.getSource(); // 이벤트가 발생한 소스(UI 컴포넌트)
		if (source == btnPlus) {
			result = x + y;
			operator = "+";
		} else if (source == btnMinus) {
			result = x - y;
			operator = "-";			
		} else if (source == btnMultiply) {
			result = x * y;
			operator = "x";
		} else if (source == btnDivide) {
//			if (y == 0) {
//				textArea.setText("0으로는 나눌 수 없음");
//				return;
//			}
			result = x / y;
			operator = "/";
		}
		
		// 결과창에 보여줄 문자열
		String msg = String.format("%f %s %f = %f", x, operator, y, result);
		textArea.setText(msg);
		
	}

//	private void cal(String a) {
//		double x = 0;
//		double y = 0;
//		double result = 0;
//		try {
//			x = Double.parseDouble(textField1.getText());
//			y = Double.parseDouble(textField2.getText());
//		} catch (NumberFormatException ex) {
//			textArea.setText("Number1 또는 Number2에는 숫자를 입력하세요.");
//			return;
//		}
//
//		switch (a) {
//		case "-":
//			result = x - y;
//			break;
//		case "x":
//			result = x * y;
//			break;
//		case "/":
//			if (y == 0) {
//				textArea.setText("0으로는 나눌 수 없음");
//				return;
//			}
//			result = x / y;
//
//		}
//		String msg = String.format("%f %s %f = %f", x, a, y, result);
//		textArea.setText(msg);
//	}
}
