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
import javax.swing.JTextField;
import javax.swing.SwingConstants;



public class ContactUpdateFrame extends JFrame {
	
	public static interface UpdateNotify {
		public void notifyContactUpdated();
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

	int index;
	Component parentComponent;
	private JButton btnSave;
	private JButton btnCancle;
	
	private UpdateNotify app;
	/**
	 * L
	 */
	public static void showContactUpdateFrame(Component parentComponent,int index , UpdateNotify app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactUpdateFrame frame = new ContactUpdateFrame(parentComponent,index,app);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ContactUpdateFrame(Component parentComponent,int index, UpdateNotify app) {
		this.index = index;
		this.parentComponent = parentComponent;
		this.app = app;
		initialize();
	}

	/**
	 * Create the frame.
	 */
	public void initialize() {
		setTitle("업데이트 연락처");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 463, 363);
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
		textName.setText(dao.read(index).getName());
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
		textPhone.setText(dao.read(index).getPhone());
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
		textEmail.setText(dao.read(index).getEmail());
		textEmail.setFont(new Font("D2Coding", Font.PLAIN, 16));
		textEmail.setColumns(10);
		textEmail.setBounds(107, 146, 301, 61);
		contentPanel.add(textEmail);
		
		btnSave = new JButton("저장");
		btnSave.addActionListener((e) -> updateContact());
		btnSave.setFont(new Font("D2Coding", Font.PLAIN, 22));
		btnSave.setBounds(12, 228, 175, 58);
		contentPanel.add(btnSave);
		
		btnCancle = new JButton("취소");
		btnCancle.addActionListener((e) -> dispose());
		btnCancle.setFont(new Font("D2Coding", Font.PLAIN, 22));
		btnCancle.setBounds(233, 228, 175, 58);
		contentPanel.add(btnCancle);
		

	}

	private void updateContact() {
		Contact updatedContact = new Contact(0, textName.getText(), textPhone.getText(), textEmail.getText()); 
		dao.update(index, updatedContact);
		app.notifyContactUpdated();
		dispose();
	}
}
