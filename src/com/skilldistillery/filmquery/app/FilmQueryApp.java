package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {
  
  DatabaseAccessor db = new DatabaseAccessorObject();
  

  public static void main(String[] args) throws SQLException{
	  
    FilmQueryApp app = new FilmQueryApp();
//    app.test();
  app.launch();
  }

  private void test() throws SQLException {
    Film film = db.findFilmById(1);
    System.out.println(film);
  }

  private void launch() {
    Scanner input = new Scanner(System.in);
    startUserInterface(input);
    
    try {
		System.out.println("Film Query Menu");
		int choice;
		boolean menureturn = true;
		while (menureturn) {
			menu();
			choice = input.nextInt();

			switch (choice) {
			case 1:
				filmById(input);
				break;
			case 2:
				
				break;
			case 3:
				System.out.println(" Exiting.... Goodbye. ");
				menureturn = false;
				break;
			default:
				System.out.println("Please select a choice from menu (1-3)");
				break;

			}// switch
		} // while
	} // try
	catch (Exception e) {
		System.out.println("ERROR RESTART PROGRAM");

	}

  input.close();
}
    
  

  private void startUserInterface(Scanner input) {
    
  }
  
  public void menu() {
		System.out.println("----------------------------------------");
		System.out.println("1: Look up film by ID ");
		System.out.println("2: Look up a film by a search keyword ");
		System.out.println("3: Exit ");
		System.out.println("----------------------------------------");

	}
  
  public void filmById(Scanner input) {
	  int idfilm;
	  System.out.println("Please enter film ID: ");
	  idfilm = input.nextInt();
	  Film film = db.findFilmById(idfilm);
	  System.out.println(film);
  }
}
