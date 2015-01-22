package vn.elca.training.vowelpattern.utils;

public class Testcase {
	private String first, second;
	private boolean expectedValue;
	
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getSecond() {
		return second;
	}
	public void setSecond(String second) {
		this.second = second;
	}
	public boolean getExpectedValue() {
		return expectedValue;
	}
	public void setExpectedValue(boolean expectedValue) {
		this.expectedValue = expectedValue;
	}
	
	@Override
	public String toString() {
		return String.format("First: %s; Second: %s; Expect: %s", 
				first, second, expectedValue);
	}
}
