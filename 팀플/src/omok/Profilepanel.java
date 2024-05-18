package omok;

import java.awt.Color;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Profilepanel extends JPanel {
	JLabel b_idname = new JLabel();
	JLabel h_idname = new JLabel();

	JLabel b_record = new JLabel();
	JLabel h_record = new JLabel();

	ImageIcon backdoll = new ImageIcon
			("src/images/white.png");
	ImageIcon heckdoll = new ImageIcon
			("src/images/black.png");
	JLabel jl_backdoll = new JLabel(backdoll);
	JLabel jl_heckdoll = new JLabel(heckdoll);

	public Profilepanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		//panel, BoxLayout.Y_AXIS(세로줄 배치)/X.AXIS(가로줄 배치)
		setBounds(630, 00, 155, 700);
		setBackground(new Color(100, 134, 011));
		
		//흑돌이미지
		add(Box.createVerticalStrut(60));
		//Box.createVerticalGlue(int height)세로공간 pix만큼 추가
		///Box.createHorizontalStrut(int width)세로공간
		jl_heckdoll.setSize(100, 100);
		jl_heckdoll.setAlignmentX(CENTER_ALIGNMENT);
		//부모 컨테이너에서 가로 방향으로 중앙에 정렬
		add(jl_heckdoll);
		
		//흑돌아이디
		h_idname.setText(LoginView.h_inputText);
		h_idname.setFont(new Font("맑은 고딕",Font.BOLD,18));
		h_idname.setForeground(Color.white);
		h_idname.setSize(100,20);
		h_idname.setAlignmentX(CENTER_ALIGNMENT);
		add(h_idname);

		//흑돌전적
		h_record.setText("3승 2패");
		h_record.setForeground(Color.white);
		h_record.setFont(new Font("맑은 고딕",Font.BOLD,18));
		h_record.setSize(100, 20);
		h_record.setAlignmentX(CENTER_ALIGNMENT);
		add(h_record);

		//백돌이미지
		add(Box.createVerticalStrut(180));
		jl_backdoll.setSize(100, 100);
		jl_backdoll.setAlignmentX(CENTER_ALIGNMENT);
		add(jl_backdoll);
		
		//백돌아이디
		b_idname.setText(LoginView.b_inputText);
		b_idname.setFont(new Font("맑은 고딕",Font.BOLD,18));
		b_idname.setForeground(Color.white);
		b_idname.setSize(100, 20);
		b_idname.setAlignmentX(CENTER_ALIGNMENT);
		add(b_idname);
		
		//백돌전적
		b_record.setText("2승 3패");
		b_record.setForeground(Color.white);
		b_record.setFont(new Font("맑은 고딕",Font.BOLD,18));
		b_record.setSize(100, 20);
		b_record.setAlignmentX(CENTER_ALIGNMENT);
		add(b_record);
	}
}
