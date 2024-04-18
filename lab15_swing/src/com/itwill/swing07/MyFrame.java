package com.itwill.swing07;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class MyFrame extends JFrame {
	public interface Notifiable{
		public void notifyMessage(String msg);
	}

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JButton btn;
	private JLabel lblNewLabel;

	private Component parentComponent; // 부모 컴포넌트를 저장하기 위한 필드
	private Notifiable app; // notifyMessage(String msg) 메서드를 갖는 객체의 주소를 저장

	/**
	 * Launch the application.
	 * 
	 * @param parentComponent
	 * @param appMain07
	 */
	public static void showMyFrame(Component parentComponent, Notifiable app) {
		/*
		 * Component |___ JFrame, JDialog
		 */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame frame = new MyFrame(parentComponent, app);
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public MyFrame(Component parentComponent, Notifiable app) {
		this.parentComponent = parentComponent;
		this.app = app;
		initialize();
	}

	/**
	 * Create the frame.
	 */
	public void initialize() {
		// JFrame의 닫기 버튼의 기본 동작을 설정:
		// EXIT_ON_CLOSE: 프로그램 종료(메인 쓰레드 종료)
		// DISPOSE_ON_CLOSE: 현재 JFrame만 닫음(메인 쓰레드는 계속 실행)
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		int x = 0;
		int y = 0;
		if (parentComponent != null) {
			x = parentComponent.getX(); // 부모 컴포넌트의 x 좌표
			y = parentComponent.getY();// 부모 컴포넌트의 y 좌표
		}
		setBounds(x, y, 450, 300);
		if (parentComponent == null) { // 부모 컴포넌트 정보가 없을 때
			setLocationRelativeTo(null); // 화면 중앙에 배치
		}
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("ㅡㅡㅡㅡㅡㅡㅡ");
		lblNewLabel.setFont(new Font("D2Coding", Font.BOLD, 32));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(94, 10, 240, 94);
		contentPane.add(lblNewLabel);

		btn = new JButton("버튼");
		btn.setBackground(new Color(255, 255, 224));
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// JTextField의 내용을 읽음
				String msg = textField.getText();
				app.notifyMessage(msg);
			}
		});
		btn.setForeground(new Color(220, 20, 60));
		btn.setFont(new Font("D2Coding", Font.PLAIN, 31));
		btn.setBounds(153, 187, 140, 64);
		contentPane.add(btn);

		textField = new JTextField();
		textField.setBounds(12, 114, 410, 63);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
