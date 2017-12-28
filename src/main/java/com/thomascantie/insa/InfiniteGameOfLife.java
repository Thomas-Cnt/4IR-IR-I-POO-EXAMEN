package com.thomascantie.insa;

import java.util.Arrays;

public class InfiniteGameOfLife extends GameOfLife {
	
	public InfiniteGameOfLife(int width, int height) {
		super(width, height);
	}
	
	@Override
	public void setAlive(int x, int y) {
		this.grid[y][x] = State.ALIVE;
	}
	
	@Override
	public InfiniteGameOfLife nextStep() {
		InfiniteGameOfLife previous = this.copyWithIncrease();
		InfiniteGameOfLife game = this.copyWithIncrease();
		
		for (int i = 0; i < previous.height; i++) {
			for (int j = 0; j < previous.width; j++) {
				int nb = GridUtilities.getNbAlives(previous, i, j);
				if (!previous.isAlive(i, j) && nb == 3)
					game.setAlive(j, i);
				else if(previous.isAlive(i, j) && (nb != 2 && nb != 3))
					game.setDead(i, j);
			}
		}
		
		return game;
	}
	
	private InfiniteGameOfLife copyWithIncrease() {
		int newWidth = this.width == this.height ? this.width : this.width+1;
		int newHeight = this.width == this.height ? this.height+1 : this.height;
		
		InfiniteGameOfLife game = new InfiniteGameOfLife(newWidth, newHeight);
		
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.width; j++) {
				if (this.isAlive(i, j))
					game.setAlive(j, i);
			}
		}
		return game;
	}
	
	@Override
	protected boolean isAlive(int x, int y) {
		try {
			return this.grid[x][y] == State.ALIVE;
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
	}
	
	@Override
	protected void setDead(int x, int y) {
		this.grid[x][y] = State.DEAD;
	}
	
	@Override
	public String toString() {
		StringBuffer buff = new StringBuffer();
		Arrays.stream(this.grid).forEach(states -> {buff.append("\n"); Arrays.stream(states).forEach(buff::append);});
		return buff.toString();
	}
	
}
