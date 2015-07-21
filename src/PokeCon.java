
public class PokeCon{

	public EffectTable pConE (PokemonTable poketable){
		PokemonTable pt = new PokemonTable();
		pt = poketable;
		PokemonModel pm = new PokemonModel();
		pm.addInfomationPokemon(pt);
		
		
		
		pt.makeMatchingList();//matchList作成
		
		return pt.mCe();
		
	}
	
}
