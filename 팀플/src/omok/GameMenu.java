package omok;

import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class GameMenu extends JFrame {
	private Container con;
	GameMap map = new GameMap();
	PlayMethod play = new PlayMethod();
	private int imageIndex = 0;
	private String[] cursorimages = { "src/images/흑돌.png","src/images/백돌.png" };

	public GameMenu() {
		setTitle("오목");
		Menu();
		setSize(800, 700);
		setLocationRelativeTo(null);
		setResizable(false);
		con = getContentPane();
		con.setLayout(null);
		ViewMap vm = new ViewMap(map, play);
		setContentPane(vm);
		Click c = new Click(map, play, vm, this);
		new TimerTest();
		addMouseListener(c);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// 프로필패널
		Profilepanel panel = new Profilepanel();
		add(panel);

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				imageIndex = (imageIndex + 1) % cursorimages.length;
				setCursorFromImage();
			}	
		});
		setCursorFromImage();
	}

	private void setCursorFromImage() {
		int currentPlayer = play.getplay_cun();
		String imagePath = cursorimages[currentPlayer - 1];
		Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor
				(new ImageIcon(imagePath).getImage(),
				new Point(0, 10), "");
		setCursor(cursor);
	}

	class Mouse implements ActionListener {
		JOptionPane jo = new JOptionPane();
		ViewMap vm = new ViewMap(map, play);

		@Override
		public void actionPerformed(ActionEvent e) {

			String gmb = e.getActionCommand();
			javax.swing.UIManager.put("OptionPane.messageFont", 
					new java.awt.Font("궁서", java.awt.Font.BOLD, 15));
			switch (gmb) {

			case "일시정지":
				jo.showMessageDialog(con, "계속하시겠습니까?");
				break;
			case "다시하기":
				jo.showMessageDialog(con, "처음부터 다시하시겠습니까?");
				if (gmb.equals("다시하기")) {
					JOptionPane.showMessageDialog(con, "처음부터 다시 시작 합니다.");
				}
				play.play_in();
				repaint();
				TimerTest.second = 11;
				break;
			case "게임종료":
				jo.showMessageDialog(con, "게임을 종료하시겠습니까?");
				setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				setVisible(true);
				System.exit(0);
				break;
			case "설명서":
				jo.showMessageDialog(con, "게임은 흑, 백 둘중 하나가 5개를 일렬로 정렬하면 이깁니다.");
				break;
			}
		}
	}

	public void Menu() {
		JMenuBar jb = new JMenuBar();

		JMenuItem[] ji = new JMenuItem[4];
		String[] me = { "일시정지", "다시하기", "게임종료", "설명서" };

		JMenu jm = new JMenu("게임메뉴");
		jm.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		Mouse listener = new Mouse();
		for (int i = 0; i < ji.length; i++) {
			ji[i] = new JMenuItem(me[i]);
			ji[i].addActionListener(listener);
			jm.add(ji[i]);
			ji[i].setFont(new Font("맑은 고딕", Font.BOLD, 15));
			jm.addSeparator();
		}
		jb.add(jm);
		setJMenuBar(jb);
	}
}
