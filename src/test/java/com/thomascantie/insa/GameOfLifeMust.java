package com.thomascantie.insa;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class GameOfLifeMust {
	
	private static final String GAME_INIT = ".....\n..#..\n.....";
	private static final String GAME_STEP_ONE = "...\n###\n...";
	private OutputStream out;
	
	@Before
	public void setUp() {
		this.out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(this.out));
	}
	
	@Test
	public void printACorrectGale() {
		GameOfLife game = new GameOfLife(5, 3);
		game.setAlive(2, 1);
		
		System.out.println(game);
		
		assertThat(standardOutput(), containsString(GAME_INIT));
	}
	
	@Test
	public void evolveToTheNextCorrectStep() {
		GameOfLife game = new GameOfLife(3, 3);
		game.setAlive(1, 0);
		game.setAlive(1, 1);
		game.setAlive(1, 2);
		
		System.out.println(game.nextStep());
		
		assertThat(standardOutput(), containsString(GAME_STEP_ONE));
	}
	
	private String standardOutput() {
		return this.out.toString();
	}
	
}
