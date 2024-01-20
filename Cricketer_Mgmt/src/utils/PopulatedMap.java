package utils;

import java.util.HashMap;

import com.core.classes.Cricketer;
import com.core.classes.StarRating;

public class PopulatedMap {
	public static HashMap<String, Cricketer> populatedlist() {
		HashMap<String, Cricketer> cList = new HashMap<String, Cricketer>();
		//"Enter name\n age\n email_id\n Phone number\n rating\n runs\n matches\n "
		cList.put("virat@gmail.com", new Cricketer("virat", 34, "virat@gmail.com", "9637126827",StarRating.FIRST));
		cList.put("sachin@gmail.com", new Cricketer("sachin", 40, "sachin@gmail.com", "9837126827",StarRating.THIRD ));
		cList.put("rohit@gmail.com", new Cricketer("rohit", 33, "rohit@gmail.com", "9137126827", StarRating.FIFTH));
		cList.put("surya@gmail.com", new Cricketer("surya", 32, "surya@gmail.com", "9537126827",StarRating.FOURTH));
		cList.put("jos@gmail.com", new Cricketer("jos", 31, "jos@gmail.com", "9937126827", StarRating.SECOND));
		
		return cList;
	}
}
