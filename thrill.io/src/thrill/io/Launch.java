package thrill.io;

import thrill.io.entities.Bookmark;
import thrill.io.entities.User;
import thrill.io.managers.BookmarkManager;
import thrill.io.managers.UserManager;

public class Launch {

	private static User[] users;
	private static Bookmark[][] bookmarks;

	private static void loadData() {

		System.out.println("1. Loading Data...");
		DataStore.loadData();

		users = UserManager.getInstance().getUsers();
		bookmarks = BookmarkManager.getInstance().getBookmarks();

		System.out.println("Printing data...");
		printUserData();
		printBookmarkData();
	}

	private static void printBookmarkData() {
		for (Bookmark[] bookmarklist : bookmarks) {
			for (Bookmark bookmark : bookmarklist) {
				System.out.println(bookmark);
			}

		}
	}

	private static void printUserData() {

		for (User user : users) {
			System.out.println(user);
		}

	}
	
	private static void start() {
		for (User user: users) {
			View.browse(user, bookmarks);
		}
		
	}



	public static void main(String[] args) {

		loadData();
		start();
	}

}
