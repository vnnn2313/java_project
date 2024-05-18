//package omok;
//
//import java.awt.Color;
//import javax.swing.JLabel;
//
//class TimerBar extends JLabel implements Runnable {
//	int width = 450, height = 50;
//	int a = 10, b = 50;
//	Color color = new Color(255, 0, 0);
//
//	public TimerBar() {
//		setBackground(color);
//		setOpaque(true);
//		setBounds(a, b, width, height);
//	}
//
//	@Override
//	public void run() {
//		while (true) {
//			try {
//				Thread.sleep(1000 / (width/TimerTest.second));
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//
//			if (getWidth() > 0) {
//				 width -= 4; // 너비가 2씩 줄어듦
//				// System.out.println(width);
//				setBounds(a, b, width, height);
//			} else {
//				// System.out.println("종료");
//				break;
//			}
//		}
//	}
//}