package com.itwill.practiceProject.view;

import java.awt.Component;
import java.awt.EventQueue;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.practiceProject.controller.ScheduleDao;
import com.itwill.practiceProject.model.Schedule;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.sql.Date;

public class ScheduleInfo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	String selectedItem;
	String selectedDate;
	Component parent;
	
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	LocalDate date = null;
	private JLabel lblDate;
	private JTextField textFieldTitle;
	private JTextField textFieldLocation;
	private JButton btnCancel;
	private JButton btnSave;

	ScheduleDao dao = ScheduleDao.getinstance();
	private JTextArea textAreaContent;

	/**
	 * Launch the application.
	 */
	public static void showScheduleInfo(Component parent, String selectedItem, String selectedDate) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScheduleInfo frame = new ScheduleInfo(parent, selectedItem, selectedDate);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private ScheduleInfo(Component parent, String selectedItem, String selectedDate) {
		this.parent = parent;
		this.selectedItem = selectedItem;
		this.date = LocalDate.parse(selectedDate, formatter);
		initialize();
		setInfoToTextField();
	}

	private void setInfoToTextField() {
		Schedule result = dao.readToInfo(selectedItem, date);
		textFieldTitle.setText(result.getTitle());
		textAreaContent.setText(result.getContent());
		textFieldLocation.setText(result.getWhere());
	}

	/**
	 * Create the frame.
	 */
	public void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 451, 520);
		setLocationRelativeTo(parent);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblDate = new JLabel("New label");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblDate.setBounds(12, 10, 411, 37);
		contentPane.add(lblDate);
		lblDate.setText(date + "");

		textFieldTitle = new JTextField();
		textFieldTitle.setBounds(86, 57, 317, 37);
		contentPane.add(textFieldTitle);
		textFieldTitle.setColumns(10);

		JLabel lblTitle = new JLabel("제목");
		lblTitle.setFont(new Font("D2Coding", Font.PLAIN, 22));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(12, 57, 72, 37);
		contentPane.add(lblTitle);

		JLabel lblContent = new JLabel("내용");
		lblContent.setHorizontalAlignment(SwingConstants.CENTER);
		lblContent.setFont(new Font("D2Coding", Font.PLAIN, 22));
		lblContent.setBounds(12, 170, 72, 37);
		contentPane.add(lblContent);

		textFieldLocation = new JTextField();
		textFieldLocation.setColumns(10);
		textFieldLocation.setBounds(86, 368, 317, 37);
		contentPane.add(textFieldLocation);

		JLabel lblLocation = new JLabel("장소");
		lblLocation.setHorizontalAlignment(SwingConstants.CENTER);
		lblLocation.setFont(new Font("D2Coding", Font.PLAIN, 22));
		lblLocation.setBounds(12, 368, 72, 37);
		contentPane.add(lblLocation);

		btnSave = new JButton("저장");
		btnSave.addActionListener((e) -> updateScheduleInfo());
		btnSave.setFont(new Font("D2Coding", Font.PLAIN, 18));
		btnSave.setBounds(43, 434, 120, 37);
		contentPane.add(btnSave);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener((e) -> dispose());
		btnCancel.setFont(new Font("D2Coding", Font.PLAIN, 18));
		btnCancel.setBounds(275, 434, 120, 37);
		contentPane.add(btnCancel);

		textAreaContent = new JTextArea();
		textAreaContent.setFont(new Font("D2Coding", Font.PLAIN, 18));
		textAreaContent.setBounds(86, 104, 317, 173);
		contentPane.add(textAreaContent);
	}

	private void updateScheduleInfo() {
		String title = textFieldTitle.getText();
		Date ldate = Date.valueOf(date);
		if (title.equals("")) {
			JOptionPane.showMessageDialog(contentPane, "제목 입력", "경고", JOptionPane.ERROR_MESSAGE);
			return;
		}
		String content = textAreaContent.getText();
		String location = textFieldLocation.getText();

		Schedule schedule = new Schedule(title, ldate, content, null, location);

		dao.update(schedule);

//		JOptionPane.showMessageDialog(contentPane, "업데이트 완료");
		dispose();

	}
}
