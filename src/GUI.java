import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Point;

import javafx.scene.control.ToggleButton;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.net.URL;

import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.sun.glass.events.MouseEvent;

public class GUI extends JFrame implements ActionListener, ItemListener{
	private JPanel contentPane;
	private JTextField[] text = new JTextField[12];
	private JLabel[] typelabel1 = new JLabel[12];
	private JLabel[] typelabel2 = new JLabel[12];
	public Point[] point = new Point[12];
	private JPanel mypanel = new JPanel();
	private JPanel enepanel = new JPanel();
	private JPanel drawpanel = new JPanel();
	private JButton button,button1;
	private JToggleButton[] checkbtn = new JToggleButton[12]; 
	private ArrowTable arrows = new ArrowTable();
	
	
	public GUI() {
		setTitle("PTS(PokemonTaimenSensyutu)");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				(getClass().getResource("icon/モンスターボール.png"))));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.setMaximumSize(new Dimension(300, 300));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// 自分側のパネルの生成
		mypanel.setBounds(10, 70, 200, 300);
		contentPane.add(mypanel);
		mypanel.setLayout(null);
		// 自分側のテキストとアイコンを生成
		for (int i = 0; i < 6; i++) {
			text[i] = new JTextField();
			text[i].setBounds(49, 20 + 47 * i, 111, 27);
			text[i].setHorizontalAlignment(SwingConstants.LEFT);
			text[i].setFont(new Font("MS UI Gothic", Font.PLAIN, 20));
			text[i].setColumns(6);
			mypanel.add(text[i]);
			text[i].addActionListener(this);

			checkbtn[i] = new JToggleButton("");
			checkbtn[i].addItemListener(this);
			checkbtn[i].setBounds(7, 20 + 47 * i, 40, 27);
			checkbtn[i].setContentAreaFilled(false);
			checkbtn[i].setBorderPainted(false);
			mypanel.add(checkbtn[i]);			

			typelabel1[i] = new JLabel("");
			typelabel1[i].setBounds(160, 20 + 47 * i, 30, 12);
			mypanel.add(typelabel1[i]);
			typelabel2[i] = new JLabel("");
			typelabel2[i].setBounds(160, 34 + 47 * i, 30, 12);
			mypanel.add(typelabel2[i]);

		}
		// 敵側のパネルの生成
		enepanel.setBounds(475, 70, 210, 300);
		contentPane.add(enepanel);
		enepanel.setLayout(null);
		// 敵側のテキストとアイコンの生成
		for (int i = 6; i < 12; i++) {
			text[i] = new JTextField();
			text[i].setBounds(49, 20 + 47 * (i - 6), 111, 27);
			text[i].setHorizontalAlignment(SwingConstants.LEFT);
			text[i].setFont(new Font("MS UI Gothic", Font.PLAIN, 20));
			text[i].setColumns(6);
			enepanel.add(text[i]);
			text[i].addActionListener(this);

			checkbtn[i] = new JToggleButton("");
			checkbtn[i].addItemListener(this);
			checkbtn[i].setBounds(160, 20 + 47 * (i-6), 40, 27);
			checkbtn[i].setContentAreaFilled(false);
			checkbtn[i].setBorderPainted(false);
			enepanel.add(checkbtn[i]);			

			typelabel1[i] = new JLabel("");
			typelabel1[i].setBounds(18, 20 + 47 * (i - 6), 30, 12);
			enepanel.add(typelabel1[i]);
			typelabel2[i] = new JLabel("");
			typelabel2[i].setBounds(18, 34 + 47 * (i - 6), 30, 12);
			enepanel.add(typelabel2[i]);
		}

		// 描画パネル

		drawpanel.setBounds(200, 70, 280, 300);
		contentPane.add(drawpanel);
		drawpanel.setLayout(null);

		// ボタン
		button = new JButton("Search!");
		button.setBorder(new LineBorder(new Color(0, 0, 0)));
		button.setBounds(245, 385, 200, 50);
		contentPane.add(button);
		button.addActionListener(this);

		JButton eneclear = new JButton("Clear");
		eneclear.setBorder(new LineBorder(new Color(0, 0, 0)));
		eneclear.setBounds(525, 385, 107, 30);
		contentPane.add(eneclear);
		eneclear.addActionListener(this);
		eneclear.setActionCommand("eneclear");

		JButton myclear = new JButton("Clear");
		myclear.setBorder(new LineBorder(new Color(0, 0, 0)));
		myclear.setBounds(61, 385, 107, 30);
		contentPane.add(myclear);
		myclear.addActionListener(this);
		myclear.setActionCommand("myclear");

	}

	// ボタンが押された時の処理
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		drawpanel.removeAll();
		repaint();
		for(int i=0;i<12;i++){
			checkbtn[i].setSelected(false);
		}
		
		// クリアボタンの処理
		if (cmd.equals("myclear")) {
			for (int i = 0; i < 6; i++) {
				text[i].setText("");
				checkbtn[i].setIcon(null);
				typelabel1[i].setIcon(null);
				typelabel2[i].setIcon(null);
				drawpanel.removeAll();
				repaint();
			}
		}
		if (cmd.equals("eneclear")) {
			for (int i = 6; i < 12; i++) {
				text[i].setText("");
				checkbtn[i].setIcon(null);
				typelabel1[i].setIcon(null);
				typelabel2[i].setIcon(null);
				drawpanel.removeAll();
				repaint();
			}

		} else {
			PokemonTable ptable = new PokemonTable();
			PokemonModel pmodel = new PokemonModel();
			PokeCon pcon = new PokeCon();
			String a;
			for (int i = 0; i < 12; i++) {
				a = text[i].getText();
				if (a.equals(""))
					continue;
				ptable.add(new Pokemon(i, i < 6, a));
			}

			// データベースからポケモンデータを取得
			pmodel.addInfomationPokemon(ptable);
			ptable.indexReset();

			while (ptable.hasNext()) {
				Pokemon tempPoke = ptable.next();
				String tempNo = tempPoke.getNo();
				Pokemon.Type[] tempType = tempPoke.getType();
				checkbtn[tempPoke.getId()].setIcon(new ImageIcon(getClass()
						.getResource("icon/" + tempNo + ".png")));
				typelabel1[tempPoke.getId()].setIcon(null);
				typelabel2[tempPoke.getId()].setIcon(null);
				if (tempType[0].toString() != "NONE") {
					typelabel1[tempPoke.getId()].setIcon(new ImageIcon(
							getClass().getResource(
									"icon/" + tempType[0] + ".png")));
				}
				if (tempType[1].toString() != "NONE") {
					typelabel2[tempPoke.getId()].setIcon(new ImageIcon(
							getClass().getResource("icon/" + tempType[1] + ".png")));
				}
				System.out.println(tempType[0] + "," + tempType[1]);
			}
			ptable.indexReset();

			EffectTable effecttable = new EffectTable();
			effecttable = pcon.pConE(ptable);
			//ArrowTable arrows = new ArrowTable();

			while (effecttable.hasNext()) {
				ArrowShape arrow = new ArrowShape();
				EffectRelation ef = effecttable.next();
				Pokemon ap = ef.getAttackPokemon();
				Pokemon dp = ef.getDefensePokemon();
				String eff = ef.getEffect().toString();
				switch (eff) {
				case "HYPER":
					CreateArrow(ap, dp, Color.ORANGE, arrow,arrows);
					break;

				case "SUPER":
					CreateArrow(ap, dp, Color.RED, arrow,arrows);
					break;

				case "NOTVERY":
					CreateArrow(ap, dp, Color.BLUE, arrow,arrows);
					break;
				case "MINIMUM":
					CreateArrow(ap, dp, Color.BLACK, arrow,arrows);
					break;

				case "NOT":
					CreateArrow(ap, dp, Color.GRAY, arrow,arrows);
					break;

				case "NORMAL":
					break;
				}
				System.out.println(ef);

			}
			
			//矢印を消す処理
//			while(arrows.hasNext()){
//				ArrowShape arrow = arrows.next();
//				if(arrow.getBttomId()==0){
//					System.out.println(arrow.getBttomId()+"を消去します");
//					arrow.setVisible(false);
//				}
//				
//			}
		}

	}
	
	public void CreateArrow(Pokemon ap,Pokemon dp,Color color,ArrowShape arrow,ArrowTable arrows){
		arrow = new ArrowShape(ap.getId(), dp.getId(), color);
		arrow.setBounds(0, 0, 280, 300);
		drawpanel.add(arrow);
		arrows.add(arrow);
		repaint();
	}
	public void itemStateChanged(ItemEvent e){
		ArrowShape arrow;
		arrows.indexReset();
		for(int i=0;i<12;i++){
			if(e.getItemSelectable() == checkbtn[i]){
				if(checkbtn[i].isSelected()){
//					System.out.println(i+"ON");
					while(arrows.hasNext()){
						arrow = arrows.next();
						if(arrow.getBttomId()==i||arrow.getHeadId()==i){
//							System.out.println(arrow.getBttomId()+"を消去します");
							arrow.setVisible(false);
							text[i].setEnabled(false);
							text[i].setDisabledTextColor(Color.WHITE);
						}	
					}
				}else{
//					System.out.println(i+"OFF");
					while(arrows.hasNext()){
						arrow = arrows.next();
						if(arrow.getBttomId()==i||arrow.getHeadId()==i){
//							System.out.println(arrow.getBttomId()+"をだします");
							arrow.setVisible(true);
							text[i].setEnabled(true);
						}	
					}
	
				}
			}
		}
			
	}

}