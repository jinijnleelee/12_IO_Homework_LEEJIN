package edu.kr.io.run;

import edu.kr.io.model.service.BookService;

public class BookRun {

	public static void main(String[] args) {
 BookService bs = new BookService();
 bs.displayMenu();
	}

}
