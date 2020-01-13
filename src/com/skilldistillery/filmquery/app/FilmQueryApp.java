package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) throws SQLException {

		FilmQueryApp app = new FilmQueryApp();
//    app.test();
		app.launch();
	}

	private void launch() {
		Scanner input = new Scanner(System.in);
		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {
		try {
			System.out.println("Film Query Menu");
			int choice = 0;
			boolean menureturn = true;

			while (menureturn) {
				menu();
				choice = input.nextInt();

				switch (choice) {
				case 1:
					filmById(input);
					break;
				case 2:
					filmByKeyword(input);

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

	}

	public void menu() {
		System.out.println("----------------------------------------");
		System.out.println("1: Look up film by ID ");
		System.out.println("2: Look up a film by a search keyword ");
		System.out.println("3: Exit ");
		System.out.println("----------------------------------------");

	}

	public void filmById(Scanner input) {
		int idfilm = 0;
		
			System.out.println("Please enter film ID: ");
			idfilm = input.nextInt();
			if (idfilm != 0) {
				Film film = db.findFilmById(idfilm);
				System.out.println(film);
				// System.out.println("message");
			}else {
				System.out.println("film not found");	
		} 
	}

	public void filmByKeyword(Scanner input) {
		String userKeyword;
		System.out.println("Please enter search keyword: ");
		userKeyword = input.next();
		List<Film> films = db.findFilmByKeyword(userKeyword);
		films.forEach(film -> {
			System.out.println("\nTitle: " + film.getTitle() + "\nRelease Year: " + film.getRelease_year()
					+ "\nActors: " + film.getActors() + "\nDescription: " + film.getDescription() + "\nRating:  "
					+ film.getRating() + "\nLanguage: " + film.getLanguage());
		});

		if (films.size() == 0) {
			System.out.println("film not found");
		} else {

		}
	}
}
