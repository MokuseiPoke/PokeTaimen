import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import javax.swing.border.LineBorder;


public class GUI extends JFrame implements ActionListener {
	ArrowShape line;
	private JPanel contentPane;
	private JTextField[] text=new JTextField[12];
	private JLabel[] label = new JLabel[12];
	public Point[] point = new Point[12];
	private JPanel mypanel = new JPanel();
	private JPanel enepanel = new JPanel();
	private JPanel drawpanel = new JPanel();
	
	public GUI() {
		setTitle("PBM(PokemonBestMatch)");
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\オブジェクト指向\\XYicon\\モンスターボールicon.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.setMaximumSize(new Dimension(300, 300));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//自分側のパネルの生成
		mypanel.setBounds(25, 70, 170, 300);
		contentPane.add(mypanel);
		mypanel.setLayout(null);
		//自分側のテキストとアイコンを生成
		for(int i=0;i<6;i++){
			text[i] = new JTextField();
			text[i].setBounds(49, 20+47*i, 111, 27);
			text[i].setHorizontalAlignment(SwingConstants.LEFT);
			text[i].setFont(new Font("MS UI Gothic", Font.PLAIN, 20));
			mypanel.add(text[i]);
			text[i].setColumns(7);
			label[i] = new JLabel("");
			label[i].setBounds(12,25+46*i,36,23);
			mypanel.add(label[i]);
//			point[i] = new Point(49,20+47*i);

		}
		//敵側のパネルの生成
		enepanel.setBounds(485, 70, 170, 300);
		contentPane.add(enepanel);
		enepanel.setLayout(null);
		//敵側のテキストとアイコンの生成
		for(int i=6;i<12;i++){
			text[i] = new JTextField();
			text[i].setBounds(49, 20+47*(i-6), 111, 27);
			text[i].setHorizontalAlignment(SwingConstants.LEFT);
			text[i].setFont(new Font("MS UI Gothic", Font.PLAIN, 20));
			enepanel.add(text[i]);
			text[i].setColumns(7);
			label[i] = new JLabel("");
			label[i].setBounds(12,25+46*(i-6),36,23);
			enepanel.add(label[i]);
//			point[i] = new Point(49,20+47*(i-6));
		}
		
		//描画パネル

		drawpanel.setBounds(200, 70, 280, 300);
		contentPane.add(drawpanel);
		drawpanel.setLayout(null);
		line = new ArrowShape();
		line.setBounds(0, 0, 280, 300);
		drawpanel.add(line);
		
		
		
		//ボタン
		JButton button = new JButton("Search!");
		button.setBorder(new LineBorder(new Color(0, 0, 0)));
		button.setBounds(245, 385, 200, 50);
		contentPane.add(button);
		button.addActionListener(this);
		
		
	}
	
	
	//ボタンが押された時の処理
	public void actionPerformed(ActionEvent e) {
		PokemonTable ptable = new PokemonTable();
		PokemonModel pmodel = new PokemonModel();
		String a;
		for(int i=0;i<6;i++){
			a = text[i].getText();
			//label[i].setIcon(new ImageIcon("F:\\オブジェクト指向\\XYicon\\"+a+".png"));
			label[i].setIcon(new ImageIcon(getClass().getResource("icon/"+a+".png")));
			//System.out.println(i+"…"+point[i]);
			Pokemon p = new Pokemon(i, true);	//ポケモンを作成
			p.setName(text[i].getText());
//			pmodel.searchName(p);
//			p.getType();
			ptable.add(p);
			
		}
		for(int i=6;i<12;i++){
			a=text[i].getText();
			label[i].setIcon(new ImageIcon(getClass().getResource("icon/"+a+".png")));
		//	System.out.println(i+"…"+point[i]);
			Pokemon p = new Pokemon(i-6, false);	//ポケモンを作成
			p.setName(text[i].getText());
			ptable.add(p);
		}

		
		
	}
}
