package utils;

import java.util.Map;

import com.core.classes.Cricketer;
import com.core.classes.StarRating;

public class ValidationRules {
	public static Cricketer validateAll(String name, int age, String email_id, String phone, String rating, Map<String, Cricketer> mapCricketer)
			throws IllegalArgumentException, NumberFormatException, CustomCricketException {
		StarRating rate = StarRating.valueOf(rating.toUpperCase());
		if (phone.length() != 10)
			throw new CustomCricketException("Phone number is inValid,it should be of 10 digits");
		if (email_id.indexOf('@') == -1)
			throw new CustomCricketException("Email is inValid");
		if (age < 20 || age > 30)
			throw new CustomCricketException("Cricket age is not allowed");
		if(mapCricketer.containsKey(email_id))
			throw new CustomCricketException("Email id is already exist!!!");
		return new Cricketer(name, age, email_id, phone, rate);
	}

	public static Cricketer validateEmail(String email_id, Map<String, Cricketer> mapCricketer)
			throws CustomCricketException {
		if (email_id.indexOf('@') == -1)
			throw new CustomCricketException("Email is inValid");
		if (!mapCricketer.containsKey(email_id))
			throw new CustomCricketException("No email is exist with this email id");
		return mapCricketer.get(email_id);
	}
	public static void parseAndSetRating(String rating,Cricketer cr)throws IllegalArgumentException {
		cr.setRating(StarRating.valueOf(rating.toUpperCase()));
	}
	public static void findByName(String name,Map<String, Cricketer> mapCricketer) {
		mapCricketer.values()
		.stream()
		.filter(p->p.getName().equals(name))
		.forEach(System.out::println);
	}
}
