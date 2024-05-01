package com.itwill.practiceProject.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

import com.itwill.practiceProject.controller.ScheduleDao;

import java.awt.FlowLayout;
import javax.swing.JList;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AppMain {

	private JFrame frame;
	private JPanel panelNorth;
	private JButton btnNext;
	private JLabel lblMonth;
	private JButton btnPrev;
	private JPanel panelSouth;
	private JPanel panelWest;
	private JPanel panelEast;

	private JPanel panelCenter;
	private JPanel daysPanel;
	private JPanel dayOfWeekPanel;

	private List<String> days = Arrays.asList("일", "월", "화", "수", "목", "금", "토");
	private LocalDate nowDate = LocalDate.now(); // 현재날짜
	private int selectedMonth = nowDate.getMonthValue(); // 월
	private int selectedYears = nowDate.getYear(); // 연
	private JLabel lblSelectedDay;
	private JList<String> list;
	private DefaultListModel<String> listModel = new DefaultListModel<>();

	ScheduleDao dao = ScheduleDao.getinstance();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain window = new AppMain();
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
	public AppMain() {

		initialize();

		calendarDefault(0);

		listSetUp(nowDate.getDayOfMonth() + "");

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 670, 570);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panelCenter = new JPanel();
		frame.getContentPane().add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new BorderLayout(0, 0));

		daysPanel = new JPanel();
		panelCenter.add(daysPanel, BorderLayout.CENTER);
		daysPanel.setLayout(new GridLayout(6, 7, 5, 5));

		panelNorth = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelNorth.getLayout();
		flowLayout_1.setHgap(20);
		frame.getContentPane().add(panelNorth, BorderLayout.NORTH);

		btnPrev = new JButton("prev");
		btnPrev.addActionListener((e) -> prevMonth());
		btnPrev.setFont(new Font("D2Coding", Font.PLAIN, 17));
		panelNorth.add(btnPrev);

		lblMonth = new JLabel("wwwwwwww");
		lblMonth.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonth.setFont(new Font("D2Coding", Font.PLAIN, 15));
		panelNorth.add(lblMonth);

		btnNext = new JButton("next");
		btnNext.addActionListener((e) -> nextMonth());
		btnNext.setFont(new Font("D2Coding", Font.PLAIN, 17));
		panelNorth.add(btnNext);

		panelSouth = new JPanel();
		frame.getContentPane().add(panelSouth, BorderLayout.SOUTH);

		panelWest = new JPanel();
		frame.getContentPane().add(panelWest, BorderLayout.WEST);

		panelEast = new JPanel();
		frame.getContentPane().add(panelEast, BorderLayout.EAST);
		panelEast.setLayout(new BorderLayout(0, 0));

		lblSelectedDay = new JLabel("");
		lblSelectedDay.setFont(new Font("D2Coding", Font.PLAIN, 14));
		lblSelectedDay.setPreferredSize(new Dimension(75, 18));
		panelEast.add(lblSelectedDay, BorderLayout.NORTH);

		list = new JList<>(listModel);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					handleDoubleClick(list, e);
				}
			}
		});
		list.setFont(new Font("D2Coding", Font.PLAIN, 15));
		panelEast.add(list, BorderLayout.CENTER);

	}

	private void handleDoubleClick(JList<String> list2, MouseEvent e) {
		int index = list.locationToIndex(e.getPoint());
		if (index != -1) {
			String selectedItem = list.getModel().getElementAt(index);
			System.out.println("더블클릭된 항목의 인덱스: " + index);
			System.out.println("더블클릭된 항목의 값: " + selectedItem);
			// 더블클릭된 리스트 아이템의 이름을 가지고 일정의 상세정보 띄우기
			ScheduleInfo.showScheduleInfo(this.frame,selectedItem,lblSelectedDay.getText());

		}
	}

	private void listSetUp(String btnText) {
		// 리스트 초기화
		DefaultListModel<String> newListModel = new DefaultListModel<>();
		list.setModel(newListModel);

		String formattedMonth = (selectedMonth < 10) ? "0" + selectedMonth : String.valueOf(selectedMonth);
		String formattedDay = (Integer.parseInt(btnText) < 10) ? "0" + btnText : btnText;

		String lbl = selectedYears + "/" + formattedMonth + "/" + formattedDay;

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate date = LocalDate.parse(lbl, formatter);

		lblSelectedDay.setText(lbl);
		// DB에서 일정 제목들 불러오기

		List<String> result = dao.readToDate(date);

		// 불러온거 리스트에 추가
		for (String s : result) {
			newListModel.addElement(s);
		}
	}

	private void nextMonth() {
		daysPanel = new JPanel();
		panelCenter.removeAll();
		panelCenter.add(daysPanel, BorderLayout.CENTER);
		daysPanel.setLayout(new GridLayout(6, 7, 5, 5));

		calendarDefault(1);
	}

	private void prevMonth() {
		// 리셋 테이블
		daysPanel = new JPanel();
		panelCenter.removeAll();
		panelCenter.add(daysPanel, BorderLayout.CENTER);
		daysPanel.setLayout(new GridLayout(6, 7, 5, 5));

		calendarDefault(-1);
	}

	private void calendarDefault(int select) {
		// 일 버튼 리스트
		List<JButton> daysList = new ArrayList<>();
		for (int i = 1; i <= 42; i++) {
			daysList.add(new JButton(i + ""));
		}

		if (select == -1) {
			if (selectedMonth == 1) {
				selectedYears -= 1;
				selectedMonth = 12;
			} else {
				selectedMonth -= 1;
			}
		}

		if (select == 1) {
			if (selectedMonth == 12) {
				selectedYears += 1;
				selectedMonth = 1;
			} else {
				selectedMonth += 1;
			}
		}

		// 총 일수
		int dayOfMonth = LocalDate.of(selectedYears, selectedMonth, 1).lengthOfMonth();

		// 연/월 세팅
		lblMonth.setText(selectedYears + "년" + " " + selectedMonth + "월");

		// 요일 세팅
		JPanel topPanel = new JPanel(); // 요일과 버튼이 있는 패널
		topPanel.setLayout(new BorderLayout()); // BorderLayout 사용

		// 요일 세팅
		dayOfWeekPanel = new JPanel();
		dayOfWeekPanel.setLayout(new GridLayout(1, 7)); // 요일을 표시하는 패널을 GridLayout으로 설정
		topPanel.add(dayOfWeekPanel, BorderLayout.NORTH); // 요일 패널을 topPanel의 NORTH에 추가

		for (String d : days) {
			JLabel label = new JLabel(d);
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setFont(new Font("D2Coding", Font.PLAIN, 20));
			dayOfWeekPanel.add(label);

		}

		// 버튼 세팅
		daysPanel = new JPanel();
		daysPanel.setLayout(new GridLayout(6, 7, 5, 5)); // 버튼 패널을 GridLayout으로 설정
		topPanel.add(daysPanel, BorderLayout.CENTER); // 버튼 패널을 topPanel의 CENTER에 추가
		panelCenter.add(topPanel, BorderLayout.CENTER); // topPanel을 panelCenter의 CENTER에 추가

		// 해당 월의 1일 요일
		LocalDate date = LocalDate.of(selectedYears, selectedMonth, 1);
		DayOfWeek dayOfWeek = date.getDayOfWeek();
		int dayOfWeekNumber = dayOfWeek.getValue();

		// 일수만큼만 채우기
		int x = 0;
		for (int i = 0; i < daysList.size(); i++) {
			int index = i;
			daysPanel.add(daysList.get(i));
			daysList.get(i).setBackground(new Color(255, 255, 255));
			daysList.get(i).setVerticalAlignment(SwingConstants.TOP);
			if (index % 7 == 0) {
				daysList.get(index).setForeground(Color.RED); // 일요일 빨간색
			} else if (index % 7 == 6) {
				daysList.get(index).setForeground(Color.BLUE);// 토요일 파란색
			}
			if (dayOfWeekNumber == 7) {
				dayOfWeekNumber = 0;
			}
			if (i < dayOfWeekNumber || x >= dayOfMonth) {
				daysList.get(i).setText("");
			} else {
				daysList.get(i).setText("" + (x + 1));
				daysList.get(i).addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						String btnText = daysList.get(index).getText();
						listSetUp(btnText);
					}
				});
				x++;
			}
		}
	}
}