/**
 * @author Ihor Tryndey 3105023
 * @since 2023
 * @version 1.0
 */
package griffith;

import java.util.LinkedHashSet;
import java.util.List;

/**
 * @author Ihor Tryney
 * Class Test to make experiments with table
 */
public class Test {

	public static void main(String[] args) {
		
		/*
		 * Initialisation of tables 
		 */
		Table<String, String> t1 = new Table<>();
		Table<Integer, String> t2 = new Table<>();
		Table<String, Integer> t3 = new Table<>();
		 
		
		/*
		 * Creation of LinkedHashSets for tables values
		 */
		LinkedHashSet<String> values11 = new LinkedHashSet<>(List.of("ihor", "artem", "illa", "nazar", "rostislav"));
		LinkedHashSet<String> values12 = new LinkedHashSet<>(List.of("Ivan", "Kotigoroshko", "Pan", "Kotskiy"));
		LinkedHashSet<String> values13 = new LinkedHashSet<>(List.of("Roman", "Oleskey", "Pan", "katya"));
		
		LinkedHashSet<String> values21 = new LinkedHashSet<>(List.of("samsung", "apple", "lenovo", "hp"));
		LinkedHashSet<String> values22 = new LinkedHashSet<>(List.of("Iphone", "Galaxy", "lp3452", "G2314"));
		LinkedHashSet<String> values23 = new LinkedHashSet<>(List.of("Ipad", "airpods", "mac", "iMac"));
		
		LinkedHashSet<Integer> values31 = new LinkedHashSet<>(List.of(89, 45, 1234,435,563));
		LinkedHashSet<Integer> values32 = new LinkedHashSet<>(List.of(4, 8, 12, 56, 1));
		LinkedHashSet<Integer> values33 = new LinkedHashSet<>(List.of(14891234, 51234, 95678314,413435,134151263));
		
		
		/*
		 * Addition of columns
		 */
		t1.addColumn("It", values11);
		t1.addColumn("Business", values12);
		t1.addColumn("Mates", values13);
		
		t2.addColumn(18, values21);
		t2.addColumn(34, values22);
		t2.addColumn(90, values23);
		
		t3.addColumn("level", values31);
		t3.addColumn("exp", values32);
		t3.addColumn("gold", values33);
		
		
		System.out.println("First table\nBefore modifications:\n----------------------------------------\n" 
				+ t1.getAllValues()+ "\n" + t1.getAllFields());
	 
		/*
		 * Removing and addition value and column from first table
		 */
		t1.removeValue("It", "nazar");
		t1.removeColumn("Business");
		t1.addValue("Mates", "dima");
		System.out.println("Return of values with given key:\n"+ t1.getValues("It"));
		
		System.out.println("\nAfter modifications:\n" + t1.getAllValues() + "\n----------------------------------------");
		
		System.out.println("Second table\nBefore modifications:\n----------------------------------------\n" 
				+ t2.getAllValues()+ "\n" + t2.getAllFields()); 
		
		/*
		 * Removing and addition value and column from second table
		 */
		t2.removeValue(90, "Ipad");
		t2.removeColumn(34);
		t2.addValue(18, "kj79834321");
		System.out.println("Return of values with given key:\n"+ t2.getValues(18));
		
		System.out.println("\nAfter modifications:\n" + t2.getAllValues() + "\n----------------------------------------"); 
		
		System.out.println("Third table\nBefore modifications:\n----------------------------------------\n" 
				+ t3.getAllValues()+ "\n" + t3.getAllFields()); 
		
		/*
		 * Removing and addition value and column from third table
		 */
		t3.removeColumn("gold");
		t3.removeValue("level", 435);
		t3.addValue("exp", 13491);
		System.out.println("Return of values with given key:\n"+ t3.getValues("exp"));
		
		System.out.println("\nAfter modifications:\n" + t3.getAllValues() + "\n----------------------------------------"); 
	
	}

}
