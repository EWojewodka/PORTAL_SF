package pl.jemiol.other;

public enum PostAccess {
	/**
	 * 
	 */
	HIDDEN(true, false, false, false),
	/**
	 * 
	 */
	PRIVATE(true, true, false, false),
	/**
	 * 
	 */
	PUBLIC(true, true, true, false),
	/**
	 * 
	 */
	GLOBAL(true, true, true, true);
	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private boolean author, byLink, friends, all;
	/**
	 *  Visible for:
	 * @param author
	 * @param byLink
	 * @param friends
	 * @param all
	 */
	private PostAccess(boolean author, boolean byLink, boolean friends, boolean all) {
		this.author = author;
		this.byLink = byLink;
		this.friends = friends;
		this.all = all;
	}
}
