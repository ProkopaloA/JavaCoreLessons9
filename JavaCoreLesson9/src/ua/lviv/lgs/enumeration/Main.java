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
		System.out.println("��� ��������� �� ����� ���� ������ 0");
		System.out.println("��� ������� �� ����� � ����� � ����� ���� ������ 1");
		System.out.println("��� ������� �� ����� �� ����� ���� ���� ������� ��� ������ 2");
		System.out.println("��� ������� �� ����� �� ����� �� ����� ����� ������� ��� ������ 3");
		System.out.println("��� ������� �� ����� �� ����� �� ����� ����� ������� ��� ������ 4");
		System.out.println("��� ������� �� ����� �������� ���� ���� ������ 5");
		System.out.println("��� ������� �� ����� ��������� ���� ���� ������ 6");
		System.out.println("��� ������� �� ����� �� ����� �� ����� ����� ������� ��� ������ 7");
		System.out.println("��� ������� �� ����� �� ����� �� ����� ������� ������� ��� ������ 8");
		System.out.println("��� ������� �� ����� �� �������� � ������ ����� �� ����� ������� ��� ������ 9");
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
				System.out.println("������ �����");
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
				System.out.println("������ ���� ����");
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
							System.out.println("� ����� � ����� ���� ����� : " + m1);
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
				System.out.println("������ ������� ��� � �����");
				sc = new Scanner(System.in);
				int NumberOfDays1 = sc.nextInt();
				if (NumberOfDays1 == 28) {
					System.out.println("���� ����� �� ���� ����������");
				}
				for (Month m : masMonth) {
					if (m.getNumberOfDays() == NumberOfDays1) {
						System.out.println("������ � ��� � ����� : " + m);
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
				System.out.println("������ ������� ��� � �����");
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
							System.out.println("� ����� ����� ����� ��� " + m2);
						}
					}
				}

				if (flag == false) {
					String message = "There is no such month!";
				throw new WrongInputConsoleParametersException(message);}

				break;
			}
			case "4": {
				System.out.println("������ ������� ��� � �����");
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

							System.out.println("� ����� ����� ����� ��� " + m2);
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
				System.out.println("������ ���� ����");
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
						System.out.println("�������� " + masSeasons[i]);
					} else {
						System.out.println("�������� " + masSeasons[i + 1]);
					}
				}
				if (!flag) {
					String message = "There is no such seasons!";
					throw new WrongInputConsoleParametersException(message);
				}
				break;
			}
			case "6": {
				System.out.println("������ ���� ����");
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
						System.out.println("����� ��� ���� " + masSeasons[i]);
					} else {
						System.out.println("����� ��� ���� " + masSeasons[i + 1]);
					}
				}
				if (!flag){				
					String message = "There is no such seasons!";
					throw new WrongInputConsoleParametersException(message);
				}


				break;
			}
			case "7": {
				System.out.println("����� �� ����� ����� ������� ���");
				for (Month m : masMonth) {
					if (m.getNumberOfDays() % 2 == 0) {
						System.out.println(m);
					}
				}

				break;
			}
			case "8": {
				System.out.println("����� �� ����� ������� ������� ��� ");

				for (Month m : masMonth) {
					if (m.getNumberOfDays() % 2 != 0) {
						System.out.println(m);
					}
				}

				break;
			}
			case "9": {
				System.out.println("������ ����� ");
				String month0 = sc.next().toUpperCase();

				boolean flag = isMonthPresent(masMonth, month0);

				if (flag) {
					Month m3 = Month.valueOf(month0);
					if (m3.numberOfDays % 2 == 0) {
						System.out.println("��� �����: " + m3 + " �� ����� ������� ��� " + m3.getNumberOfDays());
					} else {
						System.out
								.println("��� �����: " + m3 + " �� �� ����� ������� ��� " + m3.getNumberOfDays());
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
				System.out.println("̳���� ����");
				flag = true;
			}
		}
		return flag;
	}
}
