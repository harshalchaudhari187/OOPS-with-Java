package utils;

import java.util.Scanner;

import com.core.classes.Category;
import com.core.classes.Pet;

import custom_exception.AuthenticationException;

import static tester.PetStore.isAdmin;
public class Validation {
	
	public static void login(Scanner sc) throws AuthenticationException{
		System.out.println("Enter email and password:");
		String email = sc.next();
		String pass = sc.next();
		if(email.equals("admin") && pass.equals("admin"))
			 isAdmin = "admin" ;
		else if(email.equals("c1") && pass.equals("c1"))
			isAdmin = "customer";
		else {
			isAdmin = null;
			throw new AuthenticationException("Invalid Credentials, Login Failed!!!!");
		}	
	}
	public static Pet validatePet(int petId, String name, String category, int unitPrice, int stocks)throws IllegalArgumentException {	
		Category category2 = Category.valueOf(category.toUpperCase());
		return new Pet(petId, name, category2, unitPrice, stocks);
	}
}
