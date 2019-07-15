import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class CountriesApp {

	public static void main(String[] args) throws IOException {
		// Variables
		Scanner in = new Scanner(System.in);
		// check for file
		Country country = new Country();
		Path path = Paths.get("countries.txt");
		if (Files.notExists(path)) {
			Files.createFile(path);
		}
		int choice = 0;
		do {
			// Display Menu
			System.out.println("Welcome to the Countries Maintenance Application!");
			// Validate user choice
			choice = Validator.getInt(in, "1- See the list of countries\n2- Add a country\n3- Exit");

			switch (choice) {
			case 1:
				List<Country>theFile = CountryFileUtil.readFile();	
				for (Country c : theFile) {
					System.out.println(c.getName() + " (population "+ c.getPopulation() + ")");
				}
				break;
			case 2:
				country.setName(Validator.getString(in, "Enter country:"));
				country.setPopulation(Validator.getInt(in, "Enter population:"));
				CountryFileUtil.appendToFile(country);
				System.out.println("This country has been saved!");
				break;
			case 3:
				break;
			}
		} while (choice != 3);
		
		System.out.println("Goodbye Now");
		//close scanner object
		in.close();
	}

}
