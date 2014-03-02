/**
 * 
 */
package com.effectivejava.classinterface;

/**
 * Public class with exposed immutable fields - questionable
 * 
 * @author Kaibo
 * 
 */
public final class Time {
	private static final int HOURS_PER_DAY = 24;
	private static final int MINUTES_PER_HOUR = 60;
	public final int hour;
	public final int minute;

	public Time(int hour, int minute) {
		if (hour < 0 || hour >= HOURS_PER_DAY)
			throw new IllegalArgumentException("Hour: " + hour);
		if (minute < 0 || minute >= MINUTES_PER_HOUR)
			throw new IllegalArgumentException("Min: " + minute);
		this.hour = hour;
		this.minute = minute;
	}

	public static void main(String[] args) {
		Time t = new Time(1, 30);
		Time t2 = t;
		t = new Time(2, 0);
		System.out.println("t=" + t);
		System.out.println("t2=" + t2);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Time [hour=" + hour + ", minute=" + minute + "]";
	}
}