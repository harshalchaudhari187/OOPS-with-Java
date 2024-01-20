package tester;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import static utils.ValidationRules.*;
import com.core.classes.Cricketer;
import static utils.utitlity.*;
import static utils.PopulatedMap.populatedlist;
public class CricketerTest {

	public static void main(String[] args) {
	try(Scanner sc = new Scanner(System.in)){
		boolean exit = false;
		Map<String, Cricketer> mapCricketer = new HashMap<>(populatedlist());
		while(!exit) {
			try {
				System.out.println("Enter a choice: "
						+ "1.Enter minimum 5 Cricketers details\n"
						+ "2.Modify Cricketer's rating\n"
						+ "3.Search Cricketer by name\n"
						+ "4.Display all Cricketers added in collection\n"
						+ "5.Display All Cricketers in sorted form by rating\n"
						+ "0.Exit");
				switch (sc.nextInt()) {
				case 1:
					System.out.println("Enter name, age, email_id, phone,"
							+ " rating: first/second/third/fourth/fifth");
					Cricketer cr =  validateAll(sc.next(),sc.nextInt(),sc.next(),sc.next(),sc.next(),mapCricketer);
					mapCricketer.put(cr.getEmail_id(),cr);
					break;
				case 2:
					System.out.println("Enter the cricketer email: ");
					cr = validateEmail(sc.next(),mapCricketer);
					System.out.println("Enter the new Rating:");
					parseAndSetRating(sc.next(),cr);
					break;
				case 3:
					System.out.println("Enter the cricketer name");
					findByName(sc.next(),mapCricketer);
					break;
				case 4:
					displayAll(mapCricketer);
					break;
				case 5:
					sortByRatings(mapCricketer);
					break;
				case 0:
					exit=true;
					System.out.println("Thanks, Exiting!!!!");
					break;
				default:
					System.out.println("Invalid Choice");
					break;
				}
			}catch(Exception e){
				e.printStackTrace();
				sc.nextLine();
				System.out.println("Please Try Again!!!!");
				
			}
		}
	}

	}

}
