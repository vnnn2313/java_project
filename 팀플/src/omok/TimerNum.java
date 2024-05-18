package omok;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

class TimerNum extends JLabel implements Runnable {
	int width = 150, height = 150;
	int a = 170, b = 140;

	public TimerNum() {
		setOpaque(true);
		setBounds(a, b, width, height);
		setForeground(Color.BLUE);
		setText(TimerTest.second + "");
		setFont(new Font("맑은고딕", Font.PLAIN, 100));
		setHorizontalAlignment(JLabel.CENTER);
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000); // 1초
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (TimerTest.second > 0) {
				TimerTest.second -= 1; // 1초씩 줄어듦
				setText(TimerTest.second + "");
			} else {
				// System.out.println("종료");
				break;
			}
		}
	}
}
