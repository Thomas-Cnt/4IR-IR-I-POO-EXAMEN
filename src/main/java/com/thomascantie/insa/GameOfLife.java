package com.thomascantie.insa;
		
import java.util.Arrays;

public class GameOfLife extends Game {
	
	public GameOfLife(int width, int height) {
		super(width, height);
	}
	
	@Override
	public GameOfLife nextStep() {
		GameOfLife game = new GameOfLife(this.width, this.height);
		
		for (int i = 0; i <this.height; i++) {
			for (int j = 0; j < this.width; j++) {
				int nb = GridUtilities.getNbAlives(this, i, j);
				if (!this.isAlive(i, j) && nb == 3)
					game.setAlive(i, j);
				else if(this.isAlive(i, j) && (nb == 2 || nb == 3))
					game.setAlive(i, j);
				else
					game.setDead(i, j);
			}
		}
		
		return game;
	}
	
	@Override
	protected boolean isAlive(int x, int y) {
		try {
			return this.grid[y][x] == State.ALIVE;
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
	}
	
	@Override
	public String toString() {
		StringBuffer buff = new StringBuffer();
		Arrays.stream(this.grid).forEach(states -> {buff.append("\n"); Arrays.stream(states).forEach(buff::append);});
		return buff.toString();
	}
	
}
