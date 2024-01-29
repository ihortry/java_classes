/**
 * @author Ihor Tryndey 3105023
 * @since 2023
 * @version 1.0
 */
package griffith;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * Generic class table that implements Iterator interface
 * @param <T> 
 * @param <L>
 */
public class Table<T, L> implements Iterator<Column<T, L>>{
	
	/*
	 * Creation of arrayList for columns in table
	 */
	private ArrayList<Column<T, L>> columnObj;
	/*
	 * current size of the array
	 */
	private int current = -1;
	
	/**
	 * Non-parametrised constructor for the Table inside which I create an instance of ArrayList
	 */
	public Table() {
		super();
		this.columnObj = new ArrayList<>();		 
	}
	
	/**
	 * The addColumn method which create new column or add values to existed one
	 * @param key generic data type 
	 * @param values generic LinkedHashSet data type 
	 */
	public void addColumn(T key, LinkedHashSet<L> values) {
	
		/*
		 * Variable which is used to check for existence column with given key
		 */
		boolean checker = false;
		
		/*
		 * A loop for checking column for existence
		 */
		for(int i=0; i<columnObj.size(); i++) {
			if(columnObj.get(i).getField().equals(key)) {
				checker = true;
				for(L value : values) {
					columnObj.get(i).addValue(value);
				}				 
			}
		}
		
		/*
		 * Creation of column if column with given key doesn't exist
		 */
		if(checker == false) {
			Column<T, L> newCl = new Column<>(key);
			
			for(L value : values) {
				newCl.addValue(value);
			}
					 			 
			 columnObj.add(newCl);
		}
	}

	
	/**
	 * The removeColumn method that remove column which select by given key
	 * @param key generic data type
	 */
	public void removeColumn(T key) {
		current = -1;
		
		while(hasNext()){
			Column<T, L> e = next();
			if(e.getField().equals(key)) {
				columnObj.remove(e);
				return;
			}
		}
	}
	
	/**
	 * The method getAllFields that returns an ArrayList with all fields
	 * @return allNames
	 */
	public ArrayList<T> getAllFields() {
		ArrayList<T> allNames = new ArrayList<>();
		
		for(int i=0; i<columnObj.size();i++) {
			allNames.add(columnObj.get(i).getField()); 
		} 
		
		return allNames;
	}
	
	/**
	 * The addValue method that add value to the column with the given key
	 * @param key
	 * @param value
	 */
	public void addValue(T key, L value) {
		for(int i=0; i<columnObj.size();i++) {
			if(columnObj.get(i).getField().equals(key)) {
				columnObj.get(i).addValue(value);
			}
		}
	}
	
	/**
	 * The removeValue method that remove value where key equals given key
	 * @param key
	 * @param value
	 */
	public void removeValue(T key, L value) {
		current = -1;
		
		while( hasNext()) {
			Column<T, L> e =  next();
			if(e.getField().equals(key)) {
				e.removeValue(value);
				return;
			}
		}
	}
	
	/**
	 * The getValues method that returns values where key equals given key
	 * @param key
	 * @return values
	 */
	public ArrayList<L> getValues(T key) {
		ArrayList<L> values = new ArrayList<>();
		
		current = -1;
		
		while(hasNext()) {
			Column<T, L> e = next();
			if(e.getField().equals(key)) {
				values.addAll((Collection<? extends L>)e.getValue()); 
			}					 
		}
		return values;
	}
	
	/**
	 * The getAllValues method that returns all values with their key
	 * @return allValues
	 */
	@SuppressWarnings("unchecked")
	public HashMap<T, L> getAllValues() {
		HashMap<T, L> allValues = new HashMap<>();
		
		current = -1;
		
		while(hasNext()) {
			Column<T, L> e = next();			  
			allValues.put(e.getField(), (L) e.getValue());
		}	
		return allValues;
	}

	/**
	 * The hasNext method is override method which checks is there is next element in the list 
	 */
	@Override
	public boolean hasNext() { 
		return current < columnObj.size() - 1;
	}

	/**
	 * The next method is override method which takes the next method 
	 */
	@Override
	public Column<T, L> next() {
		if(columnObj.size() == 0)
			return null;
		current++;
		return columnObj.get(current);
	}
}