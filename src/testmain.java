import java.awt.EventQueue;


public class testmain {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Pokemon pika= new Pokemon(0, false, "pika");
		Pokemon jira =new Pokemon(1,true,"jira");
		
		EffectRelation kouka;
		EffectRelation.Effect bairitu;
		//pika.setType(Pokemon.Type.ELECTRIC);
		pika.setType(Pokemon.Type.GRASS,Pokemon.Type.NONE);
		jira.setType(Pokemon.Type.FIRE,Pokemon.Type.NONE);
		
		TypeChecker tc = new TypeChecker();
		kouka = tc.typecheck(pika, jira);
		
		bairitu = kouka.getEffect();
		
	
		
		switch(bairitu){
		case HYPER:System.out.println("hyper");break;
		case SUPER:System.out.println("super");break;
		case NORMAL:System.out.println("normal");break;
		case NOTVERY:System.out.println("notvery");break;
		case MINIMUM:System.out.println("minimum");break;
		case NOT:System.out.println("not");break;
		}
		
		
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
