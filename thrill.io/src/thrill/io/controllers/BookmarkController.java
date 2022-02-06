package thrill.io.controllers;

import thrill.io.entities.Bookmark;
import thrill.io.entities.User;
import thrill.io.managers.BookmarkManager;

public class BookmarkController {

	private static BookmarkController instance = new BookmarkController();

	private BookmarkController() {
	}

	public static BookmarkController getInstance() {
		return instance;
	}

	public void saveUserBookmark(User user, Bookmark bookmark) {
		BookmarkManager.getInstance().saveUserBookmark(user, bookmark);

	}

}
