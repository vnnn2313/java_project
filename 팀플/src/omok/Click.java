package omok;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

public class Click extends MouseAdapter {
	private ViewMap m;
	private GameMap map;
	private PlayMethod play;
	private GameMenu gameMenu;

	public Click(GameMap map, PlayMethod play, 
			ViewMap m, 
			GameMenu gameMenu) {
		this.map = map;
		this.gameMenu = gameMenu;
		this.play = play;
		this.m = m;
	}

	@Override
	public void mousePressed(MouseEvent me) {
		int a = (int) Math.round(me.getX() / (double) map.getCel()) - 1;
		int b = (int) Math.round(me.getY() / (double) map.getCel()) - 2;
		if (play.checkInput(b, a) == false) {
			return;
		}
		Stone s = new Stone(b, a, play.getplay_cun());
		play.inputStone(s);
		play.Player2(play.getplay_cun());
		
		m.repaint();
		if (play.finish(s) == true) {
			String ms = null;
			if (s.getColor() == 1) {
				ms = "흑 승리";
				
			} else if (s.getColor() == 2) {
				ms = "백 승리";
			}
			sW(ms);
			play.play_in();
			m.repaint();
			TimerTest.second = 11;
		}
	}

	public void sW(String a) {
		JOptionPane.showMessageDialog(gameMenu, a, "", JOptionPane.INFORMATION_MESSAGE);
	}
}