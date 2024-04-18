package com.itwill.swing07;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.itwill.swing07.MyFrame.Notifiable;

public class AppMain07 implements Notifiable {

	private JFrame frame;
	private JButton btnMsgDlg;
	private JButton btnConfirmDlg;
	private JButton btnInputDlg;
	private JButton btnCustomDlg;
	private JButton btnMyFrame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain07 window = new AppMain07();
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
	public AppMain07() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(600, 300, 643, 602);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnMsgDlg = new JButton("버 튼");
		btnMsgDlg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 메시지 다이얼로그 보여주기
				JOptionPane.showMessageDialog(
						frame,						// 부모 컴포넌트
						"끼야아악",					// 다이얼로그 메시지
						"으아아악",					// 다이얼로그 타이틀(제목)
						JOptionPane.QUESTION_MESSAGE// 메이지 타입
						); 
			}
		});
		btnMsgDlg.setFont(new Font("D2Coding", Font.BOLD, 90));
		btnMsgDlg.setBounds(12, 10, 603, 100);
		frame.getContentPane().add(btnMsgDlg);
		
		btnConfirmDlg = new JButton("컨 펌");
		btnConfirmDlg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				int result = JOptionPane.showConfirmDialog(frame, "정말요?"); 
				int result = JOptionPane.showConfirmDialog(
						frame,							// 부모 컴포넌트
						"질문",							// 메시지
						"제목",							// 타이틀
						JOptionPane.YES_NO_OPTION,		// 옵션 타입(버튼 종류, 개수)
						JOptionPane.QUESTION_MESSAGE);	// 메시지 타입
				
				btnConfirmDlg.setText(result+"");
			}
		});
		btnConfirmDlg.setFont(new Font("D2Coding", Font.BOLD, 90));
		btnConfirmDlg.setBounds(12, 120, 603, 100);
		frame.getContentPane().add(btnConfirmDlg);
		
		btnInputDlg = new JButton("인 풋");
		btnInputDlg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 입력 다이얼로그 보여주기
//				String input = JOptionPane.showInputDialog(frame,"꺄아아아악");
//				String input = JOptionPane.showInputDialog("제목", "초기값");
			
				final String[] selections = {"인*","얼굴장부","X","너튜브"};
				Object input = JOptionPane.showInputDialog(
						frame,		//부모 컴포넌트
						"메시지", 	// 메시지
						"제목", 	// 제목
						JOptionPane.QUESTION_MESSAGE, // 메시지 타입 - 메시지 기본 아이콘
						null,		// 아이콘
						selections,		// 선택할 값들
						selections[0]);	// 초기 선택값
				if(input != null && input.equals("꺄아아아악")) {
					JOptionPane.showConfirmDialog(frame, "따라하지마셈;;",";;;",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE);
				}else {
					btnInputDlg.setText(""+input);
					btnInputDlg.setFont(new Font("D2Coding", Font.BOLD, 77));
				}
			}
		});
		btnInputDlg.setFont(new Font("D2Coding", Font.BOLD, 90));
		btnInputDlg.setBounds(12, 227, 603, 100);
		frame.getContentPane().add(btnInputDlg);
		
		btnCustomDlg = new JButton("커스텀");
		btnCustomDlg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 내가 만든 다이얼로그 보여주기
				MyDialog.showMyDialog(frame);
			}
		});
		btnCustomDlg.setFont(new Font("D2Coding", Font.BOLD, 90));
		btnCustomDlg.setBounds(12, 337, 603, 100);
		frame.getContentPane().add(btnCustomDlg);
		
		btnMyFrame = new JButton("프레임");
		btnMyFrame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MyFrame.showMyFrame(frame, AppMain07.this);
				//-> 아규먼트 frame: MyFrame 클래스가 부모 컴포넌트(JFrame) 정보를 사용할 수 있도록.
				//-> 아규먼트 AppMain07.this: AppMain07 타입으로 생성된 객체(의 주소). 현재 객체.
				//	MyFrame 클래스에서 AppMain07 객체의 public 메서드를 호출할 수 있도록.
			}
		});
		btnMyFrame.setFont(new Font("D2Coding", Font.BOLD, 90));
		btnMyFrame.setBounds(12, 447, 603, 100);
		frame.getContentPane().add(btnMyFrame);
	}
	@Override
	public void notifyMessage(String msg) {
		btnMyFrame.setText(msg);
	}
}
