package ua.lviv.lgs.enumeration;

import java.util.Scanner;

/**
 * @author Alla
 * @since Java 1.8
 * @exception WrongInputConsoleParametersException
 */
public class Main {
	/* displays program menu items on the console */
	static void menu() {
		System.out.println("ўоб перев≥рити чи м≥с€ць ≥снуЇ введ≥ть 0");
		System.out.println("ўоб вивести вс≥ м≥с€ц≥ з такою ж порою року введ≥ть 1");
		System.out.println("ўоб вивести вс≥ м≥с€ц≥ €к≥ мають таку саму к≥льк≥сть дн≥в введ≥ть 2");
		System.out.println("ўоб вивести на екран вс≥ м≥с€ц≥ €к≥ мають меншу к≥льк≥сть дн≥в введ≥ть 3");
		System.out.println("ўоб вивести на екран вс≥ м≥с€ц≥ €к≥ мають б≥льшу к≥льк≥сть дн≥в введ≥ть 4");
		System.out.println("ўоб вивести на екран наступну пору року введ≥ть 5");
		System.out.println("ўоб вивести на екран попередню пору року введ≥ть 6");
		System.out.println("ўоб вивести на екран вс≥ м≥с€ц≥ €к≥ мають парну к≥льк≥сть дн≥в введ≥ть 7");
		System.out.println("ўоб вивести на екран вс≥ м≥с€ц≥ €к≥ мають непарну к≥льк≥сть дн≥в введ≥ть 8");
		System.out.println("ўоб вивести на екран чи введений з консол≥ м≥с€ць маЇ парну к≥льк≥сть дн≥в введ≥ть 9");
	}

	public static void main(String[] args) throws WrongInputConsoleParametersException {
		Scanner sc = new Scanner(System.in);
		Seasons[] masSeasons = Seasons.values();
		Month[] masMonth = Month.values();
		/* creates an infinite loop that calls the menu method */
		while (true) {
			menu();
			switch (sc.next()) {
			case "0": {
				System.out.println("¬вед≥ть м≥с€ць");
				sc = new Scanner(System.in);
				String month = sc.next();

				boolean flag = isMonthPresent(masMonth, month);
				if (!flag) {
					String message = "There is no such month!";
					throw new WrongInputConsoleParametersException(message);
				}
				break;
			}
			case "1": {
				System.out.println("¬вед≥ть пору року");
				String season = sc.next();

				boolean flag = false;

				for (Month m : masMonth) {
					if (m.getSeasons().toString().equalsIgnoreCase(season)) {
						flag = true;
					}
				}
				if (flag) {
					for (Month m1 : masMonth) {
						if (m1.getSeasons().name().equalsIgnoreCase(season)) {
							System.out.println("« такою ж порою року м≥с€ц≥ : " + m1);
						}
					}
				}

				if (!flag) {
					String message = "There is no such seasons!";
				throw new WrongInputConsoleParametersException(message);
				}
				break;
			}
			case "2": {
				System.out.println("¬вед≥ть к≥льк≥сть дн≥в у м≥с€ц≥");
				sc = new Scanner(System.in);
				int NumberOfDays1 = sc.nextInt();
				if (NumberOfDays1 == 28) {
					System.out.println("Ћише Ћютий на таке спроможний");
				}
				for (Month m : masMonth) {
					if (m.getNumberOfDays() == NumberOfDays1) {
						System.out.println("—т≥льки ж дн≥в у м≥с€ц≥ : " + m);
					}
				}
				if (NumberOfDays1 > 31) {
					String message = "No month with so many days!";
					throw new WrongInputConsoleParametersException (message); 
				}
				if (NumberOfDays1 < 28) {
					String message = "No month with so many days!";
					throw new WrongInputConsoleParametersException (message);
				}
				break;
			}
			case "3": {
				System.out.println("¬вед≥ть к≥льк≥сть дн≥в у м≥с€ц≥");
				int numberOfDays2 = sc.nextInt();

				boolean flag = false;

				for (Month m : masMonth) {
					if (m.getNumberOfDays() == numberOfDays2) {
						flag = true;
					}
				}

				if (flag) {

					for (Month m2 : masMonth) {
						if (m2.getNumberOfDays() < numberOfDays2) {
							System.out.println("” цьомц м≥с€ц≥ менше дн≥в " + m2);
						}
					}
				}

				if (flag == false) {
					String message = "There is no such month!";
				throw new WrongInputConsoleParametersException(message);}

				break;
			}
			case "4": {
				System.out.println("¬вед≥ть к≥льк≥сть дн≥в у м≥с€ц≥");
				int numberOfDays3 = sc.nextInt();
				boolean flag = false;
				for (Month m : masMonth) {
					if (m.getNumberOfDays() == numberOfDays3) {
						flag = true;
					}
				}

				if (flag) {

					for (Month m2 : masMonth) {
						if (m2.getNumberOfDays() > numberOfDays3) {

							System.out.println("” цьомц м≥с€ц≥ б≥льше дн≥в " + m2);
						}
					}
				}

				if (!flag) {
					String message = "There is no such month!";
					throw new WrongInputConsoleParametersException(message);
				}
				break;
			}
			case "5": {
				System.out.println("¬вед≥ть пору року");
				String season1 = sc.next().toUpperCase();
				boolean flag = false;
				for (Seasons s : masSeasons) {
					if (s.name().equalsIgnoreCase(season1)) {
						flag = true;
					}
				}
				if (flag) {
					Seasons seasons2 = Seasons.valueOf(season1);
					int i = seasons2.ordinal();

					if (i == (masSeasons.length - 1)) {
						i = 0;
						System.out.println("Ќаступна " + masSeasons[i]);
					} else {
						System.out.println("Ќаступна " + masSeasons[i + 1]);
					}
				}
				if (!flag) {
					String message = "There is no such seasons!";
					throw new WrongInputConsoleParametersException(message);
				}
				break;
			}
			case "6": {
				System.out.println("¬вед≥ть пору року");
				String season1 = sc.next().toUpperCase();
				boolean flag = false;
				for (Seasons s : masSeasons) {
					if (s.name().equalsIgnoreCase(season1)) {
						flag = true;
					}
				}
				if (flag) {
					Seasons seasons2 = Seasons.valueOf(season1);
					int i = seasons2.ordinal();

					if (i == (masSeasons.length - 1)) {
						i = 0;
						System.out.println("ѕеред тим була " + masSeasons[i]);
					} else {
						System.out.println("ѕеред тим була " + masSeasons[i + 1]);
					}
				}
				if (!flag){				
					String message = "There is no such seasons!";
					throw new WrongInputConsoleParametersException(message);
				}


				break;
			}
			case "7": {
				System.out.println("м≥с€ц≥ €к≥ мають парну к≥льк≥сть дн≥в");
				for (Month m : masMonth) {
					if (m.getNumberOfDays() % 2 == 0) {
						System.out.println(m);
					}
				}

				break;
			}
			case "8": {
				System.out.println("м≥с€ц≥ €к≥ мають непарну к≥льк≥сть дн≥в ");

				for (Month m : masMonth) {
					if (m.getNumberOfDays() % 2 != 0) {
						System.out.println(m);
					}
				}

				break;
			}
			case "9": {
				System.out.println("¬вед≥ть м≥с€ць ");
				String month0 = sc.next().toUpperCase();

				boolean flag = isMonthPresent(masMonth, month0);

				if (flag) {
					Month m3 = Month.valueOf(month0);
					if (m3.numberOfDays % 2 == 0) {
						System.out.println("÷ей м≥с€ць: " + m3 + " маЇ парну к≥льк≥сть дн≥в " + m3.getNumberOfDays());
					} else {
						System.out
								.println("÷ей м≥с€ць: " + m3 + " маЇ не парну к≥льк≥сть дн≥в " + m3.getNumberOfDays());
					}
				}

				if (!flag) {
					String message = "There is no such seasons!";
					throw new WrongInputConsoleParametersException(message);
				}

				break;
			}
			}
		}
	}
	/* Checks if the month exists in array */

	private static boolean isMonthPresent(Month[] masMonth, String month) {
		boolean flag = false;
		for (Month m : masMonth) {
			if (m.name().equalsIgnoreCase(month)) {
				System.out.println("ћ≥с€ць ≥снуЇ");
				flag = true;
			}
		}
		return flag;
	}
}
