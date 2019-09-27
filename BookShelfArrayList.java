package application;
import java.util.Scanner;
import  generics.ArrayList2;
import generics.ArrayList2;
public class BookShelfArrayList {

	ArrayList2<Book> list;
	final int capacity = 3;
	
	public BookShelfArrayList(){
	list = new ArrayList2<Book>();	
	
	for(int i=0; i<3; i++){
		addABook(i);
	}
	
	System.out.println();
	System.out.println("The books are");
	displayBooks();
	
	removeBook();
	System.out.println("After removal, books are: ");
	displayBooks();
  }
	public void addABook(int i){
		Book aBook = new Book();
		String title,author;
		int year;
		Scanner sc = new Scanner(System.in);
		if(i < capacity){
			System.out.println("Title: ");
			title = sc.nextLine();
			System.out.println("Author: ");
			author = sc.nextLine();
			System.out.println("Year: ");
			year = sc.nextInt();
			aBook =new Book(title, author, year);
			System.out.println("Enter position");
			int position = sc.nextInt();             //????????????????????????
			list.add(aBook, position);
		}
	}
	public void displayBooks(){
		System.out.println(list.toString());
	}
	
	public void removeBook() {
	Book aBook = list.remove(16);
	System.out.println(aBook.getTitle() + " has been deleted");
	}
		 
		public static void main(String[] args) {
		new BookShelfArrayList();
		} 
}
