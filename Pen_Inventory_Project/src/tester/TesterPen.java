package tester;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import static utils.FunctionOfPenMap.*;
import com.app.core.Pen;

public class TesterPen {

	public static void main(String[] args) {
		/*
		 *  Add new Pen
2. Update stock of aPen
3.Set discount of 20% for all the pens which are not at all sold in last 3 months
4. Remove Pens which are never sold once listed in 9 months

		 */
		try(Scanner sc = new Scanner(System.in))
		{
			boolean exit =false;
			Map<Integer,Pen> penMap = new HashMap<>();
			while(!exit) {
			try {
				System.out.println("Enter the choice: \n1)Add New Pen \n2)Update stock of Pen "
						+ "\n3)Set Discount \n4)Remove Pens form listed  \n5)Display All stocks \n0)Exit");
				switch (sc.nextInt()) {
				case 1:
					addPen(penMap,sc);
					System.out.println("Pen Added successfully!!!");
					break;
				case 2:
					updatePenStocks(penMap,sc);
					System.out.println("Stocks Updated!!!!");
					break;
				case 3:
					setDiscount(penMap);
					System.out.println("Discount Applied!!!");
					break;
				case 4:
					removeAll(penMap);
					System.out.println("Removed successfully");
					break;
				case 5:
					displayAll(penMap);
					break;
				case 0:
					System.out.println("Exiting!!! thanksss");
					exit=true;
					break;
				default:
					break;
				}
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("Please try again!!!!");
				sc.nextLine();
			}
			}
		}
	}

}
