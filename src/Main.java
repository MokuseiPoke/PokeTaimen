import java.awt.EventQueue;


public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		
		
		//GUI関連のrun
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		
		
		
	}

}
