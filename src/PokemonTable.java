import java.util.ArrayList;
import java.util.List;

import com.sun.org.glassfish.external.statistics.annotations.Reset;

public class PokemonTable {
	private List<Pokemon> pokemons = new ArrayList<Pokemon>();
	private int index;
	private int size;

	private List<Pokemon> enemyPokemon = new ArrayList<Pokemon>();
	private List<Pokemon> myPokemon = new ArrayList<Pokemon>();
	private List<Pokemon[]> kumiawase = new ArrayList<Pokemon[]>();
	Pokemon[] adpoke = new Pokemon[2];// [0]に攻めポケ[1]に防御ポケ

	private int ePokeSize = 0;
	private int mPokeSize = 0;
	private int matchIndex = 0;
	private int matchSize = 0;

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

	public void matchIndexReset() {
		matchIndex = 0;
	}

	public Pokemon[] matchingListNext() {

		return kumiawase.get(matchIndex++);
	}

	public boolean matchListHasNext() {
		if (kumiawase.size() > matchIndex) {
			return true;
		} else {
			return false;
		}
	}

	public List<Pokemon[]> makeMatchingList() {

		int myIndex = 0;
		int eneIndex = 0;
		indexReset();
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
				adpoke[1] = enemyPokemon.get(eneIndex);
				kumiawase.add(adpoke.clone());
			}
		}

		eneIndex = 0;
		myIndex = 0;

		for (eneIndex = 0; eneIndex < enemyPokemon.size(); eneIndex++) {
			adpoke[1] = enemyPokemon.get(eneIndex);
			for (myIndex = 0; myIndex < myPokemon.size(); myIndex++) {
				adpoke[0] = myPokemon.get(myIndex);
				kumiawase.add(adpoke.clone());
			}
		}

		return kumiawase;
	}

	public EffectTable mCe() {
		matchIndexReset();
		EffectRelation kouka;
		EffectTable effecttable = new EffectTable();
		TypeChecker tc = new TypeChecker();
		matchIndexReset();
		while (matchListHasNext()) {
			// 組み合わせの効果をeffecttableリストへ追加していく
			kouka = tc.typecheck(kumiawase.get(matchIndex)[0],
					kumiawase.get(matchIndex)[1]);
			matchIndex++;
			effecttable.add(kouka);
		}
		return effecttable;
	}
}
