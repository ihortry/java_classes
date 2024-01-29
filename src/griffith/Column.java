/**
 * @author Ihor Tryndey 3105023
 * @since 2023
 * @version 1.0
 */
package griffith;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;


/**
 * @author Ihor Tryndey
 * Generic class Column which represent column as HashMap
 * @param <T>
 * @param <L>
 */
public class Column<T, L> {
	
	 /**
	  * The declaration of the HashMap with two generic data type as key and LinkedHashSet with generic data type 
	  */
	 private HashMap<T, LinkedHashSet<L>> itemList;
	 /**
	  * The declaration of the key attribute which is generic data type
	  */
	 private T key;
	 
	 /**
	  * The Column parametrised constructor inside which I create HashMap and initialise it
	  * @param key
	  */
	 public Column(T key) {
		super();
		this.itemList = new HashMap<>();
		this.key = key;	 
		itemList.put(key, new LinkedHashSet<>());
		
	}

	/**
	 * The addValue method which add value to the LinkedHashSet which is inside the HashMap
	 * @param value
	 */
	public void addValue(L value) {
		itemList.get(key).add(value);		 
	 }
	 
	 /**
	  * The removeValue method that removes value from the LinkedHashSet
	  * @param value
	  */
	 public void removeValue(L value) {
		 itemList.get(key).remove(value);
	 }
	 
	 /**
	  * The getField method that returns key
	  * @return key generic data type
	  */
	 public T getField() {
		 return key;
	 }
	 
	 /**
	  * The getValue that returns ArrayList with generic data type
	  * @return
	  */
	 public ArrayList<L> getValue(){
		 ArrayList<L> returnSet = new ArrayList<>();
		 
		 Iterator<L> it = itemList.get(key).iterator();
		 while(it.hasNext()) {			 
			returnSet.add(it.next());
		 } 		 
		 return returnSet;
	 }	
}
