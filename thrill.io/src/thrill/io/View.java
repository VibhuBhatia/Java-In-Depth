package thrill.io;

import thrill.io.constants.KidFriendlyStatus;
import thrill.io.controllers.BookmarkController;
import thrill.io.entities.Bookmark;
import thrill.io.entities.User;

public class View {


	public static void browse(User user, Bookmark[][] bookmarks) {
		System.out.println("\n" + user.getEmail() + " is browsing");
		int bookmarkCount = 0;

		for (Bookmark[] bookmarklist : bookmarks) {
			for (Bookmark bookmark : bookmarklist) {

				if (bookmarkCount < DataStore.USER_BOOKMARK_LIMIT) {
					boolean isBookmarked = getBookmarkDecision(bookmark);
					if (isBookmarked) {
						bookmarkCount++;
						BookmarkController.getInstance().saveUserBookmark(user, bookmark);
						System.out.println("New Item Bookmarked -- " + bookmark);
					}
				}
				
				if (bookmark.isKidFriendlyEligible() && bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)) {
                    String kidFriendlyStatus = getKidFriendlyStatusDecision(bookmark);
                    if (!kidFriendlyStatus.equals(KidFriendlyStatus.UNKNOWN)) {
                    	bookmark.setKidFriendlyStatus(kidFriendlyStatus);
                    	System.out.println("Kid-friendly-status: "+ kidFriendlyStatus + "," +  bookmark);
                    }
                }
				
				
			}
		}
		
	}
	
    private static boolean getBookmarkDecision(Bookmark bookmark) {
        return Math.random() < 0.5 ? true : false;
    }
    
    private static String getKidFriendlyStatusDecision(Bookmark bookmark) {
        double decision = Math.random();
        return decision < 0.4 ? KidFriendlyStatus.APPROVED
                : (decision >= 0.4 && decision < 0.8) ? KidFriendlyStatus.REJECTED
                : KidFriendlyStatus.UNKNOWN;
    }

}