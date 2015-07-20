public class Pokemon {
	enum Type {
		BUG, // 虫
		DARK, // 悪
		DRAGON, // ドラゴン
		ELECTRIC, // 電気
		FIGHTING, // 格闘
		FIRE, // 炎
		FLYING, // 飛行
		GHOST, // ゴースト
		GRASS, // 草
		GROUND, // 地面
		ICE, // 氷
		NORMAL, // ノーマル
		ROCK, // 岩
		POISON, // 毒
		PSYCHIC, // エスパー
		STEEL, // 鋼
		WATER, // 水
		FAIRY, // フェアリー
		NONE,	//無し
	}

	private String name; // このポケモンの名前
	private String no; // このポケモンの図鑑No
	private Type type1; // このポケモンのタイプ１
	private Type type2; // このポケモンのタイプ２
	private int id; // このポケモンのGUI上の識別番号
	private boolean player; // このポケモンはどっちのプレイヤーが持っているか 
							// true=使用者のポケモン
							// false=対戦相手のポケモン

	public Pokemon(int id,boolean player,String name){
		this.id=id;
		this.player = player;
		this.name = name;
	}
	
	public Pokemon(int id,boolean player){
		this(id,player,null);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isPlayer() {
		return player;
	}

	public void setPlayer(boolean player) {
		this.player = player;
	}
	
	public boolean getPlayer(){
		return player;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}
	
	public void setType(Type type1,Type type2){
		this.type1 = type1;
		this.type2 = type2;
	}
	
	public void setType(Type type){
		this.type1 = type;
		this.type2 = Type.NONE;
	}
	
	public Type[] getType(){
		Type type[] = {type1,type2};
		return type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return name;
	}

}
