package omok;

public class PlayMethod {
	private static final int MaxSize = 20;
	private int Map[][] = new int[MaxSize][MaxSize];
	private int Players = 2;
	private int play_cun = 1;

	public void play_in() {
		for (int i = 0; i < MaxSize; i++) {
			for (int j = 0; j < MaxSize; j++) {
				Map[i][j] = 0;
			}
		}
	}

	public void Player2(int p2_cun) {
		p2_cun++;
		if (Players < p2_cun) {
			play_cun = 1;
			TimerTest.second = 11;
		} else {
			play_cun = p2_cun;
			TimerTest.second = 11;
		}
	}

	public boolean finish(Stone s) {
		int nc = s.getColor();
		int su[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 1 }, { 1, -1 }, { -1, -1 }, { 1, 1 } };

		for (int i = 0; i < 8; i = i + 2) {
			int sc = 1;
			int cunA = s.getA();
			int cunB = s.getB();

			for (int j = 0; j < 5; j++) {
				cunA = cunA + su[i][0];
				cunB = cunB + su[i][1];
				if (cunA < 0 || cunA >= MaxSize || cunB < 0 || cunB >= MaxSize)
					break;
				if (nc != Map[cunA][cunB])
					break;
				sc++;
			}
			cunA = s.getA();
			cunB = s.getB();
			for (int j = 0; j < 5; j++) {
				cunA = cunA + su[i + 1][0];
				cunB = cunB + su[i + 1][1];
				if (cunA < 0 || cunA >= MaxSize || cunB < 0 || cunB >= MaxSize)
					break;
				if (nc != Map[cunA][cunB])
					break;
				sc++;
			}
			if (sc >= 5) {
				return true;
			}

		}
		return false;

	}

	public void inputStone(Stone s) {
		Map[s.getA()][s.getB()] = s.getColor();
	}

	public boolean checkInput(int a, int b) {
		if (Map[a][b] != 0 || a < 0 || a >= MaxSize || b < 0 || b >= MaxSize) {
			return false;
		}
		return true;
	}

	public int[][] getMap() {
		return Map;
	}

	public int getplay_cun() {
		return play_cun;
	}
}