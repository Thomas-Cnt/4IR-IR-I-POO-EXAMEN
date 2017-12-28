package com.thomascantie.insa;

import java.util.Arrays;

public class GameOfLifeParser {
	
	public static GameOfLife parse(String str) {
	
		String[] tab = str.split("\n");
		String[] dim = tab[0].split(" ");
		
		int width = Integer.parseInt(dim[0]);
		int height = Integer.parseInt(dim[1]);
		
		GameOfLife game = new GameOfLife(width, height);
		
		String[] data = Arrays.copyOfRange(tab, 1, tab.length);
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if ((data[i].charAt(j)+"").equals(State.ALIVE.toString()))
					game.setAlive(j, i);
			}
		}
		return game;
	}
	
}
