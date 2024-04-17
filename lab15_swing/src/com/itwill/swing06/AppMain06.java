package com.itwill.swing06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain06 {

	private JFrame frame;
	private JRadioButton rbPrivate;
	private JRadioButton rbPackage;
	private JRadioButton rbProtected;
	private JRadioButton rbPublic;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JCheckBox cbAbstract;
	private JCheckBox cbStatic;
	private JCheckBox cbFinal;
	private JComboBox<String> comboBox;
	private JButton btnInfo;
	private JScrollPane scrollPane;
	private JTextArea textArea;

//	private JRadioButton selectRadioButton;
//	private ArrayList<JCheckBox> selectedChekBoxes= new ArrayList<>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain06 window = new AppMain06();
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
	public AppMain06() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 638, 493);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		rbPrivate = new JRadioButton("Private");
		rbPrivate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleRadioButtonClick(e);
			}
		});
		buttonGroup.add(rbPrivate);
		rbPrivate.setHorizontalAlignment(SwingConstants.LEFT);
		rbPrivate.setFont(new Font("D2Coding", Font.PLAIN, 16));
		rbPrivate.setBounds(8, 6, 111, 40);
		frame.getContentPane().add(rbPrivate);

		rbPackage = new JRadioButton("Package");
		rbPackage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleRadioButtonClick(e);
			}
		});
		rbPackage.setSelected(true);
		buttonGroup.add(rbPackage);
		rbPackage.setHorizontalAlignment(SwingConstants.LEFT);
		rbPackage.setFont(new Font("D2Coding", Font.PLAIN, 16));
		rbPackage.setBounds(123, 6, 111, 40);
		frame.getContentPane().add(rbPackage);

		rbProtected = new JRadioButton("Protected");
		rbProtected.addActionListener((e) -> handleRadioButtonClick(e));
		buttonGroup.add(rbProtected);
		rbProtected.setHorizontalAlignment(SwingConstants.LEFT);
		rbProtected.setFont(new Font("D2Coding", Font.PLAIN, 16));
		rbProtected.setBounds(238, 6, 111, 40);
		frame.getContentPane().add(rbProtected);

		rbPublic = new JRadioButton("Public");
		rbPublic.addActionListener(this::handleRadioButtonClick);
		// AppMain06.this::handleRadioButtonClick
		buttonGroup.add(rbPublic);
		rbPublic.setHorizontalAlignment(SwingConstants.LEFT);
		rbPublic.setFont(new Font("D2Coding", Font.PLAIN, 16));
		rbPublic.setBounds(353, 6, 111, 40);
		frame.getContentPane().add(rbPublic);

		cbAbstract = new JCheckBox("abstract");
		cbAbstract.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				handleCheckBoxClick(e);
			}
		});
		cbAbstract.setFont(new Font("D2Coding", Font.PLAIN, 13));
		cbAbstract.setBounds(8, 48, 141, 40);
		frame.getContentPane().add(cbAbstract);

		cbStatic = new JCheckBox("static");
		cbStatic.addActionListener((e) -> handleCheckBoxClick(e));
		cbStatic.setFont(new Font("D2Coding", Font.PLAIN, 13));
		cbStatic.setBounds(296, 48, 141, 40);
		frame.getContentPane().add(cbStatic);

		cbFinal = new JCheckBox("final");
		cbFinal.addActionListener(this::handleCheckBoxClick);
		cbFinal.setFont(new Font("D2Coding", Font.PLAIN, 13));
		cbFinal.setBounds(151, 48, 141, 40);
		frame.getContentPane().add(cbFinal);

		comboBox = new JComboBox<>(); // new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleComboBoxChange(e);
			}
		});
		final String[] emails = { "naver.com", "gmail.com", "kakao.com", "yahoo.com" };
		final DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(emails); // new String[] {"naver.com",
																						// "gmail.com", "kakao.com",
																						// "yahoo.com"};
		comboBox.setModel(model); // new DefaultComboBoxModel<String>(emails)
		comboBox.setFont(new Font("D2Coding", Font.BOLD, 18));
		comboBox.setBounds(8, 94, 429, 40);
		frame.getContentPane().add(comboBox);

		btnInfo = new JButton("확 인");
		btnInfo.addActionListener((e) -> handleButtonClick());
		btnInfo.setFont(new Font("D2Coding", Font.BOLD, 18));
		btnInfo.setBounds(461, 95, 111, 40);
		frame.getContentPane().add(btnInfo);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(8, 162, 564, 201);
		frame.getContentPane().add(scrollPane);

		textArea = new JTextArea();
		textArea.setFont(new Font("D2Coding", Font.PLAIN, 18));
		scrollPane.setViewportView(textArea);
	}

	private void handleButtonClick() {
		// JTextArea에 출력할 문자열들을 붙여 나갈(append) 문자열 버퍼
		StringBuffer buffer = new StringBuffer();

		// 어떤 라디오버튼이 선택 됐는 지
		if (rbPrivate.isSelected()) {
			buffer.append(rbPrivate.getText());
		} else if (rbPackage.isSelected()) {
			buffer.append(rbPackage.getText());
		} else if (rbProtected.isSelected()) {
			buffer.append(rbProtected.getText());
		} else {
			buffer.append(rbPublic.getText());
		}
		
		
		
		buffer.append(" 라디오 버튼 선택됨.\n");
		// 어떤 체크박스(들)이 선택 됐는 지
		if (cbAbstract.isSelected()) {
			buffer.append(cbAbstract.getText()).append(" ");
		}
		if (cbFinal.isSelected()) {
			buffer.append(cbFinal.getText()).append(" ");
		}
		if (cbStatic.isSelected()) {
			buffer.append(cbStatic.getText()).append(" ");
		}
		buffer.append("체크박스 선택됨.\n");
		// 콤보박스에서 선택된 아이템
		Object selectedItem = comboBox.getSelectedItem();
		buffer.append(selectedItem).append(" 콤보박스 아이템 선택됨.\n");
		
		// 문자열 버퍼의 내용을 JTextArea에 씀.
		textArea.setText(buffer.toString());
	}

	private void handleComboBoxChange(ActionEvent e) {
		// 이벤트가 발생한 컴포넌트(JComboBox) 찾기
		@SuppressWarnings("unchecked")
		JComboBox<String> cb = (JComboBox<String>) e.getSource();
		// 콤보박스에서 선택된 아이템 찾기
		int index = cb.getSelectedIndex(); // 콤보박스에서 선택된 아이템의 인덱스
		String item = (String) cb.getSelectedItem(); // 콤보박스에서 선택된 아이템

		// JTextArea에 정보 출력
		textArea.setText(index + ": " + item);

	}

	private void handleCheckBoxClick(ActionEvent e) {
		// 3개의 체크박스들 중에서 누가 클릭 됐는 지
		JCheckBox cb = (JCheckBox) e.getSource();
		String text = cb.getText();
		boolean selected = cb.isSelected();
		textArea.setText(text + ": " + selected);
	}

	private void handleRadioButtonClick(ActionEvent e) {
		// 4개의 라디오 버튼들 중에서누가 클릭 됐는 지 찾기:
		JRadioButton rb = (JRadioButton) e.getSource();
		String text = rb.getText(); // 이벤트가 발생한 라디오 버튼의 텍스트
		boolean selected = rb.isSelected(); // 이벤트가 발생한 라디오 버튼의 선택여부
		textArea.setText(text + ": " + selected);
	}
}
