package pl.jemiol.other;

public enum Roles {
	/**
	 * 
	 */
	ROLE_USER(true, false, false),
	/**
	 * 
	 */
	ROLE_ADMIN(true, true, false),
	/**
	 * 
	 */
	ROLE_MODERATOR(true, true, true);
	/**
	 * 
	 */
	boolean publicPost, moderatorTools, administrationTools;

	/**
	 * 
	 * @param publicPost
	 * @param moderatorTools
	 * @param administrationTools
	 */
	private Roles(boolean publicPost, boolean moderatorTools, boolean administrationTools) {
		this.publicPost = publicPost;
		this.moderatorTools = moderatorTools;
		this.administrationTools = administrationTools;
	}

}
