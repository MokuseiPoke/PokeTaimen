import java.util.ArrayList;
import java.util.List;


public class EffectTable {
	 private List<EffectRelation> effectrelation = new ArrayList<EffectRelation>();
	    private int index;
	    private int size;
	    
	    public EffectTable(){
	    	size = 0;
	    	index = 0;
	    }
	    
	    public void add(EffectRelation ef){
	    	effectrelation.add(ef);
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

	    public EffectRelation next(){
	        return effectrelation.get(index++);
	    }

}
