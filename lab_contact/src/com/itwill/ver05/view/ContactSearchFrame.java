package com.itwill.ver05.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.itwill.ver05.controller.ContactDaoImpl;
import com.itwill.ver05.model.Contact;
import com.itwill.ver05.controller.ContactDao;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ContactSearchFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Component parentComponent;
	private JTextField textField;
	private JButton btnSearch;
	private JScrollPane scrollPane;
	private JPanel headerPanel;
	private JTable table;
	private static final String[] COLUMN_NAMES = { "이름" , "전화번호" , "이메일" };
	private DefaultTableModel model;
	
	private ContactDao dao = ContactDaoImpl.getInstance();
	/**
	 * Launch the application.
	 */
	public static void showContactSearchFrame(Component parentComponent) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactSearchFrame frame = new ContactSearchFrame(parentComponent);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public ContactSearchFrame(Component parentComponent) {
		this.parentComponent = parentComponent;
		
		initialize();
	}
	

	/**
	 * Create the frame.
	 */
	public void initialize() {
		setTitle("연락처 검색");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		int x = 0;
		int y = 0;
		if (parentComponent != null) {
			// 부모 컴포넌트가 있으면 부모 컴포넌트와 같은 좌표(x,y)에 위치시킴.
			x = parentComponent.getX();
			y = parentComponent.getY();
		}

		setBounds(x, y, 525, 491);
		if (parentComponent == null) {
			// 부모 컴포넌트가 없으면 화면 중앙에 위치시킴.
			setLocationRelativeTo(null);
		}
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		headerPanel = new JPanel();
		contentPane.add(headerPanel, BorderLayout.NORTH);
		
		textField = new JTextField();
		textField.setFont(new Font("D2Coding", Font.PLAIN, 16));
		headerPanel.add(textField);
		textField.setColumns(10);
		
		btnSearch = new JButton("검색");
		btnSearch.addActionListener((e) -> searchByKeyword());
		btnSearch.setFont(new Font("D2Coding", Font.PLAIN, 16));
		headerPanel.add(btnSearch);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		model = new DefaultTableModel(null, COLUMN_NAMES);
		
		table.setFont(new Font("D2Coding", Font.PLAIN, 18));
		table.getTableHeader().setFont(new Font("D2Coding", Font.PLAIN, 18));
		table.setRowHeight(22);
		table.setModel(model);
		scrollPane.setViewportView(table);
	}

	private void searchByKeyword() {
		// 검색어 읽음
		String keyword = textField.getText();
		
		// DAO를 사용해서 검색어로 검색 결과를 가져옴.
		List<Contact> list = dao.search(keyword);
		
		// 테이블 리셋
		model = new DefaultTableModel(null, COLUMN_NAMES);
		
		// 비워진 테이블모델에 검색결과만 행으로 추가
		for(Contact c : list) {
			Object[] row = {c.getName(), c.getPhone(), c.getEmail()};
			model.addRow(row);
		}

		table.setModel(model); // 테이블에 테이블모델을 다시 세팅
	}
	
}
