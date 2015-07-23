import java.util.ArrayList;
import java.util.List;


public class ArrowTable {
	 private List<ArrowShape> arrowshape = new ArrayList<ArrowShape>();
	    private int index;
	    private int size;
	    
	    public ArrowTable(){
	    	size = 0;
	    	index = 0;
	    }
	    
	    public void add(ArrowShape ef){
	    	arrowshape.add(ef);
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

	    public ArrowShape next(){
	        return arrowshape.get(index++);
	    }

}
