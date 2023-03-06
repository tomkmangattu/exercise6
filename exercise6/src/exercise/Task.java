package exercise;

import java.util.Scanner;

import customexceptions.*;

public class Task {
	
	
	
	static Scanner scanner = new Scanner(System.in);
	static BrowserHistory browserHistory = new BrowserHistory();
	
	static void checkChoice(String input) throws InvalidURLException , NoHistoryFoundException, InvalidPositionException{
		int choice = Integer.parseInt(input);
		
		switch(choice) {
		case 1 : visit();
			break;
		case 2 : moveBack();
			break;
		case 3: moveForward();
			break;
		case 4: getUrl();
			break;
		case 5: display();
			break;
		default: System.out.print("Enter a number between 1 and 5 ");
			break;
		}
	}
	
	static void display() {
		browserHistory.displayHistory();
	}
	static void getUrl() throws InvalidPositionException {
		
		System.out.println("Enter the url number to get :");
		String input = scanner.nextLine();
		int index = Integer.parseInt(input);
		
		String url = browserHistory.getUrl(index);
		System.out.println(url);
		
	}
	
	static void moveForward() throws NoHistoryFoundException {
		System.out.println("Enter the number of urls you have to move forward: ");
		String input = scanner.nextLine();
		
		int stepsBack = Integer.parseInt(input);
		String historyUrl = browserHistory.moveForward(stepsBack);
		System.out.println(historyUrl);
	}
	
	static void moveBack() throws NoHistoryFoundException{
		System.out.println("Enter the number of urls you have to move back: ");
		String input = scanner.nextLine();
		
		int stepsBack = Integer.parseInt(input);
		String historyUrl = browserHistory.moveBack(stepsBack);
		System.out.println(historyUrl);
	}
	
	static void visit() throws InvalidURLException{
		System.out.println("Enter a url to visit :");
		String url = scanner.nextLine();
		 
		browserHistory.addHistory(url);
		
	}
	
	public static void main(String[] args) {
		
		String input = "";
		
		while(true) {
			try {
				System.out.println("\n--------------------");
				System.out.println("Actions \n1. vist \n2. back \n3. forward \n4. get \n5. display");
				System.out.println("\nEnter the action :");
				
				input = scanner.nextLine();
				if("exit".equalsIgnoreCase(input)) {
					break;
				}
				
				checkChoice(input);	
			}catch(InvalidURLException e) {
				System.out.println(e.message);
			}catch(NoHistoryFoundException e) {
				System.out.println(e.message);
			}catch(InvalidPositionException e) {
				System.out.println(e.message);
			}catch(NumberFormatException e) {
				System.out.println("Enter a number");
			}catch(IndexOutOfBoundsException e) {
				System.out.println("Array size less than the index specified");
			}
			catch(Exception e) {
				System.out.println("Sorry, some unexpected error occured, Try again");
			}
			
		}
	}
}
