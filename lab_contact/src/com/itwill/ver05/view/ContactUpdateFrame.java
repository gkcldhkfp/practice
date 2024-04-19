package com.itwill.ver05.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.ver05.controller.ContactDao;
import com.itwill.ver05.controller.ContactDaoImpl;
import com.itwill.ver05.model.Contact;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ContactUpdateFrame extends JFrame {
	public interface notifyUpdated {
		void notifyContactUpdated();
	}

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel contentPanel;
	private JTextField textName;
	private JTextField textPhone;
	private JTextField textEmail;
	private JLabel lblEmail;
	private JLabel lblPhone;
	private JLabel lblName;

	private ContactDao dao = ContactDaoImpl.getInstance();

	private int index; // 업데이트할 연락처의 (리스트) 인덱스를 저장하기 위해
	private Component parentComponent; // 부모 컴포넌트를 저장하기 위해
	private notifyUpdated app; // 메인 쓰레드 주소를 저장하기 위한 객체
	
	private JButton btnSave;
	private JButton btnCancle;


	/**
	 * L
	 */
	public static void showContactUpdateFrame(Component parentComponent, int index, notifyUpdated app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactUpdateFrame frame = new ContactUpdateFrame(parentComponent, index, app);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ContactUpdateFrame(Component parentComponent, int index, notifyUpdated app) {
		this.index = index;
		this.parentComponent = parentComponent;
		this.app = app;
		initialize();
		initializeTextFields();
	}

	/**
	 * Create the frame.
	 */
	public void initialize() {
		setTitle("업데이트 연락처");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 463, 363);
		setLocationRelativeTo(parentComponent);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		contentPanel = new JPanel();
		contentPane.add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblName = new JLabel("이름");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("D2Coding", Font.PLAIN, 16));
		lblName.setBounds(12, 10, 83, 58);
		contentPanel.add(lblName);

		textName = new JTextField();
		textName.setFont(new Font("D2Coding", Font.PLAIN, 16));
		textName.setBounds(107, 10, 301, 58);
		contentPanel.add(textName);
		textName.setColumns(10);

		lblPhone = new JLabel("전화번호");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setFont(new Font("D2Coding", Font.PLAIN, 16));
		lblPhone.setBounds(12, 78, 83, 58);
		contentPanel.add(lblPhone);

		textPhone = new JTextField();
		textPhone.setFont(new Font("D2Coding", Font.PLAIN, 16));
		textPhone.setColumns(10);
		textPhone.setBounds(107, 78, 301, 58);
		contentPanel.add(textPhone);

		lblEmail = new JLabel("이메일");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("D2Coding", Font.PLAIN, 16));
		lblEmail.setBounds(12, 146, 83, 61);
		contentPanel.add(lblEmail);

		textEmail = new JTextField();
		
		textEmail.setFont(new Font("D2Coding", Font.PLAIN, 16));
		textEmail.setColumns(10);
		textEmail.setBounds(107, 146, 301, 61);
		contentPanel.add(textEmail);

		btnSave = new JButton("저장");
		btnSave.addActionListener((e) -> updated());
		btnSave.setFont(new Font("D2Coding", Font.PLAIN, 22));
		btnSave.setBounds(12, 228, 175, 58);
		contentPanel.add(btnSave);

		btnCancle = new JButton("취소");
		btnCancle.addActionListener((e) -> dispose());
		btnCancle.setFont(new Font("D2Coding", Font.PLAIN, 22));
		btnCancle.setBounds(233, 228, 175, 58);
		contentPanel.add(btnCancle);

	}

	private void updated() {
		// 업데이트 할 내용을 읽음
		String name = textName.getText();
		String phone = textPhone.getText();
		String email = textEmail.getText();
		// 읽은 내용으로 연락처 생성
		Contact updatedContact = new Contact(0, name, phone, email);
		// 해당 인덱스에 덮어쓰기
		int result = dao.update(index, updatedContact);
		// 성공시 메시지 출력후 종료
		if (result == 1) {
			dispose();
			app.notifyContactUpdated(); // 실시간 갱신
		} else {
			JOptionPane.showMessageDialog(contentPane, "FAIL"); // 실패시 알림 종료x
		}

	}
	
	private void initializeTextFields() {
		// 3개의 텍스트필드에 해당 인덱스의 연락처 정보를 채움.
		textName.setText(dao.read(index).getName());
		textPhone.setText(dao.read(index).getPhone());
		textEmail.setText(dao.read(index).getEmail());
		
	}

}
