package com.thomascantie.insa;

public enum State {
	
	ALIVE("#"), DEAD(".");
	
	private String txt;
	
	State(String txt) {
		this.txt = txt;
	}
	
	@Override
	public String toString() {
		return this.txt;
	}
	
}
