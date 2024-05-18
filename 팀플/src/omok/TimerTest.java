package omok;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TimerTest extends JFrame {
	private JPanel panel;
	private TimerNum timerNum;
	private Thread threadNum;
	public static int second;

	public TimerTest() {
		second = 10; // 초

		panel = new JPanel();
		panel.setLayout(null);
		

		timerNum = new TimerNum();
		threadNum = new Thread(timerNum);
		threadNum.start();
		panel.add(timerNum);

		add(panel);
		panel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		setTitle("타이머");
		setSize(500,500);
		setVisible(true);
		setResizable(false);
		setLocation(200,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
