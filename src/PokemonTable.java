import java.util.ArrayList;
import java.util.List;

public class PokemonTable {
	private List<Pokemon> pokemons = new ArrayList<Pokemon>();
	private int index, myIndex = 0, eneIndex = 0;
	private int size;

	private List<Pokemon> enemyPokemon = new ArrayList<Pokemon>();
	private List<Pokemon> myPokemon = new ArrayList<Pokemon>();
	private List<Pokemon[]> kumiawase = new ArrayList<Pokemon[]>();
	Pokemon[] adpoke = new Pokemon[2];// [0]に攻めポケ[1]に防御ポケ

	private int ePokeSize = 0;
	private int mPokeSize = 0;

	public PokemonTable() {
		size = 0;
		index = 0;
	}

	public void add(Pokemon pokemon) {
		pokemons.add(pokemon);
		size++;
	}

	public void indexReset() {
		index = 0;
	}

	public boolean hasNext() {
		if (size > index) {
			return true;
		} else {
			return false;
		}
	}

	public Pokemon next() {
		return pokemons.get(index++);
	}

	public List<Pokemon[]> makeMatchingList() {

		while (hasNext()) {
			if (pokemons.get(index).isPlayer() == true) {// ポケモンのidがtrue(味方)なら
				myPokemon.add(next());
			} else {
				enemyPokemon.add(next());
			}
		}

		for (myIndex = 0; myIndex < myPokemon.size(); myIndex++) {
			adpoke[0] = myPokemon.get(myIndex);
			for (eneIndex = 0; eneIndex < enemyPokemon.size(); eneIndex++) {
				adpoke[1] = enemyPokemon.get(index);
				kumiawase.add(adpoke.clone());
			}
		}

		for (eneIndex = 0; eneIndex < enemyPokemon.size(); eneIndex++) {
			adpoke[1] = enemyPokemon.get(index);
			for (myIndex = 0; myIndex < myPokemon.size(); myIndex++) {
				adpoke[0] = myPokemon.get(myIndex);
				kumiawase.add(adpoke.clone());
			}
		}
		return kumiawase;
	}

}
