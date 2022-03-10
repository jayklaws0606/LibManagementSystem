package sait.bms.managers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import sait.bms.problemdomain.Book;
import sait.bms.problemdomain.ChildrenBooks;
import sait.bms.problemdomain.CookBooks;
import sait.bms.problemdomain.PaperBacks;
import sait.bms.problemdomain.Periodicals;

public class Manager {
	private ArrayList<Book> BookList = new ArrayList<>();
	private static File file = new File("res/books.txt");
	public Manager() throws IOException {
		Scanner sc = new Scanner(System.in);
		Scanner scanOpt = new Scanner(System.in);
		loadBookList();
		try {
			int option = 0;

			while (option != 5) {
				System.out.println();
				System.out.println("Welcome in ABC Book Company: How May We Assist You?");
				System.out.println("1\tCheckout Book");
				System.out.println("2\tFind Books by Title");
				System.out.println("3\tDisplay Books by Type");
				System.out.println("4\tProduce Random Book List");
				System.out.println("5\tSave & Exit");
				System.out.println();
				System.out.print("Enter your option: ");
				option = scanOpt.nextInt();
				switch (option) {
				case 1:

					System.out.print("Enter ISBN of book: ");
					long searchISBN = sc.nextLong();
					for (int i = 0; i < BookList.size(); i++) {
						if (searchISBN == BookList.get(i).getISBN() && BookList.get(i).getAvailable() > 0) {
							System.out.println("The book  " + "\"" + BookList.get(i).getTitle() + "\""
									+ "  has been checked out.");
							System.out
									.println("It can be located using a call number: " + BookList.get(i).getCallNum());
							
							int newAvailable = BookList.get(i).getAvailable() - 1;
							BookList.get(i).setAvailable(newAvailable);
							
						}
						else if(searchISBN == BookList.get(i).getISBN() && BookList.get(i).getAvailable() == 0){
							System.out.println("Periodicals cannot be checked out");
						}
					}
					break;
				case 2:
					System.out.print("Enter title to search for: ");
					String searchTitle = sc.nextLine();
					System.out.println("Matching Books:");
					for (int t = 0; t < BookList.size(); t++) {
						if (BookList.get(t).getTitle().toLowerCase().contains(searchTitle)) {
							System.out.println(BookList.get(t).toString());
						} else {
							System.out.println("No matches");
							break;
						}
					}
					break;
				case 3:
					// search books by type
					String a;
					Scanner type = new Scanner(System.in);
					Scanner sc2 = new Scanner(System.in);
					System.out.println("#\tType");
					System.out.println("1\tChildren's Books");
					System.out.println("2\tCookbooks");
					System.out.println("3\tPaperbacks");
					System.out.println("4\tPeriodicals");
					System.out.println();
					System.out.print("Enter type of book: ");
					int bookType = type.nextInt();
					switch (bookType) {

					case 1:

						System.out.print("Enter format (P for Picture Books, E for Early Readers, C for Chapter Books): ");
						a = sc2.nextLine();
						System.out.println("Matching Books:");
						for (int x = 0; x < BookList.size(); x++) {
							if (BookList.get(x).getISBN() % 10 == 0
									|| BookList.get(x).getISBN() % 10 == 1) {
								if (((ChildrenBooks) BookList.get(x)).getFormat().toLowerCase().contains(a)) {
									System.out.println(((ChildrenBooks) BookList.get(x)).toString());
								}
							} 

						}
						break;
					case 2:

						System.out.print("Enter diet (D for Picture Books, V for Early Readers, G for Chapter Books, "
								+ "I for International, N for None): ");
						a = sc2.nextLine();
						System.out.println("Matching Books:");
						for (int x = 0; x < BookList.size(); x++) {

							if (BookList.get(x).getISBN() % 10  == 2
									|| BookList.get(x).getISBN() % 10  == 3) {
								if (((CookBooks) BookList.get(x)).getDiet().toLowerCase().contains(a)) {
									System.out.println(((CookBooks) BookList.get(x)).toString());
								}
							} 

						}
						break;
					case 3:

						System.out.print("Enter genre (A for Adventures, D for Drama, E for Education, C for Classic, "
								+ "F for Fantasy, S for Sience Fiction): ");
						a = sc2.nextLine();
						System.out.println("Matching Books:");
						for (int x = 0; x < BookList.size(); x++) {

							if (BookList.get(x).getISBN() % 10  == 4
									|| BookList.get(x).getISBN() % 10  == 7) {
								if (((PaperBacks) BookList.get(x)).getGenre().toLowerCase().contains(a)) {
									System.out.println(((PaperBacks) BookList.get(x)).toString());
								}
							} 

						}
						break;

					case 4:
						
						System.out.println("Enter a frequency (D for Daily, W for Weekly, ");
						System.out.print("M for Monthly, B for Biweekly, or Q for Quarterly): ");
						a = sc2.nextLine();
						System.out.println();
						System.out.println("Matching Books:");
						for (int x = 0; x < BookList.size(); x++) {
							if (BookList.get(x).getISBN() % 10  == 9
									|| BookList.get(x).getISBN() % 10  == 9) {
									
								if (((Periodicals) BookList.get(x)).getFrequency().toLowerCase().contains(a)) {
									System.out.print(((Periodicals) BookList.get(x)).toStringFormat());
									if (a.equalsIgnoreCase("D")) {
										System.out.println("Frequency:\tDaily\n");
									}
									else if (a.equalsIgnoreCase("W")) {
										System.out.println("Frequency:\tWeekly\n");
									}
									else if (a.equalsIgnoreCase("M")) {
										System.out.println("Frequency:\tMonthly\n");
									}
									else if (a.equalsIgnoreCase("B")) {
										System.out.println("Frequency:\tBi-Weekly\n");
									}
									else if (a.equalsIgnoreCase("Q")) {
										System.out.println("Frequency:\tQuaterly\n");
									}
								}
							}
						}
						break;
					default:
						System.out.println("not a valid input");
						break;
					}
					break;
				case 4:
					// generate random books depending on how many random books the user wants
					Scanner scanRand = new Scanner(System.in);

					Random randomBooks = new Random();

					System.out.print("Enter number of books: ");
					int numberOfBooks = scanRand.nextInt();
					System.out.println("Random Books:");

					for (int m = 0; m < numberOfBooks; m++) {
						Collections.shuffle(BookList);
						int index = randomBooks.nextInt(BookList.size());
						System.out.println(BookList.get(index).toString());
					}

					break;
				case 5:
					saveBooks();
					System.exit(0);
					break;
				default:
					System.out.println("invalid option");
				}
			}
		} catch (Exception e) {
			System.out.println("your input might be invalid, please try again");
		}
		scanOpt.close();
		sc.close();
	}

	private void loadBookList() throws FileNotFoundException {
		Scanner in = new Scanner(file);
		while (in.hasNext()) {
			String line = in.nextLine();
			String[] fields = line.split(";");
			char lastChar = fields[0].charAt(fields[0].length() - 1);
			switch (lastChar) {
			case '0':
			case '1':
				BookList.add(new ChildrenBooks(Long.parseLong(fields[0]), fields[1], Integer.parseInt(fields[2]),
						Integer.parseInt(fields[3]), fields[4], fields[5], fields[6]));
				break;
			case '2':
			case '3':
				BookList.add(new CookBooks(Long.parseLong(fields[0]), fields[1], Integer.parseInt(fields[2]),
						Integer.parseInt(fields[3]), fields[4], fields[5], fields[6]));
				break;
			case '4':
			case '7':
				BookList.add(new PaperBacks(Long.parseLong(fields[0]), fields[1], Integer.parseInt(fields[2]),
						Integer.parseInt(fields[3]), fields[4], fields[5], Integer.parseInt(fields[6]), fields[7]));
				break;
			case '8':
			case '9':
				BookList.add(new Periodicals(Long.parseLong(fields[0]), fields[1], Integer.parseInt(fields[2]),
						Integer.parseInt(fields[3]), fields[4], fields[5]));
				break;
			}
		}
		in.close();

	}

	public void saveBooks() throws FileNotFoundException {
		try {
			FileWriter myWriter = new FileWriter(file);

			for (int x = 0; x < BookList.size(); x++) {
				myWriter.write(BookList.get(x).rawString() + "\n");
			}

			myWriter.close();
		} catch (Exception e) {
			System.out.println("Error: Saving data");
		}
	}

}
