package process;

import process.CyclicCounter;

/**
 * 
 * @author Tianxiao Liu
 *
 */

public class Chronometer {
	
	private CyclicCounter hour = new CyclicCounter(0, 59, 0);
	private CyclicCounter minute = new CyclicCounter(0, 59, 0);
	private CyclicCounter second = new CyclicCounter(0, 59, 0);

	public void increment() {
		second.increment();
		if (second.getValue() == 0) {
			minute.increment();
			if (minute.getValue() == 0) {
				hour.increment();
			}
		}

	}

	public void decrement() {
		second.decrement();
		if (second.getValue() == 59) {
			minute.decrement();
			if (minute.getValue() == 59) {
				hour.decrement();
			}
		}
	}

	public CyclicCounter getHour() {
		return hour;
	}

	public CyclicCounter getMinute() {
		return minute;
	}

	public CyclicCounter getSecond() {
		return second;
	}

	public String toString() {
		return hour.toString() + " : " + minute.toString() + " : " + second.toString();
	}

	public static String transform(int value) {
		String result = "";
		if (value < 10) {
			result = "0" + value;
		} else {
			result = String.valueOf(value);
		}
		return result;
	}

	public void init() {
		hour.setValue(0);
		minute.setValue(0);
		second.setValue(0);
	}
}