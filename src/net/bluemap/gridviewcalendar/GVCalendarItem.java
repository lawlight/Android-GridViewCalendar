package net.bluemap.gridviewcalendar;

import java.util.Calendar;

public class GVCalendarItem {
	//how to show the date
	private String dayString;
	//show something
	private String planString;
	//this day has plan
	private boolean hasMark;
	//this day is the same day of next month, or previous month
	private boolean isLastOrNextMonth;
	//this day is today
	private boolean isToday;
	//how to show the day of week
	private int dayOfWeek;
	//Calendar
	private Calendar calendar;
	
	public GVCalendarItem(){
		this.isToday = false;
		this.isLastOrNextMonth = false;
		this.hasMark = false;
		this.planString = "";
	}
	
	
	//setters and getters
	public Calendar getCalendar() {
		return calendar;
	}
	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}
	public String getDateString() {
		return dayString;
	}
	public void setDateString(String dateString) {
		this.dayString = dateString;
	}
	public int getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public boolean isHasPlan() {
		return hasMark;
	}
	public void setHasPlan(boolean hasPlan) {
		this.hasMark = hasPlan;
	}
	public boolean isLastOrNextMonth() {
		return isLastOrNextMonth;
	}
	public void setLastOrNextMonth(boolean isLastOrNextMonth) {
		this.isLastOrNextMonth = isLastOrNextMonth;
	}
	public boolean isToday() {
		return isToday;
	}
	public void setToday(boolean isToday) {
		this.isToday = isToday;
	}
	public String getPlanString() {
		return planString;
	}
	public void setPlanString(String planString) {
		this.planString = planString;
	}
	
}
