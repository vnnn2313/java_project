package omok;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class ViewMap extends JPanel {
	JPanel ViewMap;
	private GameMap gm;
	private PlayMethod pm;
	private final int STONE_SIZE = 28; // 돌 사이즈

	public ViewMap(GameMap map, PlayMethod pm) {
		setBackground(new Color(206, 167, 61));
		gm = map;
		setLayout(null);
		this.pm = pm;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		board(g);
		drawStone(g);
	}

	private void drawStone(Graphics g) {
		for (int b = 0; b < gm.getMap(); b++) {
			for (int a = 0; a < gm.getMap(); a++) {
				if (pm.getMap()[b][a] == 1)
					drawBlack(g, a, b);
				else if (pm.getMap()[b][a] == 2)
					drawWhite(g, a, b);
			}
		}
	}

	private void board(Graphics g) {
		for (int i = 1; i <= gm.getMap(); i++) {
			g.drawLine(gm.getCel(), i * gm.getCel(), gm.getCel() * gm.getMap(), i * gm.getCel());
			g.drawLine(i * gm.getCel(), gm.getCel(), i * gm.getCel(), gm.getCel() * gm.getMap());
		}
	}

	public void drawBlack(Graphics g, int a, int b) {
		g.setColor(Color.BLACK);
		g.fillOval(a * gm.getCel() + 15, b * gm.getCel() - 15, STONE_SIZE, STONE_SIZE);
	}

	public void drawWhite(Graphics g, int a, int b) {
		g.setColor(Color.WHITE);
		g.fillOval(a * gm.getCel() + 15, b * gm.getCel() - 15, STONE_SIZE, STONE_SIZE);
	}

	}
