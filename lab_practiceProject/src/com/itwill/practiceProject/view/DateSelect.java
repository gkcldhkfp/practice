package com.itwill.practiceProject.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.time.LocalDate;
import java.time.YearMonth;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;

public class DateSelect extends JFrame {

	public interface NotifyDateSelect {
		public void notifyDateChange(LocalDate date);
	}

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<Integer> comboBoxMonth;
	private JComboBox<Integer> comboBoxYears;
	private JComboBox<Integer> comboBoxDays;
	
	private NotifyDateSelect app;
	Component parent;
	private int selectedYears = LocalDate.now().getYear();
	private int selectedMonth = LocalDate.now().getMonthValue();
	
	// 총 일수
//	int dayOfMonth = LocalDate.of(selectedYears, selectedMonth, 1).lengthOfMonth();
	/**
	 * Launch the application.
	 */
	public static void showDateSelect(NotifyDateSelect app, Component parent, int selectedYears, int selectedMonth) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DateSelect frame = new DateSelect(app, parent, selectedYears, selectedMonth);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private DateSelect(NotifyDateSelect app, Component parent, int selectedYears, int selectedMonth) {
		this.app = app;
		this.parent = parent;
		this.selectedYears = selectedYears;
		this.selectedMonth = selectedMonth;
		
		
		initialize();
		initializeComboBox();
	}

	public void initialize() {
		setTitle("날짜 변경");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 499, 215);
		setLocationRelativeTo(parent);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnSave = new JButton("확인");
		btnSave.addActionListener((e) -> dateSave());
		btnSave.setFont(new Font("D2Coding", Font.PLAIN, 14));
		btnSave.setBackground(new Color(255, 255, 255));
		btnSave.setBounds(115, 133, 74, 33);
		contentPane.add(btnSave);

		JButton btnCancel = new JButton("취소");
		btnCancel.addActionListener((e) -> dispose());
		btnCancel.setFont(new Font("D2Coding", Font.PLAIN, 14));
		btnCancel.setBackground(Color.WHITE);
		btnCancel.setBounds(300, 133, 74, 33);
		contentPane.add(btnCancel);

		comboBoxYears = new JComboBox<>();
		comboBoxYears.addActionListener(this::handleComboBoxChange);
		comboBoxYears.setEditable(true);
		comboBoxYears.setBounds(12, 46, 147, 23);
		contentPane.add(comboBoxYears);

		comboBoxMonth = new JComboBox<>();
		comboBoxMonth.addActionListener(this::handleComboBoxChange);
		comboBoxMonth.setEditable(true);
		comboBoxMonth.setBounds(187, 46, 113, 23);
		contentPane.add(comboBoxMonth);

		comboBoxDays = new JComboBox<>();
		comboBoxDays.setEditable(true);
		comboBoxDays.setBounds(340, 46, 113, 23);
		contentPane.add(comboBoxDays);

		JLabel lblNewLabel = new JLabel("년");
		lblNewLabel.setFont(new Font("D2Coding", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(155, 49, 34, 17);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("월");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("D2Coding", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(300, 49, 34, 17);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("일");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("D2Coding", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(449, 50, 34, 17);
		contentPane.add(lblNewLabel_2);
	}

	private void dateSave() {
		int selectedMonth = (int) comboBoxMonth.getSelectedItem();
		int selectedDay = (int) comboBoxDays.getSelectedItem();

		String formattedMonth = (selectedMonth < 10) ? "0" + selectedMonth : String.valueOf(selectedMonth);
		String formattedDay = (selectedDay < 10) ? "0" + selectedDay : String.valueOf(selectedDay);

		String selectedDate = (comboBoxYears.getSelectedItem() + "-" + formattedMonth + "-" + formattedDay);
		
		LocalDate localDate = LocalDate.parse(selectedDate);
		app.notifyDateChange(localDate);
		
		dispose();
		
	}

	private void handleComboBoxChange(ActionEvent e) {
		int year = 1;
		int month = 1;
		@SuppressWarnings("unchecked")
		JComboBox<Integer> combo = (JComboBox<Integer>) e.getSource();

		if (combo == comboBoxMonth) {
			year = (int) comboBoxYears.getSelectedItem();
			month = (int) combo.getSelectedItem();
		}

		if (combo == comboBoxYears) {
			Integer selectedYear = (Integer) combo.getSelectedItem();
			if (comboBoxMonth.getSelectedItem() != null) {
				year = selectedYear;
				month = (int) comboBoxMonth.getSelectedItem();
			}
		}

		YearMonth yearMonth = YearMonth.of(year, month);

		int daysInMonth = yearMonth.lengthOfMonth();

		comboBoxDays.removeAllItems();
		for (int i = 1; i <= daysInMonth; i++) {
			comboBoxDays.addItem(i);
		}

	}

	private void initializeComboBox() {
		int year = 0;
		int month = 0;

		for (int i = 1902; i <= 2100; i++) {
			comboBoxYears.addItem(i);
		}

		for (int i = 1; i <= 12; i++) {
			comboBoxMonth.addItem(i);
		}

		comboBoxYears.setSelectedItem(selectedYears);
		comboBoxMonth.setSelectedItem(selectedMonth);

		year = (int) comboBoxYears.getSelectedItem();
		month = (int) comboBoxMonth.getSelectedItem();
		YearMonth yearMonth = YearMonth.of(year, month);

		// 해당 월의 일수 계산
		int daysInMonth = yearMonth.lengthOfMonth();

		for (int i = 1; i <= daysInMonth; i++) {
			comboBoxDays.addItem(i);
		}
		comboBoxDays.setSelectedIndex(0);
	}

}
