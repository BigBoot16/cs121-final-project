import java.util.*;

public class Game {

	public static void main(String[] args) {
		boolean keepGoing = true;
		Scanner input = new Scanner(System.in);
		while (keepGoing) {
			System.out.print("\n0) quit \n1) sample mystery \n\nPlease select 0-1: ");
			try {
				int selection = Integer.parseInt(input.nextLine());
				if (selection == 0) {
					keepGoing = false;
				} else if (selection == 1) {
					System.out.println("sample mystery");
					startGame();
				} else {
					System.out.println("Please enter a valid option.");
				}
			} catch (NumberFormatException e) {
				System.out.println("That's not a number, try again.");
			} catch (Exception e) {
				System.out.println("Something went wrong.");
			}
		}
	}

	public static void startGame() {
		boolean gameRunning = true;
		boolean culpritArrested = false;
		int falseArrests = 0;
		Character [] witnesses = new Character[6];
		prepareCharacters(witnesses);

		Scanner input = new Scanner(System.in);
		System.out.println("This is a simplified sample mystery, facts will be predetermined for convenience.");
		while (gameRunning) {
			System.out.print("\n0) quit \n1) review scene \n2) question witnesses \n3) arrest suspect \n\nPlease select 0-3: ");
			try {
				int selection = Integer.parseInt(input.nextLine());
				if (selection == 0) {
					System.out.println("quitting game");
					gameRunning = false;
				} else if (selection == 1) {
					System.out.println("review scene");
					System.out.println("Cindy was found in the library at 8 AM on Monday, wounds on back from blunt trauma.");
				} else if (selection == 2) {
					System.out.println("question witnesses");
					question(witnesses);
				} else if (selection == 3) {
					System.out.println("arrest suspect");
					int arrested = arrest(witnesses);
					if (arrested == 1) {
						System.out.println("You arrested the correct suspect! Congratulations!");
						gameRunning = false;
					} else if (arrested == 2) {
						System.out.println("Sorry, that witness was innocent.");
						falseArrests += 1;
					}
					if (falseArrests >= 3) {
						System.out.println("You have made too many false arrests, game over.");
						gameRunning = false;
					}
				} else {
					System.out.println("Please enter a valid option");
				}
			} catch (NumberFormatException e) {
				System.out.println("That's not a number, try again.");
			} catch (Exception e) {
				System.out.println("Something went wrong.");
			}
		}
	}

	public static void prepareCharacters(Character[] characters) {
		characters[0] = new Character("James", "bakery", false);
		characters[1] = new Character("Charles", "bakery", false);
		characters[2] = new Character("Vaugn", "library", true);
		characters[3] = new Character("Angela", "doctor", false);
		characters[4] = new Character("Gary", "library", false);
		characters[5] = new Character("Mina", "doctor", false);
	}

	public static void question(Character[] witnesses) {
		Scanner input = new Scanner(System.in);
		boolean keepGoing = true;
		
		while (keepGoing) {
			System.out.println("\nWho would you like to question?");
			System.out.print("0) James \n1) Charles \n2) Vaugn \n3) Angela \n4) Gary \n5) Mina \n6) Go back \n\nPlease enter 0-6: ");
			try {
				int selection = Integer.parseInt(input.nextLine());
				if (selection < 6) {
					Character witness = witnesses[selection];
					System.out.println("My name is " + witness.getName() + ". I was at the " + witness.getLocation() + ".");
				}
				if (selection == 0) {
					System.out.println("I was finishing up an order for Charles at the time.");
				} else if (selection == 1) {
                                        System.out.println("I had an order I was there to pick up that day.");
                                } else if (selection == 2) {
                                        System.out.println("I was simply there to return some books I had borrowed. I saw Gary leaving as I arrived.");
                                } else if (selection == 3) {
                                        System.out.println("I had my yearly checkup appointment scheduled, I saw Gary head inside the library when I got there.");
                                } else if (selection == 4) {
                                        System.out.println("I was picking up the next book in a series I'm reading, I saw Vaugn in the reference section talking with Cindy.");
                                } else if (selection == 5) {
                                        System.out.println("I work at the clinic across the street, and was checking in a patient for her appointment.");
                                } else if (selection == 6) {
					System.out.println("Ending questioning.");
					keepGoing = false;
				} else {
					System.out.println("Please enter a valid option");
				}
			} catch (NumberFormatException e) {
				System.out.println("That's not a number, try again.");
			} catch (Exception e) {
				System.out.println("Something went wrong.");
			}
		}
	}

	public static int arrest(Character[] witnesses) {
		Scanner input = new Scanner(System.in);
		boolean keepGoing = true;
		
		while (keepGoing) {
			System.out.println("\nWho would you like to arrest?");
			System.out.print("0) James \n1) Charles \n2) Vaugn \n3) Angela \n4) Gary \n5) Mina \n6) Go back \n\nPlease enter 0-6: ");
			try {
				int selection = Integer.parseInt(input.nextLine());
				if (selection >= 6) {
					return 0;
				}
				boolean guilty = witnesses[selection].getGuilt();
				if (guilty) {
					return 1;
				} else {
					return 2;
				}
			} catch (NumberFormatException e) {
				System.out.println("That's not a number, try again.");
			} catch (Exception e) {
				System.out.println("Something went wrong.");
			}
		}
		return 0;
	}
}
