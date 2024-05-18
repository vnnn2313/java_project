package omok;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginView extends JFrame {

	// 배경
	JLabel backgroud = new JLabel(new ImageIcon
			("src/images/배경.jpg"));
	// 제목
	JLabel title1 = new JLabel("오목");
	JLabel title2 = new JLabel("게임");
	// 아이디입력창
	JTextField b_text = new JTextField("백돌아이디");
	JTextField h_text = new JTextField("흑돌아이디");
	// 버튼
	JButton b_bt = new JButton("랜덤");
	JButton h_bt = new JButton("랜덤");
	JButton bt3 = new JButton("게임시작");

	// 바둑이미지
	ImageIcon backdoll = new ImageIcon
			("src/images/white.png");
	ImageIcon heckdoll = new ImageIcon
			("src/images/black.png");
	JLabel jl_backdoll = new JLabel(backdoll);
	JLabel jl_heckdoll = new JLabel(heckdoll);

	static String b_inputText;
	static String h_inputText;

	static String DEFAULT_BACK_ID = "백돌아이디";
    static String DEFAULT_HECK_ID = "흑돌아이디";
    
	public LoginView() {
		setTitle("오목게임");
		setSize(500, 500);// 창 크기
		setLocationRelativeTo(null);// 화면 중앙에 띄위기
		setResizable(false);// 창 크기 변동X
		setLayout(null);// 배치순서

		// panel
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(500, 500);

		// 제목
		title1.setFont(new Font("맑은 고딕", Font.BOLD, 50));
		title1.setForeground(Color.white);
		title1.setBounds(150, 30, 200, 100);
		panel.add(title1);

		title2.setFont(new Font("맑은 고딕", Font.BOLD, 50));
		title2.setForeground(Color.black);
		title2.setBounds(250, 30, 200, 100);
		panel.add(title2);
		// 바둑이미지
		jl_backdoll.setBounds(25, 80, 225, 225);
		panel.add(jl_backdoll);

		jl_heckdoll.setBounds(250, 80, 225, 225);
		panel.add(jl_heckdoll);
		
		add(panel);
		
		// 백돌아이디창
		b_text.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		b_text.setForeground(Color.black);
		b_text.setBounds(90, 255, 90, 35);// 위치
		panel.add(b_text);
		
		// 흑돌아이디창
		h_text.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		h_text.setForeground(Color.white);// 텍스트 색
		h_text.setBackground(Color.black);// 창배경
		h_text.setBounds(315, 255, 90, 35);
		panel.add(h_text);
		
		// 백돌아이디 랜덤버튼
		b_bt.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		b_bt.setBounds(90, 300, 90, 40);
		b_bt.setBackground(Color.white);
		b_bt.setBorder(BorderFactory.createLineBorder(Color.white));// 버튼라운드
		panel.add(b_bt);
		
		// 흑돌아이디 랜덤버튼
		h_bt.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		h_bt.setBounds(315, 300, 90, 40);
		h_bt.setBackground(Color.black);
		h_bt.setForeground(Color.white);// 버튼안쪽 텍스트 색상
		h_bt.setBorder(BorderFactory.createLineBorder(Color.black));
		panel.add(h_bt);
		
		// 게임시작버튼
		bt3.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		bt3.setBounds(180, 360, 130, 40);
		bt3.setBackground(Color.white);
		bt3.setBorder(BorderFactory.createLineBorder(Color.black));
		panel.add(bt3);

		// 버튼 이벤트
		Random random = new Random();
		b_bt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] name1 = 
					{"다크나이트","소울마스터","아프로디테","아르테미스","나이지리아"
					,"룩셈부르크","리투아니아","말레이시아","몬테네그로","방글라데시"
					,"바베이도스","베네수엘라","디오니소스","아르메니아","아르헨티나"
					,"아이슬란드","카자흐스탄","타지키스탄","오케아노스","프로서피나"
					,"데모고르곤","스카치블루","다빈치코드","느타리버섯","피스타치오"};
				b_text.setText(name1[random.nextInt(25)]);
				b_inputText = b_text.getText();

				System.out.println(name1[random.nextInt(25)]);

			}
		});

		h_bt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] name2 = 
			{"둠슬레이어","아리아도스","헤라크로스","무한다이노","메가가디안"
			,"계란장조림","항공관제탑","잠자리매듭","연대깍쟁이","그레이브즈"
			,"모데카이저","블라디미르","자르반4세","카시오페아","트리스타나"
			,"트린다미어","하이머딩거","포르네우스","아스타로트","폴라우로스"
			,"데카라비아","장수하늘소","트라이앵글","비숑프리제","캘리포니아"};

				h_text.setText(name2[random.nextInt(25)]);
				h_inputText = h_text.getText();
				System.out.println(name2[random.nextInt(25)]);
			}
		});
		bt3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (b_text.getText().equals(DEFAULT_BACK_ID)) {
                    b_inputText = DEFAULT_BACK_ID;
                }
                if (h_text.getText().equals(DEFAULT_HECK_ID)) {
                    h_inputText = DEFAULT_HECK_ID;
                }
				new GameMenu();// 게임창
				setVisible(false);
			}
		});

		backgroud.setBounds(0, 0, 500, 500);
		panel.add(backgroud);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}