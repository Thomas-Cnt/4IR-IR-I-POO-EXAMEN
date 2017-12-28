package com.thomascantie.insa;

public class GridUtilities {
	
	public static int getNbAlives(GameOfLife game, int x, int y) {
		int nb = 0;
		
		if (game.isAlive(x-1, y-1)) nb++;
		if (game.isAlive(x,   y-1)) nb++;
		if (game.isAlive(x+1, y-1)) nb++;
		
		if (game.isAlive(x-1, y+1)) nb++;
		if (game.isAlive( x,   y+1)) nb++;
		if (game.isAlive(x+1, y+1)) nb++;
		
		if (game.isAlive(x-1, y)) nb++;
		if (game.isAlive(x+1, y)) nb++;
		
		return nb;
	}
	
	
}
