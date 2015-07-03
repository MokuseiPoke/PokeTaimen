import java.util.ArrayList;
import java.util.List;

public class PokemonTable {
    private List<Pokemon> pokemons = new ArrayList<Pokemon>();
    private int index;
    private int size;
    
    public PokemonTable(){
    	size = 0;
    	index = 0;
    }
    
    public void add(Pokemon pokemon){
    	pokemons.add(pokemon);
    	size++;
    }
    
    public void indexReset(){
    	index=0;
    }
    
    public boolean hasNext(){
    	if(size > index){
    		return true;
    	}else{
    		return false;
    	}
    }

    public Pokemon next(){
        return pokemons.get(index++);
    }

}
