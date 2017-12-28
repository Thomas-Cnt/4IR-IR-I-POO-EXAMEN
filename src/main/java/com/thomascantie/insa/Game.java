package com.thomascantie.insa;

public abstract class Game {
	
	protected State[][] grid;
	protected int width;
	protected int height;
	
	public Game(int width, int height) {
		this.height = height;
		this.width = width;
		this.grid = new State[height][width];
		for (int i = 0; i < height; i++)
			for (int j = 0; j < width; j++)
				this.grid[i][j] = State.DEAD;
	}
	
	public void setAlive(int x, int y) {
		this.grid[y][x] = State.ALIVE;
	}
	
	public abstract Game nextStep();
	
	protected abstract boolean isAlive(int x, int y);
	
	protected void setDead(int x, int y) {
		this.grid[y][x] = State.DEAD;
	}
	
	
}
