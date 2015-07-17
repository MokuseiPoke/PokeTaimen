import java.io.*;
import java.util.Hashtable;
import java.util.StringTokenizer;

public class PokemonModel {
	
	Hashtable<String, Hashtable<String, String>> pokeHash = new Hashtable<String,Hashtable<String,String>>();
	
	public PokemonModel(){
		readCSV("poke.csv");
	}

    private void readCSV(String fileName) {  
        try {
            File csv = new File(fileName); // CSVデータファイル

            BufferedReader br = new BufferedReader(new FileReader(csv));

            // 最終行まで読み込む
            String line = "";
            //一行目(label部)
            String[] label = br.readLine().split(",");
            while ((line = br.readLine()) != null) {

              // 1行をデータの要素に分割
              StringTokenizer st = new StringTokenizer(line, ",");

              int i=0;
              Hashtable<String,String> aPoke = new Hashtable<String,String>();
              while (st.hasMoreTokens()) {
                // 1行の各要素をタブ区切りで表示
                //System.out.print(st.nextToken() + "\t");
            	  aPoke.put(label[i++], st.nextToken());
              }
              pokeHash.put(aPoke.get("name"), aPoke);
            }
            br.close();

          } catch (FileNotFoundException e) {
            // Fileオブジェクト生成時の例外捕捉
            e.printStackTrace();
          } catch (IOException e) {
            // BufferedReaderオブジェクトのクローズ時の例外捕捉
            e.printStackTrace();
          }
        }

	public Pokemon searchName(Pokemon pokemon){
		
		Hashtable<String,String> aPoke = pokeHash.get(pokemon.getName()); //aPokeに目的のポケモンを格納
		Pokemon.Type type1,type2;
		//タイプをデーターベースのひらがな表記からenum型へ
		String sType1 = aPoke.get("type1");
		
		type1=Pokemon.Type.NONE;
		type2=Pokemon.Type.NONE;

		if(sType1.equals("ノーマル")) type1=Pokemon.Type.NORMAL;
		if(sType1.equals("ほのお")) type1=Pokemon.Type.FIRE;
		if(sType1.equals("みず")) type1=Pokemon.Type.WATER;
		if(sType1.equals("くさ")) type1=Pokemon.Type.GRASS;
		if(sType1.equals("でんき")) type1=Pokemon.Type.ELECTRIC;
		if(sType1.equals("こおり")) type1=Pokemon.Type.ICE;
		if(sType1.equals("かくとう")) type1=Pokemon.Type.FIGHTING;
		if(sType1.equals("どく")) type1=Pokemon.Type.POISON;
		if(sType1.equals("じめん")) type1=Pokemon.Type.GROUND;
		if(sType1.equals("ひこう")) type1=Pokemon.Type.FLYING;
		if(sType1.equals("エスパー")) type1=Pokemon.Type.PSYCHIC;
		if(sType1.equals("むし")) type1=Pokemon.Type.BUG;
		if(sType1.equals("いわ")) type1=Pokemon.Type.ROCK;
		if(sType1.equals("ゴースト")) type1=Pokemon.Type.GHOST;
		if(sType1.equals("ドラゴン")) type1=Pokemon.Type.DRAGON;
		if(sType1.equals("あく")) type1=Pokemon.Type.DARK;
		if(sType1.equals("はがね")) type1=Pokemon.Type.STEEL;
		if(sType1.equals("フェアリー")) type1=Pokemon.Type.FAIRY;
		
		
		if(aPoke.containsKey("type2")){
			String sType2 = aPoke.get("type2");
			
			if(sType2.equals("ノーマル")) type2=Pokemon.Type.NORMAL;
			if(sType2.equals("ほのお")) type2=Pokemon.Type.FIRE;
			if(sType2.equals("みず")) type2=Pokemon.Type.WATER;
			if(sType2.equals("くさ")) type2=Pokemon.Type.GRASS;
			if(sType2.equals("でんき")) type2=Pokemon.Type.ELECTRIC;
			if(sType2.equals("こおり")) type2=Pokemon.Type.ICE;
			if(sType2.equals("かくとう")) type2=Pokemon.Type.FIGHTING;
			if(sType2.equals("どく")) type2=Pokemon.Type.POISON;
			if(sType2.equals("じめん")) type2=Pokemon.Type.GROUND;
			if(sType2.equals("ひこう")) type2=Pokemon.Type.FLYING;
			if(sType2.equals("エスパー")) type2=Pokemon.Type.PSYCHIC;
			if(sType2.equals("むし")) type2=Pokemon.Type.BUG;
			if(sType2.equals("いわ")) type2=Pokemon.Type.ROCK;
			if(sType2.equals("ゴースト")) type2=Pokemon.Type.GHOST;
			if(sType2.equals("ドラゴン")) type2=Pokemon.Type.DRAGON;
			if(sType2.equals("あく")) type2=Pokemon.Type.DARK;
			if(sType2.equals("はがね")) type2=Pokemon.Type.STEEL;
			if(sType2.equals("フェアリー")) type2=Pokemon.Type.FAIRY;
		}else{
			type2=Pokemon.Type.NONE;
		}
		
		pokemon.setType(type1,type2);
    	
        return null;
    }

}
