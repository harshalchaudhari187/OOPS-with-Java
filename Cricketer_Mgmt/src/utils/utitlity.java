package utils;

import java.util.Map;

import com.core.classes.Cricketer;

public class utitlity {
	public static void displayAll(Map<String,Cricketer> mapCricketer) {
		mapCricketer.values()
		.stream()
		.forEach(System.out::println);
	}
	public static void sortByRatings(Map<String, Cricketer> mapCricketer) {
		mapCricketer.values()
		.stream()
		.sorted((i1,i2)->i1.getRating().compareTo(i2.getRating()))
		.forEach(System.out::println);
	}
}
