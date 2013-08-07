package com.srenner.billminderandroid2;

import org.codehaus.jackson.annotate.JsonProperty;
import org.joda.time.DateTime;
import org.joda.time.Days;

public class Bill {

	private int mID;
	
	// field names and naming convention needs to match the python objects
	
	@JsonProperty("default_amount")
	private double default_amount;
	@JsonProperty("default_reminder_days")
	private int default_reminder_days;
	@JsonProperty("name")
	private String name;
	@JsonProperty("last_payment_date")
	private String last_payment_date;
	@JsonProperty("demo_access")
	private boolean demo_access;
	
	@JsonProperty("default_amount")
	public double getDefaultAmount() {
		return default_amount;
	}
	
	@JsonProperty("default_reminder_days")
	public int getDefaultReminderDays() {
		return default_reminder_days;
	}
	
	@JsonProperty("name")
	public String getName() {
		return name;
	}
	
	@JsonProperty("last_payment_date")
	public String getLastPaymentDate() {
		return last_payment_date;
	}
	
	@JsonProperty("demo_access")
	public boolean getDemoAccess() {
		return demo_access;
	}
	
	public int getID() {
		return mID;
	}
	
	public void setID(int id) {
		mID = id;
	}
	
	public String getDaysAgoString() {
		String daysAgo = "";
		String dayText = "day";
		if(last_payment_date != null) {
			DateTime now = new DateTime();
			DateTime lastPayment = new DateTime(last_payment_date.substring(0, last_payment_date.lastIndexOf(" ")));
			int daysBetween = Days.daysBetween(lastPayment, now).getDays();
			if(daysBetween < 1 || daysBetween > 1) {
				dayText += "s";
			}
			daysAgo = String.valueOf(daysBetween);
		}
		if(daysAgo.length() == 0) {
			return "never paid";
		}
		else {
			return "paid " + daysAgo + " " + dayText + " ago";
		}		
	}
	
	public String toString() {
		String daysAgo = "";
		String dayText = "day";
		if(last_payment_date != null) {
			DateTime now = new DateTime();
			DateTime lastPayment = new DateTime(last_payment_date.substring(0, last_payment_date.lastIndexOf(" ")));
			int daysBetween = Days.daysBetween(lastPayment, now).getDays();
			if(daysBetween < 1 || daysBetween > 1) {
				dayText += "s";
			}
			daysAgo = String.valueOf(daysBetween);
		}
		if(daysAgo.length() == 0) {
			return name;
		}
		else {
			return name + " - " + daysAgo + " " + dayText + " ago";
		}
	}
}

