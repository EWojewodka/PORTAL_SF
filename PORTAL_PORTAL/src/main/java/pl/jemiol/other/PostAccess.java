package pl.jemiol.other;

public enum PostAccess {
	/**
	 * 
	 */
	HIDDEN("Hidden", "icon-eye-close", true, false, false, false),
	/**
	 * 
	 */
	PRIVATE("Private", "glyphicon-lock", true, true, false, false),
	/**
	 * 
	 */
	PUBLIC("Public", "glyphicon-user", true, true, true, false),
	/**
	 * 
	 */
	GLOBAL("Global", "glyphicon-globe", true, true, true, true);
	/**
	 * 
	 */
	private boolean author, byLink, friends, all;
	private String name, glyph;

	/**
	 * 
	 * @param name
	 * @param glyph
	 * @param author
	 * @param byLink
	 * @param friends
	 * @param all
	 */
	PostAccess(String name, String glyph, boolean author, boolean byLink, boolean friends, boolean all) {
		this.name = name;
		this.glyph = glyph;
		this.author = author;
		this.byLink = byLink;
		this.friends = friends;
		this.all = all;
	}

	public boolean isAuthor() {
		return author;
	}

	public void setAuthor(boolean author) {
		this.author = author;
	}

	public boolean isByLink() {
		return byLink;
	}

	public void setByLink(boolean byLink) {
		this.byLink = byLink;
	}

	public boolean isFriends() {
		return friends;
	}

	public void setFriends(boolean friends) {
		this.friends = friends;
	}

	public boolean isAll() {
		return all;
	}

	public void setAll(boolean all) {
		this.all = all;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGlyph() {
		return glyph;
	}

	public void setGlyph(String glyph) {
		this.glyph = glyph;
	}

}
