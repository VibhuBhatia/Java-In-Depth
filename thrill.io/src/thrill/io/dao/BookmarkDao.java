package thrill.io.dao;

import thrill.io.DataStore;
import thrill.io.entities.Bookmark;
import thrill.io.entities.UserBookmark;

public class BookmarkDao {

	public Bookmark[][] getBookmarks() {
		return DataStore.getBookmarks();
	}

	public void saveUserBookmark(UserBookmark userBookmark) {

		DataStore.add(userBookmark);

	}
}