package thrill.io;

import thrill.io.controllers.BookmarkController;
import thrill.io.entities.Bookmark;
import thrill.io.entities.User;

public class View {

	public static void bookmark(User user, Bookmark[][] bookmarks) {
		System.out.println("\n" + user.getEmail() + " is bookmarking");
		for (int i = 0; i < DataStore.USER_BOOKMARK_LIMIT; i++) {
			int typeOffset = (int) (Math.random() * DataStore.BOOKMARK_TYPES_COUNT);
			int bookmarkOffset = (int) (Math.random() * DataStore.BOOMARK_COUNT_PER_TYPE);

			Bookmark bookmark = bookmarks[typeOffset][bookmarkOffset];
			BookmarkController.getInstance().saveUserBookmark(user, bookmark);
			System.out.println(bookmark);
		}

	}

}