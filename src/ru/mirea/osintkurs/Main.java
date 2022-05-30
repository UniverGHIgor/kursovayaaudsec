package ru.mirea.osintkurs ;

import java.util.Scanner;

public class Main {
	static String  url      = "jdbc:mysql://mysql.j06318538.myjino.ru:3306/j06318538",
			namebase = "j06318538",
			pass     = "kursovaya",
			table    = "Popular";
	public static void menu() throws InterruptedException {
		System.out.println(" ______________________________________________________________________________________________________________________________________________________________________________________________________________");
		System.out.println("|An application for auditing the privacy of personal data.                                                                                                                                                     |");
		System.out.println("|Purpose: To create an application for processing free information located on the Internet in order to search for a leak of user's personal data.                                                              |");
		System.out.println("|The application was created to familiarize and audit the security of personal data, takes information from open sources and does not write the received data to third-party services for later use.           |");
		System.out.println("|                        !The authors are categorically against the use of this application for any illegal purposes and are not responsible for your actions!                                                 |");
		System.out.println("|______________________________________________________________________________________________________________________________________________________________________________________________________________|\n\n");
		Scanner scn = new Scanner(System.in);

		System.out.println("Choose an option:");
		System.out.print("""

				1) Search in your DB
				2) Search by using LeakCheck.io API (API-key required)
				3) Debug
				4) Exit
				""");
		int userinsert;
		userinsert = scn.nextInt();
		while((userinsert!=1) & (userinsert!=2) &(userinsert!=3)&(userinsert!=4)) {
			System.out.println("Error retype");
			userinsert=scn.nextInt();
		}

		switch (userinsert) {
			case 1 -> {
				SQLsearch C = new SQLsearch(url, namebase, pass, table);
				C.search();
				menu();
			}
			case 2 -> {
				URLReader E = new URLReader();
				E.start();
				E.join();
				menu();
			}
			case 3 -> {
				System.out.println("Choose debug option:");
				System.out.print("""

						1) Entering new data into your DB
						2) Removing data from your DB
												
						""");
				userinsert = scn.nextInt();
				while ((userinsert != 1) & (userinsert != 2)) {
					System.out.println("Error retype");
					userinsert = scn.nextInt();
				}
				switch (userinsert) {
					case 1 -> {
						SQLInsert B = new SQLInsert(url,namebase,pass,table);
						B.Startinsert();
						menu();
					}
					case 2 -> {
						SQLDelete D = new SQLDelete(url,namebase,pass,table);
						D.Startdelete();
						menu();
					}
				}
			}
			case 4 -> {return;}
			default -> {
				SQLsearch C = new SQLsearch(url, namebase, pass, table);
				C.search();
				menu();
			}
		}
	}
	public static void main(String[] args) {
		System.setProperty("java.net.preferIPv4Stack" , "true");
		try{
		menu();
		}catch (Exception e){e.printStackTrace();}
	}
}
