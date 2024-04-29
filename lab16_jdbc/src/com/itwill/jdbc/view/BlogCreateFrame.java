package com.itwill.jdbc.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.jdbc.controller.BlogDao;
import com.itwill.jdbc.model.Blog;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class BlogCreateFrame extends JFrame {
	
	public interface CreateNotify {
		void notifyCreateSuccess();
	}

	private static final long serialVersionUID = 1L;
	
	private BlogDao dao = BlogDao.getInstance();
	private CreateNotify app;
	
	private JPanel contentPane;
	
	private Component parent;
	
	private JTextField textTitle;
	private JLabel lblContent;
	private JScrollPane scrollPane;
	private JTextArea textContent;
	private JLabel lblTitle;
	private JTextField textWriter;
	private JLabel lblWriter;
	private JButton btnSave;
	private JButton btnCancel;
	/**
	 * Launch the application.
	 * @param blogMain 
	 * @param frame 
	 */
	public static void showBlogCreateFrame(Component parent, CreateNotify app){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BlogCreateFrame frame = new BlogCreateFrame(parent, app);
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
	private BlogCreateFrame(Component parent, CreateNotify app) {
		this.parent = parent;
		this.app = app;
		initialize();
	}
	public void initialize() {
		setTitle("새 블로그 작성");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		int x = 0;
		int y = 0;
		if(parent != null) {
			x = parent.getX(); // 부모 컴포넌트의 x 좌표
			y = parent.getY(); // 부모 컴포넌트의 y 좌표
		}
		setBounds(x, y, 446, 568);
		
		if (parent == null) {
			setLocationRelativeTo(null); // 화면 중앙에서 JFrame을 띄움.
		}
			
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitle = new JLabel("제목");
		lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitle.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblTitle.setBounds(12, 10, 406, 39);
		contentPane.add(lblTitle);
		
		textTitle = new JTextField();
		textTitle.setFont(new Font("D2Coding", Font.PLAIN, 20));
		textTitle.setBounds(12, 59, 406, 39);
		contentPane.add(textTitle);
		textTitle.setColumns(10);
		
		lblContent = new JLabel("내용");
		lblContent.setHorizontalAlignment(SwingConstants.LEFT);
		lblContent.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblContent.setBounds(12, 108, 406, 39);
		contentPane.add(lblContent);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 157, 406, 163);
		contentPane.add(scrollPane);
		
		textContent = new JTextArea();
		textContent.setFont(new Font("D2Coding", Font.PLAIN, 13));
		scrollPane.setViewportView(textContent);
		
		lblWriter = new JLabel("작성자");
		lblWriter.setHorizontalAlignment(SwingConstants.LEFT);
		lblWriter.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblWriter.setBounds(12, 330, 406, 39);
		contentPane.add(lblWriter);
		
		textWriter = new JTextField();
		textWriter.setFont(new Font("D2Coding", Font.PLAIN, 20));
		textWriter.setColumns(10);
		textWriter.setBounds(12, 379, 406, 39);
		contentPane.add(textWriter);
		
		btnSave = new JButton("작성완료");
		btnSave.addActionListener((e) -> createNewBlog());
		btnSave.setFont(new Font("D2Coding", Font.PLAIN, 17));
		btnSave.setBounds(37, 468, 122, 39);
		contentPane.add(btnSave);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener((e) -> dispose());
		btnCancel.setFont(new Font("D2Coding", Font.PLAIN, 17));
		btnCancel.setBounds(263, 468, 122, 39);
		contentPane.add(btnCancel);
	}

	private void createNewBlog() {
		// 제목, 내용, 작성자에 입력된 내용을 Blog 객체로 만들어서
		// DAO 메서드를 사용해서 DB 테이블에 insert.
		String title = textTitle.getText();
		String content = textContent.getText();
		String writer = textWriter.getText();
		if(title.equals("") || content.equals("") || writer.equals("")) {
			JOptionPane.showMessageDialog(BlogCreateFrame.this, 
					"제목, 내용, 작성자는 반드시 입력해야 합니다", 
					"경고",
					JOptionPane.WARNING_MESSAGE
					);
			return;
		}
		
		Blog blog = new Blog(0, title, content, writer, null, null);
		int result = dao.create(blog);
		if(result == 1) {
		// BlogMain 프레임에게 테이블 삽입 성공을 알려줌.
		app.notifyCreateSuccess();
		dispose(); // 현재 창 닫기
		} else {
			JOptionPane.showMessageDialog(BlogCreateFrame.this,"실패","어케했누",JOptionPane.QUESTION_MESSAGE);
		}
	}
}
