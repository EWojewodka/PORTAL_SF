package pl.jemiol.util;

/**
 * alertToShow is a "title: reason" givi
 * 
 * @author jemiol
 *
 */
public enum AlertsResponse {
	/**
	 * 
	 */
	NO_PERSON("No person", "There is no such person", "en.NoPerson"); //TODO THIS HAVE TO BE TESTED 
	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private String title, reason, alertToShow;

	private AlertsResponse(String title, String reason, String alertToShow) {
		this.title = title;
		this.reason = reason;
		this.alertToShow = alertToShow;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getAlertToShow() {
		return this.title + ": " + this.reason;
	}

	public void setAlertToShow(String alertToShow) {
		this.alertToShow = alertToShow;
	}

}
