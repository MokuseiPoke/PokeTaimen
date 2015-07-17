public class EffectRelation {

	public enum Effect {
		HYPER,//*4.0
		SUPER,//*2.0
		NORMAL,//*1.0
		NOTVERY,//*0.5
		MINIMUM,//*0.25
		NOT,//*0
	}
    private Effect effect;
    private Pokemon attackPokemon;
    private Pokemon defensePokemon;
    
	public EffectRelation(Pokemon attackPokemon,
			Pokemon defensePokemon , Effect effect) {
		super();
		this.effect = effect;
		this.attackPokemon = attackPokemon;
		this.defensePokemon = defensePokemon;
	}
	
    
	public Effect getEffect() {
		return effect;
	}
	public void setEffect(Effect effect) {
		this.effect = effect;
	}
	public Pokemon getAttackPokemon() {
		return attackPokemon;
	}
	public void setAttackPokemon(Pokemon attackPokemon) {
		this.attackPokemon = attackPokemon;
	}
	public Pokemon getDefensePokemon() {
		return defensePokemon;
	}
	public void setDefensePokemon(Pokemon defensePokemon) {
		this.defensePokemon = defensePokemon;
	}

}
