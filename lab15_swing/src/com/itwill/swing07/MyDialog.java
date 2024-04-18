package com.itwill.swing07;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MyDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton okButton;
	private JButton cancelButton;
	private JPanel buttonPanel;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	
	// 부모 컴포넌트를 저장하기 위한 필드
	private Component parentComponent;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;

	/**
	 * Launch the application.
	 */
	
	public static void showMyDialog(Component parentComponent) {
		
		try {
			MyDialog dialog = new MyDialog(parentComponent);
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MyDialog(Component parentComponent) {
		this.parentComponent = parentComponent;
		initialize();
	}

	private void initialize() {
		// 다이얼로그의 좌표(x, y)와 크기(width, height)
		setBounds(100, 100, 512, 431);
		
		// setBounds의 (x, y) 좌표를 무시하고 부모 컴포넌트에 상대적으로(부모의 가운데 위치) 배치.
		// 아규먼트가 null인 경우 화면 중앙에 배치.
		setLocationRelativeTo(parentComponent);;

		// 다이얼로그의 닫기 버튼(X)의 기본 동작을 설정:
		// DISPOSE_ON_CLOSE: 현재 다이얼로그만 닫고, 메인 프로세스는 계속 실행.
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		// getContentPane(): 컨텐트 영역 & 버튼 영역
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(12, 10, 126, 71);
		contentPanel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(12, 91, 126, 71);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(btnNewButton_1.isEnabled()) {
					btnNewButton_1.setEnabled(false);
				}else {
					btnNewButton_1.setEnabled(true);
				}
			}
		});
		btnNewButton.setBounds(150, 10, 126, 71);
		contentPanel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(btnNewButton_2.isEnabled()) {
					btnNewButton_2.setEnabled(false);
				}else {
					btnNewButton_2.setEnabled(true);
				}
			}
		});
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.setBounds(150, 91, 126, 71);
		contentPanel.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("New button");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(btnNewButton_3.isEnabled()) {
					btnNewButton_3.setEnabled(false);
				}else{
					btnNewButton_3.setEnabled(true);
				}
							
			}
		});
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.setBounds(290, 10, 126, 71);
		contentPanel.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("New button");
		btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnNewButton_1.setEnabled(false);
				btnNewButton_2.setEnabled(false);
				btnNewButton_3.setEnabled(false);
				textField.setText("ㅇㅅㅇ");
				
			}
		});
		btnNewButton_3.setEnabled(false);
		btnNewButton_3.setBounds(288, 91, 126, 71);
		contentPanel.add(btnNewButton_3);

		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);

		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelButton.setFont(new Font("D2Coding", Font.PLAIN, 16));
		cancelButton.setActionCommand("Cancel");
		buttonPanel.add(cancelButton);

		okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		okButton.setFont(new Font("D2Coding", Font.PLAIN, 27));
		okButton.setActionCommand("OK");
		buttonPanel.add(okButton);
		getRootPane().setDefaultButton(okButton);

	}
}
